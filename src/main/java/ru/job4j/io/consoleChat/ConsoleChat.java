package ru.job4j.io.consoleChat;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {

    final String path;
    final String botAnswer;

    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswer) {
        this.path = path;
        this.botAnswer = botAnswer;
    }

    public void run() {
        List<String> answers = readPhrases();
        List<String> logList = new ArrayList<>();
        boolean marker = true;
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (!OUT.equals(input)) {
            input = scanner.nextLine();
            logList.add(input);
            if (STOP.equals(input)) {
                marker = false;
            } else if (CONTINUE.equals(input)) {
                marker = true;
            }
            if (marker && !OUT.equals(input)) {
                String answer = answers.get((int) (Math.random() * answers.size()));
                logList.add(answer);
                System.out.println(answer);
            }
        }
        saveLog(logList);
    }

    private List<String> readPhrases() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(
                new FileReader(
                        botAnswer, StandardCharsets.UTF_8))) {
            bf.lines().forEach(answers::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(
                        path, StandardCharsets.UTF_8, true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("LogChatBot.txt", "BotAnswer.txt");
        cc.run();
    }
}
