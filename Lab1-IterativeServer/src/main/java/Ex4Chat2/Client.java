package Ex4Chat2;

import java.net.Socket;

public class Client {

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


    }
}
