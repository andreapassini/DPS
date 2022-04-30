package Ex4Chat2;

import java.net.Socket;

public class ProducerServerFromClient extends Producer{

    Socket clientSocket;

    public ProducerServerFromClient(String id, Queue q, Socket socket) {
        super(id, q);
        this.clientSocket = socket;
    }
}
