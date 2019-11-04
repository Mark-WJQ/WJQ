package com.wjq.netty.grpc;

import com.wjq.netty.protobuffer.*;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {


    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReponse> responseObserver) {
        System.out.println("接收到客户端信息： " + request.getGreet());
        HelloReponse reponse = HelloReponse.newBuilder().setReply("1111").build();
        responseObserver.onNext(reponse);
        responseObserver.onCompleted();
    }


    @Override
    public void getStudent(StreamRequest request, StreamObserver<StudentReponse> responseObserver) {

        System.out.println("收到客户端请求：" + request);

      StudentReponse reponse =  StudentReponse.newBuilder().setAge(10).setCity("beijing").setCity("Tony").build();

        responseObserver.onNext(reponse);
        responseObserver.onNext(reponse);
        responseObserver.onCompleted();

    }



    @Override
    public StreamObserver<StreamRequest> getStudents(StreamObserver<StudentReponseList> responseObserver) {


        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest streamRequest) {
                System.out.println("接收客户端请求:" + streamRequest);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onCompleted() {

                StudentReponse reponse =  StudentReponse.newBuilder().setAge(10).setCity("beijing").setCity("Tony").build();

                StudentReponse reponse1 =  StudentReponse.newBuilder().setAge(101).setCity("上海").setCity("Mark").build();


                StudentReponseList list = StudentReponseList.newBuilder().addStudentReponse(reponse).addStudentReponse(reponse1).build();


                responseObserver.onNext(list);
                responseObserver.onCompleted();


            }
        };




    }


    @Override
    public StreamObserver<StreamRequest> getStudentsStream(StreamObserver<StreamReponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest streamRequest) {
                System.out.println("接收客户端请求:" + streamRequest);
                responseObserver.onNext(StreamReponse.newBuilder().setReponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable throwable) {

                System.out.println(throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
                System.out.println();
            }
        };
    }
}
