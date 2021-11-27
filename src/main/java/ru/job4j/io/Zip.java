package ru.job4j.io;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public static void packFiles(@NotNull List<Path> sources, File target) {
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

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zos = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            zos.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(
                    new FileInputStream(source))) {
                zos.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        packSingleFile(new File("./pom.xml"),
                new File("./pom.zip"));
        ArgsName argsName = ArgsName.of(args);
        packFiles(
                Search.search(Path.of(argsName.get("d")),
                        p -> p.toFile().
                        getName().
                        endsWith(argsName.get("e"))),
                new File(argsName.get("o"))
        );
    }
}
