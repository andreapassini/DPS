package Ex4Chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientEx4Producer {
    // Ask the Server for a ticket
    // Get back the number of the seat

    public static void main(String argv[]) throws Exception{
        int portNumber;
        int animal;
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

        // Create a Producer
        //  Producer read from Keyboard
        //  Producer send to Queue

        System.out.println("0 for CAT, 1 for DOG: ");
        // read a line from the user
        animal = Integer.parseInt(inFromUser.readLine());

        // send the line to the server
        outToServer.writeBytes(animal + "\n");
        System.out.println("Request sent...");

        // read the response from the server
        response = inFromServer.readLine();
        System.out.println(response);

        clientSocket.close();
    }

}
