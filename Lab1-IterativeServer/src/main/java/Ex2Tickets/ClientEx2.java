package Ex2Tickets;

import java.io.*;
import  java.net.*;

public class ClientEx2 {
    // Ask the Server for a ticket
    // Get back the number of the seat

    public static void main(String argv[]) throws Exception{
        int portNumber;
        String address;

        String response;

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

        // send the line to the server
        // outToServer.writeBytes("Ticket please"+ "\n");
        System.out.println("Request sent . . .");

        // read the response from the server
        response = inFromServer.readLine();
        System.out.println("FROM SERVER: CONFIRMED TICKET at " + response);

        clientSocket.close();
    }

}
