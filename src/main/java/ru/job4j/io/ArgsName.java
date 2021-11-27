package ru.job4j.io;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        String key;
        String value;
        String[] param;
        if (args.length > 0) {
            for (String string : args) {
                param = string.split("=");
                if (param.length < 2) {
                    throw new IllegalArgumentException();
                }
                key = param[0].replace("-", "");
                value = param[1];
                values.put(key, value);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName name = new ArgsName();
        name.parse(args);
        return name;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
