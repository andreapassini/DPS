package Ex2Tickets;

import Ex1.ServerThreadEx1;

import java.io.*;
import java.net.*;

public class MultiServerEx2 {
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
            ServerThreadEx1 theThread =
                    new ServerThreadEx1(connectionSocket);

            // Start the thread
            theThread.start();
        }
    }

}
