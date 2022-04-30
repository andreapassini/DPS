package Ex4Chat2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {

    public static void main(String argv[]) throws Exception{

        // Connecting with socket
        int portNumber = 6789;
        ServerSocket welcomeSocket = new ServerSocket(portNumber);
        System.out.println("MultiServer started!");

        // Init Q
        Queue q = new Queue();
        Queue q1 = new Queue();

        try {
            welcomeSocket = new ServerSocket(portNumber);

//            while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            ProducerClientFromUser p1 = new ProducerClientFromUser("p1", q);
            ConsumerClientToServer c1 = new ConsumerClientToServer("c1", q, connectionSocket);
            ProducerServerFromClient p2 = new ProducerServerFromClient("p2", q1, connectionSocket);
            ConsumerServerFromQueue c2 = new ConsumerServerFromQueue("c2", q1);

            new Thread(p1).start();
            new Thread(c1).start();
            new Thread(p2).start();
            new Thread(c2).start();
//            }
        } catch(Exception e) {
            System.out.println("\nEXCEPTION!");
            e.printStackTrace();
        }

    }
}
