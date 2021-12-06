package ru.job4j.io.duplicates;

import ru.job4j.io.readAndWrite.FileProperty;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    Map<FileProperty, List<Path>> files = new HashMap<>();

    public List<Path> getDuplicates() {
        List<Path> pathList = new ArrayList<>();
        files.values()
                .stream()
                .filter(e -> e.size() > 1)
                .forEach(pathList::addAll);
        return pathList;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fP = new FileProperty(attrs.size(), file.getFileName().toString());
        if (files.containsKey(fP)) {
            List<Path> duplicates = new ArrayList<>(files.get(fP));
            duplicates.add(file);
            files.put(fP, duplicates);
        } else {
            List<Path> lst = new ArrayList<>();
            lst.add(file);
            files.put(fP, lst);
        }
        return super.visitFile(file, attrs);
    }
}
