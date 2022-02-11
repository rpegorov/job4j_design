package ru.job4j.jdbc.spammers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {
    final Properties cfg;
    private final String dump;

    public ImportDB(Properties properties, String dump) {
        this.cfg = properties;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dump))) {
            br.lines().forEach(s -> {
                String[] values = s.split(";");
                if (values.length != 2 || values[0].isEmpty() || values[1].isEmpty()) {
                    throw new IllegalArgumentException("Illegal args");
            }
                users.add(new User(s.split(";")[0], s.split(";")[1]));
            });
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("insert into users(name, email) values(?, ?)")) {
                    ps.setString(1, user.getName());
                    ps.setString(2, user.getEmail());
                    ps.execute();
                }
            }
        }
    }
}
