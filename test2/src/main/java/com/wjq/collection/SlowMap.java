package com.wjq.collection;

import java.util.*;

/**
 * Created by wangjianqiang on 2018/1/4.
 */
public class SlowMap<K,V> extends AbstractMap<K,V> implements Map<K,V>{

    private List<K>  keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    @Override
    public V put(K key, V value) {
        V oldV = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        }else {
            values.set(keys.indexOf(key),value);
        }

        return oldV;
    }

    @Override
    public V get(Object key) {

        if (!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Entry<K, V>> entrySet() {

        Set<Map.Entry<K,V>> m = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext())
            m.add(new MapEntry<K, V>(ki.next(),vi.next()));

        return m;
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public Set<K> keySet() {
        return new HashSet<>(keys);
    }

    class MapEntry<K,V> implements Map.Entry<K,V>{

        private K key;
        private V value;

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
            return key;
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
            return value;
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
            V result = this.value;
            this.value = value;
            return result;
        }

        @Override
        public int hashCode() {
            return (key == null ? 0 : key.hashCode())^(value == null ? 0 : value.hashCode());
        }

        @Override
        public boolean equals(Object obj) {

            if (!(obj instanceof MapEntry)) return false;
            MapEntry me = (MapEntry) obj;
            return (key == null? me.getKey() == null : key.equals(me.getKey()))&& (value == null ? me.getValue() == null : value.equals(me.getValue()));
        }
    }
}
