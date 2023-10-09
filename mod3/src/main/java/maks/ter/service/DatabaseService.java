package maks.ter.service;

import maks.ter.entity.*;
import maks.ter.entity.ChildClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class DatabaseService {

    private SessionFactory sessionFactory;

    public DatabaseService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Employee saveEmployee(String name, String surname, BigDecimal salary, Long departmentId, String city, String phone, String email) {
        Session session = getSession();
        session.beginTransaction();

        Department department = session.get(Department.class, departmentId);
        if (department == null) {
            return null;
        }

        EmployeeDetails details = new EmployeeDetails(city, name, phone);
        Employee employee = new Employee(name, surname, salary, department, details);

        session.save(employee);
        session.save(details);

        session.close();

        return employee;
    }

    public Department saveDepartment(String name, BigDecimal maxPrice, BigDecimal minPrice) {
        Session session = getSession();
        session.beginTransaction();

        Department department = new Department(name, maxPrice, minPrice);
        session.save(department);

        session.close();

        return department;
    }

    public ChildClass saveClass(String name, String subject) {
        Session session = getSession();
        session.beginTransaction();

        ChildClass childClass = new ChildClass(name, subject);
        session.save(childClass);

        session.close();

        return childClass;
    }

    public Child saveChild(String name, String surname, Set<ChildClass> classes) {
        Session session = getSession();
        session.beginTransaction();

        Child child = new Child(name, surname, classes);
        session.save(child);

        session.close();

        return child;
    }

    public <T> T deleteEntity(Class<T> entityClass, Long id) {
        Session session = getSession();
        session.beginTransaction();

        T entity = session.get(entityClass, id);
        session.delete(entity);

        session.close();

        return entity;
    }

    public <T> List<T> getEntities(Class<T> entityClass) {
        Session session = getSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> rootEntry = cq.from(entityClass);
        CriteriaQuery<T> all = cq.select(rootEntry);

        TypedQuery<T> allQuery = session.createQuery(all);
        session.close();
        return allQuery.getResultList();
    }

    public <T> T getEntity(Class<T> entityClass, Long id) {
        Session session = getSession();
        session.beginTransaction();

        T entity = session.get(entityClass, id);

        session.close();

        return entity;
    }
}
