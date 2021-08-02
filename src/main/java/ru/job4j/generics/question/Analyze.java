package ru.job4j.generics.question;


import java.util.*;

public class Analyze {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info rsl = new Info(0, 0, 0);
        Map<Integer, String> map = new HashMap<>();
        for (User users : previous) {
            map.put(users.getId(), users.getName());
        }
        for (User users : current) {
            if (map.containsKey(users.getId())) {
                if (!Objects.equals(users.getName(), map.get(users.getId()))) {
                    rsl.changed++;
                }
            } else {
                rsl.added++;
            }
        }
        rsl.deleted = previous.size() + rsl.added - current.size();
        return rsl;
    }
}

