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

        // Start Producer
        Producer p1 = new Producer("p1", q, connectionSocket);
        Consumer c1 = new Consumer("c1", q);
        new Thread(c1);
        new Thread(p1);

        // Start Consumer
    }
}
