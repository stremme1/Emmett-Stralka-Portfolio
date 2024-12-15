class Board:
    """A data type representing a Connect-4 board
       with an arbitrary number of rows and columns.
    """

    def __init__(self, width, height):
        """Construct objects of type Board, with the given width and height."""
        self.width = width
        self.height = height
        self.data = [[' ']*width for row in range(height)]

        # We do not need to return anything from a constructor!

    def __repr__(self):
        """This method returns a string representation
           for an object of type Board.
        """
        s = ''                          # The string to return
        for row in range(0, self.height):
            s += '|'
            for col in range(0, self.width):
                s += self.data[row][col] + '|'
            s += '\n'

        s += (2*self.width + 1) * '-' + "\n"
        s+= ' '
        for col in range(7):
            s += str(col) + ' '   # Bottom of the board
        

        return s
        
    def addMove(self, col, ox):
        """represents the index 
        of the column to which the checker will be added
        """
        H=self.height
        for row in range(0,H):
            if self.data[row][col]!=' ':
                self.data[row-1][col]=ox
                return
        self.data[H-1][col]=ox
        return self

    def clear(self):
        """clears the board of any ox"""
        for i in range(self.width):
            for j in range(self.height):
                if self.data[j][i]!=' ':
                    self.data[j][i]=' '

    
        return self
    


      # The board is complete; return it





# This is the end of the Board class
# Below are some boards that will be re-created each time the file is run:

    def setBoard(self, moveString):
        """Accepts a string of columns and places
            alternating checkers in those columns,
            starting with 'X'.

            For example, call b.setBoard('012345')
            to see 'X's and 'O's alternate on the
            bottom row, or b.setBoard('000000') to
            see them alternate in the left column.

            moveString must be a string of one-digit integers.
        """
        nextChecker = 'X'   # start by playing 'X'
        for colChar in moveString:
            col = int(colChar)
            if 0 <= col <= self.width:
                self.addMove(col, nextChecker)
            if nextChecker == 'X':
                nextChecker = 'O'
            else:
                nextChecker = 'X'


            H = self.height
            W = self.width
            D = self.data

            # Check to see if ox wins, starting from any checker:
            for row in range(H):
                for col in range(W):
                    if inarow_Neast(ox, row, col, D, 4) == True:
                        return True
                    # you need three more, very similar, such checks
                    # for the three other directions!

            # but, if it looks at EACH row and col and never finds a win...
            return False     # only gets here if it never returned True, above


    def allowsMove(self, c):
        """return True if the calling object (of type Board) 
        does allow a move into column c. 
        It returns False if column c is not a legal column number
        """
        if self.data[self.height-1][c] !=' ':
            return False
        else: return True
        


    def isFull(self):
        """return True if the calling object (of type Board) is 
        completely full of checkers. It should return False
        """
        result=0
        for i in range(self.width):
            if self.allowsMove(i)==False:
                result +=1
                

        
            return result==self.width


    def delMove(self, c):
        """remove the top checker from the column c. 
        If the column is empty, then delMove should do nothing
        """
        H =self.height
        for row in range(0,H):
            if self.data[row][c] !=' ':
                self.data[row][c]=' '
                return

    def winsFor(self, ox):
        """ox is a 1-character checker: either 'X' or 'O'. 
        It should return True if 
        there are four checkers of type ox in a row on the board
        """
        H = self.height
        W = self.width
        D = self.data

            # Check to see if ox wins, starting from any checker:
        for row in range(H):
            for col in range(W):
                if inarow_Neast(ox, row, col, D, 4) == True:
                    return True
                if inarow_Nnortheast(ox, row, col, D, 4) == True:
                    return True
                if inarow_Nsouth(ox, row, col, D, 4) == True:
                    return True
                if inarow_Nsoutheast(ox, row, col, D, 4) == True:
                    return True
                    # you need three more, very similar, such checks
                    # for the three other directions!

            # but, if it looks at EACH row and col and never finds a win...
        return False     # only gets here if it never returned True, above
        
    def hostGame(self):
        """hosts game using the self and board class
        for connect four, prints board, 
        """
        print('Welcome to Connect Four!')
        while self.winsFor==False:

          # _while_ not valid
            users_col = int(input("Choose a column: "))
            if users_col==True:
                print('please pick a new input that column is full')
                users_col = int(input("Choose a column: "))
            self.addMove(self, users_col, 'X')
            

          # _while_ not valid
            user2_col = int(input("Choose a column: "))
            if users_col==True:
                print('please pick a new input that column is full')
                users_col = int(input("Choose a column: "))   
            self.addMove(self, user2_col, 'O')
                
        print('win--Congratulations!')






            
