import scipy.stats as stats

# Data
permanent_molding = [45.5, 45.3, 45.4, 44.4, 44.6, 43.9, 44.6, 44.0]
die_casting = [44.2, 43.9, 44.7, 44.2, 44.0, 43.8, 44.6, 43.1]
plaster_molding = [46.0, 45.9, 44.8, 46.2, 45.1, 45.5]

# Perform ANOVA
f_statistic, p_value = stats.f_oneway(permanent_molding, die_casting, plaster_molding)

# Print results
print(f"F-statistic: {f_statistic}")
print(f"P-value: {p_value}")

# Compare p-value to the significance level (α)
alpha = 0.01
if p_value < alpha:
    print("Reject the null hypothesis. There is significant evidence that the casting procedure affects the average elastic modulus.")
else:
    print("Fail to reject the null hypothesis. There is not enough evidence to conclude that the casting procedure affects the average elastic modulus.")

#  two-sided t-test  die casting and  plaster molding
t_statistic, p_value_die_casting_plaster = stats.ttest_ind(die_casting, plaster_molding, equal_var=False)

# Bonferroni correction
alpha_bonferroni = alpha / 3  # Divide alpha (two-sided)
alpha_bonferroni
print(f"(α*): {alpha_bonferroni}")

# Print t-statistic and p-value
print(f"T-statistic: {t_statistic}")
print(f"P-value (Bonferroni corrected): {p_value_die_casting_plaster}")

# Compare p-value vs corrected SL (α_bonferroni)
if p_value_die_casting_plaster < alpha_bonferroni:
    print("Reject the null hypothesis. There is significant evidence that the true average elastic modulus is different for die casting than for plaster molding.")
else:
    print("Fail to reject the null hypothesis. There is not enough evidence to conclude a difference in the true average elastic modulus between die casting and plaster molding.")
