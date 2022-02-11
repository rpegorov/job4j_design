package ru.job4j.jdbc.spammers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("./src/main/resources/app.properies-spammer.txt")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./src/main/resources/dump.txt");
        db.save(db.load());
    }
}

