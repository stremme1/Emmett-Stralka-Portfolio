module main_controller (
    input logic clk,
    input logic reset,
    input logic [6:0] op,          // Opcode from instruction
    input logic [2:0] funct3,      // Funct3 field from instruction
    input logic funct7b5,          // Bit 5 of funct7 field
    input logic zero,              // Zero flag from ALU
    output logic [1:0] immsrc,     // Immediate source
    output logic [1:0] alusrca,    // ALU Source A
    output logic [1:0] alusrcb,    // ALU Source B
    output logic [1:0] resultsrc,  // Result Source
    output logic adrsrc,           // Address Source
    output logic [2:0] alucontrol, // ALU Control
    output logic irwrite,          // Instruction Register Write Enable
    output logic pcwrite,          // Program Counter Write Enable
    output logic regwrite,         // Register Write Enable
    output logic memwrite          // Memory Write Enable
);

    // Internal signals
    logic branch;
    logic [1:0] aluop;
    logic pcupdate;

    // Instantiate main_fsm for FSM state logic
    main_fsm fsm_dut (clk, reset, op, pcupdate, irwrite, alusrca, alusrcb, aluop, resultsrc, regwrite, memread, memwrite, branch, adrsrc
    );

    // Instantiate aludec module to generate ALU control signal
    aludec alu_dut (aluop[1],aluop[0],funct3[2],funct3[1],funct3[0],op[5], funct7b5, alucontrol[0],alucontrol[1],alucontrol[2]
    );

//input logic A, B, C, D, E, F, G,  // Inputs (A = ALUop1, B = ALUOp0, etc.)
    //output logic X,Y,Z;      


    // Instantiate maindec module for immediate source logic
    maindec dec_dut (op, immsrc
    );

    // Branching logic for updating PC based on Zero flag and branch control
    assign pcwrite = pcupdate | (zero & branch);

endmodule



module main_fsm(
    input logic clk,
    input logic reset,
    input logic [6:0] op_code,   // 7-bit opcode from instruction
    output logic pcupdate,    // Control for PC Update
    output logic irwrite,     // Control for Instruction Register Write
    output logic [1:0] alusrca, alusrcb, // ALU source control
    output logic [1:0] aluop,  // ALU operation control
    output logic [1:0] resultsrc, // Result Source for Register Write
    output logic regwrite,    // Control for Register Write
    output logic memread, memwrite, // Memory Read/Write control
    output logic branch,     // Branch control
output logic adrsrc
);

    // State encoding
    typedef enum logic [3:0] {
        S0_FETCH   = 4'b0000,
        S1_DECODE  = 4'b0001,
        S2_MEMADR  = 4'b0010,
        S3_MEMREAD = 4'b0011,
        S4_MEMWB   = 4'b0100,
        S5_MEMWRITE= 4'b0101,
        S6_EXECUTER = 4'b0110,
        S7_ALUWB   = 4'b0111,
        S8_EXECUTEL= 4'b1000,
        S9_JAL     = 4'b1001,
        S10_BEQ    = 4'b1010
    } state_t;

    state_t state, next_state;

    // State machine logic
    always_ff @(posedge clk or posedge reset) begin
        if (reset)
            state <= S0_FETCH; // Reset to Fetch state
        else
            state <= next_state;
    end

    always_comb
        case(state)
            S0_FETCH: begin
                pcupdate = 1;
                irwrite = 1;
                alusrca = 2'b00;
                alusrcb = 2'b10;
                aluop = 2'b00;
                resultsrc = 2'b10;
                memwrite = 0;
                regwrite = 0;
                branch = 0;
adrsrc = 0;
next_state = S1_DECODE;

            end
            S1_DECODE: begin
                pcupdate = 0;
                irwrite = 0;
                alusrca = 2'b01;
                alusrcb = 2'b01;
                aluop = 2'b00;
                resultsrc = 2'b00;
                memwrite = 0;
                regwrite = 0;
                branch = 0;
adrsrc= 0;
                case(op_code)
                    7'b0000011: next_state = S2_MEMADR;
 7'b0100011: next_state = S2_MEMADR; // load/store instructions
 7'b0110011: next_state = S6_EXECUTER;
 7'b0010011: next_state = S8_EXECUTEL;
                    7'b1101111: next_state = S9_JAL; // JAL instruction
                    7'b1100011: next_state = S10_BEQ; // BEQ branch
                    default: next_state = S0_FETCH;
                endcase
            end
            S2_MEMADR: begin
                pcupdate = 0;
                irwrite = 0;
                alusrca = 2'b10;
                alusrcb = 2'b01;
                aluop = 2'b00;
                resultsrc = 2'b00;
                memwrite = 0;
                regwrite = 0;
                branch = 0;
