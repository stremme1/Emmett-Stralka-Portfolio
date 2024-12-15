#
# hw6pr5.py -  Python!
#
#  Gold:   this is "Intro to loops"! (starter code below)
# Black:   this file is not used
#
# Name: Emmett Stralka
#
def fac(n):
    """Loop-based factorial function
       Argument: a nonnegative integer, n
       Return value: the factorial of n
    """
    result = 1                 # starting value - like a base case
    for x in range(1, n + 1):  # loop from 1 to n, inclusive
        result = result * x    # update the result by mult. by x
    return result              # notice this is AFTER the loop!

#
# Tests for looping factorial
#
print("fac(0) should be 1:", fac(0))
print("fac(5) should be 120:", fac(5))


def power(b,p):
    """Accept any numeric value (base) b
    Accept any nonnegative integer (power) p
    returns b**p
    """
    result=1
    for x in range(1,p+1):
        result=result*b
    return result

# print("power(2, 5): should be 32 ==", power(2, 5))
# print("power(5, 2): should be 25 ==", power(5, 2))
# print("power(42, 0): should be 1 ==", power(42, 0))
# print("power(0, 42): should be 0 ==", power(0, 42))
# print("power(0, 0): should be 1 ==", power(0, 0))

def summer(L):
    """Accept any list as input, L
    add up all of the values in L and 
    return that added-up value, the sum
    """
    total=0 
    for x in range(len(L)):
        total= total+L[x]
    return total

# print("summer([10,10,10,2,10]): should be 42 ==", summer([10,10,10,2,10]))
# print("summer([10,10,10,2]): should be 32 ==", summer([10,10,10,2]))
# print("summer([11, 11]): should be 22 ==", summer([11,11]))
# print("summer([47]): should be 47 ==", summer([47]))
# print("summer([ ]): should be 0 ==", summer([ ]))

def summed(L):
    """Loop-based function to return a numeric list.
       ("sum" is built-in, so we're using a different name.)
       Argument: L, a list of integers.
       Result: the sum of the list L.
    """
    result = 0
    for e in L:
        result = result + e    # or result += e
    return result



def summed(L):
    """Loop-based function to return a numeric list.
       ("sum" is built-in, so we're using a different name.)
       Argument: L, a list of integers.
       Result: the sum of the list L.
    """
    result =0
    for x in range(len(L)):
        if L[x]%2 ==1:
            result = result +L[x]
    return result

def summedExcept(exc, L):
    """Take as the first input any integer exc.
    Take as the second input any list of integers L
    return the sum of all of the elements in L except exc. That is, it 
    ignores all of the integers equal to exc
    """
    result=0
    for x in range(len(L)):
        if L[x]==exc:
            result =result
        else: result= result + L[x]
    return result 
        
def summedUpto(exc, L):
    """Take as the first input any integer exc.
    Take as the second input any list of integers L
    return the sum of all of the elements in L upto but not including the first instance of exc. 
    That is, it stops when exc is encountered
    """
    result=0
    for x in range(len(L)):
        if L[x]==exc:
            x= len(L)
        else: result= result + L[x]
    return result 

import random

def countGuesses(hidden):
    """Use a while loop to guess "hidden", from 0 to 99.
       Argument: hidden, a "hidden" integer from 0 to 99.
       Result: the number of guesses needed to guess hidden.
    """
    guess = random.choice(range(0, 100))     # 0 to 99, inclusive
    numguesses = 1                           # We just made one guess, above
    while guess != hidden:
        guess = random.choice(range(0, 100)) # Guess again!
        numguesses += 1                      # Add one to our number of guesses
    return numguesses


def unique(L):
    """Decide whether all elements in L are unique.
       Argument: L, a list of any elements.
       Return value: True, if all elements in L are unique,
                  or False, if there is any repeated element
    """
    if len(L) == 0:
        return True
    elif L[0] in L[1:]:
        return False
    else:
        return unique(L[1:])  # recursion is OK in this function!

def untilARepeat(high):
    """Keeps looping as long as all of the elements in L are unique (no repeats).
    Use the unique(L) function that's provided below—it returns a Boolean.
    """
    L=[]
    guess=0
    while unique(L):
        countguess(high)
        guess= guess+1
    return guess



# Here's what I got when I analyzed 10,000 calls of untilARepeat(365):

# In [1]: sum(L)/len(L)   # The average "birthday room" size
# Out[1]: Poptarts!

# In [2]: max(L)          # The largest "birthday room"
# Out[2]: Poptarts!
 
# In [3]: min(L)          # The smallest "birthday room"
# Out[3]: Poptarts!

# In [4]: 42 in L         # Did any have exactly 42 people?
# Out[4]: Poptarts!

# In [5]: L.count(2)      # How many times did rooms have exactly 2 people? 
# Out[5]: Poptarts!

# In [6]: 1 in L          # Did any have exactly 1 person?
# Out[6]: Poptarts!

# In [7]: 142 in L        # Did any have exactly 142 people?
# Out[7]: Poptarts!


def rs():
    """One random step"""
    return random.choice([-1, 1])


def rwalk(radius):
    """Random walk between -radius and +radius  (starting at 0 by default)"""
    totalsteps = 0          # Starting value of totalsteps (_not_ final value!)
    start = 0               # Start location (_not_ the total # of steps)

    while True:             # Run "forever" (really, until a return or break)
        if start == -radius or start == radius:   
            return totalsteps # Phew!  Return totalsteps (stops the while loop)

        start = start + rs()
        totalsteps += 1     # addn totalsteps 1 (for all who miss Hmmm :-)

        # print("start:", start) # To see what's happening / debugging

    # it can never get here!

"""
First, I created an LC with 10,000 radius-5 random-walk trials, using this line:

   LC = [rwalk(30) for x in range(10000)]

Out of those 10,000 radius-5 trials, the average number of steps
(sum(LC) / len(LC)) needed to reach the boundary was:

++++++++++++
+ 5  avg 25.292
+ 10 avg 99.9826
+ 15 avg 223.1742
+ 20 avg 402.7606
+ 30 avg 892.3916
++++++++++++

"""