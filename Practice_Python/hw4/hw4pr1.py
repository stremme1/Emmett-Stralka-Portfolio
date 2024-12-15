# CS5, hw4pr1
# Filename: hw4pr1.py
# Name: Emmett Stralka
# Problem description: Binary <-> decimal conversions


def isOdd(N):
    if N%2==0:
        return False
    else: 
        return True


def numToBinary(N):
    """Returns Interger to Binary 
    """
    if N == 0:
        return ''
    elif N%2 == 1:
        return   numToBinary(N//2) + '1'
    else:
        return   numToBinary(N//2) + '0'
def binaryToNum(S):
    """Returns a Binary Number to an Integer
    """
    if S == '':
        return 0

    # if the last digit is a '1'...
    elif S[0] ==  '1':
        return 2**(len(S)-1) + binaryToNum(S[1:])

    else: # last digit must be '0'
        return binaryToNum(S[1:])

def increment(S):
    """returns binary number that is one more than the orginial
    numberical value
    """
    x= binaryToNum(S)+1
    return (len(S)-len(numToBinary(x)))*'0' + numToBinary(x)

def count(S, n):
    """
    """
    if n==0:
        return False
    print(n)
    return count(increment(S),n-1)