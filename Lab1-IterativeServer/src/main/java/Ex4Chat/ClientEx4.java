package Ex4Chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientEx4 {
    // 1 Thread Producer
    //      Reads from Keyboard
    //      Writes on Queue
    // 1 Thread Consumer
    //      Reads from Queue (msgs not sent by its client)
    //      Writes on Console

    public static void main(String argv[]) throws Exception {
        int portNumber;
        String request;
        String address;
        String response;
        String clientId;

        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        address = "localhost";
        portNumber = 6789;
        //client socket init
        Socket clientSocket = new Socket(address, portNumber);

        // output stream towards
        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());

        // input stream from socket init
        BufferedReader inFromServer =
                new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

        clientId = inFromUser.readLine();

        // Create Client Queue
        Queue q = new Queue();

        //Create a Producer
        //  Producer read from Keyboard
        //  Producer send to local Queue
        Producer p1 = new Producer(clientId, q);
        // new Thread for the client's Producer

        //Create a Consumer
        //  Consumer read form local Queue
        //  Consumer send msg to Server
        Consumer c1 = new Consumer(clientId, q);
        // new Thread for the consumer

        System.out.println("Welcome to the chat");

        // read a line from the user
        request = inFromUser.readLine();

        // send the line to the server
        outToServer.writeBytes(request + "\n");
        System.out.println("Request sent...");

        // read the response from the server
        response = inFromServer.readLine();
        System.out.println(response);

        clientSocket.close();
    }

}
