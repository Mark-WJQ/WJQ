package com.wjq.nio;


import java.io.IOException;
import java.net.InetSocketAddress;

import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangjianqiang on 2019/5/5.
 */
public class TestSocket {

    /**
     * 连接Selector
     */
    private Selector connS;

    /**
     * 读取选择器
     */
    private Selector readS;


    private Object lock = new Object();


    ExecutorService service = Executors.newCachedThreadPool();



    public void init() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(10998));

        connS = Selector.open();
        //readS = Selector.open();

        serverSocketChannel.register(connS, SelectionKey.OP_ACCEPT);

    }


    public void connect() throws IOException {

        new Thread() {
            @Override
            public void run() {
                System.out.println("--------begin connect------");
                while (true) {
                    //阻塞
                    try {
                        connS.select();
                        System.out.println("-------- connect select------");
                        Set<SelectionKey> keys = connS.selectedKeys();
                        Iterator<SelectionKey> it = keys.iterator();
                        while (it.hasNext()) {
                            SelectionKey key = it.next();
                            it.remove();
                            if (key.isAcceptable()) {
                                ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                                handle(channel.accept());
                            }
                            if (key.isReadable()){
                                handleData((SocketChannel) key.channel());
                            }

                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }


    public static void main(String[] args) throws IOException {
        TestSocket testSocket = new TestSocket();
        testSocket.init();
        testSocket.connect();

    }


    public void handle(SocketChannel channel) throws IOException {
        System.out.println("---------connec handle --------" + channel.isOpen());
        channel.configureBlocking(false);
        channel.register(connS, SelectionKey.OP_READ);
    }





    public void receive() throws IOException {

        while (true) {
            System.out.println("----------begin receive--------");
            readS.select() ;
            System.out.println("----------readS.select--------");
            Set<SelectionKey> keys = readS.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                key.interestOps(key.interestOps() & ~SelectionKey.OP_READ);
                iterator.remove();
                if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    handleData(socketChannel) ;
                }
            }

        }
    }




    public void handleData(SocketChannel channel) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(512);
        int rs = channel.read(buffer);
        while (rs != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            channel.read(buffer);
        }
        System.out.println();
        channel.close();
    }

}
