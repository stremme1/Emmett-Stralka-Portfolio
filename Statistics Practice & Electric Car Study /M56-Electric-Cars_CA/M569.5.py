import numpy as np
import matplotlib.pyplot as plt
import scipy.stats as stats

# Given data
observed_frequencies = np.array([4, 15, 23, 25, 38, 31, 32, 14, 10, 8])
total_observations = sum(observed_frequencies)

# Calculate expected proportions
expected_proportions = np.array([(5.5 - abs(i - 5.5)) / 30 for i in range(1, 11)])

# Calculate expected frequencies
expected_frequencies = total_observations * expected_proportions

# Perform chi-square test
chi2, p_value = stats.chisquare(observed_frequencies, expected_frequencies, ddof=1)

# Print results
print(f'Chi-square statistic: {chi2:.4f}')
print(f'p-value: {p_value:.4f}')

# Check significance at alpha = 0.05
alpha = 0.05
if p_value < alpha:
    print("Reject the null hypothesis. The data is not consistent with the expected proportions.")
else:
    print("Fail to reject the null hypothesis. The data is consistent with the expected proportions.")

# Plotting
locations = np.arange(1, 11)
plt.bar(locations, expected_proportions, color='blue', label='Expected Proportions')
plt.scatter(locations, observed_frequencies / total_observations, color='red', marker='*', label='Observed Proportions')
plt.xlabel('Location')
plt.ylabel('Proportion')
plt.legend()
plt.show()
