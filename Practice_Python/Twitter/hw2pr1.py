from turtle import *

t = Turtle()

t.shape('turtle')  # or 'arrow'

t.speed(10)  # fastest speed!

t.color("blue")

t = Turtle()

def tri(n):
    """Draws n 100-pixel sides of an equilateral triangle.
       Note that n doesn't have to be 3 (!)
    """
    if n == 0:
        return      # No sides to draw, so stop drawing
    else:
        t.forward(100)
        t.left(120)
        tri(n-1)    # Recur to draw the rest of the sides!

#t.fillcolor('Royalblue')
#t.begin_fill()
#tri(3)
#t.end_fill()




def spiral(initialLength, angle, multiplier):
    """Spiral-drawing function.  Arguments:
       initialLength = the length of the first leg of the spiral
       angle = the angle, in degrees, turned after each spiral's leg
       multiplier = the fraction by which each leg of the spiral changes
    """
    if initialLength <= 1 or initialLength > 1000:
        return
    else:
        t.forward(initialLength)
        t.right(angle)
        t.left(5)
        initialLength*multiplier
        return spiral(initialLength,angle,multiplier)
#
#spiral(101,42,1.42)   # here, call spiral!

def chai(size):
    """Our chai function!"""
    if (size < 5): 
        return
    else:
        t.forward(size)
        t.left(90)
        t.forward(size/2)
        t.right(90)

      
        chai(size/2)
      

        t.right(90)
        t.forward(size)
        t.left(90)

        chai(size/2)

        t.left(90)
        t.forward(size/2)
        t.right(90)
        t.backward(size)
        return

#
# This runs the chai function:
#chai(100)

def svtree(trunklength, levels):
    """svtree: draws a side-view tree
       trunklength = the length of the first line drawn ("the trunk")
       levels = the depth of recursion to which it continues branching
    """
    if levels == 0:
        return
    else:
        t.forward(trunklength)
        t.left(15)
        svtree(trunklength/2,levels-1)
        t.right(30)
        svtree(trunklength/2,levels-1)
        t.left(15)
        t.backward(trunklength)
        
        

#
# setup
#

# Go!  One example:

def flakeside(sidelength, levels):
  """ flakeside draws _one side_ of the fractal Koch snowflake
    """
  if levels == 0:
    t.forward(sidelength)
  else:
    flakeside(sidelength/3,levels-1)
    t.right(60)
    flakeside(sidelength/3,levels-1)
    t.left(120)
    flakeside(sidelength/3,levels-1)
    t.right(60)
    flakeside(sidelength/3,levels-1)



def snowflake(sidelength, levels):
    """Fractal snowflake function, complete.
       sidelength: pixels in the largest-scale triangle side
       levels: the number of recursive levels in each side
    """
    flakeside(sidelength, levels)
    t.left(120)
    flakeside(sidelength, levels)
    t.left(120)
    flakeside(sidelength, levels)
    t.left(120)




#t.fillcolor('LightSkyblue')
#t.begin_fill()
#snowflake(100,3)
#t.end_fill()