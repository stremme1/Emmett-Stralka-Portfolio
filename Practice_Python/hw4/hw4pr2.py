# CS5, hw4pr1
# Filename: hw4pr1.py
# Name: Emmett Stralka
# Problem description: Binary <-> decimal conversions


from xml.etree.ElementTree import C14NWriterTarget


def isOdd(N):
    if N%2==0:
        return False
    else: 
        return True
def binToNum(S):
    """Converts a binary to decimal int
    """
    if S=='': return 0
    else: return 2*binToNum(S[1:])+ int(S[-1])
def numToTernary(N):
    """ takes in a base 10 number 
    covers it into ternary interger"""
    if N==0:
        return ''
    elif N%3 ==1:
        return numToBinary(N//3)+'1'
    elif N%3 ==2:
        return numToTernary(N//3)+'2'
    else:
        return numToTernary(N//3)+ '0'





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



def numToBaseB(N,B):
    """Converts a binary string to a decimal in of Base B 

    """
    if N==0:
        return ''
    elif N//B ==1:
        return numToBaseB(N//B,B)+'1'
    else:
        return numToBaseB(N//B,B)+'0'




def numToBaseB(N,B):
    """Converts a binary string to a decimal in of Base B 
    """
    if N==0: 
        return ''
    else: return numToBaseB(N//B,B)+str(N%B)

def baseBToNum(S, B):
    """accepts binary number with base B and returns
    Number"""

    if S=='': return 0
    else: return B*baseBToNum(S[:-1],B)+int(S[-1])

def baseToBase(B1, B2, s_in_B1):
    """Accepts a number with Base B1 and 
    return the same number but in Base B2
    """
    new1= baseBToNum(s_in_B1,B1)
    return numToBaseB(new1,B2)

def add(S,T):
    """ takes two binary strings S and T 
    and returns their sum, also in binary.
    """
    new1=binaryToNum(S)
    new2=binaryToNum(T)
    return numToBinary(new1+new2)



def addB(S, T):
    """ adds two base2 numbers in binary  
    """
    if S=='':
        return T
    if T=='':
        return S
    
    if S[-1] == '0' and T[-1] == '0':
        return addB(S[:-1], T[:-1]) + '0' 
    if S[-1] == '1' and T[-1] == '0' or S[-1] == '0' and T[-1] == '1' :
        return addB(S[:-1], T[:-1]) + '1'  
    if S[-1] == '1' and T[-1] == '1':
        return addB(addB(S[:-1], T[:-1]), '1')  + '0'
    


def frontNum(S):
    """returns the # of times
    the first element of the input $
    appears consecutively at the start of S 
    """
    if len(S)<= 1:
        return len(S)
    elif S[0]==S[1]:
        return 1 + frontNum(S[1:])
    else:
        return 1

    
def compress(S):
    """S of length less than or equal to 64, 
    and returns another binary result
    """
    if len(S)==0:
        return ''
    numffront = frontNum(S)
    digitfront= S[0]
    binarynum= numToBinary(numffront)
    binarynum=(7-numffront)*'0' + binarynum
    return digitfront + binarynum+ compress(S[numffront:])
    



def uncompress(C):
    """Uncompressed the Compressfuntion's binary result
    into a S length 
    """
    if len(C)==0:
        return ''
    C1= C[0:8]
    frontnum=C1[0]
    return frontnum*binaryToNum(C1[1:])+ uncompress(C[8:])

