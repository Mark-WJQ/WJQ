package com.wjq.thread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangjianqiang on 2018/5/12.
 */
public class NioInterruption {


    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            InetSocketAddress isa = new InetSocketAddress("localhost",8080);
            SocketChannel sc1 = SocketChannel.open(isa);
            SocketChannel sc2 = SocketChannel.open(isa);

            Future f = service.submit(new NIOBlocked(sc2));
            service.execute(new NIOBlocked(sc1));

            service.shutdown();

            TimeUnit.SECONDS.sleep(1);

            f.cancel(true);

            TimeUnit.SECONDS.sleep(1);

            sc1.close();


            new Timer().scheduleAtFixedRate(new TestTimerTask(),10,10);

            Lock lock = new ReentrantLock();
            lock.lockInterruptibly();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}



class NIOBlocked implements Runnable{

    private SocketChannel sc;

    public NIOBlocked(SocketChannel sc) {
        this.sc = sc;
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

        try {
            System.out.println("waiting for read in " + this) ;
            sc.read(ByteBuffer.allocate(1));
        }catch (ClosedByInterruptException e){
            System.out.println("ClosedByInterruptException");
        }catch (AsynchronousCloseException e){
            System.out.println("AsynchronousCloseException");
        }
    catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Exiting NIOBlocked.run() " + this);

    }
}


class TestTimerTask extends TimerTask{

    /**
     * The action to be performed by this timer task.
     */
    @Override
    public void run() {

    }
}
