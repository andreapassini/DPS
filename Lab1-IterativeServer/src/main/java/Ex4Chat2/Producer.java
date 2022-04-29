package Ex4Chat2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Producer implements Runnable {

    final String id;
    final Queue queue;

    Socket connectionSocket;

    public Producer(String id, Queue q, Socket connectionSocket) {
        this.id = id; queue = q;
        this.connectionSocket = connectionSocket;
    }

    public void run() {
        while (true){
            queue.put(produce());
        }
    }

    public String produce() {
        String msg = null;

        // From Client
        // Listen from the Socket

        // input stream from socket init
        BufferedReader inFromCLient;
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
        System.out.println("FROM Client: " + msg);

        return msg;
    }

}
