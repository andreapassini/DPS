package Ex5UniversityJSON;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThreadEx5 extends Thread{
    private Socket connectionSocket = null;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;

    // the constructor argument is established socket
    public ServerThreadEx5(Socket a){
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

            Gson gson = new Gson();

            StudentInfo studentInfo = gson.fromJson(clientRequest, StudentInfo.class);

            System.out.println(clientRequest);

            response = "COMPLETE" + "\n";

            outToClient.writeBytes(response);
            connectionSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
