package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void isValid(String[] args) {
        for (String s : args) {
            if (s.charAt(0) != '-' | !s.contains("=")) {
                throw new IllegalArgumentException("Data does not match key-value pattern");
            }
        }
    }

    private void parse(String[] args) {
        String key;
        String value;
        String[] param;
        if (!(args.length == 0)) {
            isValid(args);
            for (String s : args) {
                param = s.split("=");
                key = param[0].replace("-", "");
                value = param[1];
                values.put(key, value);
            }
        } else {
            throw new IllegalArgumentException("Invalid set arguments");
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName name = new ArgsName();
        name.parse(args);
        return name;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xml=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xml"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}