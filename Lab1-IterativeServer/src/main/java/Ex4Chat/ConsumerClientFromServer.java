package Ex4Chat;

import java.net.Socket;

public class ConsumerClientFromServer extends Consumer{

    public ConsumerClientFromServer(String id, Queue q) {
        super(id, q);
    }

    public void run() {
        while (true){
            consume(queue.take());
        }
    }

    public void consume(String message) {

    }
}
