% Define parameters
Ix = 0.06;  % Moment of inertia about the x-axis (kg⋅m^2)
Iy = 0.099; % Moment of inertia about the y-axis (kg⋅m^2)
Iz = 0.101; % Moment of inertia about the z-axis (kg⋅m^2)
tfinal = 10;

% Linearize the equations of motion around each equilibrium point
initdata = [0.1; 0.1; 50];
diffeq = @(t, y) [((Iy - Iz) * y(3) * y(2)) / Ix;
    ((Iz - Ix) * y(1) * y(3)) / Iy;
    ((Ix - Iy) * y(2) * y(1)) / Iz];

sol = ode45(diffeq, [0, tfinal], initdata);
plott = linspace(0, tfinal, 1000);

OmegaX = deval(sol, plott, 1);
OmegaY = deval(sol, plott, 2);
OmegaZ = deval(sol, plott, 3);  

subplot(3, 1, 1)
plot(plott, OmegaX)
title("OmegaX vs Time")
xlabel('Time (secs)')
ylabel('Angular Velocity rad/s')
hold on

subplot(3, 1, 1)
plot(plott, OmegaY)
title("OmegaY vs Time")
xlabel('Time (secs)')
ylabel('Angular Velocity rad/s')
hold on

subplot(3, 1, 2)
plot(plott, OmegaZ)
title("OmegaZ vs Time")
xlabel('Time (secs)')
ylabel('Angular Velocity rad/s')

% Define Jacobian function
Jacobian = @(OmegaX, OmegaY, OmegaZ) [0, ((Iy - Iz) * OmegaZ) / Ix,((Iy - Iz) * OmegaY) / Ix;
    ((Iz - Ix) * OmegaZ) / Iy, 0, ((Iz - Ix) * OmegaX) / Iy;
    ((Ix - Iy) * OmegaY) / Iz, ((Ix - Iy) * OmegaX) / Iz, 0 ];

% Compute eigenvalues for each equilibrium point

A1 = Jacobian(C, 0, 0);
A2 = Jacobian(0, C, 0);
A3 = Jacobian(0, 0, C);

% Compute eigenvalues
eig1 = eig(A1);
eig2 = eig(A2);
eig3 = eig(A3);

% Display stability results
disp("Eigenvalues for equilibrium point 1:");
disp(eig1);
disp("Eigenvalues for equilibrium point 2:");
disp(eig2);
disp("Eigenvalues for equilibrium point 3:");
disp(eig3);
