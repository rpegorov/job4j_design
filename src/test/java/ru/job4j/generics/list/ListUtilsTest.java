package ru.job4j.generics.list;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.*;
import static org.junit.Assert.*;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void addAfter() {
        List<Integer> input = new ArrayList<>(asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(asList(0, 1, 2, 3), Is.is(input));
    }

    @Test
    public void removeIf() {
        List<Integer> input = new ArrayList<>(asList(1, 2, 3, 4, 5));
        ListUtils.removeIf(input, t -> t > 2);
        assertThat(asList(1, 2), Is.is(input));
    }

    @Test
    public void removeByCondition() {
        List<Integer> input = new ArrayList<>(asList(1, 2, 3, 4, 5));
        ListUtils.removeIf(input, t -> t == 1);
        assertThat(asList(2, 3, 4, 5), Is.is(input));
    }

    @Test
    public void replace() {
        List<Integer> input = new ArrayList<>(asList(0, 1, 2));
        ListUtils.replaceIf(input, t -> t == 2, 3);
        assertThat(asList(0, 1, 3), Is.is(input));
    }

    @Test
    public void replaceByCondition() {
        List<Integer> input = new ArrayList<>(asList(0, 1, 2, 4, 5, 6));
        ListUtils.replaceIf(input, t -> t > 2, 0);
        assertThat(asList(0, 1, 2, 0, 0, 0), Is.is(input));
    }

    @Test
    public void removeAll() {
        List<Integer> input = new ArrayList<>(asList(0, 1, 2));
        List<Integer> remove = new ArrayList<>(asList(0, 1, 2));
        ListUtils.removeAll(input, remove);
        assertThat(Collections.emptyList(), Is.is(input));
    }

    @Test
    public void removeWhenOneElement() {
        List<Integer> input = new ArrayList<>(asList(0, 1, 2));
        List<Integer> remove = new ArrayList<>(Collections.singletonList(1));
        ListUtils.removeAll(input, remove);
        assertThat(asList(0, 2), Is.is(input));
    }
}