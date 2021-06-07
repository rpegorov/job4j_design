package ru.job4j.map;

import org.junit.Ignore;
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
    }

//    @Ignore
    @Test
    public void size() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("Test", 1);
        map.put("Test2", 2);
        map.put("Test3", 1);
        assertThat(map.getSize(), is(3));
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