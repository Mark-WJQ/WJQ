package com.wjq.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

import static com.google.common.base.Charsets.UTF_8;

/**
 * @author wjq
 * @version 1.0.0
 * @ClassName ByteBuftest1.java
 * @createTime 2019年11月30日 17:45:00
 */
public class ByteBuftest1 {


    public static void main(String[] args) {

        ByteBuf byteBuf = Unpooled.copiedBuffer("hello world",UTF_8);


        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();


    }



}
