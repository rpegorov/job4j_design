package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count, modCount;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    private Object[] resize() {
        if (modCount >= table.length * LOAD_FACTOR) {
            int newCap = (capacity + (count >> 1));
            table = Arrays.copyOf(table, newCap);
        }
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
        boolean rsl = true;
        for (int i = 0; i < count; i++) {
            if (table[i].getKey().equals(key)) {
                table[i].setValue(value);
                rsl = false;
            }
        }
        if (rsl) {
            resize();
            table[indexFor(hash(key))] = new MapEntry<>(key, value);
//            count++;
            modCount++;
        }
        return rsl;
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
        boolean rsl = true;
        for (int i = 0; i < count; i++) {
            if (table[i].getKey().equals(key)) {
                table[i] = null;
//                count--;
                modCount--;
                rsl = false;
            }
        }
        return rsl;
    }

    @Override
    public int getSize() {
        return modCount;
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
