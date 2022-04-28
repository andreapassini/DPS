package Ex4Chat;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Producer implements Runnable {

    final String id;
    final Queue queue;

    public Producer(String id, Queue q) {
        this.id = id; queue = q;
    }

    public void run() {

    }

    public String produce() {
        String msg = null;

        return msg;
    }

}
