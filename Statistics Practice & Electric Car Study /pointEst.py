import numpy as np
import matplotlib.pyplot as plt

# Population size
n = 100000

# Parameter of interest (proportion of yes votes)
p = 0.63

# Number of yes votes
yeses = np.ones(round(p * n))
# Number of no votes
nos = np.zeros(round((1 - p) * n))

# Combine yeses and nos
votes = np.append(yeses, nos)

# Sample size
samp = 1000

# Number of samples
trials = 10000

# Point estimate for each sample
phat = np.zeros(trials)

for i in range(trials):
    # Sampling without replacement
    poll = np.random.choice(votes, size=samp, replace=False)

    # Store point estimate for each sample (proportion of yeses in poll)
    phat[i] = np.mean(poll)

# Find and print most extreme estimates
phatMax = np.max(phat)
phatMin = np.min(phat)

print("Maximum point estimate (phatMax):", phatMax)
print("Minimum point estimate (phatMin):", phatMin)

# Plot a histogram for phat with 30 bins (sampling distribution)
plt.hist(phat, bins=30, edgecolor='k')
plt.xlabel('Sampled Proportions (phat)')
plt.ylabel('Frequency')
plt.title('Sampling Distribution of Proportions')
plt.show()
