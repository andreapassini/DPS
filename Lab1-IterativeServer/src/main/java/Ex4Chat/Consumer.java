package Ex4Chat;

public class Consumer implements Runnable {

    private final Queue queue;
    private final String id;

    public Consumer(String id, Queue q) {
        this.id = id;
        queue = q;
    }

    public void run() {
        consume(queue.take());
    }

    public void consume(String message) {
        System.out.println("Cons. " + id + ": prelevato " + message);
    }
}
