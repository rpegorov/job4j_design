package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count, modCount;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    public Object[] resize() {
        int newCap = (capacity + (count >> 1));
        table = Arrays.copyOf(table, newCap);
        return table;
    }

    final int hash(K key) {
        return key.hashCode() % capacity;
    }

    @Override
    public boolean put(K key, V value) {
        if (count >= table.length * LOAD_FACTOR) {
            resize();
        }
        boolean rsl = false;
        for (MapEntry<K, V> kvMapEntry : table) {
            if (kvMapEntry.getKey().equals(key)) {
                kvMapEntry.setValue(value);
                rsl = true;
                count++;
                modCount++;
            }
        }
        if (!rsl) {
            resize();
            table[capacity++] = new MapEntry<>(key, value);
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
        boolean rsl = false;
        for (int i = 0; i < table.length; i++) {
            if (table[i].getKey().equals(key)) {
                table[i] = null;
                count--;
                modCount++;
                rsl = true;
            }
        }
        return rsl;
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
