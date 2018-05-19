package com.wjq.collection;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by wangjianqiang on 2018/1/14.
 */
public class SimpleHashSet<T> extends AbstractSet<T> {

    public static final int SIZE = 997;

    LinkedList<T>[] buckets = new LinkedList[SIZE];

    @Override
    public boolean add(T t) {
        int index = t.hashCode()%SIZE;

        boolean found = false;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<>();
        LinkedList<T> bucket = buckets[index];
        for (T t1 : bucket){
            if (t1.equals(t)){
                found = true;
                break;
            }
        }
        if (!found)
            bucket.add(t);

        return !found;
    }

    /**
     * Returns an iterator over the elements contained in this collection.
     *
     * @return an iterator over the elements contained in this collection
     *
     */


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
