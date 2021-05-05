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

//        gen.printBoundedWildCard(first);
        gen.printBoundedWildCard(second);
        gen.printBoundedWildCard(third);
        out.println();

//        gen.printLowerBoundedWildCard(first);
//        gen.printLowerBoundedWildCard(second);
        gen.printLowerBoundedWildCard(third);
    }

    public void printObject(List<?> list) {
        for (Object next : list) {
            out.println("Текущий элемент: " + next);
        }
    }

    public void printBoundedWildCard(List<? extends Predator> list) {
        for (Animal next : list) {
            out.println("Текущий элемент: " + next);
        }
    }

    public void printLowerBoundedWildCard(List<? extends Tiger> list) {
        for (Predator next : list) {
            out.println("Текущий элемент: " + next);
        }
    }
}
