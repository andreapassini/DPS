package Ex4Chat2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {

    private Socket connectionSocket = null;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;
    private Queue q;

    public ServerThread(Socket connectionSocket, Queue q) {
        this.connectionSocket = connectionSocket;
        this.q = q;

    }
}
