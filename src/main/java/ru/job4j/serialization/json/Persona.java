package ru.job4j.serialization.json;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "Persona")
@XmlAccessorType(XmlAccessType.FIELD)
public class Persona {
    @XmlElementWrapper(name = "Persons")
    @XmlElement(name = "persona")
    private String[] fullName;
    private int age;
    private String sex;
    private Contact contact;

    public String[] getFullName() {
        return fullName;
    }

    public void setFullName(String[] fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Persona() {
    }

    public Persona(String[] fullName, int age, String sex, Contact contact) {
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
