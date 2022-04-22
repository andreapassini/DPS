package Ex5UniversityJSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// It's the Dispatcher
public class MultiServerEx5 {
    public static void main(String argv[]) throws Exception{

        int portNumber;

        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Insert port:");
        portNumber = Integer.parseInt(inFromUser.readLine());

        ServerSocket welcomeSocket = new ServerSocket(portNumber);
        System.out.println("MultiServer started!");

        while (true){
            Socket connectionSocket = welcomeSocket.accept();

            if(connectionSocket != null){
                System.out.println("Client accept at: " + welcomeSocket.getLocalSocketAddress());
            }

            // thread creation passing established socket as arg
            ServerThreadEx5 theThread =
                    new ServerThreadEx5(connectionSocket);

            // Start the thread
            theThread.start();
        }
    }

}
