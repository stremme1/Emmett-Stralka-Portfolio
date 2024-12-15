import numpy as np

# Define your 3x3 matrix
matrix = np.array([[1, 0, 0,0],
                   [.5, 0, .5,0],
                   [0, .5, 0,.5],
                   [0,0,0,1]])

# Define the desired power (e.g., to raise the matrix to the power of 2)
power = 2

# Calculate the result
result_matrix = np.linalg.matrix_power(matrix, power)

# Print the result
print("Original Matrix:")
print(matrix)
print(f"Matrix raised to the power of {power}:")
print(result_matrix)


# Compute the eigenvalues and eigenvectors
eigenvalues, eigenvectors = np.linalg.eig(matrix.T)  # Transpose for left eigenvectors

# Find the index of the eigenvalue closest to 1 (within a small tolerance)
index = np.argmin(np.abs(eigenvalues - 1))

# Extract the corresponding eigenvector
stationary_vector = np.real(eigenvectors[:, index])

# Normalize the stationary vector to make it a probability distribution
stationary_vector /= np.sum(stationary_vector)

print("Stationary Distribution:")
print(stationary_vector)
