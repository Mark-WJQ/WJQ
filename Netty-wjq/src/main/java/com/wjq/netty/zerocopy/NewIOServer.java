package com.wjq.netty.zerocopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author wjq
 * @version 1.0.0
 * @ClassName NewIOServer.java
 * @createTime 2019年11月06日 09:07:00
 */
public class NewIOServer {


    public static void main(String[] args) throws Exception {

        InetSocketAddress address = new InetSocketAddress(9999);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(address);
        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true){

            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true);
            int count = 0;

            while (-1 != count){


                try{

                    count = socketChannel.read(byteBuffer);
                }catch (Exception e){
                    e.printStackTrace();
                }
                byteBuffer.rewind();

            }

        }


    }


}
