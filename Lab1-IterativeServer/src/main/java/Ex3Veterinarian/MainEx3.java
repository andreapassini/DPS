package Ex3Veterinarian;

import java.util.ArrayList;
import java.util.Random;

public class MainEx3 {

    public static void main(String arg[]) throws Exception {
        Random r = new Random();
        ArrayList<Thread> threads = new ArrayList<Thread>();
        //create some threads
        for (int i=0; i<10; i++) {
            MyThreadEx3 mt = new MyThreadEx3(r);
            threads.add(mt);
        }
        System.out.println("All threads have been created.");
        //start all the threads
        for (Thread t: threads) {
            t.start();
        }
        System.out.println("All threads have been started.");
        System.out.println("Start waiting for all thread to finish...");
        //wait all the thread to finish
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("...All thread finished!");
    }

}
