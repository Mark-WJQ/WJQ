package com.wjq.netty.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @author wjq
 * @version 1.0.0
 * @ClassName NewIoClient.java
 * @createTime 2019年11月06日 09:11:00
 */
public class NewIoClient {


    public static void main(String[] args) throws Exception {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 9999));

        socketChannel.configureBlocking(true);

        String fileName = "/Users/wangjianqiang/Downloads/apache-jmeter-4.0.tgz";
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();


        long start = System.currentTimeMillis();
        long transforCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);


        System.out.println("发送总字节数："+ transforCount + "耗时：" + (System.currentTimeMillis() - start));





    }


}
