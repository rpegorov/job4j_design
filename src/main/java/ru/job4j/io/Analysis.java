package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Analysis {
    public static void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
                List<String[]> list = in.lines().map(n -> n.split(" ")).collect(Collectors.toList());
                String startTimeFail = null;
                String stopTimeFail;
                for (String[] time : list) {
                    if (startTimeFail == null && (time[0].equals("400") || time[0].equals("500"))) {
                        startTimeFail = time[1];
                    }
                    if (startTimeFail != null && (time[0].equals("200") || time[0].equals("300"))) {
                        stopTimeFail = time[1];
                        out.println(startTimeFail + ";" + stopTimeFail);
                        startTimeFail = null;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}