package iterative;//package iterative;

import java.io.*;
import java.net.*;

public class IterativeServer {
    public static void main(String argv[]) throws Exception{
        String clientSentece;
        String capitalizedSentence;

        // create a "listening socket" on the specific port
        ServerSocket welcomeSocket = new ServerSocket(6789);
        System.out.println("Server started!");

        while (true){
            /*
            accept is a blocking call
            once a new connection arrived, it creates
            a new "established socket
             */

            Socket connectionSocket = welcomeSocket.accept();

            // input stream from the socket initialization
            BufferedReader inFromClient =
                    new BufferedReader(
                            new InputStreamReader(connectionSocket.getInputStream()));

            // output stream to the socket initialization
            DataOutputStream outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());

            // read a line (that terminates with \n) from the client
            clientSentece = inFromClient.readLine();

            // wait for 10 sec
            System.out.println("Request processing...");
            Thread.sleep(10000);

            capitalizedSentence = clientSentece.toUpperCase() + "\n";

            // send out the response to the client
            outToClient.writeBytes(capitalizedSentence);
        }
    }
}
