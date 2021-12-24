package ru.job4j.io.searchDataFile;

import ru.job4j.io.search.ArgsName;
import ru.job4j.io.search.Search;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SearcherFile {
    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        Path root = Path.of(argsName.get("d"));
        writeFile(pathsList(root, argsName), argsName);
    }

    public static List<Path> pathsList(Path root, ArgsName argsName) throws IOException {
        List<Path> paths = new ArrayList<>();
        String searchTypes = argsName.get("t");
        if ("mask".equals(searchTypes)) {
            paths = Search.search(root, s -> s.toFile().getName().endsWith(argsName.get("n")));
        }
        if ("name".equals(searchTypes)) {
            paths = Search.search(root, s -> s.toFile().getName().startsWith(argsName.get("n")));
        }
        if ("regex".equals(searchTypes)) {
            Pattern pattern = Pattern.compile(argsName.get("n"));
            paths = Search.search(root, s -> pattern.matcher(s.toFile().getName()).find());
        }
        return paths;
    }

    public static void writeFile(List<Path> paths, ArgsName argsName) {
        try (Writer out = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(argsName.get("o"))))) {
            for (Path path: paths) {
                out.write(String.valueOf(path));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
