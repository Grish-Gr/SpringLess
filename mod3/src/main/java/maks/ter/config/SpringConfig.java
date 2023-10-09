package maks.ter.config;

import maks.ter.entity.Child;
import maks.ter.entity.Department;
import maks.ter.entity.Employee;
import maks.ter.entity.EmployeeDetails;
import maks.ter.service.DatabaseService;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public SessionFactory getSessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("configuration.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Class.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(EmployeeDetails.class)
                .buildSessionFactory();
    }

    @Bean
    public DatabaseService databaseService(SessionFactory factory) {
        return new DatabaseService(factory);
    }
}
