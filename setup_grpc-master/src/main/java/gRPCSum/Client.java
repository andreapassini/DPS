package gRPCSum;

public class Client {
    public static void main(String[] args) {
        System.out.println("Trying to call greeting synchronous method:\n");

        //synchronousCall();

        System.out.println("\n...Done!");

        System.out.println("--------------");

        System.out.println("Now calling streamGreeting asynchronous method:\n");

        System.out.println("\n...Done!");
    }

    

}
