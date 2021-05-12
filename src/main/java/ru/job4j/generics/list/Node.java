package ru.job4j.generics.list;

public class Node<E> {

    private final E element;
    private Node<E> next;

    public Node(Node<E> prev, E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
