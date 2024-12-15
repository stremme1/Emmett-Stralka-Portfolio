#
# Example user-interaction looping program
#  (a variant of the one done in class)
#
 

import math
import statistics
from telnetlib import BM

def menu():
    """Prints the menu of options that the user can choose."""
    print("(0) Input a new list")
    print("(1) Print the current list")
    print("(2) Find the average price")
    print("(3) Find the Standard Deviation")
    print("(4) Find the minimum and its day")
    print("(5) Find the maximum and its day")
    print("(6) Your TT investment plan")
    print("(9) Break! (quit)")


def stnddev(L):
    """returns the standard Deviation of the list"""
    st=0
    for x in range(len(L)):
        st+= (((L[x]-statistics.mean(L)))**2/len(L))
    return st**.5

def predict(L):
    """Predict ignores its argument and returns
       what the next element should have been.
    """
    return 42

def find_min(L):
    """find min uses a loop to return the minimum of L.
       Argument L: a nonempty list of numbers.
       Return value: the smallest value in L.
    """
    result = L[0]
    for x in L:
        if x < result:     # A smaller one was found!
            result = x
    return result

def find_min_loc(L):
    """find min loc uses a loop to return the minimum of L
            and the location (index or day) of that minimum.
        Argument L: a nonempty list of numbers.
        Results:  the smallest value in L, its location (index)
    """
    minval = L[0]
    minloc = 0

    for i in list(range(len(L))):
        if L[i] < minval:  # A smaller one was found!
            minval = L[i]
            minloc = i

    return minval, minloc

def TTrade(L):
    """compares two values in a list and returns the 
    greatest diffrence in chronological order"""
    cmax = 0
    for b in range(len(L)):
        for s in range(b,len(L)):
            if L[s] - L[b]>cmax:
                cmax=L[s] - L[b]
                buymin=L[b]
                sellmax=L[s]
                sl=s
                bl=b
    print(f"The max profit is {cmax}, the day to buy is {bl} at a price of {buymin} the day to sell is {sl} at a price of {sellmax}.")
    #return cmax,bl,buymin,sl,sellmax

def main():
    """The main user-interaction loop."""
    secret_value = 4.2

    L = [30, 10, 20]  # an initial list

    while True:       # The user-interaction loop
        print("\n\nThe list is", L)
        menu()
        choice = input("Choose an option: ")

        #
        # "Clean and check" the user's input
        # 
        try:
            choice = int(choice)   # Make into an int!
        except:
            print("I didn't understand your input! Continuing...")
            continue

        #
        # Run the appropriate menu option
        #
        if choice == 9:    # We want to quit
            break          # Leaves the while loop altogether

        elif choice == 1:  # We want to continue (and print) ...
            print("Continuing...")
            continue       # Goes back to the top of the while loop,
                           # ..where it will print L

        elif choice == 0:  # We want to enter a new list
            newL = input("Enter a new list: ")    # Enter _something_
            
            #
            # "Clean and check" the user's input
            #
            try: 
                newL = eval(newL) # eval runs Python's interpreter! Note: Danger!
                if type(newL) != type([]): 
                    print("That didn't seem like a list. Not changing L.")
                else: 
                    L = newL  # Here, things were OK, so let's set our list, L
            except:
                print("I didn't understand your input. Not changing L.")

        elif choice == 2:  # Predict and add the next element
            n = predict(L) # Get the next element from the predict function
            print("The next element is", n)
            print("Adding it to your list...")
            L = L + [n]    # ...and add it to the list

        elif choice == 3:  # Unannounced menu option!
            print(stnddev(L))           # This is the "nop" (do-nothing) statement in Python

        elif choice == 4:  # Unannounced menu option (more interesting...)
            m = find_min(L)
            print("The minimum value in L is", m)

        elif choice == 5:  # Even more interesting unannounced menu option...
            minval, minloc = find_min_loc(L)
            print("The minimum value in L is", minval, "at day #", minloc)
        
        elif choice==6: 
            print(TTrade(L))
            


        else:
            print(choice, " ?      That's not on the menu!")

    print()
    print("See you yesterday!")