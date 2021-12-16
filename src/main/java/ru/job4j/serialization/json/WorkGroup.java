package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class WorkGroup {

    private static void toGson(Employee employee) {
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

    private static void toXML(Employee employee) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(employee, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Employee result = (Employee) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }

    public static void main(String[] args) throws Exception {
        toGson(new Employee(true, 4,
                new Persona(new String[]{"Ivan Podorov"}, 34, "M",
                        new Contact("8912 111 111 11", "Syktyvkar"))));

        toXML(new Employee(true, 4,
                new Persona(new String[]{"Ivan Podorov"}, 34, "M",
                        new Contact("8912 111 111 11", "Syktyvkar"))));

    }
}
