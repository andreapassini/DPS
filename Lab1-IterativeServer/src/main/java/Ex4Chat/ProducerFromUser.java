package Ex4Chat;

import com.google.gson.Gson;
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
                // JSON marshaling
                Message m = new Message(id, fromKeyboard);
                Gson gson = new Gson();
                String userJson = gson.toJson(m);

                System.out.println("Prod. " + id + ": inserisco " + fromKeyboard);

                queue.put(userJson + "\n");

                notifyAll();
            }

            fromKeyboard = produce();
        }

    }

    public String produce() {
        String msg;

        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Insert Message: \n");

        try {
            msg = inFromUser.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return msg;
    }

}
