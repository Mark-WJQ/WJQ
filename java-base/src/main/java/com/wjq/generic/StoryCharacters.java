package com.wjq.generic;

import java.util.Iterator;

/**
 * Created by wangjianqiang on 2017/11/29.
 */
public class StoryCharacters implements Generator<Guys>,Iterable<Guys> {

    public Guys next() {
        return null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    public Iterator<Guys> iterator() {
        return null;
    }
}

interface Guys{

}

class GoodGuys implements Guys{

}

class BadGuys implements Guys{

}

