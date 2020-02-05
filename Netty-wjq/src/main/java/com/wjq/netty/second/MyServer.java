package com.wjq.netty.second;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;

public class MyServer {


    public static void main(String[] args) {
        EventLoopGroup boos = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();


        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boos,worker).channel(NioServerSocketChannel.class).option(ChannelOption.SO_KEEPALIVE,true).handler(new LoggingHandler(LogLevel.INFO)).childHandler(new MyServerInitializer());





            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boos.shutdownGracefully();
            worker.shutdownGracefully();
        }


    }






    public void  test() throws IOException {

        Selector selector = Selector.open();

        SelectorProvider provider = SelectorProvider.provider();
        ServerSocketChannel.open();

        ServerSocketChannel serverSocketChannel =  provider.openServerSocketChannel();

        SelectionKey key = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        key.cancel();


        serverSocketChannel.
                accept();

        selector.wakeup();








    }


}
