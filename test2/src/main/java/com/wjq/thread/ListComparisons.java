package com.wjq.thread;

import com.wjq.array.CountingGenerator;
import com.wjq.array.Generated;
import org.apache.zookeeper.common.AtomicFileOutputStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.LongBinaryOperator;

/**
 * Created by wangjianqiang on 2018/5/22.
 */
public class ListComparisons {


    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong();

        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.writeLock().tryLock();
       // atomicLong.accumulateAndGet()
    }


}

abstract class Tester<C>{

    static int testReps = 10;
    static int testCycles = 1000;
    static int containerSize = 10000;


    abstract C containerInitializer();
    abstract void startReadersAndWriters();

    C testContainer;
    String testId;
    int nReaders;
    int nWriters;

    volatile long readResult = 0;
    volatile long readTime = 0;
    volatile long writeTime = 0;

    CountDownLatch endLatch;
    static ExecutorService exec = Executors.newCachedThreadPool();

    Integer[] writeData;

    public Tester(String testId, int nReaders, int nWriters) {
        this.testId = testId + " " + nReaders  + " r " + nWriters + "w";
        this.nReaders = nReaders;
        this.nWriters = nWriters;
        writeData = Generated.array(Integer.class,new CountingGenerator.Integer(),containerSize);
        for (int i = 0 ; i < testReps;i++){
            runTest();
            readTime = 0;
            writeTime = 0;
        }
    }
    void runTest(){
        endLatch = new CountDownLatch(nReaders + nWriters);
        testContainer = containerInitializer();
        startReadersAndWriters();
        try{
            endLatch.await();
        } catch (InterruptedException e) {
            System.out.println("endLatch interrupted");
        }
        System.out.printf("%-27s %14d %14d\n",testId,readTime,writeTime);
        if (readTime != 0 && writeTime != 0){
            System.out.printf("%-27s %14d\n","readTime + writeTime = ",readTime + writeTime);
        }

    }

    abstract class TestTask implements Runnable{
        abstract void test();
        abstract  void putResult();
    long duration;
        @Override
        public void run() {
            long startTime = System.nanoTime();
            test();
           duration = System.nanoTime() - startTime;
           synchronized (Tester.this){
               putResult();
           }
           endLatch.countDown();
        }
    }


    public static void initMain(String ... args){
        if (args.length > 0)
            testReps = new Integer(args[0]);
        if (args.length > 1)
            testCycles = new Integer(args[1]);
        if (args.length > 2)
            containerSize = new Integer(args[2]);
        System.out.printf("%-27s %14s %14s\n","Type","Read Time ","Write Time");
    }
}


abstract class ListTest extends Tester<List<Integer>>{

    public ListTest(String testId, int nReaders, int nWriters) {
        super(testId, nReaders, nWriters);
    }

    class Reader extends  TestTask{
        long result = 0;

        @Override
        void test() {
            for (long i = 0 ; i < testCycles; i++){
                for (int index = 0 ; index < containerSize ; index++){
                    result += testContainer.get(index);
                }
            }
        }

        @Override
        void putResult() {
readResult += result;
readTime += duration;
        }
    }


    class Writer extends TestTask{

        @Override
        void test() {
            for (long i = 0 ; i < testCycles; i++){
                for (int index = 0 ; index < containerSize ; index++){
                     testContainer.set(index,writeData[index]);
                }
            }
        }

        @Override
        void putResult() {
            writeTime += duration;
        }
    }

    @Override
    void startReadersAndWriters() {
        for (int i = 0; i < nReaders; i++) {
            exec.execute(new Reader());

        }

        for (int i = 0; i < nWriters; i++) {
            exec.execute(new Writer());

        }
    }

    class  SychronizedArrayListTest extends  ListTest{
        public SychronizedArrayListTest(String testId, int nReaders, int nWriters) {
            super(testId, nReaders, nWriters);
        }

        @Override
        List<Integer> containerInitializer() {
            return Collections.synchronizedList(new ArrayList<Integer>(containerSize));
        }
    }
}
