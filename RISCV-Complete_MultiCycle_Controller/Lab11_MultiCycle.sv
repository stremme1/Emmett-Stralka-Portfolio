//Atempting to alter the single to multi
module top(input  logic        clk, reset, 
           output logic [31:0] WriteData, Adr, 
           output logic        memwrite);

  logic [31:0] PC, Instr, ReadData;
  
  // instantiate processor and memories
  // Changed
  RISCVmulti RISCVsingle(clk, reset, Adr, MemWrite, DataAdr, 
                          WriteData, ReadData); // Omitted PC signal I do not know what to do with it its j internal? Replaces with Adr
       
    //Changed 
  dmem_instmem dmem_instmem(clk, memwrite, Adr, WriteData, ReadData);
endmodule

// different then the RISCVsingle
module RISCVmulti(input  logic        clk, reset,
                   output logic [31:0] Adr // Changed to Adr?!//output logic [31:0] PC, what do I do with this PC Signal
                   output logic        MemWrite,
                   output logic [31:0] ALUResult, WriteData,
                   input  logic [31:0] ReadData);

  logic       ALUSrc, RegWrite, Jump, Zero;
  logic [1:0] ResultSrc, ImmSrc;
  logic [2:0] ALUControl;
  logic [31:0] Instr;


    //modified
  main_controller c(reset, opInstr[], funct3Instr[], funct7b5Instr[], zero, 
  immsrc, alusrca, alusrcb, resultsrc, adrsrc,alucontrol, irwrite, pcwrite, regwrite, memwrite);


    // modifiied
  datapath dp(clk, reset, immsrc, alusrca, alusrcb,resultsrc, adrsrc,alucontrol, irwrite, pcwrite, regwrite, memwrite, zero, 
  instruction, alu_out, mem_out);
endmodule


//Different then Single Cycle
module datapath (
    input logic clk,
    input logic reset,
    input logic [1:0] immsrc,        // Immediate source
    input logic [1:0] alusrca,       // ALU source A
    input logic [1:0] alusrcb,       // ALU source B
    input logic [1:0] resultsrc,     // Result source
    input logic adrsrc,              // Address source
    input logic [2:0] alucontrol,    // ALU control signals
    input logic irwrite,             // Instruction Register write
    input logic pcwrite,             // Program Counter write
    input logic regwrite,            // Register file write enable
    input logic memwrite,            // Memory write enable
    output logic zero,                // Not Sure if it is a output or input
    output logic [31:0] instruction, // Current instruction
    output logic [31:0] alu_out,     // ALU output
    output logic [31:0] mem_out      // Data memory output
);
// controller signals follow all lower case


    //My Code Internal Signals *Internal Sigals follow case from chart
    logic [31:0] PCNext, PC, OldPC;
    logic [31:0] Adr, ReadData, Instr, Data
    logic [31:0] ImmExt;
    logic [31:0] RD1e, RD2e; // Not Sure If needed
    logic [31:0] A, WriteData
    logic [31:0] SrcA, SrcB;
    logic [31:0] ALUResult, ALUOut;
    logic [31:0] Result;



    // From Left to right Top to bottom on Diagram
    flopr_enable #(32) PCNEXT_CLK(clk, reset, pcwrite, PCNext, PC); // 1
    mux2  #(32) A_MUX2(PC, Result, adrsrc, Adr);
    dmem_instmem INSTR_DATA_MEM(clk, memwrite, Adr, WriteData, ReadData);
    flopr2_enable #(32) OLDPC_CLK(clk, reset, irwrite, PC, ReadData, OldPC, Instr);
    flopr #(32) DATA_CLK(clk, reset, ReadData, Data);
    RegFile RF(clk, regwrite, Instr[19:15], Instr[24:20], Instr[11:7], Result, RD1e, RD2e);
    Extend Ext(Instr[31:7], ImmSrc, ImmExt);


    flopr #(32) RFC1(clk, reset, RD1e, A);
    flopr #(32) RFC2(clk, reset, RD2e, WriteData);
    mux3 #(32) SRCA_MUX3(PC, OldPC, A, alusrca, SrcA);
    mux3 #(32) SRCB_MUX3(WriteData, ImmExt, 32'd4, alusrcb, SrcB);
    alu ALU(SrcA, SrcB, alucontrol, ALUResult, zero); // Not Sure if zero or Zero here
    flopr #(32) RESULT_CLK(clk, reset, ALUResult, ALUOut);
    mux3 #(32) RES_MUX3(ALUOut, Data, ALUResult, resultsrc, Result);

endmodule






