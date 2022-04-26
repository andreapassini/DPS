package main.java.Ex3Veterinarian;

import java.util.Random;

public class MyThreadEx3 extends Thread {

    private Random rnd;
    private boolean cat;

    MyThreadEx3(Random r) {
        rnd = r;
        cat = false;
    }

    public void run() {
        int seconds = rnd.nextInt(10) + 1;

        System.out.println("A thread started!");

        WaitingRoom waitingRoom = WaitingRoom.getInstance();

        // Check if is a CAT or a DOG with rnd

        if(rnd.nextInt()%2 == 0){
            cat = true;
        } else if (rnd.nextInt()%2 == 1){
            cat = false;
        }

        try {
            // get in line for the vet
            waitingRoom.enterRoom(cat);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("A thread died!");

    }
}
