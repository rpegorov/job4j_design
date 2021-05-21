package ru.job4j.generics.list;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private static final int DEFAULT_CAP = 10;
    private Object[] data;
    private int actSize, modCount;

    public SimpleArray() {
        this.data = new Object[DEFAULT_CAP];
    }

    public int getSize() {
        return actSize;
    }

    public void add(T model) {
        if (actSize == data.length) {
            resize();
        }
        data[actSize++] = model;
        modCount++;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, actSize);
        data[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, actSize);
        System.arraycopy(data, index + 1, data, index, actSize - index - 1);
        data[actSize--] = null;
        modCount--;
        actSize--;
    }

    public T get(int index) {
        Objects.checkIndex(index, actSize);
        return (T) data[index];
    }

    public Object[] resize() {
            int newCap = (DEFAULT_CAP + (actSize >> 1));
            data = Arrays.copyOf(data, newCap);
            return data;
    }

    @Override
    public Iterator<T> iterator() {
        int expectedModCount = modCount;
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < actSize;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(index++);
            }
        };
    }
}
