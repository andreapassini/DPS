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

        // output stream towards Server
        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());

        // input stream from socket
        BufferedReader inFromServer =
                new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

        clientId = inFromServer.readLine();

        // Create Client Queue
        Queue q = new Queue();

        //Create ProducerFromUser
        //  Producer read from Keyboard
        //  Producer send to local Queue
        ProducerFromUser p1 = new ProducerFromUser(clientId, q);
        // new Thread for ProducerFromUser
        new Thread(p1).start();

        //Create ProducerFromServer
        //  Producer reads from Server
        //  Producer writes on local Queue
        ProducerFromServer p2 = new ProducerFromServer(clientId, q, clientSocket);
        // new Thread for ProducerFromServer

        //Create ConsumerClientToServer
        //  Consumer read form local Queue
        //  Consumer send msg to Server
        ConsumerClientToServer c1 = new ConsumerClientToServer(clientId, q, clientSocket);
        // new Thread for the consumer
        new Thread(c1).start();

        //Create ConsumerClientFromServer
        //  Consumer read form local Queue
        //  Consumer send msg to Server
        ConsumerClientFromServer c2 = new ConsumerClientFromServer(clientId, q);
        // new Thread for the consumer
        new Thread(c2).start();

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
