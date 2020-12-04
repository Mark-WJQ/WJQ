package com.wjq.netty.protobuffer;

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
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: grpc.proto")
public final class HelloServiceGrpc {

  private HelloServiceGrpc() {}

  public static final String SERVICE_NAME = "com.wjq.netty.protobuffer.HelloService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.wjq.netty.protobuffer.HelloRequest,
      com.wjq.netty.protobuffer.HelloReponse> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = com.wjq.netty.protobuffer.HelloRequest.class,
      responseType = com.wjq.netty.protobuffer.HelloReponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.wjq.netty.protobuffer.HelloRequest,
      com.wjq.netty.protobuffer.HelloReponse> getSayHelloMethod() {
    io.grpc.MethodDescriptor<com.wjq.netty.protobuffer.HelloRequest, com.wjq.netty.protobuffer.HelloReponse> getSayHelloMethod;
    if ((getSayHelloMethod = HelloServiceGrpc.getSayHelloMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getSayHelloMethod = HelloServiceGrpc.getSayHelloMethod) == null) {
          HelloServiceGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<com.wjq.netty.protobuffer.HelloRequest, com.wjq.netty.protobuffer.HelloReponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wjq.netty.protobuffer.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wjq.netty.protobuffer.HelloReponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("SayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.wjq.netty.protobuffer.StreamRequest,
      com.wjq.netty.protobuffer.StudentReponse> getGetStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudent",
      requestType = com.wjq.netty.protobuffer.StreamRequest.class,
      responseType = com.wjq.netty.protobuffer.StudentReponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.wjq.netty.protobuffer.StreamRequest,
      com.wjq.netty.protobuffer.StudentReponse> getGetStudentMethod() {
    io.grpc.MethodDescriptor<com.wjq.netty.protobuffer.StreamRequest, com.wjq.netty.protobuffer.StudentReponse> getGetStudentMethod;
    if ((getGetStudentMethod = HelloServiceGrpc.getGetStudentMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getGetStudentMethod = HelloServiceGrpc.getGetStudentMethod) == null) {
          HelloServiceGrpc.getGetStudentMethod = getGetStudentMethod =
              io.grpc.MethodDescriptor.<com.wjq.netty.protobuffer.StreamRequest, com.wjq.netty.protobuffer.StudentReponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wjq.netty.protobuffer.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wjq.netty.protobuffer.StudentReponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("GetStudent"))
              .build();
        }
      }
    }
    return getGetStudentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.wjq.netty.protobuffer.StreamRequest,
      com.wjq.netty.protobuffer.StudentReponseList> getGetStudentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudents",
      requestType = com.wjq.netty.protobuffer.StreamRequest.class,
      responseType = com.wjq.netty.protobuffer.StudentReponseList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.wjq.netty.protobuffer.StreamRequest,
      com.wjq.netty.protobuffer.StudentReponseList> getGetStudentsMethod() {
    io.grpc.MethodDescriptor<com.wjq.netty.protobuffer.StreamRequest, com.wjq.netty.protobuffer.StudentReponseList> getGetStudentsMethod;
    if ((getGetStudentsMethod = HelloServiceGrpc.getGetStudentsMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getGetStudentsMethod = HelloServiceGrpc.getGetStudentsMethod) == null) {
          HelloServiceGrpc.getGetStudentsMethod = getGetStudentsMethod =
              io.grpc.MethodDescriptor.<com.wjq.netty.protobuffer.StreamRequest, com.wjq.netty.protobuffer.StudentReponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStudents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wjq.netty.protobuffer.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wjq.netty.protobuffer.StudentReponseList.getDefaultInstance()))
              .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("GetStudents"))
              .build();
        }
      }
    }
    return getGetStudentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.wjq.netty.protobuffer.StreamRequest,
      com.wjq.netty.protobuffer.StreamReponse> getGetStudentsStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentsStream",
      requestType = com.wjq.netty.protobuffer.StreamRequest.class,
      responseType = com.wjq.netty.protobuffer.StreamReponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.wjq.netty.protobuffer.StreamRequest,
      com.wjq.netty.protobuffer.StreamReponse> getGetStudentsStreamMethod() {
    io.grpc.MethodDescriptor<com.wjq.netty.protobuffer.StreamRequest, com.wjq.netty.protobuffer.StreamReponse> getGetStudentsStreamMethod;
    if ((getGetStudentsStreamMethod = HelloServiceGrpc.getGetStudentsStreamMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getGetStudentsStreamMethod = HelloServiceGrpc.getGetStudentsStreamMethod) == null) {
          HelloServiceGrpc.getGetStudentsStreamMethod = getGetStudentsStreamMethod =
              io.grpc.MethodDescriptor.<com.wjq.netty.protobuffer.StreamRequest, com.wjq.netty.protobuffer.StreamReponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStudentsStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wjq.netty.protobuffer.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.wjq.netty.protobuffer.StreamReponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("GetStudentsStream"))
              .build();
        }
      }
    }
    return getGetStudentsStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloServiceStub newStub(io.grpc.Channel channel) {
    return new HelloServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HelloServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HelloServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HelloServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HelloServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *一问一答
     * </pre>
     */
    public void sayHello(com.wjq.netty.protobuffer.HelloRequest request,
        io.grpc.stub.StreamObserver<com.wjq.netty.protobuffer.HelloReponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     * <pre>
     *流式返回
     * </pre>
     */
    public void getStudent(com.wjq.netty.protobuffer.StreamRequest request,
        io.grpc.stub.StreamObserver<com.wjq.netty.protobuffer.StudentReponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStudentMethod(), responseObserver);
    }

    /**
     * <pre>
     *流式请求
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.wjq.netty.protobuffer.StreamRequest> getStudents(
        io.grpc.stub.StreamObserver<com.wjq.netty.protobuffer.StudentReponseList> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetStudentsMethod(), responseObserver);
    }

    /**
     * <pre>
     *流式请求与返回
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.wjq.netty.protobuffer.StreamRequest> getStudentsStream(
        io.grpc.stub.StreamObserver<com.wjq.netty.protobuffer.StreamReponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetStudentsStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.wjq.netty.protobuffer.HelloRequest,
                com.wjq.netty.protobuffer.HelloReponse>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            getGetStudentMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.wjq.netty.protobuffer.StreamRequest,
                com.wjq.netty.protobuffer.StudentReponse>(
                  this, METHODID_GET_STUDENT)))
          .addMethod(
            getGetStudentsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.wjq.netty.protobuffer.StreamRequest,
                com.wjq.netty.protobuffer.StudentReponseList>(
                  this, METHODID_GET_STUDENTS)))
          .addMethod(
            getGetStudentsStreamMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.wjq.netty.protobuffer.StreamRequest,
                com.wjq.netty.protobuffer.StreamReponse>(
                  this, METHODID_GET_STUDENTS_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class HelloServiceStub extends io.grpc.stub.AbstractStub<HelloServiceStub> {
    private HelloServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *一问一答
     * </pre>
     */
    public void sayHello(com.wjq.netty.protobuffer.HelloRequest request,
        io.grpc.stub.StreamObserver<com.wjq.netty.protobuffer.HelloReponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *流式返回
     * </pre>
     */
    public void getStudent(com.wjq.netty.protobuffer.StreamRequest request,
        io.grpc.stub.StreamObserver<com.wjq.netty.protobuffer.StudentReponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStudentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *流式请求
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.wjq.netty.protobuffer.StreamRequest> getStudents(
        io.grpc.stub.StreamObserver<com.wjq.netty.protobuffer.StudentReponseList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetStudentsMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *流式请求与返回
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.wjq.netty.protobuffer.StreamRequest> getStudentsStream(
        io.grpc.stub.StreamObserver<com.wjq.netty.protobuffer.StreamReponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetStudentsStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class HelloServiceBlockingStub extends io.grpc.stub.AbstractStub<HelloServiceBlockingStub> {
    private HelloServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *一问一答
     * </pre>
     */
    public com.wjq.netty.protobuffer.HelloReponse sayHello(com.wjq.netty.protobuffer.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *流式返回
     * </pre>
     */
    public java.util.Iterator<com.wjq.netty.protobuffer.StudentReponse> getStudent(
        com.wjq.netty.protobuffer.StreamRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStudentMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HelloServiceFutureStub extends io.grpc.stub.AbstractStub<HelloServiceFutureStub> {
    private HelloServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *一问一答
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.wjq.netty.protobuffer.HelloReponse> sayHello(
        com.wjq.netty.protobuffer.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_GET_STUDENT = 1;
  private static final int METHODID_GET_STUDENTS = 2;
  private static final int METHODID_GET_STUDENTS_STREAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HelloServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HelloServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((com.wjq.netty.protobuffer.HelloRequest) request,
              (io.grpc.stub.StreamObserver<com.wjq.netty.protobuffer.HelloReponse>) responseObserver);
          break;
        case METHODID_GET_STUDENT:
          serviceImpl.getStudent((com.wjq.netty.protobuffer.StreamRequest) request,
              (io.grpc.stub.StreamObserver<com.wjq.netty.protobuffer.StudentReponse>) responseObserver);
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
        case METHODID_GET_STUDENTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudents(
              (io.grpc.stub.StreamObserver<com.wjq.netty.protobuffer.StudentReponseList>) responseObserver);
        case METHODID_GET_STUDENTS_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentsStream(
              (io.grpc.stub.StreamObserver<com.wjq.netty.protobuffer.StreamReponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HelloServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HelloServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.wjq.netty.protobuffer.Grpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HelloService");
    }
  }

  private static final class HelloServiceFileDescriptorSupplier
      extends HelloServiceBaseDescriptorSupplier {
    HelloServiceFileDescriptorSupplier() {}
  }

  private static final class HelloServiceMethodDescriptorSupplier
      extends HelloServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HelloServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HelloServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HelloServiceFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getGetStudentMethod())
              .addMethod(getGetStudentsMethod())
              .addMethod(getGetStudentsStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
