Web VPython 3.2


#Scripps:   vec(52/255, 116/255, 92/255)

#Pitzer:   vec(247/255, 148/255, 29/255)

#Pomona:   vec(32/255, 67/255, 143/255)

#CMC:   vec(152/255, 26/255, 49/255)

#Mudd:   vec(0/255, 0/255, 0/255)

#
# physics_starter.py
#
# Building an interaction with 3D graphics using Python
#   Documentation: http://www.glowscript.org/docs/VPythonDocs/index.html
#   Examples:      http://www.glowscript.org/#/user/GlowScriptDemos/folder/Examples/
#

scene.bind('keydown', keydown_fun)     # Function for key presses
scene.bind('click', click_fun)         # Function for mouse clicks
scene.background = 0.42*vec(1, 1, 1)    # Light gray (0.8 out of 1.0)
scene.width = 400                      # Make the 3D canvas larger
scene.height = 400


# +++ Start of OBJECT_CREATION section


# The ground is represented by a box (vPython's rectangular solid)
# http://www.glowscript.org/docs/VPythonDocs/box.html
# Note that this time we save the thing constructed by "box" in
# a variable named "ground".
#
ground = box(size = vec(20, 1, 20),
             pos = vec(0, -1, 0),
             color = .4*vec(1, 1, 1)
             )

# Show our x and z axes (for labeling and intuition-building)
# http://www.glowscript.org/docs/VPythonDocs/label.html
#
x_axis = arrow(axis = vec(5, 0, 0),
               color = vec(0, 0, .5)   # Dark blue
               )
x_axis_label = label(pos = vec(6, 0, 0),
                     text = 'x',
                     color = vec(0, 0, .5)
                     )
z_axis = arrow(axis = vec(0, 0, 5),
               color = vec(0, .5, 0)   # Dark green
               )
z_axis_label = label(pos = vec(0, 0, 6), 
                     text = 'z',
                     color = vec(0, .5, 0)
                     )

# Make a sphere, which is something we will animate.
# http://www.glowscript.org/docs/VPythonDocs/sphere.html
# Again, we save the sphere as "ball" so that we can manipulate it later.
#
ball = ring(pos=vector(1,1,1),
        axis=vector(0,1,0),
        radius=1.5, thickness=0.4)   # ball is an object of class sphere
ball.vel = vec(4.2, 0, 0)           # This is the initial velocity
print("velocity is now:", ball.vel) # Printing works as usual


# +++ End of OBJECT_CREATION section


# +++ Start of ANIMATION section

# Important constants
RATE = 30                # The number of times the while loop runs each second
dt = 1.0/RATE            # The time step each time through the while loop
scene.autoscale = False  # Avoids changing the view automatically
scene.forward = vec(0, -3, 0)  # Ask for a bird's-eye view of the scene...
origin = vec(0, 0, 0)    # It's nice to have a name for the origin location

# This is the "event loop" or "animation loop".
# Each pass through the loop will animate one step in time, called "dt".
# In other words, dt seconds elapse on each pass through the loop.
# Note that dt is both REAL time (what we see on the screen) and
# SIMULATED time (what happens in our simulated physical world).
# Based on the default constants above, dt is 1/30 second.
#
# IMPORTANT DETAIL: In all Glowscript programs, there should be only
# ONE "while True" loop, which is this loop.  If you try to put
# another "while True" loop somewhere inside here, your program won't
# work.  (Why?)
#
while True:

    rate(RATE)                             # Maximum number of times per second
                                           # ..that the while loop runs

    # +++ Start of PHYSICS UPDATES -- update all positions here, every time step


    ball.pos = ball.pos + ball.vel*dt      # distance = rate*time


    # +++ End of PHYSICS UPDATES -- be sure new objects are
    # updated appropriately!


    # +++ Start of COLLISIONS -- check for collisions and do the "right" thing


    # If the ball ventures too far, restart it with a random velocity
    if mag(ball.pos - origin) > 10.0:      # mag == magnitude of a vector
        ball.pos = ball.pos + ball.vel*dt
        ball.vel = ball.vel * 0.98  # Reset the ball.pos (position)
        ball.vel = 4.2*vec.random()        # Set a random velocity
        ball.vel.y = 0.0                   # With no y component (no vertical)
        print("velocity is now:", ball.vel)


    # +++ End of COLLISIONS

    # +++ End of WHILE TRUE loop



# +++ Start of EVENT-HANDLING section -- separate functions for
#                                key presses and mouse clicks...

def keydown_fun(event):
    """This function is called each time a key is pressed."""
    key = event.key
    print("key pressed:", key)          # Print which key was pressed...

    if key in 'c':                     # Redo the sphere's color...
        ball.color = randcolor()        # Shows how to call your own function...

    elif key in 'rR':                   # Redo the sphere's velocity...
        ball.pos = vec(0, 0, 0)         # Reset the ball.pos (position)
        ball.vel = 4.2*vec.random()     # Set a random velocity
        ball.vel.y = 0.0                # With no y component (no vertical)
        print("velocity is now:", ball.vel)


def click_fun(event):
    """This function is called each time the mouse is clicked."""
    print("mouse event is", event.event, event.which)

# +++ End of EVENT-HANDLING section



# +++ Other functions can go here...

def randcolor():
    """Returns a vector of (r, g, b), randomly selected from 0.0 to 1.0."""
    r = random()           # This is different than Python's random.uniform
    g = random()           # ..it automatically uses 0.0 to 1.0
    b = random()
    return vec(r, g, b)    # A color is a three-element tuple
    # See the next example for implementations of choice and randint