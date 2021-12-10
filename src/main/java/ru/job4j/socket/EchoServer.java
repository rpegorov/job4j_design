package ru.job4j.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String word = in.readLine().substring(10).split(" ")[0];
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        serverMSG(server, out, word);
                        System.out.println(str);
                    }
                    out.flush();
                }
            }
        }
    }

    private static void serverMSG(ServerSocket server, OutputStream out, String word) throws IOException {
        String msg;
        if ("hello".equals(word)) {
            msg = "hello )";
            out.write("HTTP/1.1 200 OK\r\n".getBytes());
            out.write(msg.getBytes());
        }
        if ("exit".equals(word)) {
            server.close();
        }
        if (!"hello".equals(word) && !"exit".equals(word)) {
            msg = "what?)";
            out.write("HTTP/1.1 200 OK\r\n".getBytes());
            out.write(msg.getBytes());
        }
    }
}

