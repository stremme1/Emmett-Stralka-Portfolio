#
# hw9pr2.py
#
# Name: Emmett Stralka
#

# Here is a function for printing 2D arrays
#  (lists-of-lists) of data

def print2d(A):
    """print2d prints a 2D array, A,
       as rows and columns.
       Argument: A, a 2D list of lists.
       Result: None (no return value)
    """
    num_rows = len(A)
    num_cols = len(A[0])

    for r in range(num_rows):
        for c in range(num_cols):
            print(A[r][c], end = ' ')
        print()

    print()

    return None  # This is implied anyway
                 # when no return statement is present



# Create a 2D array from a 1D string
def createA(num_rows, num_cols, s):
    """Returns a 2D array with
           num_rows rows and
           num_cols columns
       using the data from s: across the
       first row, then across the second, etc.
       We'll only test it with enough data!
    """
    A = []
    for r in range(num_rows):
        newrow = []
        for c in range(num_cols):
            newrow += [s[0]] # Add that char
            s = s[1:]        # Get rid of that first char
        A += [newrow]
    return A

# A couple of tests for createA:
A = [['X', ' ', 'O'], ['O', 'X', 'O']]
newA = createA(2, 3, 'X OOXO')
assert newA == A
print("Is newA == A? Should be True:", newA == A)

A = [['X', 'O'], [' ', 'X'], ['O', 'O'], ['O', 'X']]
newA = createA(4, 2, 'XO XOOOX')
assert newA == A


# For the 3-in-a-row-east function:
A = createA(3, 4, 'XXOXXXOOOOOO')


def inarow_3east(ch, r_start, c_start, A):
    num_rows = len(A)      # Number of rows is len(A)
    num_cols = len(A[0])
    if r_start < 0 or r_start >= num_rows:
    
        return False   
            # Out of bounds in rows

    # Other out-of-bounds checks...
    if c_start < 0 or c_start > num_cols - 3:
        
        return False       # Out of bounds in columns

    # Are all of the data elements correct?
    for i in range(3):                  # Loop index i as needed
        if A[r_start][c_start+i] != ch: # Check for mismatches
            return False                # Mismatch found--return False

    return True 

A = createA(4, 4, 'XXOXXXOXXOO OOOX')


def inarow_3south(ch, r_start, c_start, A):
    num_rows = len(A)      # Number of rows is len(A)
    num_cols = len(A[0])
    if c_start < 0 or c_start >= num_cols:
    
        return False   
            # Out of bounds in rows

    # Other out-of-bounds checks...
    if r_start < 0 or r_start > num_rows - 3:
        
        return False       # Out of bounds in columns

    # Are all of the data elements correct?
    for i in range(3):                  # Loop index i as needed
        if A[r_start+i][c_start] != ch: # Check for mismatches
            return False                # Mismatch found--return False

    return True 

A = createA(4, 4, 'XOOXXXOXX XOOOOX')

def inarow_3southeast(ch, r_start, c_start, A):
    num_rows = len(A)      # Number of rows is len(A)
    num_cols = len(A[0])
    if c_start < 0 or c_start>num_cols-3:
    
        return False   
            # Out of bounds in rows

    # Other out-of-bounds checks...
    if r_start < 0 or r_start > num_rows - 3:
        
        return False       # Out of bounds in columns

    # Are all of the data elements correct?
    for i in range(3):                  # Loop index i as needed
        if A[r_start+i][c_start+i] != ch: # Check for mismatches
            return False                # Mismatch found--return False

    return True 



A = createA(4, 4, 'XOXXXXOXXOXOOOOX')

def inarow_3northeast(ch, r_start, c_start, A):
    num_rows = len(A)      # Number of rows is len(A)
    num_cols = len(A[0])
    if c_start < 0 or c_start>num_cols-3:
        return False   
            # Out of bounds in rows

    # Other out-of-bounds checks...
    if r_start < 2 or r_start >= num_rows:
        return False       # Out of bounds in columns

    # Are all of the data elements correct?
    for i in range(3):                  # Loop index i as needed
        if A[r_start-i][c_start+i] != ch: # Check for mismatches
            return False                # Mismatch found--return False

    return True 

