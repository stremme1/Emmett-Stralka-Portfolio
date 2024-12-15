import scipy.stats as stats

# Provided data
sample_sizes = [8, 13, 17, 14]
sample_means = [43.0, 42.4, 43.1, 43.5]
sample_sds = [1.5, 1.3, 1.2, 1.2]

# Degrees of freedom for groups and error
df_groups = len(sample_sizes) - 1
df_error = sum(sample_sizes) - len(sample_sizes)

# Calculate MSG + MSE
grand_mean = sum([mean * size for mean, size in zip(sample_means, sample_sizes)]) / sum(sample_sizes)

msg_numerator = sum([size * (mean - grand_mean)**2 for mean, size in zip(sample_means, sample_sizes)])
msg_denominator = len(sample_sizes) - 1
msg = msg_numerator / msg_denominator

mse_numerator = sum([(size - 1) * sd**2 for size, sd in zip(sample_sizes, sample_sds)])
mse_denominator = df_error
mse = mse_numerator / mse_denominator

# Calculate F-score and p-value
f_score = msg / mse
p_value = 1 - stats.f.cdf(f_score, df_groups, df_error)

# Print the results
print(f"MSG: {msg}")
print(f"MSE: {mse}")
print(f"F-score: {f_score}")
print(f"P-value: {p_value}")

# Compare p-value to the significance level (α)
alpha = 0.05
if p_value < alpha:
    print("Reject the null hypothesis. There is significant evidence that there are differences in true average fat content for different feeding regimes.")
else:
    print("Fail to reject the null hypothesis. There is not enough evidence to conclude differences in true average fat content between feeding regimes")
