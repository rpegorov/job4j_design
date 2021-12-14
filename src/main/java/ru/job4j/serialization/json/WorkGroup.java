package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WorkGroup {
    public static void main(String[] args) {
        final Employee employee = new Employee(true, 4,
                new Persona(new String[]{"Ivan Podorov"}, 34, 'M',
                        new Contact("8912 111 111 11", "Syktyvkar")));

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(employee));

        final String employeeJson =
                "{"
                        + "\"worker\":true,\"standing\":4,"
                        + "\"persona\":{\"fullName\":[\"Ivan Podorov\"],"
                        + "\"age\":34,\"sex\":\"M\",\"contact\":{\"telephone\":\"891211111111\",\"address\":\"Syktyvkar\"}}"
                        + "}";

        final Employee emplMod = gson.fromJson(employeeJson, Employee.class);
        System.out.println(emplMod);
    }
}
