package Ex4Chat2;

import java.util.ArrayList;

public class Queue {

    public ArrayList<String> buffer = new ArrayList<String>();

    public synchronized void put(String message) {
        buffer.add(message);
        notifyAll();
    }

    public synchronized String take() {
        String message = null;

        while(buffer.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(buffer.size()>0){
            message = buffer.get(0);
            buffer.remove(0);
        }

        return message;
    }

    public synchronized String read(){
        String message = null;

        while(buffer.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(buffer.size()>0){
            message = buffer.get(0);
        }

        return message;
    }

}
