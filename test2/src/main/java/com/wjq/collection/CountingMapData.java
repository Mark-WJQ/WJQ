package com.wjq.collection;

import java.util.*;

/**
 * Created by wangjianqiang on 2017/12/30.
 */
public class CountingMapData extends AbstractMap<Integer,String> {

    private int size;

    private static String chars[] = "A B C D E F G H I G K L M N O P Q R S T U V W X Y Z".split(" ");

    public CountingMapData(int size) {
        if (size < 0)
            this.size = 0;
        else
            this.size = size;
    }

    private static class Entry implements Map.Entry<Integer,String>{

        int index;

        public Entry(int index) {
            this.index = index;
        }

        /**
         * Returns the key corresponding to this entry.
         *
         * @return the key corresponding to this entry
         * @throws IllegalStateException implementations may, but are not
         *                               required to, throw this exception if the entry has been
         *                               removed from the backing map.
         */
        @Override
        public Integer getKey() {
            return index;
        }

        /**
         * Returns the value corresponding to this entry.  If the mapping
         * has been removed from the backing map (by the iterator's
         * <tt>remove</tt> operation), the results of this call are undefined.
         *
         * @return the value corresponding to this entry
         * @throws IllegalStateException implementations may, but are not
         *                               required to, throw this exception if the entry has been
         *                               removed from the backing map.
         */
        @Override
        public String getValue() {
            return chars[index % chars.length] + Integer.toString(index / chars.length);
        }

        /**
         * Replaces the value corresponding to this entry with the specified
         * value (optional operation).  (Writes through to the map.)  The
         * behavior of this call is undefined if the mapping has already been
         * removed from the map (by the iterator's <tt>remove</tt> operation).
         *
         * @param value new value to be stored in this entry
         * @return old value corresponding to the entry
         * @throws UnsupportedOperationException if the <tt>put</tt> operation
         *                                       is not supported by the backing map
         * @throws ClassCastException            if the class of the specified value
         *                                       prevents it from being stored in the backing map
         * @throws NullPointerException          if the backing map does not permit
         *                                       null values, and the specified value is null
         * @throws IllegalArgumentException      if some property of this value
         *                                       prevents it from being stored in the backing map
         * @throws IllegalStateException         implementations may, but are not
         *                                       required to, throw this exception if the entry has been
         *                                       removed from the backing map.
         */
        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean equals(Object o) {
           return Integer.valueOf(index).equals(o);
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }

    static class EntrySet extends AbstractSet<Map.Entry<Integer,String>>{


        int size;
        Entry entry = new Entry(-1);

        public EntrySet(int size) {
            if (size < 0)
                size = 0;
            else
                this.size = size;
        }

        /**
         * Returns an iterator over the elements contained in this collection.
         *
         * @return an iterator over the elements contained in this collection
         */
        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Iterator<Map.Entry<Integer, String>>() {
                @Override
                public boolean hasNext() {
                    return  entry.index < size;
                }

                @Override
                public Map.Entry<Integer, String> next() {
                    entry.index ++;
                    return entry;
                }
            };
        }

        @Override
        public int size() {
            return 0;
        }
    }


    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        return new EntrySet(size);
    }

    public static void main(String[] args) {
        System.out.println(new CountingMapData(100));
    }



}
