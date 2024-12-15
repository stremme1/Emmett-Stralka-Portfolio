# CS 5 Gold, hw2pr3
# filename: hw2pr3.py
# Name: Emmett Stralka
# problem description: List comprehensions



# this gives us functions like sin and cos...
from math import *



# two more functions (not in the math library above)

def dbl(x):
    """Doubler!  argument: x, a number"""
    return 2*x

def sq(x):
    """Squarer!  argument: x, a number"""
    return x**2



# examples for getting used to list comprehensions...

def lc_mult(N):
    """This example accepts an integer N
       and returns a list of integers
       from 0 to N-1, **each multiplied by 2**
    """
    return [2*x for x in range(N)]

def lc_idiv(N):
    """This example accepts an integer N
       and returns a list of integers
       from 0 to N-1, **each divided by 2**
       WARNING: this is INTEGER division...!
    """
    return [x//2 for x in range(N)]

def lc_fdiv(N):
    """This example accepts an integer N
       and returns a list of integers
       from 0 to N-1, **each divided by 2**
       NOTE: this is floating-point division...!
    """
    return [x/2 for x in range(N)]


# Here is where your functions start for the lab:

# Step 1, part 1
def unitfracs(N):
    """divides N into equal peices with evenly 
    spaced fractions on unit interval 0-1
    """
    return [x/N for x in range(N)]

def scaledfracs(low,high,N):
    """Scledfracs takes the high and a low and a interger N 
    It returns a list of the high - the low plus the 
    frac which is the equal distance or the quality of 
    rectangles 
    """
    frac=(high-low)/N
    return [low+(x*frac) for x in range(N)]

def sqfracs(low, high, N):
    """
    Inputs the low, high, and N and returns 
    N numbers in a list. The numbers are low added to the 
    fraction of high-low/N squared
    """
    frac=(high-low)/N
    return [(low+(x*frac))**2 for x in range(N)]


def f_of_fracs(f, low, high, N):
    """F_of_fracs returns a height of a rectangle at its left most edpoint 
    of N rectangles for a function f
    """
    frac=(high-low)/N
    return [f(low+(x*frac)) for x in range(N)]


def integrate(f, low, high, N):
    """Integrate returns an estimate of the definite integral
       of the function f (the first argument)
       with lower limit low (the second argument)
       and upper limit high (the third argument)
       where N steps are taken (the fourth argument)

       integrate simply returns the sum of the areas of rectangles
       under f, drawn at the left endpoints of N uniform steps
       from low to high
    """
    return sum(f_of_fracs(f, low, high, N))*(high-low)/N
    



"""Q1. 
Integration works by approximating the area. It does this 
by creating rectangles under the curve. If the curve is not 
flat the rectangles will not be flush on the curve 
and there will be some gapping leading to 
an approximation less than the acutal value.

An integral that would overestimate would consider the right endpoints 
on a increasing slope ( in this case the problem had a slope of 2 y=2x 
so it would be postive considering the left and underesimating) and the left on a decreasing slope
The recangles would be slighly over the the curve instead of under
and that would increase the area. 
A function that would be overesimated would be y=-2x
"""

"""Q2. 
integrate(c, 0, 2, 2)
3.732
integrate(c, 0, 2, 20)
3.228
integrate(c, 0, 2, 2000)
3.
integrate(c, 0, 2, 20000)
3.
The intergral has less of an overestimation and gets closer to the actual value 
the more recatngles you create the finer the resolution 
and less of the error when approximating.
"""