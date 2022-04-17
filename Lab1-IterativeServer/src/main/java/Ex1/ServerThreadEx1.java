package Ex1;

import java.io.*;
import java.net.*;

public class ServerThreadEx1 extends Thread{
    private Socket connectionSocket = null;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;

    // the constructor argument is established socket
    public ServerThreadEx1(Socket a){
        connectionSocket = a;

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
        int firstNumber;
        int secondNumber;
        int sum;
        String response;

        try {
            System.out.println("Processing request...");

            // read a line (that terminates with \n) from the client
            clientRequest = inFromClient.readLine();

            // Parse the string to the 2 numbers
            firstNumber = Integer.parseInt(clientRequest.split("-")[0]);
            secondNumber = Integer.parseInt(clientRequest.split("-")[1]);

            Thread.sleep(10000);

            sum = firstNumber + secondNumber;
            response = sum + "\n";

            outToClient.writeBytes(response);
            connectionSocket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
