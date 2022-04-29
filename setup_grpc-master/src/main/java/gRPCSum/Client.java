package gRPCSum;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import io.grpc.stub.StreamObserver;
import io.grpc.ServerBuilder;

public class Client {
    public static void main(String[] args) {


        // Insert type of Operation
        System.out.println("Choose an Operation: ");
        System.out.println(" -> 1 Simple Sum ");
        System.out.println(" -> 2 Repeated Sum ");
        System.out.println(" -> 3 Stream Sum ");

        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        // Insert number
        int choise = 0;

        try {
            choise = Integer.parseInt(inFromUser.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(choise == 1){
            //Simple sum
            synchSimpleSum();
        } else if (choise == 2) {
            // Repeated sum
        } else if (choise == 3) {
            // Stream sum
        } else if (choise == 0) {
            // Error
            System.out.println("Error");
        }


        System.out.println("Trying to call greeting synchronous method:\n");

        //synchronousCall();

        System.out.println("\n...Done!");
    }

    private void synchSimpleSum() {
        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        int n1;
        // Get the 2 numbers from user
        System.out.println("Insert I Number:  ");
        try {
            n1 = Integer.parseInt(inFromUser.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int n2;
        System.out.println("Insert II Number:  ");
        try {
            n2 = Integer.parseInt(inFromUser.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //plaintext channel on the address (ip/port) which offers the GreetingService service
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080").usePlaintext().build();

        //creating a blocking stub on the channel
        GreetingServiceBlockingStub stub = SumServiceGrpc.newBlockingStub(channel);

        //creating the HelloRequest object which will be provided as input to the RPC method
        Sum.SumRequest request = Sum.SumRequest.newBuilder().setN1(n1).setN2(n2).build();

        //calling the method. it returns an instance of HelloResponse
        Sum.SumResponse response = stub.simpleSum(request);

        //printing the answer
        System.out.println(response.getSumN());

        //closing the channel
        channel.shutdown();
    }


}
