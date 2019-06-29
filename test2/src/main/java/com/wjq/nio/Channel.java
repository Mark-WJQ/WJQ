package com.wjq.nio;

import com.wjq.array.CountingGenerator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.time.LocalDateTime;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

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

        SocketChannel socketChannel = SelectorProvider.provider().openSocketChannel();

        socketChannel.connect(new InetSocketAddress(10998));
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ByteBuffer readBuff = ByteBuffer.allocate(1024);
        String str = "my first sockt " + LocalDateTime.now();
        buffer.put(str.getBytes());
        buffer.flip();
        while (true) {
            buffer.rewind();
            socketChannel.write(buffer);

            readBuff.clear();
            socketChannel.read(readBuff);
            readBuff.flip();
            System.out.println( Thread.currentThread().getId() + "-----------"+ new String(readBuff.array()).trim());
            System.out.println();
        }

       // socketChannel.close();
    }


   static ExecutorService service = Executors.newCachedThreadPool();
    public static void main(String[] args) throws IOException {
       // testChannel();
       // copyFile();
        for (int i = 0;i < 2;i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
                        testSocketChannel();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        service.shutdown();




    }


}
