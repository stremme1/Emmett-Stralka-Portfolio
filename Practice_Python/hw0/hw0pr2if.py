# All jokes.
# hw0pr2if.py
#

""" 
Title for your adventure:   The QUEST OF HMC HOUSING.

Notes on how to "win" or "lose" this adventure:
  To win, choose the SOUTH DORM.
  To lose, choose the WEST DORM.
"""

import time

def adventure():
    delay = 0.0          # change to 0.0 for testing or speed runs,
                         # ..larger for dramatic effect!

    user_name = input("What do they call you, worthy adventurer? ")

    print()
    print("Welcome,", user_name, " Welcome to West dorm")
    print("home of the weighty wonders and unreal quantities...of terrible music!")
    print()

    print("Your quest: To find--and partake in the desruction of--all things wEsT!")
    print()
    flavor = input("What side do you seek, light or dark: ")
    if flavor == "light":
        print("Wise! You show deep Harvey Mudd experience.")
    elif flavor == "dark":
        print("ew what were you thinking, I will pick South for you")
    else:
        print("Each to their own, then. You must be for Atwood")
    print()

    print("On to the quest!\n\n")
    print("A corridor stretches before you; its gothic RGB lighting betrays, you")
    print("one side, a table with cups and ping pong balls with cheap seltzer")
    print("and, to the other, a door ajar, leaking with a week old Hooch Food")
    print("Food? and a WHOLE 5 gallons of MiLK")
    time.sleep(delay)
    print()

    choice1 = input("Do you choose the table or the door? [table/door] ")
    print()

    if choice1 == "table":
        print("As you approach the table, its hazy burdens loom ever larger, that seltzer is very tempting")
        print("until...")
        time.sleep(delay)
        print("...you were thrown in a cage fight with a gorilla, Oh No! ")
        print("shimmering.  You succeed, as a gift you receive, every lime green bike in Claremont")
        print("Congrats! Just dont drink and bike")
        print("Go well,", user_name, "!")

    else:  
        print("You push the door into a gathering of people chugging mIlK,")
        print("as you think Who could ever drink that much milk your suddenly overwhelmed with")
        print("merriment abound you, except...")
        time.sleep(delay)
        print("...the Smell The green Hooch Containers have been left for months with Drifts of wrappers")
        print("watch the floor.  Dizzy, you grasp for a pastry. oh no theres is a RaT. sQuEaK")
        print("Retreat to the CoUch, jump to the chairs, the counter is infested. \n Relax, exhale, as slip out the door fresh air alas")
        print("as fires winde around you.")
        print("Say Farewell, to west", user_name, "and welcome to South")