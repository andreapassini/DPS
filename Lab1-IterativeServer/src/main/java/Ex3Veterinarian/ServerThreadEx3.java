package Ex3Veterinarian;

import Ex2Tickets.Reservations;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThreadEx3 extends Thread{
    private Socket connectionSocket = null;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;

    // the constructor argument is established socket
    public ServerThreadEx3(Socket a){
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
        String clientRequest;
        String response = "";

        try {
            System.out.println("Processing request...");

            // Read from the client if CAT or DOG
            clientRequest = inFromClient.readLine();

            // 0 for CAT, 1 for DOG
            int animal = Integer.parseInt(clientRequest);

            WaitingRoom waitingRoom = WaitingRoom.getInstance();


            // CAT
            if(animal==0){
                System.out.println("It's a CAT");
                waitingRoom.enterRoom(true);
            }

            // DOG
            if(animal==1){
                System.out.println("It's a DOG");
                waitingRoom.enterRoom(false);
            }

            if(animal != 1 && animal != 0){
                response = "error, pick 0 for CAT or 1 for DOG";
            }



            outToClient.writeBytes(response);
            connectionSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
