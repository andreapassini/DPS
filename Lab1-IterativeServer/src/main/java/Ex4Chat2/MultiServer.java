package Ex4Chat2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {

    public static void main(String argv[]) throws Exception{

        // Init Q
        Queue q = new Queue();

        // Connecting with socket
        int portNumber = 6789;
        ServerSocket welcomeSocket = new ServerSocket(portNumber);
        System.out.println("MultiServer started!");

        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        while (true){
            Socket connectionSocket = welcomeSocket.accept();

            if(connectionSocket != null){
                System.out.println("Client accept at: " + welcomeSocket.getLocalSocketAddress());

                // thread creation passing established socket as arg
                ServerThread theThread =
                        new ServerThread(connectionSocket, q);

                // Start the thread
                theThread.start();
            }
        }
        
    }
}
