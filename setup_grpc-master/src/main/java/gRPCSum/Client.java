package gRPCSum;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import it.ewlab.researcher.Sum;
import it.ewlab.researcher.SumServiceGrpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {


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
            asyncSimpleSum();
        } else if (choise == 2) {
            // Repeated sum
            AsynchRepeatedSum();
        } else if (choise == 3) {
            // Stream sum
            AsynchStreamSum();
        } else if (choise == 0) {
            // Error
            System.out.println("Error");
        }


        System.out.println("\n...Done!");
    }

    public static void synchSimpleSum() {
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
        SumServiceGrpc.SumServiceBlockingStub stub = SumServiceGrpc.newBlockingStub(channel);

        //creating the HelloRequest object which will be provided as input to the RPC method
        Sum.SumRequest request = Sum.SumRequest.newBuilder().setN1(n1).setN2(n2).build();

        //calling the method. it returns an instance of HelloResponse
        Sum.SumResponse response = stub.simpleSum(request);

        //printing the answer
        System.out.println(response.getSumN());

        //closing the channel
        channel.shutdown();
    }

    public static void asyncSimpleSum() {
        //plaintext channel on the address (ip/port) which offers the GreetingService service
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080").usePlaintext().build();

        //creating an asynchronous stub on the channel
        SumServiceGrpc.SumServiceStub stub = SumServiceGrpc.newStub(channel);

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


        Sum.SumRequest request = Sum.SumRequest.newBuilder().setN1(n1).setN2(n2).build();

        //calling the RPC method. since it is asynchronous, we need to define handlers
        stub.simpleSum(request, new StreamObserver<Sum.SumResponse>() {

            //this hanlder takes care of each item received in the stream
            @Override
            public void onNext(Sum.SumResponse value) {
                //each item is just printed
                System.out.println(Sum.SumResponse.getSumN());
            }

            //if there are some errors, this method will be called
            public void onError(Throwable throwable) {

                System.out.println("Error! "+throwable.getMessage());

            }

            //when the stream is completed (the server called "onCompleted") just close the channel
            public void onCompleted() {

                channel.shutdownNow();

            }

        });

        //you need this. otherwise the method will terminate before that answers from the server are received
        try {
            channel.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    private static void AsynchRepeatedSum() throws InterruptedException {
        //plaintext channel on the address (ip/port) which offers the GreetingService service
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080").usePlaintext().build();

        //creating an asynchronous stub on the channel
        SumServiceGrpc.SumServiceStub stub = SumServiceGrpc.newStub(channel);

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


        Sum.SumRequest request = Sum.SumRequest.newBuilder().setN1(n1).setN2(n2).build();

        //calling the RPC method. since it is asynchronous, we need to define handlers
        stub.repeatedSum(request, new StreamObserver<Sum.SumResponse>() {

            //this hanlder takes care of each item received in the stream
            @Override
            public void onNext(Sum.SumResponse value) {
                //each item is just printed
                System.out.println(value.getSumN());
            }

            //if there are some errors, this method will be called
            public void onError(Throwable throwable) {

                System.out.println("Error! "+throwable.getMessage());

            }

            //when the stream is completed (the server called "onCompleted") just close the channel
            public void onCompleted() {

                channel.shutdownNow();

            }

        });

        channel.awaitTermination(10, TimeUnit.SECONDS);
    }

    private static void AsynchStreamSum() throws InterruptedException {

        //plaintext channel on the address (ip/port) which offers the GreetingService service
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080").usePlaintext().build();

        //creating an asynchronous stub on the channel
        SumServiceGrpc.SumServiceStub stub = SumServiceGrpc.newStub(channel);

        //the stub returns a stream to communicate with the server.
        //the argument is the stream of messages which are transmitted by the server.
        StreamObserver<Sum.SumRequest> serverStream = stub.streamSum(new StreamObserver<Sum.SumResponse>() {
            //remember: all the methods here are CALLBACKS which are handled in an asynchronous manner.

            //we define what to do when a message from the server arrives (just print the message)
            @Override
            public void onNext(Sum.SumResponse value) {
                System.out.println("[FROM SERVER] " + value.getSumN());
            }

            public void onError(Throwable throwable) {
            }

            public void onCompleted() {
            }
        });

        // input stream initialization (from user keyboard)
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        int n1 = 1;
        int n2 = 1;

        while(n1 == 0 || n2 == 0){

            System.out.println("Insert I Number:  (0) to exit");
            try {
                n1 = Integer.parseInt(inFromUser.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Insert II Number:  (0) to exit");
            try {
                n2 = Integer.parseInt(inFromUser.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if(n1 != 0 || n2 != 0){
                System.out.println("Summing '" + n1 + " + " + n2);
                serverStream.onNext(Sum.SumRequest.newBuilder().setN1(n1).setN2(n2).build());
            }

        }

        try {
            //you need this. otherwise the method will terminate before that answers from the server are received
            channel.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
