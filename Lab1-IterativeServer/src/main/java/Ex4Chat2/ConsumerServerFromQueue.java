package Ex4Chat2;

public class ConsumerServerFromQueue extends Consumer{
    public ConsumerServerFromQueue(String id, Queue q) {
        super(id, q);
    }
}
