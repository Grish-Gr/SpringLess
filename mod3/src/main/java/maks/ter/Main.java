package maks.ter;

import maks.ter.config.SpringConfig;
import maks.ter.entity.Child;
import maks.ter.entity.ChildClass;
import maks.ter.entity.Department;
import maks.ter.entity.Employee;
import maks.ter.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    private static Map<String, Class<?>> entityMap = new HashMap<>();
    private static String[] listCommand = new String[] {"get", "getAll", "delete", "save"};

    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        DatabaseService service = ac.getBean(DatabaseService.class);

        initEntityMap();
        Scanner scanner = new Scanner(System.in);

        while (scanner.next().equals("end")) {
            System.out.println("Write entity class (child, childClass employee, department)");

            String classEntity = scanner.next();
            if (!entityMap.containsKey(classEntity)) {
                System.out.println("Not found entity name");
                continue;
            }

            System.out.println("Write command for entity (get, getAll, delete, save)");
            String command = scanner.next();
            if (!Arrays.asList(listCommand).contains(command)) {
                System.out.println("Not found command name");
                continue;
            }

            switch (command) {
                case "get": {
                    Long id = scanner.nextLong();
                    System.out.println(service.getEntity(entityMap.get(classEntity), id).toString());
                    continue;
                }
                case "getAll":
                    service.getEntities(entityMap.get(classEntity)).forEach(entity -> System.out.println(entity.toString()));
                    continue;
                case "delete": {
                    Long id = scanner.nextLong();
                    System.out.println(service.deleteEntity(entityMap.get(classEntity), id).toString());
                    continue;
                }
            }

            if (classEntity.equals("employee")) {
                System.out.println("Write name");
                String name = scanner.next();
                System.out.println("Write surname");
                String surname = scanner.next();
                System.out.println("Write salary");
                BigDecimal salary = scanner.nextBigDecimal();

                System.out.println("Write phone");
                String phone = scanner.next();
                System.out.println("Write email");
                String email = scanner.next();
                System.out.println("Write city");
                String city = scanner.next();
                System.out.println("Write departmentId");
                Long departmentId = scanner.nextLong();

                System.out.println(service.saveEmployee(name, surname, salary, departmentId, city, phone, email).toString());
            } else if (classEntity.equals("department")) {
                System.out.println("Write name");
                String name = scanner.next();
                System.out.println("Write minSalary");
                BigDecimal minSalary = scanner.nextBigDecimal();
                System.out.println("Write maxSalary");
                BigDecimal maxSalary = scanner.nextBigDecimal();

                System.out.println(service.saveDepartment(name, minSalary, maxSalary).toString());
            } else if (classEntity.equals("class")) {
                System.out.println("Write name");
                String name = scanner.next();
                System.out.println("Write subject");
                String subject = scanner.next();

                System.out.println(service.saveClass(name, subject).toString());
            } else {
                System.out.println("Write name");
                String name = scanner.next();
                System.out.println("Write surname");
                String surname = scanner.next();

                System.out.println("Write child classes, use separator ','");
                Set<ChildClass> classes = Arrays.stream(scanner.next().split(","))
                    .map(Long::parseLong)
                    .map(id -> service.getEntity(ChildClass.class, id))
                    .collect(Collectors.toSet());

                System.out.println(service.saveChild(name, surname, classes));
            }
        }
    }

    private static void initEntityMap() {
        entityMap.put("child", Child.class);
        entityMap.put("childClass", ChildClass.class);
        entityMap.put("employee", Employee.class);
        entityMap.put("department", Department.class);
    }
}