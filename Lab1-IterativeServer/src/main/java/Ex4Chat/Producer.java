package main.java.Ex4Chat;


import java.io.*;
import  java.net.*;

public class Producer implements Runnable {

    final String id;
    final Queue queue;

    public Producer(String id, Queue q) {
        this.id = id; queue = q;
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
