# coding: utf-8
#
# The top line, above, is important -- it ensures that Python will be
# able to use this file even if you paste in text with fancy Unicode
# characters that aren't part of normal ASCII.
#
# For another example of such a file, see
# https://www.cl.cam.ac.uk/~mgk25/ucs/examples/UTF-8-demo.txt
#
# OK! Now we're ready for hw10pr3.py ...
#
# Name:emmett stralka
#

#
# First, some helper/example functions for files + text ...
#
# To make the examples work, you should have the text file named "a.txt"
# in the same directory as this .py file!
#
# If you _don't_ have "a.txt", create it.  Here are its contents:
"""
I like poptarts and 42 and spam.
Will I get spam and poptarts for
the holidays? I like spam poptarts!
"""

import random
def get_text(filename):
    """Opens a file named 'filename', reads
       it, and returns its contents (as one big string).

       Example:
          In [1]: get_text("a.txt")
          Out[1]: 'I like poptarts and 42 and spam.\nWill I get spam and poptarts for\nthe holidays? I like spam poptarts!\n\n\n\n'

          In [1]: len(get_text("a.txt"))
          Out[1]: 102  # Well, _around_ 102, depending how many \n's you have at the end of a.txt.
                       # Note that '\n' is ONE character:   len('\n') == 1
    """
    #
    # First we have to open the file (just like opening a book to read it).
    # We assume the "utf-8" encoding, which accepts more characters than plain ASCII
    #
    # Other common codings welcome, e.g., utf-16 or latin1
    # See [docs.python.org/3.8/library/codecs.html#standard-encodings]
    # for the full list (it's big!).
    #
    f = open(filename, encoding = 'utf-8')

    #
    # Read the contents of the file into a string named "text", close
    # the file, and return the string.
    #
    text = f.read()
    f.close()
    return text

def word_count(text):
    """Word-counting function.
       Counts the number of "words" (space-separated sequences) in
       the string "text".

       Examples:
          In [1]: word_count('This has four words!')
          Out[1]: 4

          In [1]: word_count(get_text("a.txt"))
          Out[1]: 20                 # If it's the a.txt file above
    """
    #
    # The text of the file is one long string.  Use "split" to get words!
    #
    LoW = text.split()    # We could use text.split("\n") to get _lines_.

    #
    # LoW is a List of Words, so its length is the word count.
    #
    result = len(LoW)

    # Comment out, as needed...
    if result < 100:
        print("LoW[0:result] is", LoW[0:result])  # For sanity checking...
    else:
        print("LoW[0:100] is", LoW[0:100])        # without going too far...

    return result



# Use the string library to implement remove_punctuation:
import string    # See https://docs.python.org/3/library/string.html
                 # Note: str is different: docs.python.org/3/library/stdtypes.html#textseq

def remove_punctuation(text):
    """Accepts a string named "text".  Returns an equivalent string, _but_
       with all non-(English)-text characters removed (keeps only
       letters + digits).

       + Vary to suit the language at hand!

       Examples:
          In [1]: remove_punctuation("42_isn't_.!?41.9bar")
          Out[1]: '42isnt419bar'

          In [2]: remove_punctuation(get_text("a.txt"))
          Out[2]: 'Ilikepoptartsand42andspamWillIgetspamandpoptartsfortheholidaysIlikespampoptarts' # (Not so useful w/o spaces!)
    """
    new_text = ''
    CHARS_TO_KEEP = string.ascii_letters + string.digits # + string.whitespace + string.punctuation
    for c in text:  # c is each character
        # Use the Python string library
        if c in CHARS_TO_KEEP:
            new_text += c
        else:
            pass # don't include it  [WARNING: as written, this removes spaces!]

    # We're finished!
    return new_text


def vocab_count(text):
    """Returns a dictionary of (punctuationless, lower-cased) words in "text".

       + Removes everything not in string.ascii_letters (via the function
         above).
       + Also, lower-cases everything (alter to suit your taste or
         application!).
       + Builds and returns a dictionary of how many times each word occurs.

       Examples:
          In [1]: vocab_count("Spam, spam, I love spam!")
          There are 5 words.
          There are 3 *distinct* words in the text.

          Out[1]: {'spam': 3, 'i': 1, 'love': 1}


          In [2]: vocab_count(get_text("a.txt"))
          There are 20 words.
          There are 11 *distinct* words in the text.

          Out[2]:
                    {'i': 3,
                    'like': 2,
                    'poptarts': 3,
                    'and': 3,
                    '42': 1,
                    'spam': 3,
                    'will': 1,
                    'get': 1,
                    'for': 1,
                    'the': 1,
                    'holidays': 1}
    """
    LoW = text.split()
    print("There are", len(LoW), "words.")  # For info - comment out if you like

    d = {}
    for word in LoW:
        word = remove_punctuation(word)  # Remove punctuation!
        word = word.lower()   # Make lower case!

        if word not in d:     # If it's not already in the dictionary, d
            d[word] = 1       # Set count to 1  (the VALUE is the count, here)
        else:                 # ..or if it IS already in the dictionary, d
            d[word] += 1      # ..add 1 to count (again, the VALUE is the count)

    print("There are", len(d), "*distinct* words in the text.\n")
    return d            # This way we can _use_ or look up the keys in d...




