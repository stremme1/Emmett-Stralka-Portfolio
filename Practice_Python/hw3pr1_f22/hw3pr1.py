# CS5 Gold, Lab 3
# Filename: hw3pr1.py
# Name:
# Problem description: Lab 3 problem, "Sounds Good!"

import time
import random
import math
import csaudio
from csaudio import *
import wave
wave.big_endian = 0  # needed long ago
# if you are having trouble, comment out the above line...



# a function to get started with a reminder
# about list comprehensions...
def three_ize(L):
    """three_ize is the motto of the green CS 5 alien.
       It's also a function that accepts a list and
       returns a list of elements each three times as large.
    """
    # this is an example of a list comprehension
    LC = [3 * x for x in L]
    return LC



# Function to write #1:  scale







# here is an example of a different method
# for writing the three_ize function:
def three_ize_by_index(L):
    """three_ize_by_index has the same behavior as three_ize
       but it uses the INDEX of each element, instead of
       using the elements themselves -- this is much more flexible!
    """
    # we get the length of L first, in order to use it in range:
    N = len(L)
    LC = [3 * L[i] for i in range(N)]
    return LC



# Function to write #2:  add_2






# Function to write #3:  add_3






# Function to write #4:  add_scale_2








# Helper function:  randomize

def randomize(x, chance_of_replacing):
    """randomize accepts an original value, x
       and a fraction named chance_of_replacing.

       With the "chance_of_replacing" chance, it
       should return a random float from -32767 to 32767.

       Otherwise, it should return x (not replacing it).
    """
    r = random.uniform(0, 1)
    if r < chance_of_replacing:
        return random.uniform(-32768, 32767)
    else:
        return x






# Function to write #5:  replace_some











#
# below are functions that relate to sound-processing ...
#


# a function to make sure everything is working
def test():
    """A test function that plays swfaith.wav
       You'll need swfaith.wav in this folder.
    """
    play('swfaith.wav')


# The example changeSpeed function
def changeSpeed(filename, newsr):
    """changeSpeed allows the user to change an audio file's speed.
       Arguments: filename, the name of the original file
                  newsr, the new sampling rate in samples per second
       Result: no return value, but
               this creates the sound file 'out.wav'
               and plays it
    """
    print("Playing the original sound...")
    play(filename)

    samps, sr = readwav(filename)   # get samps and sr from the file!

    print("The first 10 sound-pressure samples are\n", samps[:10])
    print("The number of samples per second is", sr)

    # we don't really need this line, but for consistency...
    newsr = newsr             # from the input! (not needed, a reminder!) 
    newsamps = samps          # same samples as before
    write_wav([newsamps, newsr], "out.wav") # write data to out.wav
    print("\nPlaying new sound...")
    play('out.wav')   # play the new file, 'out.wav'



def flipflop(filename):
    """flipflop swaps the halves of an audio file
       Argument: filename, the name of the original file
       Result: no return value, but
               this creates the sound file 'out.wav'
               and plays it
    """
    print("Playing the original sound...")
    play(filename)

    samps, sr = readwav(filename)   # get samps and sr from the file!

    print("The first 10 sound-pressure samples are\n", samps[:10])
    print("The number of samples per second is", sr)

    print("Computing new sound...")
    # this gets the midpoint and calls it x
    x = len(samps)//2
    newsamps = samps[x:] + samps[:x]
    newsr = sr               # same sr as before

    write_wav([newsamps, newsr], "out.wav") # write data to out.wav
    print("\nPlaying new sound...")
    play('out.wav')   # play the new file, 'out.wav'




# Sound function to write #1:  reverse
def reverse(filename):
    """reverse of an audio file
    Argument: filename, the name of the original file
    esult: no return value, but
    this creates the sound file 'out.wav'
    and plays it
    """
    print("Playing the original sound...")
    play(filename)

    samps, sr = readwav(filename)   # get samps and sr from the file!

    print("The first 10 sound-pressure samples are\n", samps[:10])
    print("The number of samples per second is", sr)

    print("Computing new sound...")   
    newsamps = samps[::-1] 
    newsr = sr               # same sr as before

    write_wav([newsamps, newsr], "out.wav") # write data to out.wav
    print("\nPlaying new sound...")
    play('out.wav') 




# Sound function to write #2:  volume







# Sound function to write #3:  static







# Sound function to write #4:  overlay







# Sound function to write #5:  echo








# Helper function for generating pure tones
def gen_pure_tone(freq, seconds):
    """pure_tone returns the y-values of a cosine wave
       whose frequency is freq Hertz.
       It returns nsamples values, taken once every 1/44100 of a second.
       Thus, the sampling rate is 44100 hertz.
       0.5 second (22050 samples) is probably enough.
    """
    # we get to pick our own sampling rate, sr
    sr = 22050
    # how many data samples to create
    nsamples = int(seconds*sr) # rounds down
    # our frequency-scaling coefficient, f
    f = 2*math.pi/sr   # converts from samples to Hz
    # our amplitude-scaling coefficient, a
    a = 32767.0
    
    # now, create the sound!
    samps = [a*math.sin(f*n*freq) for n in range(nsamples)]
    sr = sr   # not needed, but a reminder
    return [samps,sr]


def pure_tone(freq, time_in_seconds):
    """Generates and plays a pure tone of the given frequence."""
    print("Generating tone...")
    samps, sr = gen_pure_tone(freq, time_in_seconds)

    print("The first 10 sound-pressure samples are\n", samps[:10])
    print("The number of samples per second is", sr)

    print("Writing out the sound data...")
    write_wav([samps, sr], "out.wav") # write data to out.wav

    print("Playing new sound...")
    play('out.wav')




# Sound function to write #6:  chord

def scale(L, scale_factor):
    """Scale returns a list of the same size were
    the numbers are multipied by the scale_factor
    """
    # This is an example of a list comprehension
    LC = [scale_factor * x for x in L]
    return LC

def add_2(L, M):
    """Adds two list's consecutive intergers 
    up to the shortest list
    """
    N = min(len(L), len(M))

    LC = [L[i] + M[i] for i in range(N)]
    return LC

def add_3(L, M,P):
    """ Adds threee lists's concecutive intergers
    up to the shortest list
    """
    N = min(len(L), len(M), len(P))

    LC = [L[i] + M[i] +P[i] for i in range(N)]
    return LC

def add_scale_2(L, M, L_scale, M_scale):
    """ Adds two list's concentutive intergers 
    up to the shortest list, mulitplyies each value before adding
    by the L scale of L list and M for M list
    """
    N = min(len(L), len(M))

    LC = [L[i]*L_scale + M[i]*M_scale for i in range(N)]
    return LC


def replace_some(L, chance_of_replacing):

    """replace_some accepts a list L and 
    a floating-point value chance_of_replacing

     independently replace—or not replace—each element in L, 
     using the helper function randomize
    """
    LC = [randomize(x, chance_of_replacing) for x in L]
    return LC
    

