package Ex4Chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConsumerClient extends Consumer{

    private Socket clientSocket;

    public ConsumerClient(String id, Queue q, Socket clientSocket) {
        super(id, q);

        this.clientSocket = clientSocket;
    }

    public void consume(String message) {
        System.out.println("Cons. " + id + ": prelevato " + message);

        // output stream towards Server
        DataOutputStream outToServer;
        try {
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // send the line to the server
        try {
            outToServer.writeBytes(message + "\n");
            System.out.println("MSG sent to Server");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
