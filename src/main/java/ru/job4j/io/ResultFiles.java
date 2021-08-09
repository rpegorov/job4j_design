package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ResultFiles {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j <= 9; j++) {
                try (FileOutputStream out = new FileOutputStream("result.txt")) {
                    out.write(Integer.parseInt(.getBytes(StandardCharsets.UTF_8)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                System.out.print(i + "x" + j + "=" + (i * j) + "\t");
//            }
//            System.out.println();
//        }
            }
        }
    }
}
