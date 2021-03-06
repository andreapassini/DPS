package Ex4Chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServerEx4 {
    public static void main(String argv[]) throws Exception{

        // Init Q
        Queue q = new Queue();

        int portNumber;

        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        portNumber = 6789;

        ServerSocket welcomeSocket = new ServerSocket(portNumber);
        System.out.println("MultiServer started!");

        int idToGive = 0;

        while (true){
            Socket connectionSocket = welcomeSocket.accept();

            if(connectionSocket != null){
                System.out.println("Client accept at: " + welcomeSocket.getLocalSocketAddress());

                //Send ID
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                outToClient.writeBytes(idToGive + "\n");

                // thread creation passing established socket as arg
                ServerThreadEx4 theThread =
                        new ServerThreadEx4(connectionSocket, q);

                // Start the thread
                theThread.start();

                idToGive++;
            }

        }
    }

}
