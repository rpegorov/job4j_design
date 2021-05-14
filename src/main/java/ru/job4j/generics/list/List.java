package ru.job4j.generics.list;

public interface List<E> extends Iterable<E> {

    int getSize();

    void add(E value);

    E get(int index);

}
