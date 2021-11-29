package ru.job4j.io;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {

    private static void isValid(String @NotNull [] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Invalid set arguments");
        }
        File file = Path.of(args[0]).toFile();
        if (!file.exists() || !file.isDirectory()) {
            throw new IllegalArgumentException(
                    "Not search file or Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
    }

    public static @NotNull List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void main(String[] args) throws IOException {
        isValid(args);
        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile().getName().endsWith("." + args[1])).forEach(System.out::println);
    }
}
