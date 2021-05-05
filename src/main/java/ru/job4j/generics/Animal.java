package ru.job4j.generics;

public class Animal<K, V> {
    private K name;
    private V type;

    public Animal(K name, V type) {
        this.name = name;
        this.type = type;
    }
}
