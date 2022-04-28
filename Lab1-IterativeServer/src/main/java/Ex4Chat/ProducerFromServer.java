package Ex4Chat;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ProducerFromServer extends Producer {
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
                // JSON un-marshaling
                Gson gsonIn = new Gson();

                Message jsonMessageIn = gsonIn.fromJson(fromServer, Message.class);

                if(this.id != jsonMessageIn.id){
                    // Writes to Local Queue
                    System.out.println("Prod. " + jsonMessageIn.id + ": inserisco " + jsonMessageIn.msg);

                    // JSON marshaling
                    Message m = new Message(jsonMessageIn.id, jsonMessageIn.msg);
                    Gson gsonOut = new Gson();
                    String jsonStringOut = gsonOut.toJson(m);

                    queue.put(jsonStringOut);
                }
            }
        }

    }
    
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
