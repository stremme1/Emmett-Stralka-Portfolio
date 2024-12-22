
def symmetric(S):
    for i in range(len(S)):
        for j in range(len(S[1])):
                if S[i][j] == S[i+1][j+1]: # A mismatch!
                    return True
    else: return False                 # All offsets succeeded, so we return True
def isPrime(n):
    if n < 2: # not needed
        return False
    for i in range(2, n):   # n//2 is ok, as is int(math.sqrt(n))
        if n % i == 0:
            return False
    return True

def addPrimes(L):
    if len(L) == 0:
        return 0
    else:
        if isPrime(L[0]):
            return L[0] + addPrimes(L[1:])
        else:
            return addPrimes(L[1:])
def addPrimes(L):
    LC = [ x for x in L if isPrime(x) ]  # get all primes!
    return sum(LC)

def uniquify(L):
    if len(L) == 0:
        return []
    else:
        if L[0] in L[1:]:
            return uniquify(L[1:])
        else:
            return L[0:1] + uniquify(L[1:])

def median(L):
    
    SL = sort(L)    # uses sort from week 4!
    N = len(SL)

    if N % 2 == 1:
        return SL[N//2]
    else:
        return (SL[N//2-1] + SL[N//2])/2.0

def symmetric(S):
    for i in range(len(S)):
        for j in range(len(S[i])):
            if S[i][j] != S[j][i]:
                return False
    return True

def max(self, m2):
    minrows = min(m2.NRows, self.NRows)
    mincols = min(m2.NCols, self.NCols)
    M = Matrix(minrows, mincols)
    for i in range(minrows):
        for j in range(mincols):
            M.data[i][j] = max(self.data[i][j], 
                                  m2.data[i][j])
    return M


def firstIsUniq( s ):
    if s[0] in s[1:]:
        return False # s[0] is not unique
    else:
        return True # s[0] is unique!

def uniqScore( s ):
    if s == '':
        return 0 # here, empty case == empty string!
    elif firstIsUniq(s) == True:
        return 1 + uniqScore(s[1:]) # s[0] is unique: count it!
    else:
        return 0 + uniqScore(s[1:])

def uniqScore(s):
    LC = [ firstIsUniq(s[i:]) for i in range(len(s)) ]
    result = sum(LC) # True == 1, False == 0
    return result

def mostUniq( L ):
    LoL = [ [uniqScore(s),s] for s in L ]
    bestpr = max(LoL) # finds pair w/ maximum score
    result = bestpr[1] # gets original word from the pair
    return result

