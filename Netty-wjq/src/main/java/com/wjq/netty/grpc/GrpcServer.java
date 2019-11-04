package com.wjq.netty.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {




    private Server server;

    private void start() throws IOException {
        this.server = ServerBuilder.forPort(9988).addService(new HelloServiceImpl()).build().start();

        System.out.println("Server start");


        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run() {

                System.out.println("关闭jvm");
                GrpcServer.this.stop();

            }
        });
        System.out.println("执行到这里");
    }


    private void stop(){
        if (server != null){
            server.shutdown();
        }
    }


    private void awaitTermination() throws InterruptedException {
        if (server != null){
            this.server.awaitTermination();
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer grpcServer = new GrpcServer();
        grpcServer.start();
        grpcServer.awaitTermination();
    }

}
