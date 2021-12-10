package ru.job4j.io.csv;

import ru.job4j.io.search.ArgsName;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CSVReader {

    private static void isValid(ArgsName args) {
        if (args.getValues().size() != 4) {
            throw new IllegalArgumentException("Invalid set arguments");
        }
        File f = new File(args.get("path"));
        if (!f.isFile() || !f.exists()) {
            throw new IllegalArgumentException("File not found or file not exist");
        }
        if (!args.get("delimiter").equals(";")) {
            throw new IllegalArgumentException("Incorrect delimiter in File");
        }
    }

    private static void handle(ArgsName args) throws IOException {
        isValid(args);
        StringBuilder rsl = new StringBuilder();
        List<String[]> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(
                new BufferedReader(
                        new FileReader(args.get("path")))).useDelimiter("\n")) {
            while (scanner.hasNext()) {
                var s = scanner.next().split(args.get("delimiter"));
                list.add(s);
            }

            List<Integer> indexFilter = new ArrayList<>();
            var l = Arrays.stream(list.get(0)).collect(Collectors.toList());
            for (String s1 : args.get("filter").split(",")) {
                indexFilter.add(l.indexOf(s1));
            }
            for (String[] a : list) {
                var tmp = Arrays.stream(a).collect(Collectors.toList());
                rsl.append(tmp.get(indexFilter.get(0))).append(";")
                        .append(tmp.get(indexFilter.get(1))).append(System.lineSeparator());
            }
        }
        if ("stdout".equals(args.get("out"))) {
            System.out.print(rsl);
        } else {
            try (PrintWriter out = new PrintWriter(
                    new BufferedOutputStream(new FileOutputStream(args.get("out"))))) {
                out.print(rsl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void handleOf(ArgsName args) throws IOException {
        handle(args);
    }
}
