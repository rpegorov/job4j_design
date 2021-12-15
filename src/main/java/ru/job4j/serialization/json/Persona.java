package ru.job4j.serialization.json;

import java.util.Arrays;

public class Persona {
    private final String[] fullName;
    private final int age;
    private final char sex;
    private final Contact contact;

    public Persona(String[] fullName, int age, char sex, Contact contact) {
        this.fullName = fullName;
        this.age = age;
        this.sex = sex;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Persona{"
                + "fullName=" + Arrays.toString(fullName)
                + ", age=" + age
                + ", sex=" + sex
                + ", contact=" + contact
                + '}';
    }
}
