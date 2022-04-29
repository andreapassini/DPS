package Ex4Chat2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    // Client will only writes
    public static void main(String[] args) throws Exception {
        int portNumber;
        String request;
        String address;
        String response;
        String clientId;

        //Connect with a Socket to Server
        address = "localhost";
        portNumber = 6789;
        Socket clientSocket = new Socket(address, portNumber);
        System.out.println("Connecting");

        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        // output stream towards Server
        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());

        System.out.println("Welcome to Write Only Chat ");
        System.out.println("Write 0 to exit");
        request = "1";

        //Cicle
        while (request.equals("0")){
            System.out.println("Write something: ");
            request = inFromUser.readLine();

            if(request != null && !request.equals("0")){
                //Send message
                System.out.println("Message Sent ");
                outToServer.writeBytes(request + "\n");
            }
        }
    }
}
