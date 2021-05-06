package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void add() {
        String s1 = "Test";
        SimpleArray<String> array = new SimpleArray<>();
        array.add(s1);
        Object rsl = array.get(0);
        assertThat(rsl, is(s1));

    }

    @Test
    public void set() {
        SimpleArray<Integer> array = new SimpleArray<>();
        array.add(1);
        array.set(0, 5);
        Object rsl = array.get(0);
        assertThat(rsl, is(5));
    }

    @Test
    public void remove() {
        SimpleArray<Integer> array = new SimpleArray<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.remove(1);
        Object rsl = array.get(1);
        assertThat(rsl, is(3));
    }

    @Test
    public void resize() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("1");
        array.add("2");
        array.add("3");
        array.add("4");
        array.add("5");
        array.add("6");
        array.add("7");
        array.add("8");
        array.add("9");
        array.add("10");
        array.add("11");
        array.add("12");
        array.add("13");
        array.add("14");
        Object rsl = array.get(12);
        assertThat(rsl, is("13"));
    }
}