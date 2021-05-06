package ru.job4j.generics;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private static final int DEFAULT_CAP = 10;
    private Object[] data;
    private int actSize;

    public SimpleArray() {
        this.data = new Object[DEFAULT_CAP];
    }

    public void add(T model) {
        if (actSize == data.length) {
            resize();
        }
        data[actSize++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, data.length);
        data[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, actSize);
        System.arraycopy(data, index + 1, data, index, actSize - index - 1);
        actSize--;
    }

    public T get(int index) {
        Objects.checkIndex(index, actSize);
        return (T) data[index];
    }

    public Object[] resize() {
            int newCap = (DEFAULT_CAP + (actSize >> 1));
            return data =  Arrays.copyOf(data, newCap);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index <= actSize;
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
