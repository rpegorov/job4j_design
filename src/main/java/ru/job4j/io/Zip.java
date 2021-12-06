package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void isValid(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        var validDir = (Path.of(argsName.get("d"))).toFile();
        if (!validDir.isDirectory()) {
            throw new IllegalArgumentException(
                    "Not search file or Root folder is null.");
        }
    }
    public static void packFiles(List<Path> sources, File target) {
            try (ZipOutputStream zos = new ZipOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(target)))) {
                for (Path files : sources) {
                    zos.putNextEntry(new ZipEntry(String.valueOf(files)));
                    try (BufferedInputStream out = new BufferedInputStream(
                            new FileInputStream(String.valueOf(files)))) {
                        zos.write(out.readAllBytes());
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        isValid(args);
        packFiles(
                Search.search(Path.of(argsName.get("d")),
                        p -> !p.toFile().
                        getName().
                        endsWith(argsName.get("e"))),
                new File(argsName.get("o"))
        );
    }
}
