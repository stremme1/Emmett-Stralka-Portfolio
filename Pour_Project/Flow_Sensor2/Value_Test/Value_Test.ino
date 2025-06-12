
// Working Code for the Valve
const int in1 = 8;
const int in2 = 9;

void setup() {
  pinMode(in1, OUTPUT);
  pinMode(in2, OUTPUT);
}

void loop() {
  // Positive pulse (open valve)
  digitalWrite(in1, LOW);
  digitalWrite(in2, HIGH);
  delay(100); // 100ms pulse
  digitalWrite(in1, LOW);
  digitalWrite(in2, LOW);
  delay(3000); // wait 3 seconds

  // Negative pulse (close valve)
  digitalWrite(in1, HIGH);
  digitalWrite(in2, LOW);
  delay(100); // 100ms pulse
  digitalWrite(in1, LOW);
  digitalWrite(in2, LOW);
  delay(3000); // wait 3 seconds
}
