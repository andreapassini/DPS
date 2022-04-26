package main.java.Ex4Chat;

public class Main {
    public static void main(String[] args) {
        // Init Q
        Queue q = new Queue();

        Producer p1 = new Producer("p1", q);
        Producer p2 = new Producer("p2", q);
        Consumer c1 = new Consumer("c1", q);
        Consumer c2 = new Consumer("c2", q);
        new Thread(p1).start();
        new Thread(p2).start();
    }
}
