import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import linregress

# Given data
temperature = np.array([170, 172, 173, 174, 174, 175, 176, 177, 180, 180, 180, 180, 180, 181, 181, 182, 182, 182, 182, 184, 184, 185, 186, 188])
ratio = np.array([0.84, 1.31, 1.42, 1.03, 1.07, 1.08, 1.04, 1.80, 1.45, 1.60, 1.61, 2.13, 2.15, 0.84, 1.43, 0.90, 1.81, 1.94, 2.68, 1.49, 2.52, 3.00, 1.87, 3.08])

# (a) Prepare: Write down the null and alternative hypotheses.
# Null Hypothesis (H0): There is no relationship between temperature and efficiency ratio.
# Alternative Hypothesis (H1): There is a significant relationship between temperature and efficiency ratio.
print("Null Hypothesis (H0): There is no relationship between temperature and efficiency ratio.")
print("Alternative Hypothesis (H1): There is a significant relationship between temperature and efficiency ratio.\n")

# (b) Check: Input temperature and ratio as numpy arrays. Confirm conditions for fitting a least-squares line.
# Plotting
plt.scatter(temperature, ratio, label='Data Points')
plt.xlabel('Temperature')
plt.ylabel('Efficiency Ratio')
plt.title('Temperature vs. Efficiency Ratio')

# (c) Calculate: Print the slope and y-intercept of the least-squares line, the coefficient of determination R^2, and the p-value.
# Perform linear regression
slope, intercept, r_value, p_value, std_err = linregress(temperature, ratio)

# Calculate R-squared
r_squared = r_value**2

# Print results
print(f"Slope: {slope:.4f}")
print(f"Intercept: {intercept:.4f}")
print(f"R-squared: {r_squared:.4f}")
print(f"P-value: {p_value:.4f}")

# Plot least-squares line in red
line = slope * temperature + intercept
plt.plot(temperature, line, color='red', label='Regression Line')

# Show legend and plot
plt.legend()
plt.show()

# (d) Conclude: Provide a conclusion to your hypothesis test in the context of the problem.
# Check if p-value is less than the significance level (α = 0.05)
if p_value < 0.05:
    print("Conclusion: Reject the null hypothesis. There is a significant relationship between temperature and efficiency ratio.")
else:
    print("Conclusion: Fail to reject the null hypothesis. There is no significant relationship between temperature and efficiency ratio.")
