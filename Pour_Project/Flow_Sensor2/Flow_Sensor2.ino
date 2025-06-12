#include <ArduinoBLE.h>

const int flowSensorPin = 2;    // Flow sensor signal pin (D2)
const int solenoidPin = A5;     // Solenoid connected to A5
const int buttonPins[] = {A0, A1, A2, A3, A4}; // Buttons on A0-A4
const float targetVolumes[] = {50.0, 100.0, 150.0, 200.0, 250.0}; // Target volumes (mL)

volatile int pulseCount = 0;    // Flow sensor pulse counter
const float calibrationFactor = 4.7; // Adjusted from your test (10ml count = 88ml actual)

unsigned long lastTime = 0;     // For flow rate calculation
const long readoutInterval = 250; // Update interval (ms)

float totalVolume = 0;          // Total volume dispensed (mL)
float targetVolume = 0;         // Selected target volume (mL)
bool volumeSelected = false;    // Volume selection flag

// Button debouncing and double-click detection
unsigned long lastDebounceTime = 0;
unsigned long lastButtonPressTime = 0;
const long debounceDelay = 150;  // Debounce time (ms)
const long doubleClickWindow = 400; // Time for double-click detection (ms)
int lastButtonPressed = -1;      // Track last pressed button

// BLE Service
BLEService dispenserService("19B10000-E8F2-537E-4F6C-D104768A1214");
BLEStringCharacteristic volumeCharacteristic("19B10001-E8F2-537E-4F6C-D104768A1214", BLERead | BLENotify, 20);

void setup() {
  Serial.begin(9600);
  pinMode(flowSensorPin, INPUT);
  pinMode(solenoidPin, OUTPUT);
  digitalWrite(solenoidPin, LOW); // Start with valve closed

  // Initialize buttons
  for (int i = 0; i < 5; i++) {
    pinMode(buttonPins[i], INPUT);
  }

  attachInterrupt(digitalPinToInterrupt(flowSensorPin), countPulse, RISING);

  // Initialize BLE
  if (!BLE.begin()) {
    Serial.println("BLE initialization failed!");
    while (1);
  }
  
  BLE.setLocalName("Perfect Pour");
  BLE.setAdvertisedService(dispenserService);
  dispenserService.addCharacteristic(volumeCharacteristic);
  BLE.addService(dispenserService);
  volumeCharacteristic.writeValue("Ready");
  BLE.advertise();
  
  Serial.println("System ready. Press a button to select volume.");
}

void loop() {
  // Handle BLE connections
  BLEDevice central = BLE.central();
  if (central) {
    while (central.connected()) {
      BLE.poll();
      mainDispensingLogic();
    }
  } else {
    mainDispensingLogic();
  }
}

void mainDispensingLogic() {
  // Check for button presses
  if (millis() - lastDebounceTime > debounceDelay) {
    for (int i = 0; i < 5; i++) {
      if (analogRead(buttonPins[i]) > 500) { // Button pressed
        handleButtonPress(i);
        lastDebounceTime = millis();
        break; // Exit loop after first detected press
      }
    }
  }

  // Flow control logic
  if (volumeSelected) {
    unsigned long currentTime = millis();
    
    if (currentTime - lastTime >= readoutInterval) {
      // Corrected flow calculation using your calibration
      float volumeDispensed = pulseCount * calibrationFactor;
      totalVolume += volumeDispensed;
      
      Serial.print("Dispensed: ");
      Serial.print(totalVolume);
      Serial.print(" / ");
      Serial.print(targetVolume);
      Serial.println(" mL");

      volumeCharacteristic.writeValue("Dispensed:" + String(totalVolume) + "/" + String(targetVolume));

      pulseCount = 0;
      lastTime = currentTime;
    }

    if (totalVolume >= targetVolume) {
      endDispensing();
    }
  }
}

void handleButtonPress(int buttonIndex) {
  unsigned long currentTime = millis();
  
  // Check for double click
  if (buttonIndex == lastButtonPressed && (currentTime - lastButtonPressTime) < doubleClickWindow) {
    digitalWrite(solenoidPin, LOW);
    volumeSelected = false;
    totalVolume = 0;
    pulseCount = 0;
    
    Serial.println("Double click detected. Pouring session reset.");
    volumeCharacteristic.writeValue("Reset");
    
    lastButtonPressTime = currentTime;
    return;
  }
  
  if (!volumeSelected) {
    targetVolume = targetVolumes[buttonIndex];
    volumeSelected = true;
    totalVolume = 0;
    pulseCount = 0;
    digitalWrite(solenoidPin, HIGH);
    
    Serial.print("Button ");
    Serial.print(buttonIndex + 1);
    Serial.print(" pressed. Target: ");
    Serial.print(targetVolume);
    Serial.println(" mL");
    
    volumeCharacteristic.writeValue("Button:" + String(buttonIndex+1) + " Target:" + String(targetVolume));
  } else {
    targetVolume = targetVolumes[buttonIndex];
    totalVolume = 0;
    pulseCount = 0;
    digitalWrite(solenoidPin, HIGH);
    
    Serial.print("New target: ");
    Serial.print(targetVolume);
    Serial.println(" mL");
    
    volumeCharacteristic.writeValue("NewTarget:" + String(targetVolume));
  }
  
  lastButtonPressed = buttonIndex;
  lastButtonPressTime = currentTime;
  lastTime = millis();
}

void endDispensing() {
  digitalWrite(solenoidPin, LOW);
  volumeSelected = false;
  Serial.println("Target reached. Valve closed. Ready for new selection.");
  volumeCharacteristic.writeValue("Complete:" + String(totalVolume));
}

void countPulse() {
  pulseCount++;
}