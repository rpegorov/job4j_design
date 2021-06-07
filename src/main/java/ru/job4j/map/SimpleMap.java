package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 16;
    private int count, modCount;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    private Object[] resize() {
        if (count >= capacity * LOAD_FACTOR) {
            int newCap = (capacity + (count * 2));
            table = Arrays.copyOf(table, newCap);
        }
        return table;
    }

    final int hash(K key) {
        int h = key.hashCode();
        return h - 1 ^ h >>> 16;
    }

    private int indexFor(int hash) {
        int i = hash % (table.length - 1);
        System.out.println(hash + " - " + i);
        return i;
    }

    @Override
    public boolean put(K key, V value) {
        boolean isPut = false;
        int index = indexFor(hash(key));
        MapEntry<K, V> val = table[index];
        if (val != null
                && val.getKey().equals(key)
                && !val.getValue().equals(value)) {
            val.setValue(value);
        } else if (val == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            resize();
            isPut = true;
        }
        modCount++;
        return isPut;
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
