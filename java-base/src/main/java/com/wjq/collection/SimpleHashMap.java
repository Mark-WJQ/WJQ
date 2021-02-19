package com.wjq.collection;

import java.util.*;

/**
 * Created by wangjianqiang on 2018/1/8.
 */
public class SimpleHashMap<K,V> extends AbstractMap<K,V> {



    static final int SIZE = 997;
    //LinkedList<MapEntry<K,V>[]> buckets = new LinkedList[SIZE];
    MapEntry<K,V>[] buckets = new MapEntry[SIZE];


    @Override
    public V put(K key, V value) {

        V oldValue = null;

        int index = Math.abs(key.hashCode()) % SIZE;

        //存放list
       /* if (buckets[index] == null)
            buckets[index] = new LinkedList<>();
        LinkedList<MapEntry<K,V>> bucket = buckets[index];

        MapEntry<K,V> pair = new MapEntry(key,value);

        boolean found = false;

        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        while (it.hasNext()){
            MapEntry<K,V> iPair = it.next();
            if (iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if (!found)
            bucket.add(pair);
            */

        //存放前向链接的对象
        boolean found = false;
        if (buckets[index] == null) {
            buckets[index] = new MapEntry<>(key,value);
            return oldValue;
        }
        MapEntry<K,V> entry = buckets[index];
        while (entry != null || entry.next != null){
            if (entry.getKey().equals(key)) {
                oldValue= entry.getValue();
                entry.setValue(value);
                found = true;
                break;
            }
            entry = entry.next;
        }
        if (!found)
            entry.setNext(new MapEntry(key,value));

        return oldValue;
    }


    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            return null;
        /*for (MapEntry<K,V> iPair : buckets[index]){
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        }*/
        MapEntry<K,V> entry = buckets[index];
        while (entry != null || entry.next != null){
            if (entry.getKey().equals(key))
                return entry.getValue();
        }

        return null;
    }

    @Override
    public void clear() {

        super.clear();
    }


    @Override
    public boolean remove(Object key, Object value) {

        return false;
    }


    @Override
    public V remove(Object key) {
        V value = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            return null;
        /*LinkedList<MapEntry<K,V>> bucket = buckets[index];
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                value = iPair.getValue();
                it.remove();
            }
        }*/
        return value;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {

        Set<Entry<K,V>> set = new HashSet<>();
        /*for (LinkedList<MapEntry<K, V>> bucket : buckets){
            if (bucket == null)
                continue;
            for (MapEntry<K,V> mPair : bucket){
                set.add(mPair);
            }
        }*/


        for (MapEntry<K,V> entry : buckets){
            if (entry == null)
                continue;
            while (entry != null || entry.next != null){
                set.add(entry);
                entry = entry.next;
            }
        }
        return set;
    }




    class MapEntry<K,V> implements Map.Entry<K,V>{

       private K key;
        private V value;
        private MapEntry next;


        public MapEntry getNext() {
            return next;
        }

        public void setNext(MapEntry next) {
            this.next = next;
        }

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
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
        public K getKey() {
            return this.key;
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
        public V getValue() {
            return this.value;
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
        public V setValue(V value) {
            return this.value = value;
        }

        @Override
        public int hashCode() {
            return key.hashCode() ^ ((value == null) ? 0 : value.hashCode());
        }


        @Override
        public boolean equals(Object obj) {
            MapEntry<K,V> entry = (MapEntry) obj;
            Object k1 = getKey();
            Object k2 = entry.getKey();
            if (k1.equals(k2)){
                Object v1 = getValue();
                Object v2 = entry.getValue();
                return v1 == null ? v2 == null : v1.equals(v2);
            }
            return false;
        }
    }
}
