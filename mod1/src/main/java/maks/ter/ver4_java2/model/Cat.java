package maks.ter.ver4_java2.model;

import org.springframework.stereotype.Component;

public class Cat {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
