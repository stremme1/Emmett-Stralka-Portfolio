import pandas as pd
import matplotlib.pyplot as plt
from scipy.stats import linregress

# Read the CSV file into a pandas DataFrame
data = pd.read_csv('mammals.csv')

# Remove rows with 'NA' entries for total sleep
data_cleaned = data[data['total_sleep'].notna()].copy()

# Compute brain weight to body weight ratio
data_cleaned['brain_ratio'] = 0.001 * (data_cleaned['brain_wt'] / data_cleaned['body_wt'])

# Perform linear regression
slope, intercept, r_value, p_value, std_err = linregress(data_cleaned['brain_ratio'], data_cleaned['total_sleep'])

# Scatter plot with least-squares line
plt.scatter(data_cleaned['brain_ratio'], data_cleaned['total_sleep'], label='Data Points')
plt.plot(data_cleaned['brain_ratio'], slope * data_cleaned['brain_ratio'] + intercept, color='red', label='Regression Line')
plt.xlabel('Brain Weight Ratio (g/kg)')
plt.ylabel('Total Sleep (hours)')
plt.title('Linear Regression: Brain Weight Ratio vs. Total Sleep')
plt.legend()
plt.show()

# Print the p-value from linear regression
print(f"P-value: {p_value:.4f}")

# Check significance at α = 0.05
if p_value < 0.05:
    print("The data support that 'smarter' animals sleep more at a significance level of 0.05.")
else:
    print("There is not enough evidence to support that 'smarter' animals sleep more at a significance level of 0.05.")
