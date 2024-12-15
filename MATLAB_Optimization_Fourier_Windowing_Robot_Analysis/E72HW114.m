clear all

FV = .5; % (s) F/V inlet flow/tank volume
ER = 2600; % (K) Reaction activation energy/ideal gas constant
k0 = 1750; % (liter/(g*s)) Reaction rate constant
B = -15.3; %(liter*K/g) Heat of reaction...
A = .14;      % (s^-1) Heat Transger coefficient
Cfeed = 1; % (g/liter) Concentration of reactant A in input feed
Tfeed = 298; % (K) Temperature of input feed
Tcool = 298; % Temperature of cooling jacket


C1 = @(T) (-FV + sqrt((FV)^2 - 4*k0*exp(-ER./T)*(-FV*Cfeed)))./(2*k0*exp(-ER./T));
C2 = @(T) sqrt((FV*(Tfeed - T) + A*(Tcool - T)) ./ (B*k0*exp(-ER./T)));

% Plotting Code
fplot(C1, [298,2000]);
hold on
fplot(C2, [298,2000]);
xlabel("Temperature (K)");
ylabel("Concentration");
title("Concentration of Reactant A as a Function of Temperature")


% Define vector of equilibrium points guesses
guess1 = [.7, 310];

% Define equations to solve
eqs = @(X) [((Cfeed-X(1))*FV) - k0*exp(-ER/X(2))*X(1)^2; 
            (Tfeed-X(2))*FV - B*k0*exp(-ER/X(2))*X(1)^2 + A*(Tcool-X(2))];




% Solve for equilibrium points
point1 = fsolve(eqs, guess1);


% 
% [((Cfeed-C)*FV-k0*exp(-ER/T)*C^2);
% ((Tfeed-T)*FV-k0*exp(-ER/T)*C^2)*B+(A*(Tcool-T))]




% Solve for equilibrium points
point1 = fsolve(eqs, guess1);


% Define function to compute Jacobian matrix
Jacobian = @(C, T) [(-FV - k0 * exp(-ER/T) * C * 2), (-k0 * (ER/(T^2)) * exp(-ER/T) * C^2);
                    (-2 * k0 * exp(-ER/T) * C * B), -FV - k0 * (ER/(T^2)) * exp(-ER/T) * C^2 * B - A];



% Compute Jacobian at point1
J = Jacobian(point1(1), point1(2));

% Compute eigenvalues
eigenvalues = eig(J);

% Display results
disp('Eigenvalues of Linearized System:');
disp(eigenvalues);







