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
                    String stop = in.readLine().substring(10).split(" ")[0];
                    if (!"bye".equals(stop)) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                            System.out.println(str);
                        }
                        out.flush();
                    } else {
                        server.close();
                    }
                }
            }
        }
    }
}