// Same as Single Cycle 
module Extend(input  logic [31:7] Instr,
              input  logic [1:0]  ImmSrc,
              output logic [31:0] ImmExt);
 
  always_comb
    case(ImmSrc) 
               // I-type 
      2'b00:   ImmExt = {{20{Instr[31]}}, Instr[31:20]};  
               // S-type (Stores)
      2'b01:   ImmExt = {{20{Instr[31]}}, Instr[31:25], Instr[11:7]}; 
               // B-type (Branches)
      2'b10:   ImmExt = {{20{Instr[31]}}, Instr[7], Instr[30:25], Instr[11:8], 1'b0}; 
               // J-type (Jumps)
      2'b11:   ImmExt = {{12{Instr[31]}}, Instr[19:12], Instr[20], Instr[30:21], 1'b0}; 
      default: ImmExt = 32'bx; // undefined
    endcase             
endmodule




// Same as Single Cycle
module RegFile(input  logic        clk, 
               input  logic        WE3, 
               input  logic [ 4:0] A1, A2, A3, 
               input  logic [31:0] WD3, 
               output logic [31:0] RD1, RD2);

  logic [31:0] rf[31:0];

  // three ported register file
  // read two ports combinationally (A1/RD1, A2/RD2)
  // write third port on rising edge of clock (A3/WD3/WE3)
  // register 0 hardwired to 0

  always_ff @(posedge clk)
    if (WE3) rf[A3] <= WD3;	

  assign RD1 = (A1 != 0) ? rf[A1] : 0;
  assign RD2 = (A2 != 0) ? rf[A2] : 0;
endmodule




// Same as Single Cycle Clk with 1in-1out res, CLK
module flopr #(parameter WIDTH = 8)
              (input  logic             clk, reset,
               input  logic [WIDTH-1:0] d, 
               output logic [WIDTH-1:0] q);

  always_ff @(posedge clk, posedge reset)
    if (reset) q <= 0;
    else       q <= d;
endmodule

// Clk with 1in-1out res, CLK & enable
module flopr_enable #(parameter WIDTH = 8)
            (input  logic             clk, reset, enable,
             input  logic [WIDTH-1:0] d,
             output logic [WIDTH-1:0] q);

  always_ff @(posedge clk, posedge reset)
    if (reset) q <= 0;              // Reset to 0
    else if (enable) q <= d;        // Update output if enable is high
endmodule

// Clk with 2in-2out res, CLK & enable
module flopr2_enable #(parameter WIDTH = 8)
            (input  logic             clk, reset, enable,
             input  logic [WIDTH-1:0] d1, d2,
             output logic [WIDTH-1:0] q1, q2);

  always_ff @(posedge clk, posedge reset)
    if (reset) begin
      q1 <= 0;                     // Reset both outputs to 0
      q2 <= 0;
    end
    else if (enable) begin
      q1 <= d1;                    // Update q1 with d1 if enabled
      q2 <= d2;                    // Update q2 with d2 if enabled
    end
endmodule


// Same as Single Cycle
module mux2 #(parameter WIDTH = 8)
             (input  logic [WIDTH-1:0] d0, d1, 
              input  logic             s, 
              output logic [WIDTH-1:0] y);

  assign y = s ? d1 : d0; 
endmodule

// Same as Single Cycle
module mux3 #(parameter WIDTH = 8)
             (input  logic [WIDTH-1:0] d0, d1, d2,
              input  logic [1:0]       s, 
              output logic [WIDTH-1:0] y);

  assign y = s[1] ? d2 : (s[0] ? d1 : d0); 
endmodule


// Same as Single Cycle
module alu(input  logic [31:0] a, b,
            input  logic [2:0]  alucontrol,
            output logic [31:0] result,
            output logic        zero); 

  logic [31:0] condinvb, sum;
  logic        sub;
  
  assign sub = (alucontrol[1:0] == 2'b01)
  assign condinvb = sub ? ~b : b; // for subtraction or slt
  assign sum = a + condinvb + sub;

  always_comb
    case (alucontrol)
      3'b000: result = sum;          // addition
      3'b001: result = sum;          // subtraction
      3'b010: result = a & b;        // and
      3'b011: result = a | b;        // or
      3'b101: result = sum[31];      // slt
      default: result = 0;
  endcase

  assign zero = (result == 32'b0);
endmodule



// Same as Single Cycle dmem *Update Data path Update Correct
 module dmem_instmem(input logic clk, WE, // WE- MemWrite
            input  logic [31:0] A, WD, // A- Adr, WD- WriteData
            output logic [31:0] RD);

  logic [31:0] RAM[63:0];

  assign RD = RAM[A[31:2]]; // word aligned

  initial
    $readmemh("memfile.dat",RAM);

  always_ff @(posedge clk)
    if (WE) RAM[A[31:2]] <= WD;
endmodule
//Read is just like the dmem
//Write is iMem can read 







// Lab 10 Mulicycle Controller
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

//End of Lab10 Multicycle controller


