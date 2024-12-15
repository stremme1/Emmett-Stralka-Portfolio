import pandas as pd
import statsmodels.api as sm

# Load the data
data = pd.read_csv('duke_forest.csv')

# Remove null entries in the 'lot' column
data = data.dropna(subset=['lot'])

# Extract predictor variables (bed, bath, area, year_built, lot) and response variable (price)
X = data[['bed', 'bath', 'area', 'year_built', 'lot']]
y = data['price']

# Add a constant to the predictor variables for the intercept
X = sm.add_constant(X)

# (a) Full Linear Regression Model

# Fit the full linear regression model
full_model = sm.OLS(y, X).fit()

# Display the summary
print("Full Linear Regression Model Summary:")
print(full_model.summary())

# (b) Significantly Correlated Predictors

# Extract p-values from the summary
p_values = full_model.pvalues[1:]

# Set significance level
alpha = 0.05

# Identify significant predictors
significant_predictors = p_values[p_values < alpha]

print(f'\nThe significant predictors are: {significant_predictors.index.tolist()}')

# (c) Forward Selection with p-value Approach

# Manually perform forward selection
selected_features = []
max_p_value = alpha + 1  # Initialize with a value greater than alpha

while max_p_value >= alpha:
    remaining_features = [feature for feature in X.columns if feature not in selected_features]
    p_values = []

    for feature in remaining_features:
        temp_model = sm.OLS(y, sm.add_constant(X[selected_features + [feature]])).fit()
        p_values.append(temp_model.pvalues[feature])

    max_p_value = max(p_values)
    if max_p_value >= alpha:
        selected_feature = remaining_features[p_values.index(max_p_value)]
        selected_features.append(selected_feature)
        print(f'Added feature: {selected_feature}, New max p-value: {max_p_value:.6f}')

# Display the final results
print(f'\nSelected predictors: {selected_features}')
print(full_model.summary())
