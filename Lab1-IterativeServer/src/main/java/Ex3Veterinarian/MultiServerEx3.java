package Ex3Veterinarian;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServerEx3 {
    public static void main(String argv[]) throws Exception{

        int portNumber;
        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        portNumber = 6789;

        ServerSocket welcomeSocket = new ServerSocket(portNumber);
        System.out.println("MultiServer started!");

        while (true){
            Socket connectionSocket = welcomeSocket.accept();

            if(connectionSocket != null){
                System.out.println("Client accept at: " + welcomeSocket.getLocalSocketAddress());
            }

            // thread creation passing established socket as arg
            ServerThreadEx3 theThread =
                    new ServerThreadEx3(connectionSocket);

            // Start the thread
            theThread.start();
        }
    }

}
