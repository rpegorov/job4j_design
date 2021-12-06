package ru.job4j.io.readAndWrite;

import java.io.FileInputStream;

public class ReadFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("input.txt")) {
            StringBuilder sb = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                sb.append((char) read);
        }
            System.out.println(sb);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
