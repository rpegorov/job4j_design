package ru.job4j.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class);

    public static void main(String[] args) {
        var name = "Rostislav";
        var age = 30;
        var telephone = 8912;
        var work = false;
        var pikabu = 49.5d;

        LOG.debug("User info name: {}, age: {}, telephone: {}, work: {}, read pikabu: {} ",
                name, age, telephone, work, pikabu);

    }
}
