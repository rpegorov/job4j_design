package ru.job4j.io.search;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    public Map<String, String> getValues() {
        return values;
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
        if (args.length == 0) {
            throw new IllegalArgumentException("Invalid set arguments");
        }
            isValid(args);
        for (String s : args) {
            param = s.split("=");
            key = param[0].replace("-", "");
            value = param[1];
            values.put(key, value);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName name = new ArgsName();
        name.parse(args);
        return name;
    }
}
