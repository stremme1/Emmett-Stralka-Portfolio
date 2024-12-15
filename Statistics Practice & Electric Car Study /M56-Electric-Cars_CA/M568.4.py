import pandas as pd
import matplotlib.pyplot as plt

# (a) Read mammals.csv into Python, then make a scatter plot of body weight (x) vs. brain weight (y). Label the axes.
# Assuming 'mammals.csv' is in the same directory as your script or notebook

# Read the CSV file into a pandas DataFrame
data = pd.read_csv('mammals.csv')

# Scatter plot
plt.scatter(data['body_wt'], data['brain_wt'])
plt.xlabel('Body Weight (kg)')
plt.ylabel('Brain Weight (g)')
plt.title('Scatter Plot: Body Weight vs. Brain Weight')
plt.show()

# (b) Identify the three clear outliers
# You can visually inspect the scatter plot and/or programmatically find the outliers
# One common method is to use the z-score to identify data points that are significantly different from the mean.

# Calculate z-scores for body weight and brain weight
z_scores_bodywt = (data['body_wt'] - data['body_wt'].mean()) / data['body_wt'].std()
z_scores_brainwt = (data['brain_wt'] - data['brain_wt'].mean()) / data['brain_wt'].std()

# Identify outliers (considering z-score threshold, e.g., 3)
outliers = data[(abs(z_scores_bodywt) > 3) | (abs(z_scores_brainwt) > 3)]

# Print the species of the identified outliers
print("Outliers:")
print(outliers[['species', 'body_wt', 'brain_wt']])
