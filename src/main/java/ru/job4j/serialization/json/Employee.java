package ru.job4j.serialization.json;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    @XmlAttribute
    private boolean worker;
    private int standing;
    private Persona persona;

    public boolean isWorker() {
        return worker;
    }

    public void setWorker(boolean worker) {
        this.worker = worker;
    }

    public int getStanding() {
        return standing;
    }

    public void setStanding(int standing) {
        this.standing = standing;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

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
