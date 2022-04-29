package gRPCSum;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class Server {
    public static void main(String[] args) {
        //faccio partire il servizio sulla porta 8080
        try {

            //io.grpc.Server server = ServerBuilder.forPort(8080).addService(new GreetingServiceImpl()).build();
            io.grpc.Server server = ServerBuilder.forPort(8080).addService(new SumServiceImpl()).build();

            server.start();

            System.out.println("Server started!");

            server.awaitTermination();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (InterruptedException e) {

            e.printStackTrace();

        }
    }
}
