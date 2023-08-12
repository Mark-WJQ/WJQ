package com.wjq.netty.bytebuf;

import com.google.common.base.Utf8;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
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

        ByteBuf header = Unpooled.wrappedBuffer("this is header".getBytes());
        ByteBuf body = Unpooled.wrappedBuffer("this is body".getBytes());
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();

        compositeByteBuf.addComponent(true ,header);
        compositeByteBuf.addComponent(true,body);
        System.out.println("capacity ------" + compositeByteBuf.capacity());
        System.out.println("readIndex==="+compositeByteBuf.readerIndex());
        System.out.println("writeIndex===" + compositeByteBuf.writerIndex());
        System.out.println(header.readBytes(4).toString(UTF_8));

        System.out.println(header.refCnt());
        //不共用readIndex
        System.out.println(compositeByteBuf.readerIndex());
        header.setBytes(0, "that".getBytes());
        System.out.println( "offset ------" + compositeByteBuf.componentAtOffset(17).toString(UTF_8));

        System.out.println(new String(compositeByteBuf.readBytes(14).toString(UTF_8)));
        System.out.println(new String(compositeByteBuf.readBytes(12).toString(UTF_8)));
        System.out.println(compositeByteBuf.readerIndex());

        //System.out.println(new String(compositeByteBuf.readBytes(header.readableBytes()).array()));
        System.out.println(compositeByteBuf.readableBytes());



    }



}
