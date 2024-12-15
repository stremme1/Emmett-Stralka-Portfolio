% Define parameters
Ix = 0.06;  % Moment of inertia about the x-axis (kg⋅m^2)
Iy = 0.099; % Moment of inertia about the y-axis (kg⋅m^2)
Iz = 0.101; % Moment of inertia about the z-axis (kg⋅m^2)
tfinal = 10;

% Linearize the equations of motion around each equilibrium point
initdata = [0.1; 0.1; 50];
diffeq = @(t, y) [
    (Iy - Iz) * y(3) * y(2) / Ix; 
    (Iz - Ix) * y(1) * y(3) / Iy; 
    (Ix - Iy) * y(2) * y(1) / Iz];

sol = ode45(diffeq, [0, tfinal], initdata);
plott = linspace(0, tfinal, 1000);

OmegaX = deval(sol, plott, 1);
OmegaY = deval(sol, plott, 2);
OmegaZ = deval(sol, plott, 3);

% Plot the rotational velocities over time
figure;
subplot(3, 1, 1);
plot(plott, OmegaX);
xlabel('Time (s)');
ylabel('\omega_x (rad/s)');
title('Rotation about the x-axis');

subplot(3, 1, 2);
plot(plott, OmegaY);
xlabel('Time (s)');
ylabel('\omega_y (rad/s)');
title('Rotation about the y-axis');

subplot(3, 1, 3);
plot(plott, OmegaZ);
xlabel('Time (s)');
ylabel('\omega_z (rad/s)');
title('Rotation about the z-axis');



% Jacobian matrix at the equilibrium point
Jacobian = [0, 0, (Iz - Ix) / Iy; 
            (Iy - Iz) / Ix, 0, 0; 
            (Iy - Iz) / Ix, 0, 0];

% Compute eigenvalues
eigenvalues = eig(Jacobian);

% Display eigenvalues
disp('Eigenvalues of the Jacobian matrix:');
disp(eigenvalues);


% Compute eigenvalues
eigenvalues = eig(Jacobian);

% Display eigenvalues
disp('Eigenvalues of the Jacobian matrix:');
disp(eigenvalues);


