package com.wjq.collection;

import java.util.*;

/**
 * Created by wangjianqiang on 2017/12/30.
 */
public class Countries {

    public static final String DATA[][] = {{"ALGERIA", " algeria"}, {"ANGOLA", "Luanda"}, {"CHINA", "Beijin"}, {"JAPAN", "Tokyo"}, {"AMERICA", "Washington"},
            {"ENGLAND", "Longdon"}};


    private static class FlyWeightMap extends AbstractMap<String, String> {


        private static class Entry implements Map.Entry<String, String> {

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
            public String getKey() {
                return DATA[index][0];
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
                return DATA[index][1];
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
                return DATA[index][0].equals(o);
            }

            @Override
            public int hashCode() {
                return DATA[index][0].hashCode();
            }
        }

        static class EntrySet extends AbstractSet<Map.Entry<String, String>> {

            private int size;

            public EntrySet(int size) {
                if (size < 0)
                    this.size = 0;
                else if (size > DATA.length)
                    this.size = DATA.length;
                else
                    this.size = size;
            }

            private class Iter implements Iterator<Map.Entry<String, String>> {

                private Entry entry = new Entry(-1);

                /**
                 * Returns {@code true} if the iteration has more elements.
                 * (In other words, returns {@code true} if {@link #next} would
                 * return an element rather than throwing an exception.)
                 *
                 * @return {@code true} if the iteration has more elements
                 */
                @Override
                public boolean hasNext() {
                    return entry.index < size - 1;
                }

                /**
                 * Returns the next element in the iteration.
                 *
                 * @return the next element in the iteration
                 * @throws NoSuchElementException if the iteration has no more elements
                 */
                @Override
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }

            /**
             * Returns an iterator over the elements contained in this collection.
             *
             * @return an iterator over the elements contained in this collection
             */
            @Override
            public Iterator<Map.Entry<String, String>> iterator() {
                return new Iter();
            }

            @Override
            public int size() {
                return size;
            }
        }
        private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);

        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            return entries;
        }

    }

    static Map<String, String> select(final int size) {
        return new FlyWeightMap() {
            public Set<Map.Entry<String, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }

    static Map<String, String> map = new FlyWeightMap();

    public static Map<String, String> capitals() {
        return map;
    }

    public static Map<String, String> capitals(int size) {
        return select(size);
    }

    static List<String> names = new ArrayList<>(map.keySet());


    public static List<String> names() {
        return names;
    }

    public static List<String> names(int size) {
        return new ArrayList<>(select(size).keySet());
    }

    public static void main(String[] args) {
        System.out.println(capitals(3));
    }
}
