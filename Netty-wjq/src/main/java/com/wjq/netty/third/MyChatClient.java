package com.wjq.netty.third;

import com.wjq.netty.second.MyClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyChatClient {


    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new MyChatClientInitializer());

            ChannelFuture channelFuture = bootstrap.connect("localhost",8899).sync();


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            Channel channel = channelFuture.channel();
            for (;;){
                channel.writeAndFlush(br.readLine() + "\r\n");
            }



        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

}
