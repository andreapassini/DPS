package Ex2Tickets;

public class Reservations {
    // Singleton
    private static Reservations instance = null;

    private int maxSeats = 10;
    private int lastSeatAvailable;
    //private Object lock1 = new Object();

    private Reservations(){
        lastSeatAvailable = 0;
    }

    public static Reservations getInstance(){
        // Create the object only if it does not exist
        if (instance == null){
            instance = new Reservations();
        }
        return instance;
    }

    public synchronized int AvailableSeat(){
        if(lastSeatAvailable >= maxSeats + 1){
            return 0;
        }
        int newVar = lastSeatAvailable + 1;
        lastSeatAvailable = newVar;
        return lastSeatAvailable;
    }
}