"""
[a] What was in the file you analyzed?   -->    ________
    The first three introductions to the frist three star wars films
    1-3

[b] How many words did it have?  -->     __________
    262WORDS
    147 UNIQUE WORDS

[c] How many characters did it have?  -->       ________

    Note: there's no function for this, but len(get_text("a.txt")) will do it!
1602

[d] How many _distinct_ words did it have?  -->       ________
    147 UNIQUE WORDS

[e] What are three words that appeared unusually often for this text?  -->
    TO 
    THE
    REPUBLIC
    IN
    A
    ARE ALL COMMON WORDS


[f] Other thoughts/insights?!
ALOT OF ACTION WORDS THAT ARE UNIQUE
"""

#
# Now, to the Markov modeling (createDictionary) and Markov text
# generation (generateText)
#
# Be sure to create your 500-word "CS-Essay,"" with:
#    In [1]: d = createDictionary(get_text("yourfile.txt"))
#    In [2]: generateText(d, 500)       # Then copy the "essay" below ...
#

#
# Function #1  (createDictionary)
#
import random
def createDictionary(text):
    """first, convert the text to a list of words onstruct a 
    dictionary that is the Markov model from that list of words,
    """
    LoW = text.split()

    d = {}
    pw = '$'   # pw indicates previous word

    for nw in LoW:   # nw indicates next word
        if pw not in d:
            d[pw] = [nw]   # start with a list of one element
        else:
            d[pw] += [nw]  # add to the list, already present

        pw = nw  # pw is the "new" previous word
        if pw[-1]=='.' or pw[-1]=='!' or pw[-1]=='?':
            pw='$'
    

    return d
    # Here, check for whether that new previous word, pw, ends in 
    # punctuation -- if it _does_ then set pw to be '$'
    # that way, it will be back at the start of a new sentence!


#
# Function #2   (generateText)

#
def generateText(d, N):
    """accepts a dictionary of word transitions d 
    (generated in your createDictionary function, above) and a positive integer, n
     Then, generateText should print a string of n words.
    """
    firstword='$'
    print('\n')
    
     # start by printing a newline
    
    for i in range(N):
        next_word= random.choice(d[firstword]) 
        
        print(next_word, end = ' ')
        if next_word[-1] not in ".!?":
            firstword=next_word
        else: 
            firstword='$'
    print()                  # Final print, newline


#
# Your 500-or-so-word "CS Essay" (paste into the triple-quoted strings below):
#
"""
So basically this how they wrote the plot for the 7th 8th and 9th movies


War! The taxation of peace and kidnapped Chancellor has secretly dispatched two Jedi Knights, the Republic endlessly debates this alarming chain of Count Dooku. Hoping to the overwhelmed Jedi. War! A vast sea of Naboo, is in dispute. War! In a desperate mission to vote on the conflict. Senator Amidala, the guardians of Naboo, is crumbling under the Galactic Senate. A vast sea of deadly battleships, the congress of the Galactic Republic. As the greedy Trade Federation has stopped all shipping to flee the galaxy. A long time ago in the Galactic Senate several hundred solar systems is returning to the backdrop for the greedy Trade Federation has made it difficult for the Republic is unrest in a galaxy far, far away. In a stunning move, the Galactic Republic. The taxation of Naboo. The taxation of Naboo. The taxation of the galaxy. Hoping to the Separatist Droid Army attempts to maintain peace and justice in the greedy Trade Federation has secretly dispatched two Jedi Knights to the limited number of events, the greedy Trade Federation has made it difficult for the galaxy, to flee the ruthless Sith Lord, Count Dooku, has engulfed the congress of creating an Army of the Separatist Droid Army of Naboo. The Republic is returning to flee the Republic capital with a rollup, which crawls into the former Queen of the congress of trade routes to flee the backdrop for the overwhelmed Jedi. Senator Amidala, the congress of peace and order in the galaxy, to outlaying star systems is everywhere. Evil is crumbling under attacks by a galaxy far, far away. The Republic capital and order in a rollup, which crawls into the Separatist Droid Army attempts to outlaying star systems is everywhere. While the critical issue of Naboo, is in the matter with their valuable hostage, two Jedi Knights lead a rollup, which crawls into the Galactic Senate. A long time ago in the ruthless Sith Lord, Count Dooku. Turmoil has stopped all shipping to vote on the fiendish droid leader, General Grievous, has engulfed the small planet of peace and order in the matter with their valuable hostage, two Jedi Knights, the Republic to outlaying star systems have declared their intentions to leave the congress of Jedi Knights lead a stunning move, the fiendish droid leader, General Grievous, has secretly dispatched two Jedi Knights lead a rollup, which crawls into infinity. There are heroes on both sides. Evil is in dispute. This separatist movement, under the Republic capital and kidnapped Chancellor Palpatine, leader of Count Dooku, has made it difficult for the overwhelmed Jedi. The taxation of events, the former Queen of trade routes to flee the besieged capital and justice in the galaxy. A long time ago in the Republic is returning to the guardians of stars serves as the congress of trade routes to leave the congress of peace and justice in a blockade of the Supreme Chancellor Palpatine, leader of Naboo, is everywhere. There is unrest in the matter with their


"""
