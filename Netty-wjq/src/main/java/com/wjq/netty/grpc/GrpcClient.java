package com.wjq.netty.grpc;

import com.wjq.netty.protobuffer.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class GrpcClient {






    public static void main(String[] args) throws InterruptedException {

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",9988).usePlaintext().build();

        HelloServiceGrpc.HelloServiceBlockingStub blockingStub = HelloServiceGrpc.newBlockingStub(managedChannel);

        HelloRequest request = HelloRequest.newBuilder().setGreet("hahhahh").build();
        HelloReponse reponse = blockingStub.sayHello(request);

        System.out.println(reponse);


        StreamRequest streamRequest = StreamRequest.newBuilder().setId(111).build();

        Iterator<StudentReponse> reponseIterator = blockingStub.getStudent(streamRequest);
        while (reponseIterator.hasNext()){
            StudentReponse studentReponse = reponseIterator.next();
            System.out.println(studentReponse);

        }


        StreamObserver<StudentReponseList> studentReponseListStreamObserver = new StreamObserver<StudentReponseList>() {
            @Override
            public void onNext(StudentReponseList studentReponseList) {

                System.out.println(studentReponseList);

            }

            @Override
            public void onError(Throwable throwable) {

                System.out.println(throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("complete");
            }
        };



        HelloServiceGrpc.HelloServiceStub helloServiceStub =  HelloServiceGrpc.newStub(managedChannel);

        StreamObserver<StreamRequest> streamRequestStreamObserver = helloServiceStub.getStudents(studentReponseListStreamObserver);
        streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setId(120).build());
        streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setId(121).build());
        streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setId(122).build());
        streamRequestStreamObserver.onCompleted();





         streamRequestStreamObserver = helloServiceStub.getStudentsStream(new StreamObserver<StreamReponse>() {
             @Override
             public void onNext(StreamReponse streamReponse) {
                 System.out.println(streamReponse);
             }

             @Override
             public void onError(Throwable throwable) {
                 System.out.println(throwable.getMessage());
             }

             @Override
             public void onCompleted() {
                 System.out.println("请求完成啦");
             }
         });



         for (int i =0;i < 10 ;i++){

             streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setId(100 + i).build());
             TimeUnit.SECONDS.sleep(1);


         }




















        TimeUnit.SECONDS.sleep(1);










    }

}
