package com.wjq.nio;

import java.io.IOException;
import java.net.InetSocketAddress;

import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

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


    public void init() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(10999));

        connS = Selector.open();
        readS = Selector.open();

        serverSocketChannel.register(connS, SelectionKey.OP_ACCEPT);

    }


    public void connect() throws IOException {

        System.out.println("--------begin connect------");
        while (true) {
            //阻塞
            connS.select();
            System.out.println("-------- connect select------");
            Set<SelectionKey> keys = connS.selectedKeys();
            Iterator<SelectionKey> it = keys.iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    handle(channel.accept());
                }
            }

        }
    }


    public static void main(String[] args) throws IOException {
        TestSocket testSocket = new TestSocket();
        testSocket.init();
        new Thread("receive") {
            @Override
            public void run() {
                try {
                    testSocket.receive();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        testSocket.connect();

    }


    public void handle(SocketChannel channel) throws IOException {
        System.out.println("---------connec handle --------" + channel.isOpen());
        channel.configureBlocking(false);
        synchronized (lock) {
            readS.wakeup();
            channel.register(readS, SelectionKey.OP_READ);
        }
    }


    public void receive() throws IOException {

        System.out.println("----------begin receive--------");
        while (true) {
            readS.select();
            System.out.println("----------readS.select--------");
            Set<SelectionKey> keys = readS.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    handleData(socketChannel);
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
