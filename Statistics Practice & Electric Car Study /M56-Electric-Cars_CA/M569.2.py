import pandas as pd
import statsmodels.api as sm

# (a) Full Linear Regression Model

# Load the data
data = pd.read_csv('wireBonding.csv')  # Replace 'path_to_wireBonding.csv' with the actual path

# Extract predictor variables (x1, x2, x3, time) and response variable (y)
X = data[['Force', 'Power', 'Temperature', 'Time']]
y = data['Strength']

# Add a constant to the predictor variables for the intercept
X = sm.add_constant(X)

# Fit the full linear regression model
full_model = sm.OLS(y, X).fit()

# Display the summary
print("Full Linear Regression Model Summary:")
print(full_model.summary())

# (b) Predict Strength for Given Values

# Given values
force = 35
power = 75
temperature = 200
time = 20

# Predict strength
predicted_strength = full_model.predict([1, force, power, temperature, time])

# Convert the NumPy array to a Pandas Series
predicted_strength_series = pd.Series(predicted_strength)

print(f'The predicted strength for the given values is: {predicted_strength_series.iloc[0]:.2f} gm')


# (c) Significantly Correlated Predictors

# Extract p-values from the summary
p_values = full_model.pvalues[1:]

# Set significance level
alpha = 0.05

# Identify significant predictors
significant_predictors = p_values[p_values < alpha]

print(f'The significant predictors are: {significant_predictors.index.tolist()}')

# (d) Backward Elimination with Adjusted R^2 Approach

# Manually perform backward elimination
selected_features = list(X.columns)
max_r_squared_adj = full_model.rsquared_adj

while len(selected_features) > 1:
    temp_model = sm.OLS(y, X[selected_features]).fit()
    if temp_model.rsquared_adj >= max_r_squared_adj:
        max_r_squared_adj = temp_model.rsquared_adj
        removed_feature = None
    else:
        removed_feature = selected_features.pop()
        print(f'Removed feature: {removed_feature}, New adjusted R^2: {max_r_squared_adj:.6f}')

# Display the final results
print(f'\nSelected predictors: {selected_features}')
print(full_model.summary())
