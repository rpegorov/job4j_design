package ru.job4j.seralization;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SzArrays implements Serializable {
    public static void main(String[] args) throws IOException {
        try (FileOutputStream out = new FileOutputStream("szArrays.txt")) {
            Integer[] arrays = new Integer[1000];
            for (int i = 0; i <= 200; i++) {
                arrays[i] = i;
                StringBuilder sb = new StringBuilder(new StringBuilder(String.valueOf(arrays[i]))
                        + System.lineSeparator());
                String rsl = sb.toString();
                out.write(rsl.getBytes(StandardCharsets.UTF_8));

                //Сериализация в файл с помощью класса ObjectOutputStream
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("szArraysOut.txt"));
                objectOutputStream.writeObject(1);
                objectOutputStream.close();

                // Востановление из файла с помощью класса ObjectInputStream
                ObjectInputStream objectInputStream = new ObjectInputStream(
                        new FileInputStream("szArraysOut.txt"));
                Object integer = objectInputStream.readObject();
                objectInputStream.close();
                // Проверяем восстановление
                System.out.println(integer);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }
    }
}
