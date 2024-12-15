





def dot(row, v):
    """Returns the dot product of the list row with the list v.
       Note that row and v should have the same number of elements.
       Otherwise, we will return 0 here...
    """
    if len(row) != len(v):
        return 0

    result = 0
    for i in range(len(v)):
        result = result + row[i]*v[i]
    return result

M = [[2, 9], [1, -2]]
v = [3, 4]


def matmult(M, v):
    """matmult returns the matrix multiplication Mv.
       M is a list of lists, a square matrix (same number of rows and columns).
       v is a list of the same length as each element (row) of M.
    """
    nmv=[]
    for i in range(len(M)):
        nmv+= [dot(M[i],v)]
        
    return nmv
