package maks.ter.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "childs")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToMany()
    @JoinTable(name = "class_students",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id"))
    private Set<ChildClass> classes;

    public Child() {
    }

    public Child(String name, String surname, Set<ChildClass> classes) {
        this.name = name;
        this.surname = surname;
        this.classes = classes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<ChildClass> getClasses() {
        return classes;
    }

    public void setClasses(Set<ChildClass> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", classes=" + classes +
                '}';
    }
}
