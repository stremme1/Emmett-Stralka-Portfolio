function LM = E72HW11(f)

% Butterworth filter circuit - E72 Spring 2024
% Equations found using KCL and impedance for input frequency
w=2*pi*f;
Vin = 5; %amplitude of AC input
C = [90 360 360 90]*1e-12; 
L = [620 995 620]*1e-9;
ZR = 50;
ZC = 1./(1i*w*C);
ZL = 1i*w*L;

M =[1/ZR+1/ZC(1)+1/ZL(1) -1/ZL(1) 0 0 ;
 -1/ZL(1) 1/ZL(1)+1/ZC(2)+1/ZL(2) -1/ZL(2) 0 ;
 0 -1/ZL(2) 1/ZL(2)+1/ZC(3)+1/ZL(3) -1/ZL(3) ;
 0 0 -1/ZL(3) 1/ZL(3)+1/ZC(4)+1/ZR]; 
 
RHS = [Vin/ZR 0 0 0]';
V = A\RHS

% output log magnitude of voltage across load resistor
LM = 20*log10(abs(V(4))/Vin);

return


% f=logspace(6,8)
% for k=1:length(f)
% lm(k)= hw1butterworth(f(k))
% end
% semilogx(f,lm);xlabel('Frequency (Hz)');ylabel('Magnitude (dB)'); grid on
