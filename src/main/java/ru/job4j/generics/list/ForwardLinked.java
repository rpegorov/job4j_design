package ru.job4j.generics.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {

    private Node<T> head;
    private int modCount, actSize;

    public int getSize() {
        return actSize;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
        } else {
            Node<T> tail = head;
            while (tail.getNext() != null) {
                tail = tail.getNext();
            }
            tail.setNext(node);
        }
        actSize++;
        modCount++;
    }

    public T deleteFirst() {
        Node<T> node = head;
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.getNext();
        actSize--;
        modCount++;
        return node.getElement();
    }

    public boolean revers() {
        if (head == null || head.getNext() == null) {
            return false;
        }
            Node<T> prev = null;
            Node<T> tmp = head;
            while (tmp != null) {
                Node<T> next = tmp.getNext();
                tmp.setNext(prev);
                prev = tmp;
                tmp = next;
            }
            head = prev;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> node = head;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T element = node.getElement();
                node = node.getNext();
                return element;
            }
        };
    }
}
