package com.wjq.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;

/**
 * Created by wangjianqiang on 2019/5/5.
 */
public class Channel {



    public static void testChannel() throws IOException {
        RandomAccessFile file = new RandomAccessFile("/Users/wangjianqiang/Documents/dubbo_control.sh","rw");
        FileChannel fc = file.getChannel();

        ByteBuffer bb = ByteBuffer.allocate(48);

        RandomAccessFile cf = new RandomAccessFile("/Users/wangjianqiang/Documents/copy_dubbo_control.sh","rw");
        FileChannel cfc = cf.getChannel();
        int byteRead = fc.read(bb);
        while (byteRead != -1){

            System.out.println("Read " + fc.position());
            //将buffer的读模式转换到写模式
            bb.flip();
            while (bb.hasRemaining()){
                System.out.print((char) bb.get());
            }
            bb.clear();
            byteRead = fc.read(bb);
        }
        cf.close();
        file.close();
    }



    public static void copyFile() throws IOException {
        RandomAccessFile file = new RandomAccessFile("/Users/wangjianqiang/Documents/dubbo_control.sh","rw");
        FileChannel fc = file.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(48);

        RandomAccessFile cf = new RandomAccessFile("/Users/wangjianqiang/Documents/copy_dubbo_control.sh","rw");
        FileChannel cfc = cf.getChannel();
        cfc.transferFrom(fc,0,fc.size());
        file.close();
        cf.close();

    }



    public static void testSocketChannel() throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(10999));
        ByteBuffer buffer = ByteBuffer.allocate(48);

        String str = "my first sockt " + LocalDateTime.now();
        buffer.put(str.getBytes());
        buffer.flip();
        while (buffer.hasRemaining()){
            socketChannel.write(buffer);
        }
        socketChannel.close();
    }


    public static void main(String[] args) throws IOException {
       // testChannel();
       // copyFile();
        testSocketChannel();
    }


}
