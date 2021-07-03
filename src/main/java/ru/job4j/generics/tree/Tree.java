package ru.job4j.generics.tree;

import java.util.Optional;

public interface Tree<E> {
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);
}
