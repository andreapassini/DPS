package Ex2Tickets;

public class Reservations {
    // Singleton
    private static Reservations instance = null;

    private int maxSeats = 10;
    private int lastSeatAvailable;
    private Object lock1 = new Object();

    private Reservations(){
        lastSeatAvailable = 0;
    }

    public static Reservations getInstance(){
        // Create the object only if it does not exist
        if (instance == null){
            new Reservations();
        }
        return instance;
    }

    public int AvailableSeat(){
        synchronized (lock1){
            if(lastSeatAvailable >= maxSeats){
                return 0;
            }
            lastSeatAvailable ++;
            return lastSeatAvailable - 1;
        }
    }
}
