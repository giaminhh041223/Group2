package Controller;

import java.util.Scanner;
import Model.Database;
import Model.Employee;

public class CreateEmployee {
    public void execute(Employee e, Database database) {
        database.addEmployee(e);
        System.out.println("Employee created successfully");
    }

    public void oper(Scanner s, Database database) {
        System.out.println("Enter name:");
        String name = s.next();
        System.out.println("Enter email:");
        String email = s.next();
        System.out.println("Enter phone number:");
        String phoneNumber = s.next();
        System.out.println("Enter address:");
        String address = s.next();
        System.out.println("Enter salary (double):");
        double salary = s.nextDouble();
        System.out.println("Enter password:");
        String password = s.next();

        Employee e = new Employee(); // Replace with appropriate subclass if needed
        e.setName(name)
        e.setEmail(email);
        e.setSalary(salary);
        e.setPassword(password);

        execute(e, database);
    }
}
