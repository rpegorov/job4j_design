package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;
import ru.job4j.io.readAndWrite.Config;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./app.properties.txt";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
        assertThat(config.value("hibernate.connection.password"), is("password"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithNull() {
        String path = "./app.propertiesNullString.txt";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is(Matchers.nullValue()));
    }

    @Test
    public void whenNullKey() {
        String path = "./app.propertiesBigfile.txt";
        Config config = new Config(path);
        config.load();
        assertThat(config.value(""), is(Matchers.nullValue()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotSplit() {
        String path = "./app.propertiesInvalidFormat.txt";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("test3"), is(Matchers.nullValue()));
    }

    @Test
    public void whenMoreComment() {
        String path = "./app.propertiesBigfile.txt";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
        assertThat(config.value("test"), is("test"));
        assertThat(config.value("test2"), is("test2"));
    }
}