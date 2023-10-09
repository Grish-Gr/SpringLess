package maks.ter.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "class")
public class ChildClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "subject")
    private String subject;

    @ManyToMany()
    @JoinTable(name = "class_students",
        joinColumns = @JoinColumn(name = "child_id"),
        inverseJoinColumns = @JoinColumn(name = "class_id"))
    private Set<Child> students;

    public ChildClass() {
    }

    public ChildClass(String name, String subject) {
        this.name = name;
        this.subject = subject;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<Child> getStudents() {
        return students;
    }

    public void setStudents(Set<Child> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "ChildClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", students=" + students +
                '}';
    }
}
