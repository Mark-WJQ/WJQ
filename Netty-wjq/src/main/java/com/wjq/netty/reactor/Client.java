package com.wjq.netty.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author wjq
 * @version 1.0.0
 * @ClassName Client.java
 * @createTime 2019年11月10日 11:17:00
 */
public class Client {


    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",9999));
       ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
       byteBuffer.put("hello world ".getBytes());
        socketChannel.write(byteBuffer);



    }
}
