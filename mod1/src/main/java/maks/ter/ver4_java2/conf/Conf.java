package maks.ter.ver4_java2.conf;

import maks.ter.ver4_java2.model.Cat;
import maks.ter.ver4_java2.model.Dog;
import maks.ter.ver4_java2.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Conf {

    @Bean
    public Cat getCat() {
        return new Cat("Bars");
    }

    @Bean
    public Dog getDog() {
        return new Dog();
    }

    @Bean
    public Person getPerson(Cat cat, Dog dog) {
        return new Person(cat, dog);
    }
}
