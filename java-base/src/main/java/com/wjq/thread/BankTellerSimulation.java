package com.wjq.thread;

import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by wangjianqiang on 2018/5/20.
 *
 * 出纳员仿真
 *
 *
 */
public class BankTellerSimulation {

    static final int MAX_LINE_SIZE = 50;
    static final int ADJUSTMENT_PERIOD = 1000;

private static int i;

    public static void main(String[] args) throws IOException {


        ExecutorService exec = Executors.newCachedThreadPool();

        CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);

        //生产customer
        exec.execute(new CustomerGenerator(customers));

        //tellManager 管理出纳员
        exec.execute(new TellerManager(exec,customers,ADJUSTMENT_PERIOD));

        System.out.println("Press 'Enter to quit'");
        System.in.read();
        exec.shutdownNow();

    }
}

class Customer{
    private final int serviceTime;

    public Customer(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public String toString() {
        return "["+ serviceTime + "]";
    }
}



class CustomerLine extends ArrayBlockingQueue<Customer>{

    /**
     * Creates an {@code ArrayBlockingQueue} with the given (fixed)
     * capacity and default access policy.
     *
     * @param capacity the capacity of this queue
     * @throws IllegalArgumentException if {@code capacity < 1}
     */
    public CustomerLine(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {

        if (this.size() == 0)
            return "[Empty]";
        StringBuilder result = new StringBuilder();
        for (Customer customer : this){
            result.append(customer);
        }

        return result.toString();
    }
}

class CustomerGenerator implements  Runnable{


    private CustomerLine line;
    private static Random random = new Random(47);

    public CustomerGenerator(CustomerLine line) {
        this.line = line;
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
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(random.nextInt(300));
                line.put(new Customer(random.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            System.out.println("CustomerGenertator interrupted");
        }
        System.out.println("CustomerGenerator terminating");
    }
}

class Teller implements Runnable,Comparable<Teller>{


    private static int counter = 0;
    private final int id = counter++;


    private int customerServed = 0;
    private CustomerLine customers;
    private boolean servingCustomerLine = true;

    public Teller(CustomerLine customers) {
        this.customers = customers;
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
    public synchronized int compareTo(Teller o) {
        return customerServed < o.customerServed ? -1 : (customerServed == o.customerServed ? 0 : 1);
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
            while (!Thread.interrupted()) {
                Customer customer = customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
                synchronized (this){
                    customerServed++;
                    while (!servingCustomerLine)
                        wait();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(this + "interrupted");
        }
        System.out.println(this + "terminating");
    }

    public synchronized void doSomethingElse(){
        customerServed = 0;
        servingCustomerLine = false;
    }


    public synchronized void serveCustomerLine(){
        assert !servingCustomerLine : "already serving: " + this;
        servingCustomerLine = true;
        notifyAll();
    }

    @Override
    public String toString() {
        return "Teller " + id + " ";
    }

    public String shortString(){
        return "T" + id + " " + customerServed;
    }

}

class TellerManager implements Runnable{
    private ExecutorService exec;

    private CustomerLine line;

    private PriorityQueue<Teller> workeringTellers = new PriorityQueue<>();

    private Queue<Teller> tellersDoingOtherThing = new LinkedList<>();

    private int adjustmentPeriod;
    private static Random random = new Random(47);


    public TellerManager(ExecutorService exec, CustomerLine line, int adjustmentPeriod) {
        this.exec = exec;
        this.line = line;
        this.adjustmentPeriod = adjustmentPeriod;
        Teller teller = new Teller(line);
        exec.execute(teller);
        workeringTellers.add(teller);
    }

    public void adjustTellerNumber(){
        if (line.size()/workeringTellers.size() > 2){
            if (tellersDoingOtherThing.size() > 0){
                Teller teller = tellersDoingOtherThing.remove();
                teller.serveCustomerLine();
                workeringTellers.offer(teller);
                return;
            }
            Teller teller = new Teller(line);
            exec.execute(teller);
            workeringTellers.add(teller);
            return;
        }
        if(workeringTellers.size() > 1 && line.size() / workeringTellers.size() < 2){
            if (line.size() == 0)
                while (workeringTellers.size() > 1)
                    reassignOnTeller();
        }
    }


    private void reassignOnTeller(){
        Teller teller = workeringTellers.poll();
        teller.doSomethingElse();
        tellersDoingOtherThing.offer(teller);
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
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustTellerNumber();
                System.out.print(line + " { ");
                for (Teller teller : workeringTellers)
                    System.out.print(teller.shortString() + " ");
                System.out.println("}");
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + "terminating");

    }

    @Override
    public String toString() {
        return "TellerManager ";
    }
}
