package maks.ter.ver1_xml;

import maks.ter.ver1_xml.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Person person = context.getBean("person", Person.class);
        System.out.println(person.getCat().getName());
    }
}
