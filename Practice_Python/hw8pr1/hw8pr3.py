import random

def dart():
    """Throws one dart between (-1,-1) and (1,1).
       Returns True if it lands in the unit circle; otherwise, False.
    """
    x = random.uniform(-1, 1)
    y = random.uniform(-1, 1)
    
    if x**2 + y**2 < 1:
        return True  # HIT (within the unit circle)
    else:
        return False # missed (landed in one of the corners)

def forpi(N):
    """Throws N darts, estimating pi."""
    pi = 42     # A suitably poor initial estimate
    throws = 0  # No throws yet 
    hits = 0    # No "hits" yet  (hits ~ in the circle)
    
    for i in range(N):
        if dart()==True:
            throws=throws+1
            hits=hits+1
        else:
            throws=throws+1
        pi=4*hits/throws
        #print(hits,'hits out of',throws,'throws so that pi is',pi)
        return pi

def whilepi(error):
    """
    returning a number of throws
    """
    pi = 42     # A suitably poor initial estimate
    throws = 0  # No throws yet 
    hits = 0    # No "hits" yet  (hits ~ in the circle)
    
    while abs(pi-3.14159265)>=error:
        if dart()==True:
            throws=throws+1
            hits=hits+1
        else:
            throws=throws+1
        pi=4*hits/throws
    return throws


"""
forpi

Tirals (pi value)
10  # 3.152
100 # 3.092
1000# 3.108

whilepi
error (1000 Trials)
1   # 1.864
.1  # 323.581
.01 # 973.68
.001# 10796.566

# Both functions are about the same for 
esimating Pi accoriding to my data. But specifically looking at 
the n=1000 the forpi function was .1 accurate
and the while pi was .01 accurate for 973 throws, evidence for the 
whilepi to be more efficent 
"""