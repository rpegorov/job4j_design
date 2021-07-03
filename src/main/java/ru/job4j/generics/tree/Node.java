package ru.job4j.generics.tree;

import java.util.ArrayList;
import java.util.List;

public class Node<E> {
    @SuppressWarnings("checkstyle:VisibilityModifier")
    final E value;

    @SuppressWarnings("checkstyle:VisibilityModifier")
    final List<Node<E>> children = new ArrayList<>();

    public Node(E value) {
        this.value = value;
    }
}
