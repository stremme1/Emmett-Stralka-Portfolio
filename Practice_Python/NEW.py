import random
import time
# A list of realistic date ideas for college students
date_ideas = [
  "Hey, would you like to grab a cup of coffee and walk around the campus green? There's a new coffee shop that just opened up that I've been wanting to try.",
  "I was thinking of going to see the latest indie film at the theater this weekend. Would you like to join me?",
  "How about we go for a picnic in the park and play some frisbee or catch? I can bring some wine and snacks.",
  "I heard there's a new food truck festival happening in town this weekend. Would you be interested in checking it out with me?",
  "I was thinking of going for a bike ride along the river. Would you like to come along?",
]

# A list of funny opening lines
opening_lines = [
  "Hey Taylor, do you believe in love at first swipe or should we match again?",
"Are you a magician, Taylor? Because every time I look at you, everyone else disappears.",
"I must be lost, Taylor, because heaven is a long way from here.",
"Is it just me, or do we have some serious chemistry, Taylor?",
"Hey Taylor, you know what they say, good things come in small packages. Let's grab a drink and talk about it.",
"Excuse me, Taylor, do you have a map? I keep getting lost in your eyes.","Hey Taylor, I don't have a library card, but do you mind if I check you out?",
"You must be a thief, Taylor, because you just stole my heart.",
"I think I've seen you before, Taylor, in my dreams. Let's make them a reality and go on a date?",
"Do you have a sunburn, Taylor? Because you are hot, hot, hot.",
"Excuse me, Taylor, but can I have your picture so I can show Santa what I want for Christmas?",
"Hey Taylor, are you a mermaid? Because I'm drowning in your beauty.",
]

# Choose a random date idea and opening line
date_idea = random.choice(date_ideas)
opening_line = random.choice(opening_lines)

# Ask the user for their name and interests
your_name = input("Hi," + " my name is ")
# Ask for the girl's name and introduce yourself
girl_name = input("Hi there! What's your name? ")
your_name = "I'm [Your Name Here]"

print("\n")
print("Hello there!")
print("\n")
time.sleep(2) # Wait for 2 seconds before printing the next statement
print("I am Know what your thinking, * man this stud is great at coding, and he is just an engineering major, ... like what?")
print("\n")
time.sleep(6) # Wait for 3 seconds before printing the next statement # Wait for 2 seconds before printing the next statement
print("But heres the thing I am no Econ bro")
time.sleep(3)
print("My RIZZ is WAY better")
time.sleep(2)
print("I'm happy to code yet I do find it a bit annoying especially when I run into bugs")
print("\n")
time.sleep(6) # Wait for 3 seconds before printing the next statement
print("That is why I came to grutoring to get some EXTRA help, and show a bit of LOVE to my favorite CS major")
print("\n")
time.sleep(7)
print("So play along with the prompt becuase I spent like 15min on this and thought it was funny")
print("\n")
time.sleep(5)
print("answer the questions by how YOU think I would like them to be answered")
print("\n")
time.sleep(9)


# Ask the girl if she has a boyfriend
print("So, " + girl_name + ", do you have a boyfriend? currently ;):")
answer = input()

if answer.lower() == "yes":
    print("Ah, that's too bad. He's an one unlucky guy for his sake")
    print("\n")
    time.sleep(4)
    print("or I bet you just mistyped no, but I am no linguist")
    print("\n")
    time.sleep(4)
    date_idea = random.choice(date_ideas)
    print("\n")
    print("Great! Well, " + girl_name + ", " + opening_line + " HA I know that was good but, I was wondering if you would like to go on a date with me.")
    print('\n')
    time.sleep(19)
    print(date_idea)
    time.sleep(4)
    print("What do you say?")
    print("\n")

    # Ask for preferred day and time
    day = input("What day are you free to go out? ")
    time = input("What time works best for you? ")

    # Print a flirty response
    print("Sounds like a plan! I can't wait to see you on " + day + " at " + time + ".")
    print("Don't worry, I'll make sure it's a NIGHT you won't forget. \n or we could leave here now if you want? ;)")

elif answer.lower() == "no":
    # Choose a date idea and print the invitation
    date_idea = random.choice(date_ideas)
    print("\n")
    print("Great! Well, " + girl_name + ", " + opening_line + "  HA I know that was good but, I was wondering if you would like to go on a date with me.")
    print('\n')
    time.sleep(19)
    print(date_idea)
    print("\n")
    time.sleep(8)
    print("What do you say?")
    print("\n")

    # Ask for preferred day and time
    day = input("What day are you free to go out? ")
    time = input("What time works best for you? ")
    print('\n')

    # Print a flirty response
    print("Sounds like a plan! I can't wait to see you on " + day + " at " + time + "." + "\n")
    print("Don't worry, I'll make sure it's a NIGHT you won't forget. \n or we could leave here now if you want? ;)")

else:
    print("I'm sorry, I didn't quite catch that. Do you have a boyfriend or not?")

