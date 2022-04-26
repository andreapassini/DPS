package main.java.Ex4Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ProducerFromServer extends Producer{
    Socket clientSocket;

    public ProducerFromServer(String id, Queue q, Socket clientSocket) {
        super(id, q);

        this.clientSocket = clientSocket;
    }

    public void run() {

        String fromServer;

        // SHOULD NOT BE Busy waiting
        while (true){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Reads from Server
            fromServer = produce();

            if (fromServer != null) {
                // Writes to Local Queue
                System.out.println("Prod. " + id + ": inserisco " + fromServer);
                queue.put(fromServer);
            }
        }

    }

    @Override
    public String produce() {
        // Reads from Server
        String msg;

        // Listen from the Socket

        // input stream from socket init
        BufferedReader inFromServer =
                null;
        try {
            inFromServer = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // read the response from the server
        try {
            msg = inFromServer.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("FROM SERVER: " + msg);

        return msg;
    }
}
