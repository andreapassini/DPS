package main.java.Ex4Chat;

import java.net.Socket;

public class ProducerFromServer extends Producer{
    Socket clientSocket;

    public ProducerFromServer(String id, Queue q, Socket clientSocket) {
        super(id, q);

        this.clientSocket = clientSocket;
    }

    public void run() {

    }
}
