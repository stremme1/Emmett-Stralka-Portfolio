import random
import tkinter as tk
from tkinter import messagebox

class Player:
    def __init__(self, name):
        self.name = name
        self.money = 0
        self.position = 0

    def take_turn(self):
        spin = random.randint(1, 10)
        self.position += spin
        self.process_space()
        self.update_gui()

    def process_space(self):
        space = game_board[self.position]
        if space == "Payday":
            self.receive_money(1000)
        elif space == "Lottery":
            self.receive_money(500)
        elif space == "Taxes":
            self.pay_money(500)

    def receive_money(self, amount):
        self.money += amount
        messagebox.showinfo("Money Received", f"{self.name} received ${amount}. Total money: ${self.money}.")

    def pay_money(self, amount):
        self.money -= amount
        messagebox.showinfo("Money Paid", f"{self.name} paid ${amount}. Total money: ${self.money}.")

    def update_gui(self):
        player_info = f"{self.name}\nMoney: ${self.money}\nPosition: {self.position}"
        label_player.config(text=player_info)


# Define the game board
game_board = [
    "Start", "Payday", "Taxes", "Lottery", "Payday", "Taxes",
    "Payday", "Taxes", "Lottery", "Payday", "Taxes", "Retirement"
]

# Create players
players = []
num_players = 2
for i in range(num_players):
    name = input(f"Enter the name for player {i+1}: ")
    players.append(Player(name))

# Create the GUI
root = tk.Tk()
root.title("The Game of Life")
root.geometry("300x200")

label_player = tk.Label(root, font=("Arial", 12))
label_player.pack(pady=20)

button_spin = tk.Button(root, text="Spin", width=10)
button_spin.pack(pady=10)

def spin_clicked():
    for player in players:
        player.take_turn()
        if player.position >= len(game_board):
            messagebox.showinfo("Game Over", f"{player.name} reached Retirement and won the game!")
            root.quit()
            break

button_spin.config(command=spin_clicked)

# Run the GUI
root.mainloop()
