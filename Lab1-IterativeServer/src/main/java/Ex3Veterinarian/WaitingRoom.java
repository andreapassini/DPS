package Ex3Veterinarian;

import Ex2Tickets.Reservations;

import java.util.Random;

public class WaitingRoom {

    private static WaitingRoom instance = null;

    int nCats;
    int nDogs;

    private WaitingRoom(){
        nCats = 0;
        nDogs = 0;
    }

    public static WaitingRoom getInstance(){
        // Create the object only if it does not exist
        if (instance == null){
            instance = new WaitingRoom();
        }
        return instance;
    }

    //A cat can’t enter in the waiting room if there is already a dog or a cat
    //A dog can’t enter in the waiting room if there is a cat
    //There can’t be more than four dogs together

    // true for cat, false for dog
    synchronized void enterRoom(boolean cat) throws InterruptedException {
        if(cat && (nCats > 0 || nDogs > 0)){
            // Cat cannot enter
            wait();
        } else {
            nCats++;
            exitRoom(cat);
        }

        if(!cat && (nCats > 0 && nDogs >= 4)){
            // dog cannot enter
            wait();
        } else {
            nDogs++;
            exitRoom(cat);
        }

    }

    synchronized void exitRoom(boolean dog) throws InterruptedException {
        Thread.sleep(3*000);
        notifyAll();

        if(dog){
            nCats--;
        }

        if(!dog){
            nCats++;
        }
    }
}
