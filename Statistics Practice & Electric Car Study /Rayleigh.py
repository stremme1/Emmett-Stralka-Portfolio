import numpy as np
import matplotlib.pyplot as plt

# Define the parameters for the distribution
x = np.arange(31)
v0 = 7
rayleigh = np.multiply(x, np.exp((-x**2) / (2 * v0**2)))
distSum = np.sum(rayleigh)
normRayleigh = 1 / distSum * rayleigh

# Sample 10,000 wind speeds from the probability distribution
n = 10000
windSpeeds = np.random.multinomial(n, normRayleigh)

# Calculate the normalized probabilities
normalized_probabilities = windSpeeds / n

# Create a bar plot
plt.bar(x, normalized_probabilities)
plt.xlabel('wind speed (m/s)')
plt.ylabel('probability')
plt.title('Sampled Wind Speed Distribution (n = 10,000)')
plt.show()
