import cv2
import os
import numpy as np

# Define the path to the input image
input_folder_path = os.path.join(os.path.expanduser("~"), "Desktop", "NAMEI")
input_image_path = os.path.join(input_folder_path, "input_image.jpg")

# Load the input image as a grayscale image
input_image = cv2.imread(input_image_path, cv2.IMREAD_GRAYSCALE)

# Perform SVD on the input image
U, S, Vt = np.linalg.svd(input_image)

# Set the number of singular values to keep for compression
k = 50

# Truncate the SVD matrices to compress the image
U_k = U[:, :k]
S_k = np.diag(S[:k])
Vt_k = Vt[:k, :]
compressed_image = np.dot(U_k, np.dot(S_k, Vt_k))

# Normalize the compressed image to 0-255 range and convert back to uint8
compressed_image = cv2.normalize(compressed_image, None, 0, 255, cv2.NORM_MINMAX, dtype=cv2.CV_8U)

# Save the compressed image with the suffix "_new" in the same folder
output_image_path = os.path.join(input_folder_path, "compressed_image_new.jpg")
cv2.imwrite(output_image_path, compressed_image)
