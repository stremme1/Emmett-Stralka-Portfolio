#
# hw6pr1c.py - checking uniqueness  (for the random-number generator in Hmmm)
#    The test(S) function is already here (below).
#
# Name: 
#
# You'll paste your 100 numbers in this triple-quoted string:
#  (overwriting and removing these six numbers)
NUMBERS = """
3
42
47
46
91
5
"""

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
        return unique(L[1:])  # recursion is OK in this function!       # placeholder


def test(S):
    """test accepts a triple-quoted string, S,
       containing one number per line. It
       returns True if those numbers are all unique
       (or if S is empty); otherwise it returns False
    """
    S = S.strip()               # remove all spaces in front & back of S
    ListOfStrings = S.split()   # split S at each space or newline
    # print("ListOfStrings is", ListOfStrings)
    ListOfIntegers = [int(s) for s in ListOfStrings]  # convert each to an int
    # print("ListOfIntegers is", ListOfIntegers)
    return unique(ListOfIntegers)

# Try it!
result = test(NUMBERS)
print("\nUniqueness test:  The result is", result)
