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

# Identify outliers using the function
outliers = identify_outliers(data, 'body_wt', 'brain_wt', z_threshold=3)

# Filter out the outliers (brain_wt < 1000)
data_no_outliers = data[data['brain_wt'] < 1000]

# Perform linear regression without outliers
slope_no_outliers, intercept_no_outliers, _, _, _ = linregress(data_no_outliers['body_wt'], data_no_outliers['brain_wt'])

# Perform linear regression with outliers
slope_with_outliers, intercept_with_outliers, _, _, _ = linregress(data['body_wt'], data['brain_wt'])

# Print equations of the least-squares line
equation_no_outliers = f"y = {slope_no_outliers:.4f}x + {intercept_no_outliers:.4f}"
equation_with_outliers = f"y = {slope_with_outliers:.4f}x + {intercept_with_outliers:.4f}"

print("Equation of the least-squares line without outliers:", equation_no_outliers)
print("Equation of the least-squares line with outliers:", equation_with_outliers)

# Scatter plot with both regression lines
plt.scatter(data_no_outliers['body_wt'], data_no_outliers['brain_wt'], label='Data Points (Without Outliers)')
plt.scatter(data['body_wt'], data['brain_wt'], alpha=0.3, label='Data Points (With Outliers)')
plt.plot(data_no_outliers['body_wt'], slope_no_outliers * data_no_outliers['body_wt'] + intercept_no_outliers,
         color='red', label='Regression Line (Without Outliers)')
plt.plot(data['body_wt'], slope_with_outliers * data['body_wt'] + intercept_with_outliers,
         color='green', label='Regression Line (With Outliers)')
plt.xlabel('Body Weight (kg)')
plt.ylabel('Brain Weight (g)')
plt.title('Scatter Plot with Linear Regression: Body Weight vs. Brain Weight')
plt.axis([0, 1000, 0, 1000])  # Set axes limits
plt.legend()
plt.show()
