package maks.ter.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "employess")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "salary")
    private BigDecimal salary;

    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="details_id")
    private EmployeeDetails employeeDetails;

    public Employee() {
    }

    public Employee(String name, String surname, BigDecimal salary, Department department, EmployeeDetails employeeDetails) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
        this.employeeDetails = employeeDetails;
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmployeeDetails getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(EmployeeDetails employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    public Employee(Long id, String name, String surname, BigDecimal salary, Department department, EmployeeDetails employeeDetails) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
        this.employeeDetails = employeeDetails;
    }
}
