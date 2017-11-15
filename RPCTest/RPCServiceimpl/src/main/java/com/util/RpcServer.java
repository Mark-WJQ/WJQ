package com.util;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjianqiang on 2017/11/5.
 */
public class RpcServer implements ApplicationContextAware,InitializingBean {


    private static final Logger logger = LoggerFactory.getLogger(RpcServer.class);

    private String serverAddress;
    private ServiceRegistry serviceRegistry;

    //private Map<String,Object> handleMap = new HashMap<>();


    public RpcServer(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public RpcServer(ServiceRegistry serviceRegistry) {
        this.serviceRegistry = serviceRegistry;
    }


    public RpcServer(String serverAddress, ServiceRegistry serviceRegistry) {
        this.serverAddress = serverAddress;
        this.serviceRegistry = serviceRegistry;
    }

    public void afterPropertiesSet() throws Exception {

        EventLoopGroup bossGroup  = new NioEventLoopGroup();

        EventLoopGroup workgroup  = new NioEventLoopGroup();

        ServerBootstrap bootStrap = new ServerBootstrap();
        bootStrap.group(bossGroup,workgroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                //socketChannel.pipeline().addLast()
            }
        });



    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String,Object> serviceBeanMap = applicationContext.getBeansWithAnnotation(RpcService.class);
        if (MapUtils.isNotEmpty(serviceBeanMap)){
            for (Object serviceBean : serviceBeanMap.values()){
               String interfaceName = serviceBean.getClass().getAnnotation(RpcService.class).value().getName();
              // handleMap.put(interfaceName,serviceBean);
            }
        }

    }
}
