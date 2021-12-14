package ru.job4j.serialization;

import java.io.*;
import java.nio.file.Files;

public class Contact implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "zipCode=" + zipCode
                + ", phone='" + phone + '\''
                + '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact(123456, "+7 (111) 111-11-11");

        File tempFile = outputFile(contact);
        inputFile(tempFile);
    }

    /**
     * File read func.
     * @param temp of the referenced file
     * @throws IOException exceptions produced by failed or interrupted I/O operations
     * @throws ClassNotFoundException no definition for the class with the specified name could be found
     */
    private static void inputFile(File temp) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(String.valueOf(temp));
             ObjectInputStream ois =
                     new ObjectInputStream(fis)) {
            final Contact contactFromFile = (Contact) ois.readObject();
            System.out.println(contactFromFile);
        }
    }

    /**
     * Write to file func.
     * @param contact Object to serialization
     * @return return file`s temp folder
     * @throws IOException generate to file`s
     */
    private static File outputFile(Contact contact) throws IOException {
        var tempFolder = Files.createTempFile(null, null).toFile();
        try (FileOutputStream fos = new FileOutputStream(tempFolder);
             ObjectOutputStream oos =
                     new ObjectOutputStream(fos)) {
            oos.writeObject(contact);
        }
        return tempFolder;
    }
}
