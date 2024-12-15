import pandas as pd
from scipy import stats
import matplotlib.pyplot as plt

# Read the data set into Python
file_path = 'EmployeeAttrition.csv' 
employee_data = pd.read_csv(file_path)

# Remove null entries in the satisfaction level column
employee_data = employee_data.dropna(subset=['satisfaction_level'])

# 4: Two- t-test for employees experienced a work accident
work_accident_data = employee_data[employee_data['Work_accident'] == 1]['satisfaction_level']
no_work_accident_data = employee_data[employee_data['Work_accident'] == 0]['satisfaction_level']

t_stat_work_accident, p_value_work_accident = stats.ttest_ind(work_accident_data, no_work_accident_data, equal_var=False)

print(f"Two-sample t-test for work accident:")
print(f"T-statistic: {t_stat_work_accident}")
print(f"P-value: {p_value_work_accident}")

# Compare p-value to the significance level (α)
alpha_work_accident = 0.05
if p_value_work_accident < alpha_work_accident:
    print("Reject the null hypothesis. Job satisfaction is different for employees who have experienced a work accident.")
else:
    print("Fail to reject the null hypothesis. There is not enough evidence to conclude a difference in job satisfaction between employees with and without work accidents.")





#  5: Two- t-test  employees promoted in the last 5 years
promoted_data = employee_data[employee_data['promotion_last_5years'] == 1]['satisfaction_level']
not_promoted_data = employee_data[employee_data['promotion_last_5years'] == 0]['satisfaction_level']

t_stat_promotion, p_value_promotion = stats.ttest_ind(promoted_data, not_promoted_data, equal_var=False)

print(f"\nTwo-sample t-test for promotion in the last 5 years:")
print(f"T-statistic: {t_stat_promotion}")
print(f"P-value: {p_value_promotion}")

# Compare p-value to the significance level (α)
alpha_promotion = 0.05
if p_value_promotion < alpha_promotion:
    print("Reject the null hypothesis. Job satisfaction is different for employees who have recently been promoted.")
else:
    print("Fail to reject the null hypothesis. There is not enough evidence to conclude a difference in job satisfaction between employees who have and have not been promoted in the last 5 years.")





# 6: Plot histograms for job satisfaction based on salary level
salary_levels = employee_data['salary'].unique()

for salary_level in salary_levels:
    salary_data = employee_data[employee_data['salary'] == salary_level]['satisfaction_level']
    
    plt.hist(salary_data, bins=30, alpha=0.5, label=salary_level)
    plt.xlabel('Job Satisfaction')
    plt.ylabel('Frequency')
    plt.title(f'Histogram of Job Satisfaction for {salary_level} Salary')
    plt.legend()
    plt.show()

# Explain why the normality condition is not satisfied for ANOVA
# Note: This explanation is based on the visual inspection of histograms.
print("\nExplanation for ANOVA normality condition:")
print("The histograms show that the distributions of job satisfaction for different salary levels are not perfectly normal.")
print("There are deviations from normality, such as skewness and multimodality, which violate the assumption required for ANOVA.")
