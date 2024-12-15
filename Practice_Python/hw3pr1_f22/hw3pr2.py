
from re import L


NEXT_CHAR = { "a": "b", "A": "B",
              "b": "c", "B": "C",
              "c": "d", "C": "D",
              "d": "e", "D": "E",
              "e": "f", "E": "F",
              "f": "g", "F": "G",
              "g": "h", "G": "H",
              "h": "i", "H": "I",
              "i": "j", "I": "J",
              "j": "k", "J": "K",
              "k": "l", "K": "L",
              "l": "m", "L": "M",
              "m": "n", "M": "N",
              "n": "o", "N": "O",
              "o": "p", "O": "P",
              "p": "q", "P": "Q",
              "q": "r", "Q": "R",
              "r": "s", "R": "S",
              "s": "t", "S": "T",
              "t": "u", "T": "U",
              "u": "v", "U": "V",
              "v": "w", "V": "W",
              "w": "x", "W": "X",
              "x": "y", "X": "Y",
              "y": "z", "Y": "Z",
              "z": "a", "Z": "A",
}


def shift1(c):
    """ rotate 1 character, c, by 1 place 
        c must be 1 character.
        non-characters don't change!
    """
    if c not in NEXT_CHAR:   # if c is NOT there,
        return c             # just return it unchanged
    else:
        return NEXT_CHAR[c]  # else return the next char

def shiftN(c, N):
        """ returns c, shifted by N spots """
        if N == 0: 
            return c
        return shiftN( shift1(c), N-1 )

def shifts(s):
        """ returns c, shifted by N spots """
        if len(s) == 0: 
            return s
        return shift1(s[0])+ shifts(s[1:])

def encipher(s, N):
    """Shifts String S, N spaces
    """
    
    if N == 0:
        return s 
    else:
        return encipher(shifts(s),N-1)

def letProb(c):
    """If c is the space character or an alphabetic character,
       we return its monogram probability (for english),
       otherwise we return 1.0.  We ignore capitalization.
       Adapted from
       http://www.cs.chalmers.se/Cs/Grundutb/Kurser/krypto/en_stat.html
       Note: this should really be converted into a dictionary!
    """
    if c == ' ': return 0.1904
    elif c == 'e' or c == 'E':
        return 0.1017
    elif c == 't' or c == 'T':
        return 0.0737
    elif c == 'a' or c == 'A':
        return 0.0661
    elif c == 'o' or c == 'O':
        return 0.0610
    elif c == 'i' or c == 'I':
        return 0.0562
    elif c == 'n' or c == 'N':
        return 0.0557
    elif c == 'h' or c == 'H':
        return 0.0542
    elif c == 's' or c == 'S':
        return 0.0508
    elif c == 'r' or c == 'R':
        return 0.0458
    elif c == 'd' or c == 'D':
        return 0.0369
    elif c == 'l' or c == 'L':
        return 0.0325
    elif c == 'u' or c == 'U':
        return 0.0228
    elif c == 'm' or c == 'M':
        return 0.0205
    elif c == 'c' or c == 'C':
        return 0.0192
    elif c == 'w' or c == 'W':
        return 0.0190
    elif c == 'f' or c == 'F':
        return 0.0175
    elif c == 'y' or c == 'Y':
        return 0.0165
    elif c == 'g' or c == 'G':
        return 0.0161
    elif c == 'p' or c == 'P':
        return 0.0131
    elif c == 'b' or c == 'B':
        return 0.0115
    elif c == 'v' or c == 'V':
        return 0.0088
    elif c == 'k' or c == 'K':
        return 0.0066
    elif c == 'x' or c == 'X':
        return 0.0014
    elif c == 'j' or c == 'J':
        return 0.0008
    elif c == 'q' or c == 'Q':
        return 0.0008
    elif c == 'z' or c == 'Z':
        return 0.0005
    else:
        return 1.0



def listscore(S):
    """ This function Recursive function tests the Value of a Letter 
    and adds the value to a total and returns the total value of the letters in the string
    """
    if len(S) ==0:
        return 0
    else:
        return letProb(S[0])+listscore(S[1:])

def decipher(s):
    LC = [encipher(s, n) for n in range(26)]
        # keep this print until everything works!
    LoL = [[listscore(x),x] for x in LC ]
    maxscore= max(LoL)
    return maxscore[1]

def count(e,L):
    """
    """
    return len([e for x in L if x==e])




def blsort(L):
    """accept a list L and returns
     a list with the same elements as L,
      in ascending order"""
    if len(L)==0:
        return []
    else:
        return count(0,L)*[0]+count(1,L)*[1]



def remone(e,L):
    """returns seq. L with all e's removd
    """
    if len(L)==0:
        return L
    elif L[0]!=e:
        return L[0:1]+remone(e,L[1:])
    else:
        return L[1:]

def gensort(L):
    if len(L)==0:
        return []
    else:
        return [min(L)] + gensort(remone(min(L),L))




def jscore(S, T):
    """ two strings, S and T and returns 
    the number of characters in S that are shared by T. 
    Repeated letters are counted multiple times
    """
    if T==''or S=='':
        return 0
    elif S[0] in T:
        T= remone(S[0],T)
        return 1+jscore(S[1:],T[1:])
    else:
        return jscore(S[1:],T)


def exact_change(target_amount, L):
    """Then, exact_change should return either True or False
    it should return True if it's possible to create target_amount with list L
    False if it is uable to create the Target_amount
    """
    if target_amount==0:
        return True
    if L==[]:
        return False
    elif target_amount<0:
        return False  
    else:
        COIN=L[0]
        a = exact_change(target_amount,L[1:])
        b = exact_change(target_amount-L[0], L[1:])
        if (b== True or a==True):
            return True
    return False



def LCS(S, T):
    """which will accept two strings, 
    S and T. LCS should return the longest common 
    subsequence (LCS) that S and T share
    """
    if S=='' or T=='':
        return ''
    if S[0]==T[0]:
        return S[0]+LCS(S[1:],T[1:])
    result1 = LCS(S[1:], T)
    result2 = LCS(T[1:] ,S)
    if len(result1)>len(result2):
        return result1
    else:
        return result2