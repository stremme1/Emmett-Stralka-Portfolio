function E72HW112()
    % Define parameters
    m = 0.5;    % mass (kg)
    r = 0.1;    % radius (m)
    L = 0.2;    % distance (m)

    % Initial values
    theta_0 = 0;    % initial angle theta (rad)
    phi_0 = deg2rad(20);    % initial angle phi (rad)
    omega_R_0 = deg2rad(1200) * 2 * pi / 60;    % initial angular velocity omega_R (rad/s)

    % Define ODE system 
    dydt = @(t, y) [
        y(3);
        y(4);
        -2 * y(4) * r^2 * y(5) + 4 * L^2 * y(3) * cos(y(2)) / ((r^2 + 4 * L^2) * sin(y(2)));
        sin(y(2)) * (4 * L^2 - r^2) * y(3)^2 * cos(y(2)) + 2 * r^2 * y(5) * y(3) + 4 * 9.81 * L / (4 * L^2 + r^2);
        -y(4) * (y(3) * sin(y(2)) + 2 * (r^2 * y(5) + 4 * L^2 * y(3) * cos(y(2))) / ((r^2 + 4 * L^2) * tan(y(2))))
    ];

    % Time span
    tfinal = 3.473036e-01; % Adjusted time span to exclude problematic time point
    plott = linspace(0, tfinal, 1000);

    % Solve ODEs with adjusted integration tolerances
    options = odeset('RelTol', 1e-6, 'AbsTol', 1e-9);  % Adjust tolerance levels as needed
    solution = ode45(dydt, [0, tfinal], [theta_0, phi_0, omega_R_0, 0, 0], options);

    % Extract solution values
    y = deval(solution, plott);

    % Compute energies
    V = m * 9.81 * L * cos(y(2, :));  % potential energy
    K = 0.5 * m * (0.5 * r^2 * y(5, :).^2 + (0.25 * r^2 + L^2) * y(4, :).^2 + (0.5 * r^2 + (L^2 - 0.25 * r^2) * sin(y(2, :)).^2) .* y(3, :).^2 - r^2 * y(5, :) .* y(3, :) .* cos(y(2, :)));  % kinetic energy
    E = V + K;  % total energy

    % Plot results
    figure;
    subplot(3, 1, 1);
    plot(plott, y(1, :));
    xlabel('Time (s)');
    ylabel('\theta (rad)');
    title('\theta vs Time');

    subplot(3, 1, 2);
    plot(plott, y(2, :));
    xlabel('Time (s)');
    ylabel('\phi (rad)');
    title('\phi vs Time');

    subplot(3, 1, 3);
    plot(plott, E);
    xlabel('Time (s)');
    ylabel('Total Energy (J)');
    title('Total Energy vs Time');

    % Cartesian coordinates
    x = L * sin(y(2, :)) .* cos(y(1, :));
    y_coord = L * sin(y(2, :)) .* sin(y(1, :));
    z = L * cos(y(2, :)) + r;

    % Plot 3D path
    figure;
    plot3(x, y_coord, z); %tspan of x,y,z
    xlabel('X');
    ylabel('Y');
    zlabel('Z');
    title('3D Path of Mass Center');
end
