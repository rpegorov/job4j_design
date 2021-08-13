package ru.job4j.io;

import java.io.FileNotFoundException;
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

