package Controller;

import java.util.Scanner;
import Model.Database;
import Model.Employee;
import Model.Option;

public class CreateEmployee implements Option {

    @Override
    public void oper(Employee user, Scanner s, Database database) {
        System.out.println("Enter first name:");
        String firstName = s.next();
        System.out.println("Enter last name:");
        String lastName = s.next();
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
        e.setFristName(firstName);
        e.setLastName(lastName);
        e.setEmail(email);
        e.setPhoneNumber(phoneNumber);
        e.setAddress(address);
        e.setSalary(salary);
        e.setPassword(password);

        database.addEmployee(e);
        System.out.println("Employee created successfully");
    }

    @Override
    public String getOption() {
        return "Add New Employee";
    }
}