package com.wjq.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wangjianqiang on 2019/5/5.
 */
public class Selector {

   private static Logger logger = LoggerFactory.getLogger(Selector.class);


    public void testSelector() throws IOException {

        java.nio.channels.Selector selector = java.nio.channels.Selector.open();

        SocketChannel channel = SocketChannel.open();
        SocketAddress address = new InetSocketAddress(10999);
        channel.bind(address);
        channel.configureBlocking(false);

        //注册channel
        SelectionKey key = channel.register(selector, SelectionKey.OP_READ);


        int interestSet = key.interestOps();
        //可以添加一些处理对象
        key.attach(new Object());

        boolean isInterestedInAccept  = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;

        boolean isInterestedInConnect = (interestSet & SelectionKey.OP_CONNECT) == SelectionKey.OP_CONNECT;

        boolean isInterestedInRead    = (interestSet & SelectionKey.OP_READ) == SelectionKey.OP_READ;

        boolean isInterestedInWrite   = (interestSet & SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE;


        while (true) {

            Set set = selector.selectedKeys();
            Iterator<SelectionKey> it = set.iterator();
            while (it.hasNext()) {
                SelectionKey selectionKey = it.next();
                if (selectionKey.isAcceptable()) {
                    //调用回调处理器
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    logger.info("reday Accept");
                } else if (selectionKey.isConnectable()) {
                    logger.info("reday Connect");
                } else if (selectionKey.isReadable()) {
                    logger.info("reday Read");
                } else if (selectionKey.isWritable()) {
                    logger.info("reday Write");
                }
                it.remove();
            }


        }



    }
}
