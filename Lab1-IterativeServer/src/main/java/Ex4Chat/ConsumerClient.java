package Ex4Chat;

import java.net.Socket;

public class ConsumerClient extends Consumer{

    public ConsumerClient(String id, Queue q, Socket clientSocket) {
        super(id, q);


    }

    public void run() {
        consume(this.queue.take());
    }

    public void consume(String message) {
        System.out.println("Cons. " + id + ": prelevato " + message);
    }
}
