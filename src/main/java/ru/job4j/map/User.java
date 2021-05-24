package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Objects;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        User user = (User) o;
//        return children == user.children && Objects.equals(name,
//                user.name) && Objects.equals(birthday, user.birthday);
//    }
//

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public String toString() {
        return "\r\n"
                + "User: "
                + '\n'
                + "name= '" + name
                + ", children=" + children
                + ", birthday=" + birthday.getWeekYear();
    }

    public static void main(String[] args) {
        User u1 = new User("Slava",
                1,
                new GregorianCalendar(1990, Calendar.FEBRUARY, 1));
        User u2 = new User("Sergey",
                2,
                new GregorianCalendar(1991, Calendar.MARCH, 3));
        User u3 = new User("Dmitriy",
                3, new GregorianCalendar(1992, Calendar.APRIL, 3));
        User u4 = new User("Dmitriy",
                3, new GregorianCalendar(1992, Calendar.APRIL, 3));

        HashMap<User, Object> userHashMap = new HashMap();

        userHashMap.put(u1, "Slava");
        userHashMap.put(u2, "Sergey");
        userHashMap.put(u3, "Dmitriy");
        userHashMap.put(u4, "Dmitriy");

        System.out.println(userHashMap);
    }
}
