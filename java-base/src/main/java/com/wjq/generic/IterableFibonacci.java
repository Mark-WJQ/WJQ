package com.wjq.generic;

import java.util.Iterator;

/**
 * Created by wangjianqiang on 2017/11/29.
 */
public class IterableFibonacci implements Iterable<Integer>{

    Fibonacci f = new Fibonacci();
    private int n;

    public IterableFibonacci(int n) {
        this.n = n;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    public Iterator<Integer> iterator() {
        return iterator;
    }

    public Iterator<Integer> iterator = new Iterator<Integer>() {
        public boolean hasNext() {
            return n > 0;
        }

        public Integer next() {
            n--;
            return f.next();
        }
    };

    public static void main(String[] args) {
        for (Integer integer : new IterableFibonacci(18)){
            System.out.println(integer + " ");
        }
    }

}


class Fibonacci implements Generator<Integer>{


    private int count = 0;
    public Integer next() {
        return fib(count++);
    }

    private int fib(int i){
        if(i < 2) return 1;
        return fib(i-1) + fib(i-2);
    }
}
