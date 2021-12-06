package ru.job4j.io.readAndWrite;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFiles {

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 1; i <= 10; i++) {
                for (int j = 0; j <= 9; j++) {
                    StringBuilder sb = new StringBuilder(i + " x " + j + " = " + (i * j)
                    + System.lineSeparator());
                    String rsl = sb.toString();
                    out.write(rsl.getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

