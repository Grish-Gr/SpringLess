package maks.ter.ver1_xml.model;

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
