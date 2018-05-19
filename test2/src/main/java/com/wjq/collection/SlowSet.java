package com.wjq.collection;



import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by wangjianqiang on 2018/1/4.
 */
public class SlowSet<T> extends AbstractSet<T> {

    private Map<T,Object> map = new SlowMap<>();

    /**
     * Returns an iterator over the elements contained in this collection.
     *
     * @return an iterator over the elements contained in this collection
     */
    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }
}