def inarow_Neast(ch, r_start, c_start, A, N):
    """checks if there is four in a row east 
        returns true if 4 in a row false is not
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


def inarow_Neast(ch, r_start, c_start, A, N):
    """Starting from (row, col) of (r_start, c_start)
       within the 2d list-of-lists A (array),
       returns True if there are N ch's in a row
       heading east and returns False otherwise.
    """
    H = len(A)
    W = len(A[0])
    if r_start < 0 or r_start > H - 1:
        return False            # Out-of-bounds row
    if c_start < 0 or c_start + (N-1) > W - 1:
        return False            # O.o.b. column
    # loop over each location _offset_ i
    for i in range(N):
        if A[r_start][c_start+i] != ch: # A mismatch!
            return False
    return True                 # All offsets succeeded, so we return True

def inarow_Nsouth(ch, r_start, c_start, A, N):
    """Starting from (row, col) of (r_start, c_start)
       within the 2d list-of-lists A (array),
       returns True if there are N ch's in a row
       heading south and returns False otherwise.
    """
    H = len(A)
    W = len(A[0])
    if r_start < 0 or r_start + (N-1) > H - 1:
        return False # out of bounds row
    if c_start < 0 or c_start > W - 1:
        return False # o.o.b. col
    # loop over each location _offset_ i
    for i in range(N):
        if A[r_start+i][c_start] != ch: # A mismatch!
            return False
    return True                 # All offsets succeeded, so we return True

def inarow_Nnortheast(ch, r_start, c_start, A, N):
    """Starting from (row, col) of (r_start, c_start)
       within the 2d list-of-lists A (array),
       returns True if there are N ch's in a row
       heading northeast and returns False otherwise.
    """
    H = len(A)
    W = len(A[0])
    if r_start - (N-1) < 0 or r_start > H - 1:
        return False # out of bounds row
    if c_start < 0 or c_start + (N-1) > W - 1:
        return False # o.o.b. col
    # loop over each location _offset_ i
    for i in range(N):
        if A[r_start-i][c_start+i] != ch: # A mismatch!
            return False
    return True                 # All offsets succeeded, so we return True

def inarow_Nsoutheast(ch, r_start, c_start, A, N):
    """Starting from (row, col) of (r_start, c_start)
       within the 2d list-of-lists A (array),
       returns True if there are N ch's in a row
       heading southeast and returns False otherwise.
    """
    H = len(A)
    W = len(A[0])
    if r_start < 0 or r_start + (N-1) > H - 1:
        return False            # Out-of-bounds row
    if c_start < 0 or c_start + (N-1) > W - 1:
        return False            # O.o.b. column
    # loop over each location _offset_ i
    for i in range(N):
        if A[r_start+i][c_start+i] != ch: # A mismatch!
            return False
    return True                 # All offsets succeeded, so we return True





        
    def winsFor(self, ox):
        """ox is a 1-character checker: either 'X' or 'O'. 
        It should return True if 
        there are four checkers of type ox in a row on the board
        """
        H = self.height
        W = self.width
        D = self.data

            # Check to see if ox wins, starting from any checker:
        for row in range(H):
            for col in range(W):
                if inarow_Neast(ox, row, col, D, 4) == True:
                    return True
                if inarow_Nnortheast(ox, row, col, D, 4) == True:
                    return True
                if inarow_Nsouth(ox, row, col, D, 4) == True:
                    return True
                if inarow_Nsoutheast(ox, row, col, D, 4) == True:
                    return True
                    # you need three more, very similar, such checks
                    # for the three other directions!

            # but, if it looks at EACH row and col and never finds a win...
        return False     # only gets here if it never returned True, above
        
    def hostGame(self):
        """hosts game using the self and board class
        for connect four, prints board, 
        """
        print('Welcome to Connect Four!')
        while winsFor==True:

            while self.allowsMove(users_col) == False:  # _while_ not valid
                users_col = int(input("Choose a column: "))
                if users_col==True:
                    print('please pick a new input that column is full')
                    users_col = int(input("Choose a column: "))
                addMove(self, users_col, 'X')
                break

            while self.allowsMove(users_col) == False:  # _while_ not valid
                user2_col = int(input("Choose a column: "))
                if users_col==True:
                    print('please pick a new input that column is full')
                    users_col = int(input("Choose a column: "))   
                addMove(self, user2_col, 'O')
                break
            continue
        print('win--Congratulations!')


