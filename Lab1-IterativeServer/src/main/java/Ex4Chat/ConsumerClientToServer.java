package Ex4Chat;

import com.google.gson.Gson;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConsumerClientToServer extends Consumer{

    private Socket clientSocket;

    public ConsumerClientToServer(String id, Queue q, Socket clientSocket) {
        super(id, q);

        this.clientSocket = clientSocket;
    }

    public void consume(String message) {
        //JSON Un-marshaling
        Gson gsonIn = new Gson();
        Message jsonMessageIn = gsonIn.fromJson(message, Message.class);

        //Check id, if = this.id => send
        if(jsonMessageIn.id == this.id){
            System.out.println("Cons. " + id + ": prelevato " + message);

            // output stream towards Server
            DataOutputStream outToServer;
            try {
                outToServer = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // JSON marshaling
            Message m = new Message(jsonMessageIn.id, jsonMessageIn.msg);
            Gson gsonOut = new Gson();
            String jsonStringOut = gsonOut.toJson(m);

            // send the line to the server
            try {
                outToServer.writeBytes(jsonStringOut + "\n");
                System.out.println("MSG sent to Server");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
