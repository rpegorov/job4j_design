package ru.job4j.generics.question;


import java.util.Set;

public class Analyze {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info rsl = new Info(0, 0, 0);
        for (User user : current) {
            if (!previous.contains(user)) {
                rsl.added();
                current.remove(user);
            }
        }
        return rsl;
    }
}
