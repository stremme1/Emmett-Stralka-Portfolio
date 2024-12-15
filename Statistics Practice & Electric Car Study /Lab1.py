import matplotlib.pyplot as plt
import numpy as np
#base matrix (no chutes or ladders)
n = 101
M = np.zeros((n,n))

for i in range(n-1):
    startInd = i+1
    endInd = min(i+7,n)

    M[i,startInd:endInd] = 1/6

    #fill in rows 96-101 (incorporate rules for winning the game)
    if i>n-7:
        M[i,i] = 1-(n-i-1)/6

#chutes and ladders
C = np.zeros((101,101))

#Ladders
C[1,38] = 1
C[4,14] = 1
C[9,31] = 1
C[21,42] = 1
C[28,84] = 1
C[36,44] = 1
C[51,67] = 1
C[71,91] = 1
C[80,100] = 1

#Chutes
C[16,6] = 1
C[47,26] = 1
C[49,11] = 1
C[56,53] = 1
C[62,19] = 1
C[64,60] = 1
C[87,24] = 1
C[93,73] = 1
C[95,75] = 1
C[98,78] = 1

#positions that aren't ladders or chutes
for i in range(n):
    if C[i].sum() < 0.5:
        C[i,i] = 1

#complete matrix (product of base matrix and chutes/ladders matrix)
P = np.matmul(M,C)
for i in range(n):
    print(P[5][i])

# Define your initial state vector
v = np.zeros(101)
v[0] = 1

its = 0

while v[100] == 0:
    print("Iteration:", its)
    v = np.dot(P.T, v)
    its += 1

print("Final state vector v[100]:", v[100])
print("Number of iterations:", its)