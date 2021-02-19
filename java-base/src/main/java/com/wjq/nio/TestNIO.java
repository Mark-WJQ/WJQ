package com.wjq.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestNIO {



    Selector selector;

    ExecutorService service = Executors.newCachedThreadPool();


    public void init() {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(10998));
            selector = Selector.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        TestNIO testNIO = new TestNIO();
        testNIO.init();
        while (true) {
            try {
                testNIO.selector.select();
                Set<SelectionKey> set = testNIO.selector.selectedKeys();
                Iterator<SelectionKey> iterator = set.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    //System.out.println(key.channel().getClass()  +  "=========="+key.channel());
                    iterator.remove();
                    if (key.isAcceptable()) {
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                        SocketChannel channel = serverSocketChannel.accept();
                        channel.configureBlocking(false);
                        channel.register(testNIO.selector, SelectionKey.OP_READ);
                    }

                    if (key.isReadable()) {
                        testNIO.readFromSocketCun(key);
                    }
                    if (key.isWritable()){
                        testNIO.write(key);
                        key.interestOps(SelectionKey.OP_READ);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    private ByteBuffer writeBuff = ByteBuffer.allocate(1024);


    public void write(SelectionKey key) {
        key.interestOps(key.interestOps() & ~SelectionKey.OP_WRITE);
        try {
            writeBuff.clear();
            SocketChannel channel = (SocketChannel) key.channel();
            writeBuff.put(("have received" + LocalDateTime.now()).getBytes());
            writeBuff.flip();
            channel.write(writeBuff);
        } catch (IOException e) {
            e.printStackTrace();
        }

        key.interestOps(key.interestOps() | SelectionKey.OP_WRITE);


    }




    public synchronized void readFromSocket(SelectionKey key){

        try {
            SocketChannel channel = (SocketChannel) key.channel();
            byteBuffer.clear();
            int count = 0;
            while ((count = channel.read(byteBuffer)) > 0){
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()){
                    System.out.print((char) byteBuffer.get());
                }
                byteBuffer.clear();
            }
            System.out.println();
            //write(key);

            //channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public  void readFromSocketCun(SelectionKey key){


        key.interestOps(key.interestOps() & ~SelectionKey.OP_READ);

        service.execute(new Runnable() {
            @Override
            public  void run() {
                readFromSocket(key);
                key.interestOps(key.interestOps() | SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                selector.wakeup();
            }
        });



    }



}
