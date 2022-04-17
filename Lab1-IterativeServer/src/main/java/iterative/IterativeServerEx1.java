package iterative;

import java.io.*;
import java.net.*;

public class IterativeServerEx1 {
    public static void main(String argv[]) throws Exception{
        String clientRequest;
        int portNumber;

        int firstNumber;
        int secondNumber;
        int sum;
        String response;

        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Insert port:");
        portNumber = Integer.parseInt(inFromUser.readLine());

        // create a "listening socket" on the specific port
        ServerSocket welcomeSocket = new ServerSocket(portNumber);
        System.out.println("Server started!");

        while (true){
            /*
            accept is a blocking call
            once a new connection arrived, it creates
            a new "established socket
             */
            Socket connectionSocket = welcomeSocket.accept();

            if(connectionSocket != null){
                System.out.println("Client accept at: " + welcomeSocket.getLocalSocketAddress());
            }

            // input stream from the socket initialization
            BufferedReader inFromClient =
                    new BufferedReader(
                            new InputStreamReader(connectionSocket.getInputStream()));

            // output stream to the socket initialization
            DataOutputStream outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());

            // read a line (that terminates with \n) from the client
            clientRequest = inFromClient.readLine();

            // Parse the string to the 2 numbers
            firstNumber = Integer.parseInt(clientRequest.split("-")[0]);
            secondNumber = Integer.parseInt(clientRequest.split("-")[1]);

            // wait for 10 sec
            System.out.println("Request processing...");
            Thread.sleep(10000);

            sum = firstNumber + secondNumber;

            response = (sum) + "\n";

            // send out the response to the client
            outToClient.writeBytes(response);

            System.out.println("Request complete");
        }
    }


}
