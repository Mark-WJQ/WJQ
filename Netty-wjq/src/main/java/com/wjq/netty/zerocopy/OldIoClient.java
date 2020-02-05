package com.wjq.netty.zerocopy;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.net.Socket;
import java.net.StandardSocketOptions;
import java.nio.channels.SocketChannel;

/**
 * @author wjq
 * @version 1.0.0
 * @ClassName OldIoClient.java
 * @createTime 2019年11月06日 09:12:00
 */
public class OldIoClient {


    public static void main(String[] args) throws Exception{


        Socket socket = new Socket("localhost",9999);

        InputStream inputStream = new FileInputStream("/Users/wangjianqiang/Downloads/apache-jmeter-4.0.tgz");
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        long readCount;
        long total = 0;

        long startTime = System.currentTimeMillis();

        while ((readCount = inputStream.read(buffer)) != -1){

            total += readCount;
            dataOutputStream.write(buffer);


        }


        System.out.println("发送总字节数： "+ total + ", 耗时： " + (System.currentTimeMillis() - startTime));


        dataOutputStream.close();
        socket.close();
        inputStream.close();


    }


}
