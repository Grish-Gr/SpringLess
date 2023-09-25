package maks.ter.ver3_java1.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private Cat cat;
    private Dog dog;

    @Autowired
    public Person(Cat cat, Dog dog) {
        this.cat = cat;
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public Dog getDog() {
        return dog;
    }
}
