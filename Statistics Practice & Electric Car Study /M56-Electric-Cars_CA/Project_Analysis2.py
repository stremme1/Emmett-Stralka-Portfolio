import pandas as pd
import matplotlib.pyplot as plt
from scipy.stats import linregress

# Load the dataset
try:
    data = pd.read_csv('CA_ZEV_Survey.csv')  
except FileNotFoundError:
    print("Error: File not found. Please check the file path.")

# Define the columns for environmental care and miles driven
env_care_columns = ['Urgent national need (trunc)']
independent_variable = "Respondent's vehicle's monthly miles"

# Filter out rows with null values in the specified columns
data = data.dropna(subset=[independent_variable] + env_care_columns)

# Convert weekly miles to monthly miles
weekly_to_monthly_conversion = {'Week': 4.33}  # Assuming 4.33 weeks in a month
data[independent_variable] = data[independent_variable] * data['Distance Week/Month'].map(weekly_to_monthly_conversion)

# Filter out data points with monthly miles outside the range of 0-2500
data = data[(data[independent_variable] >= 0) & (data[independent_variable] <= 2500)]

# Extract relevant columns
monthly_miles = data[independent_variable]
env_care_score = data[env_care_columns].sum(axis=1)

# Perform linear regression
slope, intercept, r_value, p_value, std_err = linregress(monthly_miles, env_care_score)

# Scatter plot with regression line
plt.scatter(monthly_miles, env_care_score, label='Data Points')
plt.plot(monthly_miles, slope * monthly_miles + intercept, color='red', label='Regression Line')
plt.xlabel("Respondent's vehicle's monthly miles")
plt.ylabel('Environmental Care Score')
plt.title('Linear Regression: Monthly Miles vs. Environmental Care Score')
plt.legend()
plt.show()

# Print R-squared
print(f"R-squared: {r_value**2:.4f}")

# Print the p-value
print(f"P-value: {p_value}")

# Print the equation of the line
print(f"Equation of the line: Environmental Care Score = {slope:.4f} * Monthly Miles + {intercept:.4f}")

# Print the results of the hypothesis test
if p_value < 0.05:
    print("The number of miles respondents drive is a predictor of their level of environmental care.")
else:
    print("There is no statistically significant linear relationship between the number of miles respondents drive and their level of environmental care.")


# Print the calculated sample sizes
print(f"Sample size for EV group (n_ev_group): {n_ev_group}")
print(f"Sample size for FCV group (n_fcv_group): {n_fcv_group}")
print(f"Sample size for Neither group (n_neither_group): {n_neither_group}")