package com.wjq.jvm;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author wangjianqiang24
 * @date 2020/4/19
 */
public class JVMHeapSize {




    public static void main(String[] args) throws InterruptedException {

        BlockingQueue queue = new LinkedBlockingDeque();
        queue.take();




    }


}
