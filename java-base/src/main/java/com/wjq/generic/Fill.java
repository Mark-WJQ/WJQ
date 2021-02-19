package com.wjq.generic;

import java.util.*;

/**
 * Created by wangjianqiang on 2017/12/17.
 */
public class Fill {


    public static <T> void fill(Addable<T> addable,Class<? extends T> classToken,int size){
        try {
            for (int i = 0; i < size; i++) {
                addable.add(classToken.newInstance());
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public static <T> void fill(Addable<T> addable,Generator<T> generator,int size){
        for (int i = 0; i < size; i++){
            addable.add(generator.next());
        }
    }

    public static void main(String[] args) {
        List<Coffee> carrier = new ArrayList<>();
        Fill.fill(new AddableCollectionAdapter<Coffee>(carrier),Coffee.class,3);
        fill(Adapter.collectionAdapter(carrier),Coffee.class,2);
        AddableSimpleQueen<Coffee> sq = new AddableSimpleQueen<Coffee>();
        fill(sq,Coffee.class,3);
        fill(sq,Latte.class,3);
        for (Coffee c : sq){
            System.out.println(c);
        }

        fill(sq,new CoffeeGenerator(),3);
    }



}

interface Addable<T>{
    void add(T t);
}


class AddableCollectionAdapter<T> implements Addable<T>{

    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }

    @Override
    public void add(T t) {
        c.add(t);
    }
}



class Adapter{
    public static <T> Addable<T> collectionAdapter(Collection<T> collection ){
        return new AddableCollectionAdapter<>(collection);
    }
 }


class AddableSimpleQueen<T> extends SimpleQueen<T> implements Addable<T> {

    @Override
    public void add(T t) {
        super.add(t);
    }
}


class SimpleQueen<T> implements Iterable<T>{
    private LinkedList<T> storage = new LinkedList<>();

    public void add(T t){
        storage.offer(t);
    }

    public T get(){
        return storage.poll();
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }
}



