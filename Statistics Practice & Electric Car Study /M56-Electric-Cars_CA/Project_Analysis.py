import pandas as pd
from scipy.stats import ttest_ind, shapiro

# Load the dataset
data = pd.read_csv('CA_ZEV_Survey.csv')  # Replace 'your_dataset.csv' with your actual dataset file

# Define the columns for car types and environmental concerns
car_type_column = "No Trucks, Plus Incentives: drivetrain design 1"
env_care_columns = [
'Urgent national need (trunc)',

]

# Filter out rows with null values in the car type column
data = data.dropna(subset=[car_type_column])

# Calculate the environmental care score by summing relevant factors
data['Environmental Care Score'] = data[env_care_columns].sum(axis=1)

# Separate data into groups based on car type
ev_group = data[data[car_type_column].isin(['EV', 'ZEV','HEV','PHEV', 'FCV'])]['Environmental Care Score']
gas_group = data[data[car_type_column] == 'Gas']['Environmental Care Score']

# Perform a t-test
t_statistic, p_value = ttest_ind(ev_group, gas_group, equal_var=False)

# Print the results
print(f"T-statistic: {t_statistic}")
print(f"P-value: {p_value}")

# Check for statistical significance at a significance level of 0.05
if p_value < 0.05:
    print("The difference in environmental care scores between EV/ZEV/etc. and Gas cars is statistically significant.")
else:
    print("There is no statistically significant difference in environmental care scores between EV/ZEV and Gas cars.")


