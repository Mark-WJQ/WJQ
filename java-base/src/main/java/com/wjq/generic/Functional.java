package com.wjq.generic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wangjianqiang on 2017/12/17.
 */
public class Functional {

    //Calls the combiner object on each element to combine it with a running result ,which is finally returned

    public static <T> T reduce(Iterable<T> seq, ComBiner<T> comBiner){
        Iterator<T> it = seq.iterator();
        if (it.hasNext()){
            T result = it.next();
            while (it.hasNext()){
                result = comBiner.combin(result,it.next());
            }
            return result;
        }
        //if seq is a empty list return null or throw exception
        return null;
    }


    //Take a function object and call it in the list ,ingoring the return value.the function object may act as a collectiong parameter,so it is returned at the end
    public static <T> Collector<T> forEach(Iterable<T> seq,Collector<T> func){
        for (T t : seq){
            func.function(t);
        }
        return func;
    }

    //Creates a list of results by calling a function object for each object in the list
    public static <R,T>List<R> transform(Iterable<T> seq,UnaryFunction<R,T> func){
        List<R> result  = new ArrayList<>();
        for (T t : seq){
            result.add(func.function(t));
        }
        return result;
    }
    //Applies a unary predicate to each item in a sequence and return a list of items that produce true
    public static <T> List<T> filter(Iterable<T> seq,UnaryPredicate<T> pred){
        List<T> results = new ArrayList<>();
        for (T t : seq){
            if (pred.test(t)){
                results.add(t);
            }
        }
        return results;
    }

    //To use above generic methods,we need to create function objects to adapt to our paticular needs
    static class IntegerAdder implements ComBiner<Integer>{

        @Override
        public Integer combin(Integer x, Integer y) {
            return x + y;
        }
    }


    static class IntegerSub implements ComBiner<Integer>{

        @Override
        public Integer combin(Integer x, Integer y) {
            return x - y;
        }
    }


    static class BigDecimalAdder implements ComBiner<BigDecimal>{

        @Override
        public BigDecimal combin(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }


    static class BigIntegerAdder implements ComBiner<BigInteger> {

        @Override
        public BigInteger combin(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }


    static class AtomicLongAdder implements ComBiner<AtomicLong>{

        @Override
        public AtomicLong combin(AtomicLong x, AtomicLong y) {
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }


    static class BigdecimalUlp implements UnaryFunction<BigDecimal,BigDecimal>{

        @Override
        public BigDecimal function(BigDecimal x) {
            return x.ulp();
        }
    }


    static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T>{

        private T bound;

        public GreaterThan(T bound) {
            this.bound = bound;
        }

        @Override
        public boolean test(T t) {
            return t.compareTo(bound) > 0;
        }
    }


    static class MultiplayingIntegerCollector implements Collector<Integer>{


        private Integer val = 1;
        @Override
        public Integer function(Integer x) {
            val = x * val;
            return val;
        }

        @Override
        public Integer result() {
            return val;
        }
    }


    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1,2,3,4,5,6,7);
        Integer result = reduce(li,new IntegerAdder());

        System.out.println(result);


        result = reduce(li,new IntegerSub());

        System.out.println(result);

        System.out.println(filter(li,new GreaterThan<Integer>(4)));


        System.out.println(forEach(li,new MultiplayingIntegerCollector()).result());

        System.out.println(forEach(filter(li,new GreaterThan<Integer>(4)),new MultiplayingIntegerCollector()).result());

        MathContext mc = new MathContext(7);

        List<BigDecimal> ldb = Arrays.asList(new BigDecimal(1.1,mc),new BigDecimal(2.2,mc),new BigDecimal(3.3,mc),new BigDecimal(4.4,mc));

        BigDecimal rbd = reduce(ldb,new BigDecimalAdder());
        System.out.println(rbd);

        System.out.println(filter(ldb,new GreaterThan<BigDecimal>(new BigDecimal(3))));

        List<BigInteger> lbi = new ArrayList<>();
        BigInteger bi = BigInteger.valueOf(11);
        for (int i = 0 ;i < 11 ; i ++){
            lbi.add(bi);
            bi = bi.nextProbablePrime();
        }
        System.out.println(lbi);

        BigInteger rbi = reduce(lbi,new BigIntegerAdder());
        System.out.println(rbi);

        System.out.println(rbi.isProbablePrime(5));

        List<AtomicLong> lal = Arrays.asList(new AtomicLong(11),new AtomicLong(47),new AtomicLong(74),new AtomicLong(133));

        AtomicLong ral = reduce(lal,new AtomicLongAdder());

        System.out.println(ral);
        System.out.println(transform(ldb,new BigdecimalUlp()));

    }

}



interface ComBiner<T>{
    T combin(T x,T y);
}

interface UnaryFunction<R,T> {
    R function(T x);
}


interface Collector<T> extends UnaryFunction<T,T>{
    T result(); //extract result of collecting parameter
}

interface UnaryPredicate<T>{
    boolean test(T t);
}




