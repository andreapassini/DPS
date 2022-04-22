package Ex4Chat;

import Ex3Veterinarian.WaitingRoom;

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
        q = q;
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

            // Read from the client
            clientRequest = inFromClient.readLine();

            Producer p1 = new Producer("p1", q);

            Consumer c1 = new Consumer("c1", q);

            outToClient.writeBytes(c1);

            connectionSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
