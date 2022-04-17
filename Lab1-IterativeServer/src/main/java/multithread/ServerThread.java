package multithread;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread{
    private Socket connectionSocket = null;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;

    // the constructor argument is established socket
    public ServerThread(Socket a){
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
        String clientSentence;
        String capitalizedSentence;

        try {
            clientSentence = inFromClient.readLine();
            Thread.sleep(10000);

            capitalizedSentence = clientSentence.toUpperCase() + "\n";
            outToClient.writeBytes(capitalizedSentence);
            connectionSocket.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
