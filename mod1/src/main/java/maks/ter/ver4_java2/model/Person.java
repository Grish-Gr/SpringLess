package maks.ter.ver4_java2.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {

    private Cat cat;
    private Dog dog;

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
