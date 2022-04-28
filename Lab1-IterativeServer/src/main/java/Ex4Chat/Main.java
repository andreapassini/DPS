package Ex4Chat;

public class Main {
    public static void main(String[] args) {
        // Init Q
        Queue q = new Queue();

        ProducerFromUser p1 = new ProducerFromUser("p1", q);
        ProducerFromUser p2 = new ProducerFromUser("p2", q);
        Consumer c1 = new Consumer("c1", q);
        Consumer c2 = new Consumer("c2", q);
        new Thread(p1).start();
        new Thread(p2).start();
    }
}
