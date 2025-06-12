// Pin for the onboard LED (typically pin 13 for most Arduino boards)
const int ledPin = LED_BUILTIN;

void setup() {
  // Set up the LED pin as an output
  pinMode(ledPin, OUTPUT);

  // Start serial communication
  Serial.begin(9600);
  while (!Serial) {
    // Wait for the Serial Monitor to open (optional for Arduino Uno R4 WiFi)
  }

  // Display a message on the Serial Monitor
  Serial.println("Arduino is connected and ready!");
}

void loop() {
  // Blink the onboard LED
  digitalWrite(ledPin, HIGH);  // Turn LED on
  delay(500);                 // Wait 500ms
  digitalWrite(ledPin, LOW);   // Turn LED off
  delay(500);                 // Wait 500ms

  // Print a message to the Serial Monitor
  Serial.println("The LED is blinking!");
}
