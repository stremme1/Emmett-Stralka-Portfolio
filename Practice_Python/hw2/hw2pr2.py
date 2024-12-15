# CS5 Gold, hw2pr2
# Filename: hw2pr2.py
# Name: Emmett Stralka
# Problem description: Sleepwalking student

import random  

def rs():
    """rs chooses a random step and returns it.
       Note that a call to rs() requires parentheses.
       Arguments: none at all!
    """
    return random.choice([-1, 1])

import time

def rwpos(start, nsteps):
    """ rwpos models a random walker that
        * starts at the int argument, start
        * takes the int # of steps, nsteps

        rwpos returns the final position of the walker.
    """
    time.sleep(0.1)
    print('location is', start)
    if nsteps == 0:
        return start
    else:
        newpos = start + rs()  # take one step
        return rwpos(newpos, nsteps - 1)

def rwsteps(start, low, high):
    """ rwsteps models a random walker that
        * starts at the int argument, start  
        * goes UNTIL reaching low or high
          (low will always be less than high)

        rwsteps returns the number of steps the
        walker needed to reach the lower or upper bound
    """
    
    print('🏞'+"_"*(start-low) + '🦜'+"_"*(high-start)+'🏞')     # this is the beginning of a "terminal-graphics" wandering...
    time.sleep(0.05)

    s=start + rs()
    if s<low or s>high: 
        return False
    rwsteps(s, low, high)




def poptart_royale(start1,start2,L,H ):
    """
    This simulator observes two Birds, Start1 and Start2, racing to reach 
    the final two lands The rainforest and Anartica, within the Claremont Colleges. 

    start1:  the location of the first bird (who wanders)
    start2:  the location of the Second bird (who wanders)
    L:  the location of the Low end of the area
    H:  the location of the high end of the area
    Ensure that Start1 and Start2 are both values within the range of L to H
   
    """ 
    time.sleep(0.05)
    if start1<= start2: 
        print('🏞'+"_"*(start1-L) + '🦜'+"_"*(start2- start1)+'🐦'+"_"*(H-start2)+'🏞')
    if start2<=start1:
        print('🏞'+"_"*(start2-L) + '🐦'+"_"*(start1- start2)+'🦜'+"_"*(H-start1)+'🏞')


    s1=start1 + rs()
    s2 = start2 + rs()
    if s1<L or s1<L: 
        return False
    if start1 == L or start2 == L:
        print("You made it to the Amazon Rainforest Buddy")
        return False
    if start1 == H or start2 == H:
        print("You made it to the Anartica Buddy")
        return False
    else:

        poptart_royale(s1, s2,L, H)