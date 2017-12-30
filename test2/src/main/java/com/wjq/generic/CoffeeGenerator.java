package com.wjq.generic;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by wangjianqiang on 2017/11/28.
 */
public class CoffeeGenerator implements Generator<Coffee> ,Iterable<Coffee>{

    private Class[] types = new Class[]{Latte.class,Mocha.class,Cappuccino.class};

    private static Random rand = new Random(47);

    public CoffeeGenerator() {
    }

    private int size = 0;

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    class GeneratorIterator implements Iterator<Coffee>{


        int count = size;
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */


        public boolean hasNext() {
            return count > 0;
        }



        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        public Coffee next() {
            count --;
            return CoffeeGenerator.this.next();
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    public Iterator<Coffee> iterator() {
        return new GeneratorIterator();
    }


    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5 ; i ++){
            System.out.println(gen.next());
        }
        CoffeeGenerator cg = new CoffeeGenerator(5);
        //实现了Iterable 接口，所以在for遍历的时候自动调用next方法
        for (Coffee c : new CoffeeGenerator(5)){
            System.out.println(c);
        }
    }
}



interface Generator<T>{
    T next();
}

 class Coffee{
    private static long counter = 0;
    private final long id = counter++;

     @Override
     public String toString() {
         return getClass().getSimpleName() + " " + id;
     }
 }


 class Latte extends Coffee{}
 class Mocha extends Coffee{}
 class Cappuccino extends Coffee{}