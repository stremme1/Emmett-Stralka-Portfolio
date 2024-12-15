% Define the system parameters
L1 = 10e-3; % inductance in Henry
L2 = 10e-3; % inductance in Henry
C = 1e-6;   % capacitance in Farad
R = 50;     % resistance in Ohm

% Define the matrix A
A = [-R/L2, R/L2, 0;
     0, 0, 1/C;
     1/L2, (-1/L1-1/L2), 0];

% Define the initial conditions
z0 = [0; 0; 10e-3]; % Assuming initial conditions are zero

% Define the time span
tspan = linspace(0, .006, 1000); % from 0 to 1 second with 1000 points

% Initialize an array to store eAt for each time point
eAt_values = zeros(size(A, 1), size(A, 2), length(tspan));

% Loop over each time point
for i = 1:length(tspan)
    % Compute eAt for the current time point
    eAt = expm(A * tspan(i)); % Using current time as the exponent
    % Store the result in the array
    eAt_values(:, :, i) = eAt;
end

% Plot v_R(t)
figure;
hold on;
for i = 1:size(A, 1)
    plot(tspan, squeeze(eAt_values(1, i, :))/10, 'b'); % Plot each element separately
end
hold off;
xlabel('Time (s)');
ylabel('Voltage across resistor (mV)');
title('Voltage across Resistor vs. Time');

% Find the maximum voltage across the resistor
max_voltage = max(squeeze(eAt_values(1, 1, :))); % Extracting voltage across resistor
fprintf('Maximum system voltage reached: %.2f V\n', max_voltage);
