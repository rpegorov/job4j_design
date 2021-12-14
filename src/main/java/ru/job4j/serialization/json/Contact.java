package ru.job4j.serialization.json;

public class Contact {
    private final String telephone;
    private final String address;

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
