package Ex1;

import java.io.*;
import  java.net.*;

public class ClientEx1 {
    public static void main(String argv[]) throws Exception{
        String sentece;
        String modifiedSentence;

        int portNumber;
        String address;

        String firstNumber;
        String secondNumber;

        String sum;

        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Insert Address: ");
        // read a line from the user
        address = inFromUser.readLine();

        System.out.println("Insert Port Number: ");
        // read a line from the user
        portNumber = Integer.parseInt(inFromUser.readLine());

        //client socket init
        Socket clientSocket = new Socket(address, portNumber);

        // output stream towards
        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());

        // input stream from socket init
        BufferedReader inFromServer =
                new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Insert First Number");
        firstNumber = inFromUser.readLine();

        System.out.println("Insert Second Number");
        secondNumber = inFromUser.readLine();

        // send the line to the server
        outToServer.writeBytes(firstNumber + "-" + secondNumber + "\n");
        System.out.println("Request sent . . .");

        // read the response from the server
        sum = inFromServer.readLine();
        System.out.println("FROM SERVER: " + sum);

        clientSocket.close();
    }

}
