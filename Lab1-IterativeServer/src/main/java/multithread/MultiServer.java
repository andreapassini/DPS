package multithread;

import java.io.*;
import java.net.*;

// It's the Dispatcher
public class MultiServer {
    public static void main(String argv[]) throws Exception{

        ServerSocket welcomeSocket = new ServerSocket(6789);
        System.out.println("MultiServer started!");

        while (true){
            Socket connectionScoket = welcomeSocket.accept();

            // thread creation passing established socket as arg
            ServerThread theThread =
                    new ServerThread(connectionScoket);

            // Start the thread
            theThread.start();
        }
    }

}
