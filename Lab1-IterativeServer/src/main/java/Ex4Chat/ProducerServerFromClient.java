package Ex4Chat;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ProducerServerFromClient extends Producer{

    Socket connectionSocket;

    public ProducerServerFromClient(String id, Queue q, Socket socket) {
        super(id, q);

        connectionSocket = socket;
    }

    public void run() {

        String fromClient;

        // SHOULD NOT BE Busy waiting
        while (true){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Reads from Server
            fromClient = produce();

            queue.put(fromClient);
        }

    }

    @Override
    public String produce() {
        // Reads from Server
        String msg;

        // Listen from the Socket

        // input stream from socket init
        BufferedReader inFromCLient = null;
        try {
            inFromCLient = new BufferedReader(
                    new InputStreamReader(connectionSocket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // read the response from the server
        try {
            msg = inFromCLient.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("FROM SERVER: " + msg);

        return msg;
    }
}
