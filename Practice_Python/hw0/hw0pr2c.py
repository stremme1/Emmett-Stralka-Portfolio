# coding: utf-8
#
# hw0pr2c.py
#

import random          # imports the library named random

def rpsls():
    
    user = input("Choose your weapon: ")
    comp = random.choice(['rock', 'paper', 'scissors', 'lizard', 'spock'])
    print()

    print('The user (you) chose', user)
    print('The computer (I) chose', comp)
    print()

    if user == 'rock' and comp == 'rock' or user == 'paper' and comp == 'paper' or user == 'sissors' and comp == 'sissors' or user == 'lizard' and comp == 'lizard' or user == 'spock ' and comp == 'spock':
        print('Well that was ackward try again:')
        return rpsls
    elif user == 'rock' and comp == 'paper':
        print('I won! Paper Covers Rock')
        return
    elif user == 'paper' and comp == 'rock':
        print('You won! Paper Covers Rock')
        return
    elif user == 'paper' and comp == 'scissors':
        print('I won! Scissors Cuts Paper')
        return
    elif user == 'sicssors' and comp == 'paper':
        print('You won! Sissors cuts Paper')
        return

    elif user == 'scissors' and comp == 'rock':
        print('I won! Rock Beats scissors')
        return
    elif user == 'scissors' and comp == 'lizard':
        print('You won! Scissors Decapitate Lizard')
        return
    elif user == 'lizard' and comp == 'scissors':
        print('I won! Scissors Decapitate Lizard')
        return
    elif user == 'rock' and comp == 'scissors':
        print('You won! Rock Beats scissors')
        return
    elif user == 'rock' and comp == 'lizard':
        print('You won! Rock Crushes Lizard')
        return
    elif user == 'lizard' and comp == 'rock':
        print('I won! Rock Crushes Lizard')
        return
    elif user == 'paper' and comp == 'lizard':
        print('I won! Lizard eats Paper')
        return
    elif user == 'paper' and comp == 'spock':
        print('You won! Paper Disproves Spock')
        return
    elif user == 'spock' and comp == 'paper':
        print('I won! Paper Disproves Spock')
        return 
    elif user == 'spock' and comp == 'scissors':
        print('You won! Spock Smashes Scissors')
        return 
    elif user == 'scissors' and comp == 'spock':
        print('I won! Spock Smashes Scissors')
        return 
    elif user == 'lizard' and comp == 'paper':
        print('You won! Lizard eats Paper')
        return
    elif user == 'paper' and comp == 'lizard':
        print('I won! Lizard eats Paper')
        return
    elif user == 'rock' and comp == 'spock':
        print('I won! Spock Vaporizes Rock')
        return
    elif user == 'spock' and comp == 'rock':
        print('You won! Spock Vaporizes Rock')
        return
    elif user == 'lizard' and comp == 'spock':
        print('You won! Lizard Poisions Spock')
        return
    elif user == 'spock' and comp == 'lizard':
        print('I won! Lizard Poisions Spock')
        return

    
    else: 
        return

# Missed a Combo Which one?
        