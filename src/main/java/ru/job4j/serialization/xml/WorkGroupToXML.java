package ru.job4j.serialization.xml;

import ru.job4j.serialization.json.Contact;
import ru.job4j.serialization.json.Employee;
import ru.job4j.serialization.json.Persona;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class WorkGroupToXML {
    public static void main(String[] args) throws Exception {
        Employee employee = new Employee(true, 4,
                new Persona(new String[]{"Ivan Podorov"}, 34, 'M',
                        new Contact("8912 111 111 11", "Syktyvkar")));

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
}
