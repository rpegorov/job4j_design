package ru.job4j.map;

import org.junit.Test;

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
        Map<String, Integer> map = new SimpleMap<>();
        map.put("Test", 1);
        map.put("2Test", 2);
        map.put("3Test", 3);
        map.put("4Test", 4);
        map.put("5Test", 5);
        map.put("6Test", 6);
        map.put("7Test", 7);
        map.put("8Test", 8);
        map.put("9Test", 9);
        map.put("10Test", 1);
        map.put("11Test", 2);
        map.put("12Test", 3);
        map.put("13Test", 4);
        map.put("14Test", 5);
        map.put("15Test", 6);
        map.put("16Test", 7);
        map.put("17Test", 8);
        map.put("18Test", 9);
        assertThat(map.getSize(), is(18));
    }

    @Test
    public void removeFirstElem() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("Test", 1);
        map.put("Test2", 2);
        map.put("Test3", 1);
        assertTrue(map.remove("Test"));
    }

    @Test
    public void removeSecondElem() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("Test", 1);
        map.put("Test2", 2);
        map.put("Test3", 1);
        assertTrue(map.remove("Test2"));
    }
}