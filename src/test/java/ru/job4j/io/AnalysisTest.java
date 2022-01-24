package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import ru.job4j.io.readAndWrite.Analysis;
import java.io.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalysisTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void when4Down() throws IOException {
        File target = folder.newFile("target.txt");
        Analysis.unavailable("./target/fileHeap/serverLog.txt", target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01;10:59:0111:01:02;11:02:02"));
    }

    @Test
    public void whenNotDown() throws IOException {
        File target = folder.newFile("target.txt");
        Analysis.unavailable("./target/fileHeap/serverLogNotDown.txt", target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is(""));
    }

    @Test
    public void whenDataFileNotDown() throws IOException {
        File target = folder.newFile("target.txt");
        Analysis.unavailable("./target/fileHeap/serverLogNotDown.txt", target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is(""));
    }
}