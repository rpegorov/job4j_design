package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ArgsNameTest {
    @Test
    public void whenGetFirst() {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        assertThat(jvm.get("Xmx"), is("512"));
    }

    @Test
    public void whenGetFirstReorder() {
        ArgsName jvm = ArgsName.of(new String[] {"-encoding=UTF-8", "-Xmx=512"});
        assertThat(jvm.get("Xmx"), is("512"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenGetNotExist() {
        ArgsName jvm = ArgsName.of(new String[] {});
        jvm.get("Xmx");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenWrongSomeArgument() {
        ArgsName jvm = ArgsName.of(new String[] {"-encoding=UTF-8", "-Xmx"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenWrongAssignment() {
        ArgsName jvm = ArgsName.of(new String[] {"- UTF-8", "-Xmx 512"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenWrongKey() {
        ArgsName jvm = ArgsName.of(new String[] {"=UTF", "=111"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenUncorrectedFormat() {
        ArgsName jvm = ArgsName.of(new String[] {"encoding=UTF", "xlm=111"});
    }
}