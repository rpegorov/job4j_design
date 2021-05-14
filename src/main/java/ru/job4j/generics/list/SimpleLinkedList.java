package ru.job4j.generics.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int modCount, actSize;

    @Override
    public int getSize() {
        return actSize;
    }

    @Override
    public void add(E value) {
        Node<E> t = tail;
        Node<E> newNode = new Node<>(t, value, null);
        tail = newNode;
        if (t == null) {
            head = newNode;
        } else {
            t.setNext(newNode);
        }
        actSize++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, actSize);
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> node = head;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E element = node.getElement();
                node = node.getNext();
                return element;
            }
        };
    }
}
