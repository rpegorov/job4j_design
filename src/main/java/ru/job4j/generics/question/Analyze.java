package ru.job4j.generics.question;


import java.util.HashSet;
import java.util.Set;

public class Analyze {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info rsl = new Info(0, 0, 0);
        HashSet<User> previousSet = new HashSet<>(previous);
        HashSet<User> currentSet = new HashSet<>(current);
        for (User user : current) {
            if (!previousSet.contains(user)) {
                rsl.added();
                currentSet.remove(user);
            }
        }
        return rsl;
    }
}
