package ru.job4j.serialization.json;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Contact")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contact {
    @XmlAttribute
    private String telephone;
    @XmlAttribute
    private String address;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Contact() {

    }

    public Contact(String telephone, String address) {
        this.telephone = telephone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "telephone='" + telephone + '\''
                + ", address='" + address + '\''
                + '}';
    }
}
