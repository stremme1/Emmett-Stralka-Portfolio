import numpy as np
from scipy.sparse import diags
from scipy.sparse.linalg import spsolve
from PIL import Image


def gradient_regularization(img_array, alpha=1, lambda_=1):
    # Convert image to grayscale if it's in color
    if len(img_array.shape) > 2:
        img_array = np.mean(img_array, axis=2)
        
    # Get image dimensions
    n_rows, n_cols = img_array.shape
    
    # Calculate Laplacian of the image
    laplacian = np.zeros_like(img_array)
    laplacian[:-1, :] += np.abs(np.diff(img_array, axis=0))
    laplacian[:, :-1] += np.abs(np.diff(img_array, axis=1))
    laplacian[1:, :] += np.abs(np.diff(img_array, axis=0))
    laplacian[:, 1:] += np.abs(np.diff(img_array, axis=1))
    
    # Construct the sparse matrix
    diagonal_values = np.zeros((n_rows * n_cols + (n_rows - 1) * n_cols + (n_cols - 1) * n_rows))
    row_diags = np.zeros((n_rows, n_cols))
    row_diags[:, 0] = 1
    row_diags[:, -1] = -1
    for i in range(n_rows):
        diagonal_values[i*n_cols : (i+1)*n_cols] = row_diags[i, :]
        
    col_diags = np.zeros((n_rows, n_cols))
    col_diags[0, :] = 1
    col_diags[-1, :] = -1
    for j in range(n_cols):
        diagonal_values[(n_rows * n_cols) + (2 * n_rows - 2) * j : (n_rows * n_cols) + (2 * n_rows - 1) * j] = col_diags[:, j]
        
    D = diags(diagonal_values, [0], shape=(n_rows * n_cols, n_rows * n_cols))
    
    # Calculate the restored image
    restored_img = np.linalg.inv(np.eye(n_rows * n_cols) + alpha * D.T @ D + lambda_ * np.eye(n_rows * n_cols)) @ img_array.flatten()
    restored_img = restored_img.reshape((n_rows, n_cols))
    
    return restored_img


# Load the noisy image
noisy_img = np.array(Image.open("/Users/emmettstralka/Desktop/Images/TEST.png"))

# Restore the image using gradient regularization
restored_img = gradient_regularization(noisy_img)

# Display the restored image
Image.fromarray(restored_img.astype(np.uint8)).show()

# Save the restored image to a file
restored_image = Image.fromarray(restored_img.astype(np.uint8))
restored_image.save("/Users/emmettstralka/Desktop/TESTN.png")
