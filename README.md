Multithreaded Mastermind Game

This is a multithreaded client-server application in Java that implements the Mastermind game, allowing multiple players to guess a secret color code while communicating in real time.


Features

- Multiplayer Gameplay: Play with multiple users at the same time.
- Real-time Interaction: Clients communicate with the server in real time.
- Efficient Performance: The server manages multiple connections smoothly using multithreading.


Technologies Used

- Java
- Socket Programming
- Multithreading

Getting Started

Prerequisites
  Java Development Kit (JDK) installed on your machine.

Steps to Run the Game

1. Clone the repository:
   
   git clone https://github.com/yourusername/multithreaded-mastermind-game.git
   
   cd multithreaded-mastermind-game
   
2. Compile the Java files:
   
   javac *.java
   
 3.Start the client (in a new terminal):

   java mastermind


How to Play

- Connect to the server to receive instructions.
- Enter your guesses using the letters R, Y, G, B, W, O.
- Try to guess the secret code within 20 attempts or quit anytime.


File Structure

multithreaded-mastermind-game/

│
├── gameThread.java               # Handles client connections and game logic

├── GameDaemon.java               # Main server program

└── mastermind.java                # Client program for user interaction
