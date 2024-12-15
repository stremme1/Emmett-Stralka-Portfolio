# CS5, Lab1 part 2
# Filename: hw1pr2.py
# Name: Emmett Stralka
# Problem description: First few functions!



def sq(x):
    """Result: returns X multiplied by iteself (Squared)!
    """
    return x*x

def interp(low,high,fraction):
    """Interp Takes the first Low and the second High and subtracts them to find a number
    then multiplies by the fraction the Third Variable
    """
    print ((high-low)*fraction)



def checkends(s):
    """Checkends inputs a 'string' s and returns 
    False if the ends of the string do not match the first character
    and True if the first and last match
    """
    if s[0:1]==s[-1:]:
        return True
    else:
        return False
    return


d= { 5:'five', 42:'forty-two'}

def has42(f):
    """has42 calls on a previously made dictionary d and checks if f 
    called 42 if it did it is true if not false
    """
    if 42 in d:
        return True
    else:
        return False

def hasKey(k,d):
    """hasKey checks if k is in the dictionary d if not it returns false
    """
    if k in d:
        return True
    else:
        return False


def flipside(s):
    """flipside switches the fist and last half of a string around
    it the length of a string s is even it works evenly
    if the length of a string s is odd then the the first half
     will have one less charater than the last half
    """
    H= len(s)
    gh=(len(s))//2
    if (H % 2)==0:
        first=s[:gh]
        second=s[gh:]
        s=second+first
    else:
        first=s[:gh]
        second=s[gh:]
        s=second+first
    return s


def convertFromSeconds(s):# Number of days
    """CoverFromSeconds takes the number of seconds s and converts the largest amount first days 
    then hours, minutes, seconds the result is a coutdown timer
    """
    days = s // (24*60*60)
    s = s % (24*60*60)
    hours= s// (60*60)
    s = s % (60*60)
    minutes= s//(60)
    s = s % (60)     # The leftover 
    seconds = s// 1
    return [days, hours, minutes, seconds]


