import cv2
import numpy as np
import os

# Path to the known images
known_path = "/Users/emmettstralka/Desktop/NAMEDI"
# Initialize lists to hold the known images and their labels
known_images = []
labels = []
# Loop over each subfolder in the known_path
for subfolder in os.listdir(known_path):
    subfolder_path = os.path.join(known_path, subfolder)
    # Remove any .DS_Store files that might be present
    if os.path.isfile(subfolder_path):
        continue
    if ".DS_Store" in os.listdir(subfolder_path):
        os.remove(os.path.join(subfolder_path, ".DS_Store"))
    # Loop over each image in the subfolder
    for filename in os.listdir(subfolder_path):
        image_path = os.path.join(subfolder_path, filename)
        # Load the image and convert it to grayscale
        image = cv2.imread(image_path)
        gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
        # Crop the image to focus on the face
        # You can use any face detection algorithm here
        # In this example, we're using Haar cascades
        face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + "haarcascade_frontalface_default.xml")
        faces = face_cascade.detectMultiScale(gray, scaleFactor=1.1, minNeighbors=5)
        (x, y, w, h) = faces[0]
        cropped = gray[y:y+h, x:x+w]
        # Resize the image to a fixed size
        resized = cv2.resize(cropped, (200, 200), interpolation=cv2.INTER_LINEAR)
        # Add the image and its label to the lists
        known_images.append(resized)
        labels.append(subfolder)
# Train the recognizer

# Train the recognizer
recognizer = cv2.face.LBPHFaceRecognizer_create()
recognizer.train(known_images, np.array(labels))

# Path to the unknown images
unknown_path = "/Users/emmettstralka/Desktop/UNKNOWNI"

# Loop over each image in the unknown images directory
for filename in os.listdir(unknown_path):
    image_path = os.path.join(unknown_path, filename)
    # Load the image and convert it to grayscale
    image = cv2.imread(image_path)
    gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    # Crop the image to focus on the face
    # You can use any face detection algorithm here
    # In this example, we're using Haar cascades
    face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + "haarcascade_frontalface_default.xml")
    faces = face_cascade.detectMultiScale(gray, scaleFactor=1.1, minNeighbors=5)
    if len(faces) == 0:
        continue
    (x, y, w, h) = faces[0]
    cropped = gray[y:y+h, x:x+w]
    # Resize the image to a fixed size
    resized = cv2.resize(cropped, (200, 200), interpolation=cv2.INTER_LINEAR)
    # Recognize the face in the image
    label, confidence = recognizer.predict(resized)
    # Display the recognized face and confidence level
    cv2.putText(image, f"{label}", (x, y-10), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 0), 2)
    cv2.imshow("Image", image)
    cv2.waitKey(0)

cv2.destroyAllWindows()
# Close
