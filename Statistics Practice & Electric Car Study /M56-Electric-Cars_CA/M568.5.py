import pandas as pd
import matplotlib.pyplot as plt
from scipy.stats import linregress

# Function to identify outliers based on z-scores
def identify_outliers(data, x_col, y_col, z_threshold=3):
    z_scores_x = (data[x_col] - data[x_col].mean()) / data[x_col].std()
    z_scores_y = (data[y_col] - data[y_col].mean()) / data[y_col].std()
    outliers = data[(abs(z_scores_x) > z_threshold) | (abs(z_scores_y) > z_threshold)]
    return outliers

# Read the CSV file into a pandas DataFrame
data = pd.read_csv('mammals.csv')

# Perform linear regression
slope, intercept, r_value, p_value, std_err = linregress(data['body_wt'], data['brain_wt'])

# Calculate R-squared
r_squared = r_value**2

# Scatter plot with regression line
plt.scatter(data['body_wt'], data['brain_wt'], label='Data Points')
plt.plot(data['body_wt'], slope * data['body_wt'] + intercept, color='red', label='Regression Line')
plt.xlabel('Body Weight (kg)')
plt.ylabel('Brain Weight (g)')
plt.title('Scatter Plot with Linear Regression: Body Weight vs. Brain Weight')
plt.axis([0, 1000, 0, 1000])  # Set axes limits
plt.legend()
plt.show()

# Print R-squared
print(f"R-squared: {r_squared:.4f}")
