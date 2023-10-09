package maks.ter.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "max_price")
    private BigDecimal maxPrice;

    @Column(name = "min_price")
    private BigDecimal minPrice;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

    public Department() {
    }

    public Department(String name, BigDecimal maxPrice, BigDecimal minPrice) {
        this.name = name;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
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

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public Department(Long id, String name, BigDecimal maxPrice, BigDecimal minPrice, Set<Employee> employees) {
        this.id = id;
        this.name = name;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.employees = employees;
    }
}
