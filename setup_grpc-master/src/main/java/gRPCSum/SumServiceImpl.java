package gRPCSum;


import io.grpc.stub.StreamObserver;
import it.ewlab.researcher.Sum;
import it.ewlab.researcher.SumServiceGrpc;

public class SumServiceImpl extends SumServiceGrpc.SumServiceImplBase {

    @Override
    public void simpleSum(Sum.SumRequest request, StreamObserver<Sum.SumResponse> responseObserver) {
        //la richiesta è di tipo HelloRequest (definito in .proto)
        System.out.println(request);

        int n1=request.getN1();
        int n2=request.getN2();
        int sum=n1+n2;

        //costruisco la richiesta di tipo HelloResponse (sempre definito in .proto)
        Sum.SumResponse response = Sum.SumResponse.newBuilder().setSumN(sum).build();

        //passo la risposta nello stream
        responseObserver.onNext(response);

        //completo e finisco la comunicazione
        responseObserver.onCompleted();
    }

    @Override
    public void repeatedSum(Sum.SumRequest request, StreamObserver<Sum.SumResponse> responseObserver) {
        int n = request.getN1();
        int t = request.getN2();

        for (int i=2; i <= t; i++){
            int sum = n * i;

            //costruisco la richiesta di tipo HelloResponse (sempre definito in .proto)
            Sum.SumResponse response = Sum.SumResponse.newBuilder().setSumN(sum).build();

            //passo la risposta nello stream
            responseObserver.onNext(response);
        }

    }

    @Override
    public StreamObserver<Sum.SumRequest> streamSum(StreamObserver<Sum.SumResponse> responseObserver) {
        //it returns the stream that will be used by the clients to send messages. The client will write on this stream
        return new StreamObserver<Sum.SumRequest>() {
            //receiving a message from the client
            @Override
            public void onNext(Sum.SumRequest clientRequest) {
                int n1 = clientRequest.getN1();
                int n2 = clientRequest.getN2();

                int sum = n1 + n2;

                System.out.println("[FROM CLIENT] " + n1 + n2);

                // sending the response to the client
                System.out.println("Sending the response to the client...\n");
                responseObserver.onNext(Sum.SumResponse.newBuilder().setSumN(sum).build());
            }


            public void onError(Throwable throwable) {
            }

            public void onCompleted() {
            }
        };
    }
}