def inarow_Neast(ch, r_start, c_start, A, N):
    """
    """
    num_rows = len(A)      # Number of rows is len(A)
    num_cols = len(A[0])
    if r_start < 0 or r_start >= num_rows:
    
        return False   
            # Out of bounds in rows

    # Other out-of-bounds checks...
    if c_start < 0 or c_start > num_cols - N:
        
        return False       # Out of bounds in columns

    # Are all of the data elements correct?
    for i in range(N):                  # Loop index i as needed
        if A[r_start][c_start+i] != ch: # Check for mismatches
            return False                # Mismatch found--return False

    return True

def inarow_Nsouth(ch, r_start, c_start, A, N):
    num_rows = len(A)      # Number of rows is len(A)
    num_cols = len(A[0])
    if c_start < 0 or c_start >= num_cols:
    
        return False   
            # Out of bounds in rows

    # Other out-of-bounds checks...
    if r_start < 0 or r_start > num_rows - N:
        
        return False       # Out of bounds in columns

    # Are all of the data elements correct?
    for i in range(N):                  # Loop index i as needed
        if A[r_start+i][c_start] != ch: # Check for mismatches
            return False                # Mismatch found--return False

    return True 

def inarow_Nsoutheast(ch, r_start, c_start, A, N):
    """
    """
    num_rows = len(A)      # Number of rows is len(A)
    num_cols = len(A[0])
    if c_start < 0 or c_start>num_cols-N:
    
        return False   
            # Out of bounds in rows

    # Other out-of-bounds checks...
    if r_start < 0 or r_start > num_rows - N:
        
        return False       # Out of bounds in columns

    # Are all of the data elements correct?
    for i in range(N):                  # Loop index i as needed
        if A[r_start+i][c_start+i] != ch: # Check for mismatches
            return False                # Mismatch found--return False

    return True

def inarow_Nnortheast(ch, r_start, c_start, A, N):
    """
    """
    num_rows = len(A)      # Number of rows is len(A)
    num_cols = len(A[0])
    if c_start < 0 or c_start>num_cols-N:
        return False   
            # Out of bounds in rows

    # Other out-of-bounds checks...
    if r_start < N-1 or r_start >= num_rows:
        return False       # Out of bounds in columns

    # Are all of the data elements correct?
    for i in range(N):                  # Loop index i as needed
        if A[r_start-i][c_start+i] != ch: # Check for mismatches
            return False                # Mismatch found--return False

    return True 

A = createA(5, 5, 'XXOXXXOOOOOOXXXX XXXOOOOO')


print("\nNeast :")
print2d(A)
assert inarow_Neast('O', 1, 1, A, 4) == True
assert inarow_Neast('O', 1, 3, A, 2) == True
assert inarow_Neast('X', 3, 2, A, 4) == False
assert inarow_Neast('O', 4, 0, A, 5) == True
print("All Neast tests worked!")


# tests of inarow_Nsouth
A = createA(5, 5, 'XXOXXXOOOOOOXXXXOXXXOOOXO')
print("\nNsouth :")
print2d(A)
assert inarow_Nsouth('X', 0, 0, A, 5) == False
assert inarow_Nsouth('O', 1, 1, A, 4) == True
assert inarow_Nsouth('O', 0, 1, A, 6) == False
assert inarow_Nsouth('X', 4, 3, A, 1) == True
print("All Nsouth tests worked!")


# tests of inarow_Nsoutheast
A = createA(5, 5, 'XOO XXXOXOOOXXXXOXXXOOOXX')
print("\nNsoutheast :")
print2d(A)
assert inarow_Nsoutheast('X', 1, 1, A, 4) == True
assert inarow_Nsoutheast('O', 0, 1, A, 3) == False
assert inarow_Nsoutheast('O', 0, 1, A, 2) == True
assert inarow_Nsoutheast('X', 3, 0, A, 2) == False
print("All Nsoutheast tests worked!")


# tests of inarow_Nnortheast
A = createA(5, 5, 'XOO XXXOXOOOXOXXXOXXXOOXX')
print("\nNnortheast :")
print2d(A)
assert inarow_Nnortheast('X', 4, 0, A, 5) == True
assert inarow_Nnortheast('O', 4, 1, A, 4) == True
assert inarow_Nnortheast('O', 2, 0, A, 2) == False
assert inarow_Nnortheast('X', 0, 3, A, 1) == False
print("All Nnortheast tests worked!")