package main.java.Ex4Chat;


import java.io.*;
import  java.net.*;

public class Producer implements Runnable {

    private final String id;
    private final Queue queue;

    public Producer(String id, Queue q) {
        this.id = id; queue = q;
    }

    public void run() {
        // Read from keyboard

        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        String fromKeyboard;

        try {
            fromKeyboard = inFromUser.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (fromKeyboard != null){
            try {
                produce(fromKeyboard);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Prod. " + id + ": inserisco " + fromKeyboard);
            queue.put(id + "_|_" + fromKeyboard);


        }

    }

    public String produce(String msg) throws IOException {

        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        msg = inFromUser.readLine();

        return msg;
    }

}
