import scipy.stats as stats

# Given data
observed_frequencies = [57, 11, 330, 6]
census_proportions = [0.177, 0.032, 0.734, 0.057]
total_observations = sum(observed_frequencies)

# Calculate expected frequencies
expected_frequencies = [total_observations * prop for prop in census_proportions]

# Perform chi-square test
chi2, p_value = stats.chisquare(observed_frequencies, expected_frequencies)

# Print results
print(f'Chi-square statistic: {chi2:.4f}')
print(f'p-value: {p_value:.4f}')

# Check significance at alpha = 0.05
alpha = 0.05
if p_value < alpha:
    print("Reject the null hypothesis. There is evidence that the proportions are different.")
else:
    print("Fail to reject the null hypothesis. The data does not provide enough evidence to conclude a difference in proportions.")
