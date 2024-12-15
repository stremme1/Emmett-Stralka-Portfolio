% Define system parameters
I = 0.25;   % N * s^2 / m^5
R1 = 1;     % N * s / m^5
R2 = 1;     % N * s / m^5
C = 1;      % m^5 / N
Pin = 10;   % N/m^2

% Define system matrix A
A = [-R1/I, -1/I; 
     1/C, -1/(R2*C)];

% Define input matrix B
B = [Pin/I; 
     0];

% Compute the matrix exponential eAt
eAt = expm(A);



disp(eAt);
