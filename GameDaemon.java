

import java.io.*;
import java.net.*;

public class GameDaemon {
    public static void main(String[] args) {
        ServerSocket server;

        try

        {
            server = new ServerSocket(42457);
            while (true){

               Socket socket = server.accept();
               gameThread GameThread = new gameThread(socket);
               GameThread.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
/*
Output run 1
Welcome to Mastermind. You will try to guess a 4 color code using
only the letters (R, Y, G, B, W, O). You will lose the game if you
are unable to guess the code correctly in 20 guesses. Good Luck!

Please enter your guess for the secret code or 'QUIT' :
RROO
CCCC
Please enter your guess for the secret code or 'QUIT' :
RORO
CPPC
Please enter your guess for the secret code or 'QUIT' :
OORR
Congratulations!!! You guessed the code correctly in 3 moves

Process finished with exit code 0

Output run 2
Welcome to Mastermind. You will try to guess a 4 color code using
only the letters (R, Y, G, B, W, O). You will lose the game if you
are unable to guess the code correctly in 20 guesses. Good Luck!

Please enter your guess for the secret code or 'QUIT' :
BBBY
CCP
Please enter your guess for the secret code or 'QUIT' :
YUO
Invalid guess. Please enter a 4-character guess using (R, Y, G, B, W, O) or QUIT'.
Please enter your guess for the secret code or 'QUIT' :
QUIT

Goodbye but please play again!

Process finished with exit code 0



 */

