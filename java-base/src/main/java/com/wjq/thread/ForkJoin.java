package com.wjq.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by wangjianqiang on 2019/5/13.
 */
public class ForkJoin {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testForkJoin();
    }


    public static void testForkJoin() throws ExecutionException, InterruptedException {

        ForkJoinPool pool = new ForkJoinPool(2);

        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        ForkJoinTask<Integer> task = new TestForkJoinTask(0,array.length-1,array);

        System.out.println(pool.invoke(task));
    }




    static class TestForkJoinTask extends RecursiveTask<Integer> {

        int start;
        int end;
        int[] array;
        int THREAD_HOLD = 2;


        public TestForkJoinTask(int start, int end,int[] array) {
            this.start = start;
            this.end = end;
            this.array = array;
        }

        /**
         * The main computation performed by this task.
         *
         * @return the result of the computation
         */
        @Override
        protected Integer compute() {
            if (end - start < THREAD_HOLD){
                System.out.println(Thread.currentThread().getName());
                if(start == end)
                    return array[start];
                return array[start] + array[end];
            }
            int middle = (start + end)/2;
            ForkJoinTask<Integer> left = new TestForkJoinTask(start,middle,array);
            ForkJoinTask<Integer> right = new TestForkJoinTask(middle + 1,end,array);
            invokeAll(left,right);
           int sum = left.join() + right.join();
            return sum;
        }
    }



}
