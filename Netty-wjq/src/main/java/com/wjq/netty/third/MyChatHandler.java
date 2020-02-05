package com.wjq.netty.third;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class MyChatHandler extends SimpleChannelInboundHandler<String> {


    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    /**
     * <strong>Please keep in mind that this method will be renamed to
     * {@code messageReceived(ChannelHandlerContext, I)} in 5.0.</strong>
     * <p>
     * Is called for each message of type {@link I}.
     *
     * @param ctx the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler}
     *            belongs to
     * @param msg the message to handle
     * @throws Exception is thrown if an error occurred
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {


        Channel channel = ctx.channel();
        channels.forEach(c ->{
            if (channel != c){
                c.writeAndFlush(channel.remoteAddress() + " 发送的消息： " + msg + "\n");

            }else {
                c.writeAndFlush("【自己】" + msg + "\n");
            }
        });






    }

    /**
     * 连接建立
     * @param ctx
     * @throws Exception
     */

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //广播加入
        channels.writeAndFlush("【服务器】-" + channel.remoteAddress() + "加入\n");
        //将channel对象保存，后续通知使用
        channels.add(channel);
    }


    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
       Channel channel = ctx.channel();
       //移除channel可以不调用，netty自动会将该channel移除
       channels.remove(channel);
       channels.writeAndFlush("【服务器】-" + channel.remoteAddress() + " 离开\n");
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "上线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "下线");

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