adrsrc= 0;
if (op_code == 7'b0000011)
next_state = S3_MEMREAD;
else if (op_code == 7'b0100011)
next_state= S5_MEMWRITE;
else
next_state = S0_FETCH;
            end
            S3_MEMREAD: begin
                pcupdate = 0;
                irwrite = 0;
                alusrca = 2'b00;
                alusrcb = 2'b00;
                aluop = 2'b00;
                resultsrc = 2'b00;
                memwrite = 0;
                regwrite = 0;
                branch = 0;
adrsrc= 1;
next_state = S4_MEMWB;
            end
            S4_MEMWB: begin
                pcupdate = 0;
                irwrite = 0;
                alusrca = 2'b00;
                alusrcb = 2'b00;
                aluop = 2'b00;
                resultsrc = 2'b01;
                memwrite = 0;
                regwrite = 1;
                branch = 0;
adrsrc= 0;
next_state = S0_FETCH;
            end
            S5_MEMWRITE: begin
                pcupdate = 0;
                irwrite = 0;
                alusrca = 2'b00;
                alusrcb = 2'b00;
                aluop = 2'b00;
                resultsrc = 2'b00;
                memwrite = 1;
                regwrite = 0;
                branch = 0;
adrsrc= 1;
next_state = S0_FETCH;
            end
            S6_EXECUTER: begin
                pcupdate = 0;
                irwrite = 0;
                alusrca = 2'b10;
                alusrcb = 2'b00;
                aluop = 2'b10;
                resultsrc = 2'b00;
                memwrite = 0;
                regwrite = 0;
                branch = 0;
adrsrc= 0;
next_state = S7_ALUWB;
            end
            S7_ALUWB: begin
                pcupdate = 0;
                irwrite = 0;
                alusrca = 2'b00;
                alusrcb = 2'b00;
                aluop = 2'b00;
                resultsrc = 2'b00;
                memwrite = 0;
                regwrite = 1;
                branch = 0;
adrsrc= 0;
next_state = S0_FETCH;
end
S8_EXECUTEL: begin
                pcupdate = 0;
                irwrite = 0;
                alusrca = 2'b10;
                alusrcb = 2'b01;
                aluop = 2'b10;
                resultsrc = 2'b00;
                memwrite = 0;
                regwrite = 0;
                branch = 0;
adrsrc= 0;
next_state = S7_ALUWB;
            end
            S9_JAL: begin
                pcupdate = 1;
                irwrite = 0;
                alusrca = 2'b01;
                alusrcb = 2'b10;
                aluop = 2'b00;
                resultsrc = 2'b00;
                memwrite = 0;
                regwrite = 0;
                branch = 0;
adrsrc= 0;
next_state = S7_ALUWB;
            end
            S10_BEQ: begin
                pcupdate = 0;
                irwrite = 0;
                alusrca = 2'b10;
                alusrcb = 2'b00;
                aluop = 2'b01;
                resultsrc = 2'b00;
                memwrite = 0;
                regwrite = 0;
                branch = 1;
adrsrc= 0;
next_state = S0_FETCH;
            end
default: begin
pcupdate = 0;
irwrite = 0;
alusrca = 2'b00;
alusrcb = 2'b00;
aluop = 2'b00;
resultsrc = 2'b00;
memread = 0;
memwrite = 0;
regwrite = 0;
branch = 0;
adrsrc= 0;
next_state = S0_FETCH;
end
        endcase

endmodule




// Main Decoder module
module maindec(
    input [6:0] op_code, // Opcode of the instruction
    output reg [1:0] ImmSrc  // Immediate Source for ALU
);

    always @(*) begin
        case(op_code)
            7'b0110011: ImmSrc = 2'b00;  // R-type
            7'b0010011: ImmSrc = 2'b00;  // I-type ALU
            7'b0000011: ImmSrc = 2'b00;  // lw
            7'b0100011: ImmSrc = 2'b01;  // sw
            7'b1100011: ImmSrc = 2'b10;  // beq
            7'b1101111: ImmSrc = 2'b11;  // jal
            default: ImmSrc = 2'b00;
        endcase
    end
endmodule


// ALU Decoder module alucontrol, funct7b5,op[5],aluop
module aludec(
    input logic A, B, C, D, E, F, G,  // Inputs (A = ALUop1, B = ALUOp0, etc.)
    output logic X,Y,Z       // 3-bit control signals (output)
);
logic n1, n2, n3;

    // AND gate operations
    and a1(n1, ~A, B);                        // AND gate for A' and B
    and a2(n2, A, ~B, ~C, ~D, ~E, F, G);     // AND gate for multiple inputs
    and a3(n3, A, ~B, D, ~E);                // AND gate for A, B', C, and D'
    or a4(X, n1, n2, n3);               // AND gate for A, B, C, D, and E'
    and a5(Y, A, ~B, C, D);                  // AND gate for A, B', C, and D

    // OR gate to combine AND outputs for control signal (x)
    and a6(Z, A,~B,~C,D,~E);          // Combine n1, n2, and n3 for control[0]

endmodule