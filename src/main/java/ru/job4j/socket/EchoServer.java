package ru.job4j.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private final static Logger LOG = LoggerFactory.getLogger(EchoServer.class);

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String word = in.readLine().substring(10).split(" ")[0];
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        serverMSG(server, out, word);
                    }
                    out.flush();
                }
            }
        } catch (IOException e) {
            LOG.error("Error connection", e);
        }
    }

    private static void serverMSG(ServerSocket server, OutputStream out, String word) throws IOException {
        if ("hello".equals(word)) {
            out.write("HTTP/1.1 200 OK\r\n".getBytes());
            out.write("hello =^_^=".getBytes());
        } else if ("exit".equals(word)) {
            server.close();
        } else {
            out.write("HTTP/1.1 200 OK\r\n".getBytes());
            out.write("What? ``O_o".getBytes());
        }
    }
}

