import pandas as pd
from scipy import stats

# (a) Read textbooks.csv into Python
file_path = '/Users/emmettstralka/Desktop/MATH56/MATH56_project/textbooks.csv'
textbooks_data = pd.read_csv(file_path)

# Assign the column 'diff' anbd variable priceDiff
priceDiff = textbooks_data['diff']

# Find the mean and standard deviation priceDiff
mean_diff = priceDiff.mean()
std_diff = priceDiff.std()

print(f"Mean of priceDiff: {mean_diff}")
print(f"Standard Deviation of priceDiff: {std_diff}")

# (b) One-sample t-test
# Null hypothesis: The average price for all textbooks at the UCLA bookstore is the same as at Amazon.
# Alternative hypothesis: The average price for all textbooks at the UCLA bookstore is different from at Amazon.

# Ssignifiance level (α)
alpha = 0.05

# Perform one-sample t-test
t_stat, p_value = stats.ttest_1samp(priceDiff, popmean=0)

# Print t-statistic and p-value
print(f"t-statistic: {t_stat}")
print(f"P-value: {p_value}")

# Compare p-value to the significance level
if p_value < alpha:
    print("Reject the null hypothesis. There is significant evidence that the average price for textbooks at the UCLA bookstore is different from Amazon.")
else:
    print("Fail to reject the null hypothesis. There is not enough evidence to conclude a difference in average prices between the UCLA bookstore and Amazon.")
