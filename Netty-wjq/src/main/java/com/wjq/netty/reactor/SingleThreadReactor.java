package com.wjq.netty.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wjq
 * @version 1.0.0
 * @ClassName SingleThreadReactor.java
 * @createTime 2019年11月09日 21:57:00
 */
public class SingleThreadReactor implements Runnable {


    private final Selector selector;

    private final ServerSocketChannel serverSocketChannel;
    Selector[] selectors = new Selector[10];


    ExecutorService selecterPool = Executors.newFixedThreadPool(10);

    public SingleThreadReactor(int port) throws IOException {

        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
        SelectionKey sk = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        for (int i = 0 ; i< 10 ; i++){
           Selector s = Selector.open();
            selectors[i] = s;
            selecterPool.execute(()->{
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                       int count = s.select();
                        System.out.println("==========" + count);
                        Set<SelectionKey> set = s.selectedKeys();
                        Iterator<SelectionKey> it = set.iterator();
                        while (it.hasNext()) {

                            SelectionKey key = it.next();
                            System.out.println(key.isReadable());
                            dispatch(key);
                            it.remove();
                        }
                        set.clear();
                    }

                } catch (Exception e) {

                }




            });
        }
        sk.attach(new AcceptorThreads());
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                selector.select();
                Set<SelectionKey> set = selector.selectedKeys();
                Iterator<SelectionKey> it = set.iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    dispatch(key);
                }
                set.clear();
            }

        } catch (Exception e) {

        }
    }


    void dispatch(SelectionKey k) {

        Runnable r = (Runnable) k.attachment();
        if (r != null) {
            r.run();
        }
    }







    int next = 0;


    class AcceptorThreads implements Runnable {

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public synchronized void run() {

            try {
                System.out.println("--------- acceptor");


                SocketChannel socketChannel = serverSocketChannel.accept();

                if (socketChannel != null) {
                    new HandlerMulThread(socketChannel, selectors[next]);
                    if (++next == selectors.length)
                        next = 0;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }




    class Acceptor implements Runnable {

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {

            try {
                System.out.println("--------- acceptor");

                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    new HandlerMulThread(socketChannel, selector);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }


    class Handler implements Runnable {


        final SocketChannel sc;
         SelectionKey sk = null;

        ByteBuffer input = ByteBuffer.allocate(1024);
        ByteBuffer output = ByteBuffer.allocate(1024);

        static final int READING = 0, SENDING = 1;
        int state = READING;


        public Handler(SocketChannel sc, Selector select) {
            this.sc = sc;
            try {
                //Channel 的 register(Selector sel, int ops) 方法和 Selector 的 select() 方法都会 publicKeys 锁，如果 Selector 先阻塞在 select() 方法上，且只有通过 register() 方法才能唤醒，则必须使用 select(int timeout) 或 selectNow() 方法，防止死锁；
                select.wakeup();
                sc.configureBlocking(false);
                sk = sc.register(select, SelectionKey.OP_READ,this);
                //select.wakeup();
                //sk.attach(this);
                // sk.interestOps(SelectionKey.OP_READ);

            }catch (Exception e){
                e.printStackTrace();
            }

        }


        protected boolean inputComplete() {
            return true;
        }

        boolean outputComplete() {
            return true;
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            if (state == READING) {
                read();
            }
        }

        protected void send() {

            try {
                System.out.println("-----start write");

                sc.write(ByteBuffer.wrap("hdhdhdh".getBytes()));
                if (outputComplete()) {
                    sk.interestOps(sk.interestOps() & ~SelectionKey.OP_WRITE);// 【注意】写完后，一定要记得将OP_WRITE事件注销，否则会导致 select.select() 不能正常阻塞，系统空转；

                    sk.cancel();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        protected void read() {
            try {

                System.out.println("--------start read");

                sc.read(input);

                if (inputComplete()) {
                    System.out.println("----change status");
                    process();
                    sk.attach(new Sender());
                    // state = SENDING;
                    sk.interestOps(SelectionKey.OP_WRITE);
                    sk.selector().wakeup();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        protected void process() {

        }


        class Sender implements Runnable {


            /**
             * When an object implementing interface <code>Runnable</code> is used
             * to create a thread, starting the thread causes the object's
             * <code>run</code> method to be called in that separately executing
             * thread.
             * <p>
             * The general contract of the method <code>run</code> is that it may
             * take any action whatsoever.
             *
             * @see Thread#run()
             */
            @Override
            public void run() {

                send();
                try {
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }


    class HandlerMulThread extends Handler {


        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);


        static final int READING = 0, SENDING = 1, PROCESSING = 3;


        public HandlerMulThread(SocketChannel sc, Selector selector) throws IOException {
            super(sc, selector);
        }


        @Override
        protected synchronized void read() {
            try {
                System.out.println(Thread.currentThread().getId() + "-----start read---------");
                int flag = sc.read(input);
                //Java NIO 未定义客户端关闭事件，客户端关闭时，服务端会收到 SelectionKey.OP_READ 事件，服务器调用 channel.read() 函数会返回 -1，这时需把对应的 SelectionKey 给 cancel 掉，表示 selector 不再监听这个SelectionKey上的读事件，并且关闭 channel；
                if (flag == -1){
                    System.out.println("===========客户端关闭" );
                    sk.cancel();
                    sc.close();
                }
                input.flip();
                System.out.println(Charset.defaultCharset().newDecoder().decode(input).toString());
                if (inputComplete()) {
                    state = PROCESSING;
                    service.execute(new Processor());
                    int ops = sk.interestOps();
                    sk.interestOps(ops ^ SelectionKey.OP_READ);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        @Override
        protected synchronized void send() {
            super.send();
        }

        class Processor implements Runnable {

            /**
             * When an object implementing interface <code>Runnable</code> is used
             * to create a thread, starting the thread causes the object's
             * <code>run</code> method to be called in that separately executing
             * thread.
             * <p>
             * The general contract of the method <code>run</code> is that it may
             * take any action whatsoever.
             *
             * @see Thread#run()
             */
            @Override
            public void run() {
                System.out.println("----start processoring -----");
                processAndHandOff();
            }
        }

        synchronized void processAndHandOff() {
            process();
            System.out.println(Thread.currentThread().getId() + "---processor end ------");
            // state = SENDING; // or rebind attachment sk.interest(SelectionKey.OP_WRITE); }
            // sk.interestOps(SelectionKey.OP_WRITE);

            sk.attach(new Sender());
            // state = SENDING;
            sk.interestOps(SelectionKey.OP_WRITE);
            sk.selector().wakeup();
        }
    }


    public static void main(String[] args) throws IOException {

        SingleThreadReactor reactor = new SingleThreadReactor(9999);

        reactor.run();

    }

}
