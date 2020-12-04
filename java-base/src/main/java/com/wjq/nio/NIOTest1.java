package com.wjq.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

public class NIOTest1 {


    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);

        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8899));

        Selector selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


        while (true){


            selector.select();

           Set<SelectionKey> keys = selector.selectedKeys();

           keys.forEach(key ->{
               if (key.isAcceptable()){


                   try {
                       ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                       SocketChannel socket = channel.accept();
                       socket.configureBlocking(false);
                       socket.register(selector,SelectionKey.OP_READ);

                   } catch (Exception e) {
                       e.printStackTrace();
                   }


               }else if (key.isReadable()){

                  SocketChannel channel = (SocketChannel) key.channel();
                   ByteBuffer byteBuffer = ByteBuffer.allocate(512);

                   try {
                      int read = channel.read(byteBuffer);
                      if (read > 0){
                          byteBuffer.flip();
                          Charset charset = Charset.forName("utf-8");
                          String rm = String.valueOf(charset.decode(byteBuffer).array());
                          System.out.println(rm);
                          byteBuffer.rewind();
                          channel.write(byteBuffer);

                      }
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           });
            keys.clear();


        }





    }


}
