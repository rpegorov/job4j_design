package ru.job4j.map;

import org.junit.Test;
import ru.job4j.generics.list.SimpleArray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void putAndGetFirst() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("Test", 1);
        map.put("Test2", 2);
        map.put("Test3", 1);
        assertThat(map.get("Test"), is(1));
        assertThat(map.get("Test2"), is(2));
        assertThat(map.get("Test3"), is(1));
    }

    @Test
    public void putWhenDuplicate() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("Test", 1);
        assertFalse(map.put("Test", 5));
        assertThat(map.get("Test"), is(5));
    }

    @Test
    public void size() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("Test", 1);
        map.put("Test2", 2);
        map.put("Test3", 1);
        assertThat(map.getSize(), is(3));
    }

    @Test
    public void whenResize() {
        Map<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 4);
        map.put(6, 4);
        map.put(7, 4);
        map.put(8, 4);
        map.put(9, 4);
        map.put(10, 4);
        assertThat(map.getSize(), is(10));
    }

    @Test
    public void removeFirstElem() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("Test", 1);
        map.put("Test2", 2);
        map.put("Test3", 1);
        assertTrue(map.remove("Test"));
        assertThat(map.getSize(), is(2));
    }

    @Test
    public void removeSecondElem() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("Test", 1);
        map.put("Test2", 2);
        map.put("Test3", 1);
        assertTrue(map.remove("Test2"));
        assertThat(map.getSize(), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void itTest() {
        Map<Integer, Integer> map = new SimpleMap<>();
        map.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        Map<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 1);
        Iterator<Integer> it = map.iterator();
        map.put(2, 2);
        it.next();
    }
}