package ru.job4j.serialization.json;

public class Employee {
    private final boolean worker;
    private final int standing;
    private final Persona persona;

    public Employee(boolean worker, int standing, Persona persona) {
        this.worker = worker;
        this.standing = standing;
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "worker=" + worker
                + ", standing=" + standing
                + ", persona=" + persona
                + '}';
    }
}
