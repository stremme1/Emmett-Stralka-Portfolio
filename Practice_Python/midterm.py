def firstIsUniq(S):
    if S[0] in S[1:]:
        return False
    else: return True


def remAll(e,L):
    if len(L)==0:
        return L
    elif L[0] !=e:
        return L[0:1]+remAll(e,L[1:])
    else: return remAll(e,L[1:])


def uniqScore(S):
    if S=='':
        return 0
    if firstIsUniq(S)==True:
        remAll(S[0],S)
        return 1+ uniqScore(S[1:])

    else: return uniqScore(S[1:])



def mostUniq(L):
    LC= [uniqScore(c) for c in L]
    return max(LC)








def mystery( L ):
    result = 0
    for i in range(len(L)):
        if L[i] == i:
            result += 1
        if L[i] == L[i-1]:
            result = 20
        elif L[i] == 0:
            result *= 2
    return result
