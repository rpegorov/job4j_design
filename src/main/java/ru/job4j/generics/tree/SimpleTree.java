package ru.job4j.generics.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.BiPredicate;

public class SimpleTree<E> implements Tree<E> {
    private Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> parentNode = findBy(parent);
        if (parentNode.isEmpty() || findBy(child).isPresent()) {
            return false;
        }
        return parentNode.get().getChildren().add(new Node<>(child));
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        BiPredicate<Node<E>, E> func = (e, val) -> e.getValue().equals(val);
        return findByPredicate(func, value);
    }

    public boolean isBinary() {
        BiPredicate<Node<E>, E> func = (node, val) -> node.getChildren().size() > 2;
        return findByPredicate(func, null).isEmpty();
    }

    private Optional<Node<E>> findByPredicate(BiPredicate<Node<E>, E> predicate, E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> e = data.poll();
            if (predicate.test(e, value)) {
                rsl = Optional.of(e);
                break;
            }
            data.addAll(e.getChildren());
        }
        return rsl;
    }
}
