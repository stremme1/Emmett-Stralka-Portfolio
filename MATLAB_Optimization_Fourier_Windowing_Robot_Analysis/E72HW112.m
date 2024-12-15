function E72HW112()
    % Define parameters
    m = 0.5;    % mass (kg)
    r = 0.1;    % radius (m)
    L = 0.2;    % distance (m)
    g = 9.81;   % acceleration due to gravity (m/s^2)
    tfinal = 10;

    % Initial values
    theta_0 = 0;    % initial angle theta (rad)
    phi_0 = deg2rad(20);    % initial angle phi (rad)
    omega_R_0 = deg2rad(1200) * 2 * pi / 60;    % initial angular velocity omega_R (rad/s)

    % Define ODE system
    dydt = @(t, y) [
        y(3);
        y(4);
        -(2 * y(4) * (r^2 * y(5) + 4 * L^2 * y(3) * cos(y(2)))) / ((r^2 + 4 * L^2) * sin(y(2)));
        (sin(y(2)) * (4 * L^2 - r^2) * y(3)^2 * cos(y(2)) + 2 * r^2 * y(5) * y(3) + 4 * g * L) / (4 * L^2 + r^2);
        -y(4) * (y(3) * sin(y(2)) + (2 * (r^2 * y(5) + 4 * L^2 * y(3) * cos(y(2)))) / ((r^2 + 4 * L^2) * tan(y(2))));
    ];

    

    % Solve ODE
    [t, y] = ode45(dydt, [0, tfinal], [theta_0, phi_0, 0, 0, omega_R_0]);

    % Compute energies
    V = m * g * L * cos(y(:, 2));  % potential energy
    K = 0.5 * m * (0.5 * r^2 * y(:, 5).^2 + (0.25 * r^2 + L^2) * y(:, 4).^2 + (0.5 * r^2 + (L^2 - 0.25 * r^2) * sin(y(:, 2)).^2) .* y(:, 3).^2 - r^2 * y(:, 5) .* y(:, 3) .* cos(y(:, 2)));  % kinetic energy
    E = V + K;  % total energy

    % Plot results
    figure;
    subplot(3, 1, 1);
    plot(t, y(:, 1));
    xlabel('Time (s)');
    ylabel('\theta (rad)');
    title('\theta vs Time');

    subplot(3, 1, 2);
    plot(t, y(:, 2));
    xlabel('Time (s)');
    ylabel('\phi (rad)');
    title('\phi vs Time');

    subplot(3, 1, 3);
    plot(t, E);
    xlabel('Time (s)');
    ylabel('Total Energy (J)');
    title('Total Energy vs Time');

    % Cartesian coordinates
    x = L * sin(y(:, 2)) .* cos(y(:, 1));
    y = L * sin(y(:, 2)) .* sin(y(:, 1));
    z = L * cos(y(:, 2));

    % Plot 3D path
    figure;
    plot3(x, y, z);
    xlabel('X');
    ylabel('Y');
    zlabel('Z');
    title('3D Path of Mass Center');
end
