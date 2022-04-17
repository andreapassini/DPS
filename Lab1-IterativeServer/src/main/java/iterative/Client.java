package iterative;

import java.io.*;
import  java.net.*;

public class Client {
    public static void main(String argv[]) throws Exception{
        String sentece;
        String modifiedSentence;

        System.out.println("Give me a sentece...");

        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        //client socket init
        //  localhost: server address
        //  6789: server service port number
        Socket clientSocket = new Socket("localhost", 6789);

        // output stream towards
        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());

        // input stream from socket init
        BufferedReader inFromServer =
                new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

        // read a line from the user
        sentece = inFromUser.readLine();

        // send the line to the server
        outToServer.writeBytes(sentece + "\n");

        // read the response from the server
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);

        clientSocket.close();
    }
}
