import numpy as np
import scipy.stats as stats

# Given data
observed_counts = np.array([52, 73, 89, 88, 68, 47, 58, 47, 48, 53, 47, 34, 21, 31, 40, 24, 37, 31, 47, 34, 36, 44, 78, 59])

# Expected counts for a uniform distribution
total_counts = sum(observed_counts)
expected_counts = np.full_like(observed_counts, total_counts / len(observed_counts), dtype=int)

# Adjust expected counts to ensure they sum up to the total observed counts
adjustment = (total_counts - sum(expected_counts)) / len(expected_counts)
expected_counts = expected_counts + adjustment

# Perform chi-square test
chi2, p_value = stats.chisquare(observed_counts, expected_counts)

# Print results
print(f'Chi-square statistic: {chi2:.6f}')
print(f'p-value: {p_value}')

# Check significance at alpha = 0.01
alpha = 0.01
if p_value < alpha:
    print("Reject the null hypothesis. The data suggests that the time of onset of labor is not uniformly distributed throughout the day.")
else:
    print("Fail to reject the null hypothesis. The data is consistent with a uniform distribution of onset times.")
