package Ex2Tickets;

import java.io.*;
import java.net.*;

public class ServerThreadEx2 extends Thread{
    private Socket connectionSocket = null;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;

    // the constructor argument is established socket
    public ServerThreadEx2(Socket a){
        connectionSocket = a;

        try {
            inFromClient =
                    new BufferedReader(
                            new InputStreamReader(connectionSocket.getInputStream()));

            outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        int freeSeat = 0;
        String response = "";

        try {
            System.out.println("Processing request...");

            Reservations r = Reservations.getInstance();
            System.out.println("Class instance of Reservation");

            // Look for a seat
            freeSeat = r.AvailableSeat();

            Thread.sleep(10000);

            if(freeSeat <= 0){
                response = "Ticket DENIED" + "\n";
            } else{
                response = "Ticket CONFIRMED AT " + freeSeat + "\n";
            }

            outToClient.writeBytes(response);
            connectionSocket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
