package Ex4Chat;

import com.google.gson.Gson;

import java.net.Socket;

public class ConsumerClientFromServer extends Consumer{

    public ConsumerClientFromServer(String id, Queue q) {
        super(id, q);
    }

    public void run() {
        while (true){
            if(read()){
                consume(queue.take());
            }
        }
    }

    public void consume(String message) {

        //JSON Un-Marshaling
        Gson gsonIn = new Gson();
        Message jsonMessageIn = gsonIn.fromJson(message, Message.class);

        System.out.println("From: " + jsonMessageIn.id + ", message: " + jsonMessageIn.msg);
    }

    public boolean read(){
        String message = queue.read();

        //JSON Un-Marshaling
        Gson gsonIn = new Gson();
        Message jsonMessageIn = gsonIn.fromJson(message, Message.class);

        if(id != this.id){
            // JSON marshaling
            Message m = new Message(jsonMessageIn.id, jsonMessageIn.msg);
            Gson gsonOut = new Gson();
            String jsonStringOut = gsonOut.toJson(m);

            return true;
        }

        return false;
    }
}
