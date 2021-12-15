package ru.job4j.serialization.json;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    @XmlAttribute
    private boolean worker;
    private int standing;
    private Persona persona;

    public Employee() {
    }

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
