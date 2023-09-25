package maks.ter.ver3_java1;

import maks.ter.ver3_java1.conf.Conf;
import maks.ter.ver3_java1.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);

        Person person = context.getBean(Person.class);
        System.out.println(person);
    }
}
