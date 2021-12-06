package ru.job4j.io.readAndWrite;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader((file)))) {
            list = in.lines()
                    .map(s -> s.split(" "))
                    .filter(n -> "404".equals(n[n.length - 2]))
                    .map(Arrays::toString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file))
        )) {
            out.printf("%s%n", log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.printf("%s%n", log);
        save(log, "resultLog.txt");
    }
}
