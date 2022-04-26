package main.java.Ex4Chat;


import java.io.*;
import  java.net.*;

public class Producer implements Runnable {

    private final String id;
    private final Queue queue;

    public Producer(String id, Queue q) { this.id = id; queue = q; }

    public void run() {
        try {
            String fromKeyboard = produce();

            System.out.println("Prod. " + id + ": inserisco " + fromKeyboard);
            queue.put(fromKeyboard);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String produce() throws IOException {
        String msg;

        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        msg = inFromUser.readLine();

        return msg;
    }

}
