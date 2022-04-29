package Ex4Chat2;

public class Consumer implements Runnable {

    final Queue queue;
    final String id;

    public Consumer(String id, Queue q) {
        this.id = id;
        queue = q;
    }

    public void run() {
        while (true){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            consume(queue.take());
        }
    }

    public void consume(String message) {
        System.out.println("Cons. " + id + ": prelevato " + message);
    }
}
