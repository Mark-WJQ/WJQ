package com.test.wjq.collection;

import java.util.*;

/**
 * Created by wangjianqiang on 2017/11/9.
 */
public class NonCollectionSequence<T> {


    List<T> list = new ArrayList<T>();



    public <K> Iterable<T> reversed(){
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = list.size() -1;
                    public boolean hasNext() {
                        return current > -1;
                    }

                    public T next() {
                        return list.get(current--);
                    }
                };
            }
        };
    }

    public <K>Iterable<T> randomized(){
        return new Iterable() {
            public Iterator iterator() {
                Collections.shuffle(list,new Random(47));
                return list.listIterator();
            }
        };
    }

    public static void main(String[] args) {

        List<Integer> l1 = new ArrayList<Integer>();



        NonCollectionSequence no = new NonCollectionSequence();

        for (int i = 0;i< 10 ;i ++){
            no.list.add(i);
        }

       Iterator<Integer> integerIterator = no.<Integer>reversed().iterator();
        for (Object i : no.<Integer>reversed()){
            System.out.println(i);
        }

    }
}
