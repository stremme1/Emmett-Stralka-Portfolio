# CS5, hw1pr3
# Filename: hw1pr3.py
#
# Name: Emmett Stralka
# Problem description: Function Frenzy!
#





def transcribe(S):
    

#
#
def mult(n,m):
    """  mult returns the product of its two arguments
       Arguments: n and m are both integers
       Return value: the result of multiplying n and m 
    """
    if m == 0:
        return 0
    elif m > 0:
        return n + mult(n, m-1)
    else:
        return -n+mult(n,m+1)

print( "mult(6, 7)           should be  42 :",  mult(6, 7) )
print( "mult(6, -7)          should be  -42 :",  mult(6, -7) )
print( "mult(-6, 7)          should be  -42 :",  mult(-6, 7) )
print( "mult(-6, -7)         should be  42 :",  mult(-6, -7) )
print( "mult(6, 0)           should be  0 :",  mult(6, 0) )
print( "mult(0, 7)           should be  0 :",  mult(0, 7) )
print( "mult(0, 0)           should be  0 :",  mult(0, 0) )



def dot(L,K):
    """ dot returns the dot product of its two arguments
       Arguments: L and K are both integers or Strings of Integers
       Return value: the result is Multiplying L and K coresponding values 
       and adding them together
    """
    if len(L) != len(K) or len(L) == 0 or len(K) == 0:
        return 0
    else:
        return L[0]*K[0]+dot(L[1:],K[1:])

print( "dot([5, 3], [6, 4])  should be  42.0 :",  dot([5, 3], [6, 4]) )
print( "dot([5, 3], [6])     should be  0.0 :",  dot([5, 3], [6]) )
print( "dot([], [6])         should be  0.0 :",  dot([], [6]) )
print( "dot([], [])          should be  0.0 :",  dot([], []) )
print( "dot([1, 2, 3, 4], [10, 100, 1000, 10000]) should be  43210.0 :",  dot([1, 2, 3, 4], [10, 100, 1000, 10000]) )

def ind(e,L):
    """ Ind returns the number location where the value 'e' occurs in the list L"
    """
    if e not in L:
        return len(L)
    elif len(L)== 0:
        return 0
    elif e ==L[0]:
        return 0
    elif e in L:
        return 1+ind(e,L[1:])


print( "ind(42, [55, 77, 42, 12, 42, 100]) should be  2 :",  ind(42, [55, 77, 42, 12, 42, 100]) )
print( "ind(55, [55, 77, 42, 12, 42, 100]) should be  0 :",  ind(55, [55, 77, 42, 12, 42, 100]) )
print( "ind(42, list(range(0, 100)))       should be  42 :",  ind(42, list(range(0, 100))) )
print( "ind('hi', ['hello', 42, True])     should be  3 :",  ind('hi', ['hello', 42, True]) )
print( "ind('hi', ['well', 'hi', 'there']) should be  1 :",  ind('hi', ['well', 'hi', 'there']) )
print( "ind('i', 'team')                   should be  4 :",  ind('i', 'team') )
print( "ind(' ', 'outer exploration')      should be  5 :",  ind(' ', 'outer exploration') )


def letterScore(let):
     """ Letter Score inputs let a single of charater
     and adds a coresponding value to it
     """
     scoreOf =  { 'a': 1,  'b': 3,  'c': 3,  'd': 2,  'e': 1,
              'f': 4,  'g': 2,  'h': 4,  'i': 1,  'j': 8,
              'k': 5,  'l': 1,  'm': 3,  'n': 1,  'o': 1,
              'p': 3,  'q': 10, 'r': 1,  's': 1,  't': 1,
              'u': 1,  'v': 4,  'w': 4,  'x': 8,  'y': 4,  
              'z': 10   }
     if let not in scoreOf:
         return 0
     else:
         return scoreOf[let]

def scrabbleScore(S):
    """ This function Recursive function tests the Value of a Letter 
    and adds the value to a total and returns the total value of the letters in the string
    """
    if len(S) ==0:
        return 0
    else:
        return letterScore(S[0])+scrabbleScore(S[1:])

print( "scrabbleScore('quetzal')           should be  25 :",  scrabbleScore('quetzal') )
print( "scrabbleScore('jonquil')           should be  23 :",  scrabbleScore('jonquil') )
print( "scrabbleScore('syzygy')            should be  25 :",  scrabbleScore('syzygy') )
print( "scrabbleScore('?!@#$%^&*()')       should be  0 :",  scrabbleScore('?!@#$%^&*()') )
print( "scrabbleScore('')                  should be  0 :",  scrabbleScore('') )
print( "scrabbleScore('abcdefghijklmnopqrstuvwxyz') should be  87 :",  scrabbleScore('abcdefghijklmnopqrstuvwxyz') )






