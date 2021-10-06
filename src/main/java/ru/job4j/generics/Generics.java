package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class Generics {
    public static void main(String[] args) {
        Generics gen = new Generics();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();
        first.add(new Animal("A", "T"));
        second.add(new Predator());
        third.add(new Tiger());

        gen.printObject(first);
        gen.printObject(second);
        gen.printObject(third);
        out.println();

        gen.printBoundedWildCard(second);
        gen.printBoundedWildCard(third);
        out.println();

        gen.printLowerBoundedWildCard(first);
        gen.printLowerBoundedWildCard(second);
    }

    public void printObject(List<?> list) {
        list.stream().map(next -> "Текущий элемент: " + next).forEach(out::println);
    }

    public void printBoundedWildCard(List<? extends Predator> list) {
        list.stream().map(next -> "Текущий элемент: " + next).forEach(out::println);
    }

    public void printLowerBoundedWildCard(List<? super Predator> list) {
        list.stream().map(next -> "Текущий элемент: " + next).forEach(out::println);
    }
}
