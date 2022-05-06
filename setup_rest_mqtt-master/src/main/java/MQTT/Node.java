package MQTT;

public class Node {
    private Integer content;
    private Node next;

    public Node(Node n, Integer c){
        next = n;
        content = c;
    }

    public Integer getContent() {
        return content;
    }

    public Node getNext() {
        return next;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
