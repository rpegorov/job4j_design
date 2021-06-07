package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count, modCount;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    private Object[] resize() {
        int newCap = (capacity + (count >>> 2));
        table = Arrays.copyOf(table, newCap);
        return table;
    }

    final int hash(K key) {
        int h = key.hashCode();
        return h ^ h >>> 16;
    }

    private int indexFor(int hash) {
        return (table.length - 1) & hash;
    }

    @Override
    public boolean put(K key, V value) {
        table[indexFor(hash(key))] = new MapEntry<>(key, value);
        count++;
        modCount++;
        if (count >= capacity * LOAD_FACTOR) {
            resize();
            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        return Arrays.stream(table)
                .filter(Objects::nonNull)
                .filter(e -> e.getKey().equals(key))
                .map(MapEntry::getValue)
                .findFirst().orElse(null);
    }

    @Override
    public boolean remove(K key) {
        if (table[indexFor(hash(key))] != null && table[indexFor(hash(key))]
                .getKey().equals(key)) {
            table[indexFor(hash(key))] = null;
            count--;
            modCount++;
            return true;
        }
        return false;
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
                return index < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (table[index] == null) {
                    index++;
                }
                return table[index++].getKey();
            }
        };
    }
}
