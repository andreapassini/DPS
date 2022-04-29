package Ex4Chat;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThreadEx4 extends Thread{
    private Socket connectionSocket = null;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;

    private Queue q;

    // the constructor argument is established socket
    public ServerThreadEx4(Socket a, Queue q){

        connectionSocket = a;
        this.q = q;

        try {
            inFromClient =
                    new BufferedReader(
                            new InputStreamReader(connectionSocket.getInputStream()));

            outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        String clientRequest;
        String response = "";

        try {
            System.out.println("Processing request...");

            // Create ProducerFromUser
            //  Read from Client
            //  Writes to Queue
            ProducerFromUser p1 = new ProducerFromUser("p1", q);

            // Create ConsumerServer
            //  Reads from Queue
            //  Writes to Clients
            ConsumerServerToClient c1 = new ConsumerServerToClient("c1", q, connectionSocket);


            new Thread(p1).start();
            new Thread(c1).start();

            System.out.println("Thread Started");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
