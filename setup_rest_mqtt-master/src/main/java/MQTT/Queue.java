package MQTT;

import REST.beans.Words;

import java.util.List;

public class Queue {
    // Last In First Out
    List<Node> queue;

    Node last;

    int i=0;

    private static Queue instance;

    private Queue(){
    }

    public synchronized static Queue getInstance(){
        if(instance==null)
            instance = new Queue();
        return instance;
    }

    public synchronized void Add(int element){
        last = new Node(last, element);
        queue.add(last);
        i++;
    }

    public int AverageLastFive(){
        int sum = 0;
        Node ref = last;
        for(int i=0; i<5; i++){
            sum += ref.getContent();
            ref = ref.getNext();
        }

        return sum/5;
    }

    public synchronized boolean isFive(){
        if (i>=5){
            return true;
        }
        return false;
    }
}


