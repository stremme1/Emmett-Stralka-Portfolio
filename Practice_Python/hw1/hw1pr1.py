# CS5, hw1pr1
# Filename: hw1pr1.py
# Name: Emmett Stralka
# Problem description: Second Python lab, problem 1!

pi = [3, 1, 4, 1, 5, 9]
e = [2, 7, 1]

# Example problem (problem 0):  [2, 7, 5, 9]
answer0 = e[0:2] + pi[-2:]  
print("answer0:", answer0)


pi[0]

e[1:]

pi[0:6:2]

e[0:2] + pi[-2:]

first = e[0:2] + pi[4:]

second = e[1:]

answer1  = e[1:2]+pi[1:2]
print('Answer 1', answer1)

answer2 = pi[-1:] + e[-1:] + e[-1:]
print('Answer 2', answer2)

answer3 = pi[1:]
print('Answer 3', answer3)

answer4 = pi[1:2] + e[0:1] + pi[0:10:2] 
print('Answer 4', answer4)

# Lab1 string practice

h = 'harvey'
m = 'mudd'
c = 'college'

answer5 = h[0:1]+c[-1:]+h[-1:]
print('Answer 5', answer5)

answer6 = c[0:4]+m[1:3]+c[-1:]
print('Answer 6', answer6)

answer7 = h[1:]+m[1:]
print('Answer 7', answer7)

extra = h[0:4]+h[1:3]+m[-1:]+' '+m[0:1]+h[-2:-1]+m[-1:]
print('or', extra)

answer8 = h[0:3] +m[-1:] +c[-1:]+h[0:3]+h[0:3]+h[0:3]
print('Answer 8', answer8)

answer9 = c[3:6]+c[1:2]+m[0:1]+h[-1:]+c[4:6]+c[1:2]
print('Answer 9', answer9)

answer10 = c[0:5:2]+h[1:3]+c[0:1]+h[1:2]+c[2:4]
print('Answer 10', answer10)
