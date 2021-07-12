package ru.job4j.generics.tree;

import java.util.ArrayList;
import java.util.List;

public class Node<E> {

    private final E value;

    private final List<Node<E>> children = new ArrayList<>();

    public Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public List<Node<E>> getChildren() {
        return children;
    }
}
