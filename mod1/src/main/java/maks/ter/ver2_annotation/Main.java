package maks.ter.ver2_annotation;

import maks.ter.ver2_annotation.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("maks.ter.ver2_annotation")
public class Main {

    @Autowired
    private Person person;

    public static void main(String[] args) {
    }
}
