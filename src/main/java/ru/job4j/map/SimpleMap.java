package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count, modCount;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    private Object[] resize() {
        int newCap = (capacity + (count << 1));
        MapEntry<K, V>[] newTable = new MapEntry[newCap];
        for (MapEntry<K, V> e : table) {
            if (e != null) {
                int index = indexFor(hash(e.getKey()));
                newTable[index] = e;
            }
        }
        return newTable;
    }

    final int hash(K key) {
        int h = key.hashCode();
        return h - 1 ^ h >>> 16;
    }

    private int indexFor(int hash) {
        int i = Math.floorMod(hash, table.length);
        return i;
    }

    @Override
    public boolean put(K key, V value) {
        boolean isPut = false;
        if (count >= capacity * LOAD_FACTOR) {
            table = (MapEntry<K, V>[]) resize();
        }
        int index = indexFor(hash(key));
        MapEntry<K, V> val = table[index];
        if (val != null && val.getKey().equals(key)) {
            val.setValue(value);
            return false;
        } else if (val == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            isPut = true;
        }
        modCount++;
        return isPut;
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(key));
        MapEntry<K, V> isGet = table[index];
        if (isGet != null) {
            return isGet.getKey().equals(key) ? isGet.getValue() : null;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int index = indexFor(hash(key));
        MapEntry<K, V> isRemove = table[index];
        if (isRemove != null && isRemove.getKey().equals(key)) {
            isRemove = null;
            count--;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    @Override
    public int getSize() {
        return count;
    }

    @Override
    public Iterator<K> iterator() {
        int expectedModCount = modCount;
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = index; i < table.length; i++) {
                    if (table[i] != null) {
                        index = i;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].getKey();
            }
        };
    }
}
