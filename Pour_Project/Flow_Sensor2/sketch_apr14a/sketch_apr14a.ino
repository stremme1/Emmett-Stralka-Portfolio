/*
  Open-loop step response of a 2nd-order low-pass filter (LMC6484).
  Applies a 2.5V step input and logs output to serial monitor.
  
  Circuit:
  * LMC6484 Vin -> Pin 9 (PWM)
  * LMC6484 Vout -> A0 (Analog Read)
  * Switch between Pin 2 and GND
*/

// Pin Settings
const int yPin = A0;      // Analog read pin (filter output)
const int uPin = 9;       // PWM output (filter input)
const int switchPin = 2;  // Switch trigger (pull-up)
boolean switchVal = HIGH; // Initial switch state

// Parameters
int time = 0;             // Time counter
const float uin = 2.5;    // 2.5V step input
const int sampleTime = 10; // Sample interval (ms) -> 100Hz

void setup() {
  pinMode(switchPin, INPUT_PULLUP); // Enable internal pull-up
  Serial.begin(115200);             // Faster baud rate for 100Hz sampling
}

void loop() {
  // Wait for switch press (LOW when pressed)
  while (switchVal == HIGH) {
    analogWrite(uPin, 0);  // Start with 0V output
    switchVal = digitalRead(switchPin);
  }

  // Apply 2.5V step (50% duty cycle for 8-bit PWM)
  analogWrite(uPin, 128);  // 128/255 ≈ 2.5V

  // Read and log output
  int sensorVal = analogRead(yPin);
  float y = sensorVal * (5.0 / 1023.0); // Convert to volts

  // Print time (s) and voltage
  Serial.print(time * sampleTime / 1000.0, 3); // Convert ms to seconds
  Serial.print(" ");
  Serial.println(y, 3); // 3 decimal places

  // Increment time and delay
  time++;
  delay(sampleTime);
}