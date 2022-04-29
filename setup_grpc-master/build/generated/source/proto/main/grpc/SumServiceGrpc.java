import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.25.0)",
    comments = "Source: Sum.proto")
public final class SumServiceGrpc {

  private SumServiceGrpc() {}

  public static final String SERVICE_NAME = "SumService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Sum.SumRequest,
      Sum.SumResponse> getSimpleSumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "simpleSum",
      requestType = Sum.SumRequest.class,
      responseType = Sum.SumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Sum.SumRequest,
      Sum.SumResponse> getSimpleSumMethod() {
    io.grpc.MethodDescriptor<Sum.SumRequest, Sum.SumResponse> getSimpleSumMethod;
    if ((getSimpleSumMethod = SumServiceGrpc.getSimpleSumMethod) == null) {
      synchronized (SumServiceGrpc.class) {
        if ((getSimpleSumMethod = SumServiceGrpc.getSimpleSumMethod) == null) {
          SumServiceGrpc.getSimpleSumMethod = getSimpleSumMethod =
              io.grpc.MethodDescriptor.<Sum.SumRequest, Sum.SumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "simpleSum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Sum.SumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Sum.SumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SumServiceMethodDescriptorSupplier("simpleSum"))
              .build();
        }
      }
    }
    return getSimpleSumMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Sum.SumRequest,
      Sum.SumResponse> getRepeatedSumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "repeatedSum",
      requestType = Sum.SumRequest.class,
      responseType = Sum.SumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<Sum.SumRequest,
      Sum.SumResponse> getRepeatedSumMethod() {
    io.grpc.MethodDescriptor<Sum.SumRequest, Sum.SumResponse> getRepeatedSumMethod;
    if ((getRepeatedSumMethod = SumServiceGrpc.getRepeatedSumMethod) == null) {
      synchronized (SumServiceGrpc.class) {
        if ((getRepeatedSumMethod = SumServiceGrpc.getRepeatedSumMethod) == null) {
          SumServiceGrpc.getRepeatedSumMethod = getRepeatedSumMethod =
              io.grpc.MethodDescriptor.<Sum.SumRequest, Sum.SumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "repeatedSum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Sum.SumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Sum.SumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SumServiceMethodDescriptorSupplier("repeatedSum"))
              .build();
        }
      }
    }
    return getRepeatedSumMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Sum.SumRequest,
      Sum.SumResponse> getStreamSumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamSum",
      requestType = Sum.SumRequest.class,
      responseType = Sum.SumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<Sum.SumRequest,
      Sum.SumResponse> getStreamSumMethod() {
    io.grpc.MethodDescriptor<Sum.SumRequest, Sum.SumResponse> getStreamSumMethod;
    if ((getStreamSumMethod = SumServiceGrpc.getStreamSumMethod) == null) {
      synchronized (SumServiceGrpc.class) {
        if ((getStreamSumMethod = SumServiceGrpc.getStreamSumMethod) == null) {
          SumServiceGrpc.getStreamSumMethod = getStreamSumMethod =
              io.grpc.MethodDescriptor.<Sum.SumRequest, Sum.SumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "streamSum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Sum.SumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Sum.SumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SumServiceMethodDescriptorSupplier("streamSum"))
              .build();
        }
      }
    }
    return getStreamSumMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SumServiceStub newStub(io.grpc.Channel channel) {
    return new SumServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SumServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SumServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SumServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SumServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SumServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void simpleSum(Sum.SumRequest request,
        io.grpc.stub.StreamObserver<Sum.SumResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSimpleSumMethod(), responseObserver);
    }

    /**
     */
    public void repeatedSum(Sum.SumRequest request,
        io.grpc.stub.StreamObserver<Sum.SumResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRepeatedSumMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Sum.SumRequest> streamSum(
        io.grpc.stub.StreamObserver<Sum.SumResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getStreamSumMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSimpleSumMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Sum.SumRequest,
                Sum.SumResponse>(
                  this, METHODID_SIMPLE_SUM)))
          .addMethod(
            getRepeatedSumMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                Sum.SumRequest,
                Sum.SumResponse>(
                  this, METHODID_REPEATED_SUM)))
          .addMethod(
            getStreamSumMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                Sum.SumRequest,
                Sum.SumResponse>(
                  this, METHODID_STREAM_SUM)))
          .build();
    }
  }

  /**
   */
  public static final class SumServiceStub extends io.grpc.stub.AbstractStub<SumServiceStub> {
    private SumServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SumServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SumServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SumServiceStub(channel, callOptions);
    }

    /**
     */
    public void simpleSum(Sum.SumRequest request,
        io.grpc.stub.StreamObserver<Sum.SumResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSimpleSumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void repeatedSum(Sum.SumRequest request,
        io.grpc.stub.StreamObserver<Sum.SumResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getRepeatedSumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Sum.SumRequest> streamSum(
        io.grpc.stub.StreamObserver<Sum.SumResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getStreamSumMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class SumServiceBlockingStub extends io.grpc.stub.AbstractStub<SumServiceBlockingStub> {
    private SumServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SumServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SumServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SumServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Sum.SumResponse simpleSum(Sum.SumRequest request) {
      return blockingUnaryCall(
          getChannel(), getSimpleSumMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<Sum.SumResponse> repeatedSum(
        Sum.SumRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getRepeatedSumMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SumServiceFutureStub extends io.grpc.stub.AbstractStub<SumServiceFutureStub> {
    private SumServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SumServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SumServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SumServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Sum.SumResponse> simpleSum(
        Sum.SumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSimpleSumMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SIMPLE_SUM = 0;
  private static final int METHODID_REPEATED_SUM = 1;
  private static final int METHODID_STREAM_SUM = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SumServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SumServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SIMPLE_SUM:
          serviceImpl.simpleSum((Sum.SumRequest) request,
              (io.grpc.stub.StreamObserver<Sum.SumResponse>) responseObserver);
          break;
        case METHODID_REPEATED_SUM:
          serviceImpl.repeatedSum((Sum.SumRequest) request,
              (io.grpc.stub.StreamObserver<Sum.SumResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_SUM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamSum(
              (io.grpc.stub.StreamObserver<Sum.SumResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SumServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SumServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Sum.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SumService");
    }
  }

  private static final class SumServiceFileDescriptorSupplier
      extends SumServiceBaseDescriptorSupplier {
    SumServiceFileDescriptorSupplier() {}
  }

  private static final class SumServiceMethodDescriptorSupplier
      extends SumServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SumServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SumServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SumServiceFileDescriptorSupplier())
              .addMethod(getSimpleSumMethod())
              .addMethod(getRepeatedSumMethod())
              .addMethod(getStreamSumMethod())
              .build();
        }
      }
    }
    return result;
  }
}
