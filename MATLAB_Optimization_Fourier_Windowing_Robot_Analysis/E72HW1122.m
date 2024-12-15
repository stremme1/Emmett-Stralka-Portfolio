function simulateGyroscope()

    % Function defining the system of differential equations
    function dydt = gyroDynamics(t, y, r, L, g)
        theta = y(1);
        phi = y(2);
        v = y(3);
        w = y(4);
        omega_R = y(5);

        % Equations from the gyroscopic dynamics
        dv = -(2 * w * (r^2 * omega_R + 4 * L^2 * v * cos(phi))) / ((r^2 + 4 * L^2) * sin(phi));
        dw = (sin(phi) * (4 * L^2 - r^2) * v^2 * cos(phi) + 2 * r^2 * omega_R * v + 4 * g * L) / (4 * L^2 + r^2);
        domega_R = -w * (v * sin(phi) + (2 * (r^2 * omega_R + 4 * L^2 * v * cos(phi))) / ((r^2 + 4 * L^2) * tan(phi)));

        dydt = [v; w; dv; dw; domega_R];
    end

    % Function to compute energy
    function Energy = computeEnergy(Y, r, L, m, g)
        phi = Y(:, 2);
        theta_dot = Y(:, 3);
        phi_dot = Y(:, 4);
        omega_R = Y(:, 5);
        

        K = 0.5 * m * (0.5 * r^2 * omega_R.^2 + (0.25 * r^2 + L^2) * phi_dot.^2 + (0.5 * r^2 + (L^2 - 0.25 * r^2) * sin(phi).^2) .* theta_dot.^2 - r^2 * omega_R .* theta_dot .* cos(phi));


        V = m * g * L * cos(phi);

        Energy = K + V; % Total mechanical energy
    end

    % Parameters
    m = 0.5;  % Mass (kg)
    r = 0.1;  % Radius (m)
    L = 0.2;  % Distance to center of mass (m)
    g = 9.81; % Acceleration due to gravity (m/s^2)

    % Initial values
    theta_0 = 0;    % Initial angle (rad)
    phi_0 = deg2rad(20); % Initial angle (rad)
    omega_R_0 = 1200 * 2 * pi / 60; % Initial angular velocity (rad/s)

    % Simulation time
    t_span = [0 10]; % Time span for simulation (s)

    % Initial state vector
    y0 = [theta_0; phi_0; 0; 0; omega_R_0];

    % Solve differential equations
    [t, Y] = ode45(@(t, y) gyroDynamics(t, y, r, L, g), t_span, y0);

    % Compute total mechanical energy
    Energy2 = computeEnergy(Y, r, L, m, g);

    % Plot results
    figure;
    subplot(3, 1, 1);
    plot(t, Y(:, 1), 'b', t, Y(:, 2), 'r');
    xlabel('Time (s)');
    ylabel('Angle (rad)');
    legend('\theta', '\phi');

    subplot(3, 1, 2);
    plot(t, Energy2);
    xlabel('Time (s)');
    ylabel('Total Energy (J)');

    subplot(3, 1, 3);
    % Compute Cartesian coordinates
    x = L * sin(Y(:, 2)) .* sin(Y(:, 1));
    y = L * sin(Y(:, 2)) .* cos(Y(:, 1));
    z = L * cos(Y(:, 2));
    plot3(x, y, z);
    xlabel('X');
    ylabel('Y');
    zlabel('Z');
    title('Path of mass center');

end
