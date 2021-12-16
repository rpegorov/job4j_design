package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Class example Serialization / deserialization
 */
public class WorkGroup {

    /**
     * Func serialization Object to JSONString
     * String employeeJson - Modification String to Json
     * @param employee incoming List
     */
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
        System.out.println("********------********------********------********");
    }

    /**
     * Func serialization to XML, Marshaller/unmarshaller
     * @param employee incoming List
     * context - get context Employee.class for read XmlAttribute
     * @see javax.xml.bind.annotation.XmlAttribute
     * Marshaller - create serialization
     * Unmarshaller - create deserialization
     * @throws Exception for JAXBContext.newInstance
     */
    private static void toXML(Employee employee) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(employee, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
            System.out.println("********------********------********------********");
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Employee result = (Employee) unmarshaller.unmarshal(reader);
            System.out.println(result);
            System.out.println("********------********------********------********");
        }
    }

    /**
     * JSON method put in jsonObject
     * @param employee incoming List
     */
    private static void toPojoMetPut(Employee employee) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("worker", employee.isWorker());
        jsonObject.put("standing", employee.getStanding());
        jsonObject.put("persona Name", employee.getPersona().getFullName());
        jsonObject.put("persona age", employee.getPersona().getAge());
        jsonObject.put("persona sex", employee.getPersona().getSex());
        jsonObject.put("Contacts telephone", employee.getPersona().getContact().getTelephone());
        jsonObject.put("Contacts address", employee.getPersona().getContact().getAddress());
        System.out.println(jsonObject);
        System.out.println("********------********------********------********");
    }

    /**
     * JSON Object in Array
     */
    private static void toPojoMetArray(Employee employee) {
        List<Employee> l = new ArrayList<>();
        l.add(employee);
        JSONArray jsonArray = new JSONArray(l);
        System.out.println(jsonArray);
        System.out.println("********------********------********------********");
    }

    /**
          JSONObject method toString;
         */
    private static void toPojoToString() {
        JSONObject jsonObject = new JSONObject("{"
                + "\"worker\":true,\"standing\":4,"
                + "\"persona\":{\"fullName\":[\"Ivan Podorov\"],"
                + "\"age\":34,\"sex\":\"M\",\"contact\":{\"telephone\":\"891211111111\",\"address\":\"Syktyvkar\"}}"
                + "}");
        System.out.println(jsonObject);
    }

    public static void main(String[] args) throws Exception {
        final Employee employee = new Employee(true, 4,
                new Persona(new String[]{"Ivan Podorov"}, 34, "M",
                        new Contact("8912 111 111 11", "Syktyvkar")));

        toGson(employee);
        toXML(employee);
        toPojoMetPut(employee);
        toPojoMetPut(employee);
        toPojoMetArray(employee);
        toPojoToString();


    }
}
