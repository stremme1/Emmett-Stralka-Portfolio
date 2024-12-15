function KE_minimized = Class23(B)
    m = 1.2;      % mass of the building (the larger mass)
    k = 9;        % spring constant for the building
    b = 0.1;      % damping constant for the building
    md = m/10;    % damper is 1/10 of the mass of the building

    kd= B(1);
    bd= B(2);

    A = [0 1 0 0
       -(kd+k)/m -(bd+b)/m kd/m bd/m
       0 0 0 1
       kd/md bd/md -kd/md -bd/md];

    % Time span
    times = linspace(0, 10, 2000); % time points for plotting--vector from 0 to 25 with 2000 equally spaced points
    
    

    buildingpositions = zeros(1, length(times));
    for i = 1:length(times)
        buildingpositions(i) = [0,1,0,0]*expm(A*times(i))*[0;1/m;0;0];
        buildingpositionsd(i) = [0,0,1,0]*expm(A*times(i))*[0;1/m;0;0];

        %|y(t)-yd(t)| <=.3
    end

    KE = 0;
    for i = 1:length(times)
        KE = KE + 0.5 * m * abs(buildingpositions(i))^2;
    end

end



function KE_minimized = Class23(B)
    m = 1.2;      % mass of the building (the larger mass)
    k = 9;        % spring constant for the building
    b = 0.1;      % damping constant for the building
    md = m/10;    % damper is 1/10 of the mass of the building

    kd= B(1);
    bd= B(2);

    A = [0 1 0 0
       -(kd+k)/m -(bd+b)/m kd/m bd/m
       0 0 0 1
       kd/md bd/md -kd/md -bd/md];

    % Define the desired building position function yd(t)
    yd = @(t) 0.5 * sin(0.2 * t);

    % Time span
    times = linspace(0, 25, 2000); % time points for plotting--vector from 0 to 25 with 2000 equally spaced points

    buildingpositions = zeros(1, length(times));
    for i = 1:length(times)
        buildingpositions(i) = [0,1,0,0]*expm(A*times(i))*[0;1/m;0;0];
        % Define the desired building position function yd(t)
        yd = [0,0,1,0]*expm(A*times(i))*[0;1/m;0;0];
    end

    KE = 0;
    for i = 1:length(times)
        % Check if the constraint is violated
        if abs(buildingpositions(i) - yd(times(i))) > 0.3
            % Penalize solutions that violate the constraint
            KE_minimized = Inf;
            return;
        end
        KE = KE + 0.5 * m * abs(buildingpositions(i))^2;
    end

    KE_minimized = KE;
end




    


    

    KE_minimized = KE;


end
