package Ex4Chat;


import java.io.*;

public class ProducerFromUser extends Producer {

    public ProducerFromUser(String id, Queue q) {
        super(id, q);
    }

    public void run() {
        // Read from keyboard
        String fromKeyboard = null;

        // Busy waiting
        while (true){
            fromKeyboard = produce();

            if (fromKeyboard != null) {
                System.out.println("Prod. " + id + ": inserisco " + fromKeyboard);
                queue.put(id + "_|_" + fromKeyboard);
            }

            fromKeyboard = produce();
        }

    }

    public String produce() {
        String msg;

        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        try {
            msg = inFromUser.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return msg;
    }

}
