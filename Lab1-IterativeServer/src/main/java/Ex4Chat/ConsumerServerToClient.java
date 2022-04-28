package Ex4Chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConsumerServerToClient extends Consumer{
    //  Reads from Queue
    //  Writes to Clients

    private Socket socket;

    public ConsumerServerToClient(String id, Queue q, Socket socket) {
        super(id, q);

        this.socket = socket;
    }

    public void run() {
        // Reads from Queue
        consume(queue.take());
    }

    public void consume(String message) {
        // Writes to Client

        DataOutputStream outToClient;
        try {
            outToClient =
                    new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            outToClient.writeBytes(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
