import java.net.Socket;
import java.io.*;

public class mastermind {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 42457);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        ) {
            int counter = 0;
            String guessString = "";
            while (counter < 20 && (!guessString.equals("QUIT"))) {
                String inputLine = in.readLine();
                if (inputLine.equals("GO")) {
                    System.out.println("Welcome to Mastermind. You will try to guess a 4 color code using\n" +
                            "only the letters (R, Y, G, B, W, O). You will lose the game if you\n" +
                            "are unable to guess the code correctly in 20 guesses. Good Luck!\n");
                }
                else if (inputLine.equals("PPPP")) {
                    System.out.println("Congratulations!!! You guessed the code correctly in " + counter + " moves");
                    return;
                }else {
                    System.out.println(inputLine);
                }

                do {
                    System.out.println("Please enter your guess for the secret code or 'QUIT' :");
                    guessString = userInputReader.readLine();
                    if (guessString.equals("QUIT")) {
                        System.out.println("\nGoodbye but please play again!");
                        out.println(guessString);
                        socket.close();
                        return;
                    }
                    if(!verifyInput(guessString)) {
                        System.out.println("Invalid guess. Please enter a 4-character guess using (R, Y, G, B, W, O) or QUIT'.");

                    }
                } while (!verifyInput(guessString));


                out.println(guessString);
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean verifyInput(String gs) {
        if (gs.length() != 4) {
            return false;
        }
        for (char c : gs.toCharArray()) {
            if (c != 'R' && c != 'Y' && c != 'G' && c != 'B' && c != 'W' && c != 'O') {
                return false;
            }
        }
        return true;
    }
}
