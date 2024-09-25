import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class gameThread extends Thread {
    private Socket socket;
    private String code;

    public gameThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);


            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            String colors = "RYGBWO";
            for (int i = 0; i < 4; i++) {
                sb.append(colors.charAt(random.nextInt(colors.length())));
            }

            String guess = "";
            int counter = 0;
            this.code = sb.toString();
            System.out.println("Secret code: " + code);


            while (!guess.equals("PPPP") && counter < 20) {
                if (counter == 0) {

                    printWriter.println("GO");
                } else {

                    guess = bufferedReader.readLine();

                    if (guess.equals("QUIT")) {

                        break;
                    }


                    String result = processGuess(guess);
                    printWriter.println(result);
                }

                counter++;
            }


            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String processGuess(String guess) {
        StringBuilder guessResult = new StringBuilder();
        for (int i = 0; i < guess.length(); i++) {
            if (code.charAt(i) != guess.charAt(i)) {
                if (code.contains(String.valueOf(guess.charAt(i)))) {
                    guessResult.append("C");
                }

            }else{
                guessResult.append("P");
            }
        }
        while (guessResult.length()<4){     //We don't actually need this as we can't tell whether there
            guessResult.append(" ");        // is blank space or not
        }

        return guessResult.toString();
    }
}
