package Ex4Chat2;

import java.net.Socket;

public class ConsumerClientToServer  extends Consumer{

    Socket clientSocket;

    public ConsumerClientToServer(String id, Queue q, Socket socket) {
        super(id, q);
        this.clientSocket = socket;
    }
}
