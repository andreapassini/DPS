package Ex4Chat2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Producer implements Runnable {

    final String id;
    final Queue queue;

    public Producer(String id, Queue q) {
        this.id = id; queue = q;

    }

    public void run() {
        while (true){
            queue.put(produce());
        }
    }

    public String produce() {
        String msg = null;


        return msg;
    }

}
