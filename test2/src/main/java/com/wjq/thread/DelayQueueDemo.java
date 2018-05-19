package com.wjq.thread;

import com.alibaba.dubbo.remoting.Endpoint;
import org.tuckey.web.filters.urlrewrite.Run;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by wangjianqiang on 2018/5/14.
 */
public class DelayQueueDemo {

    public static void main(String[] args) {

       // System.out.println(Objects.compare(Double.valueOf("499"), 500D, Comparator.comparing(Double::doubleValue)) < 0);

       // PriorityQueue

        System.out.println(TimeUnit.MINUTES.toSeconds(10));

        ExecutorService exec = Executors.newCachedThreadPool();
        Random random = new Random(47);

        DelayQueue<DelayedTask> queue = new DelayQueue<>();
        for (int i = 0;i < 20 ; i++)
            queue.put(new DelayedTask(random.nextInt(50000)));
        queue.add(new DelayedTask.EndSentinel(50000,exec));
        exec.execute(new DealyedTaskConsumer(queue));

    }

}



class DelayedTask implements Runnable,Delayed{



    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;


    protected static List<DelayedTask> sequence = new ArrayList<>();

    public DelayedTask(int delta) {
        this.delta = delta;
        trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delta,TimeUnit.MILLISECONDS);
        sequence.add(this);
    }

    /**``   1`  1q
     * Returns the remaining delay associated with this object, in the
     * given time unit.
     *
     * @param unit the time unit
     * @return the remaining delay; zero or negative values indicate
     * that the delay has already elapsed
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * <p>
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     * <p>
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     * <p>
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     * <p>
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     * <p>
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Delayed o) {

        DelayedTask that = (DelayedTask) o;
        return trigger - that.trigger > 0 ? 1 : trigger == that.trigger ? 0 : -1;
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
        System.out.println(this + " ");
    }


    @Override
    public String toString() {
        return String.format("[%1$-4d]",delta) + "Task " + id;
    }


    public String summary(){
        return "(" + id + ":" + delta + ")";
    }



    public static class EndSentinel extends DelayedTask{

        private ExecutorService exec;

        public EndSentinel(int delta,ExecutorService e) {
            super(delta);
            exec = e;
        }


        @Override
        public void run() {
            for (DelayedTask pt : sequence){
                System.out.println(pt.summary() + " ");
            }
            System.out.println();
            System.out.println(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}

class DealyedTaskConsumer implements Runnable{


    private DelayQueue<DelayedTask> q;

    public DealyedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
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

        try{
            while (!Thread.interrupted())
                q.take().run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished DelayedTaskConsumer");
    }
}
