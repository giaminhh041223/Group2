package Controller;

import java.util.Calendar;
import java.util.Scanner;

import History.History;
import Model.Database;
import Model.Employee;
import Model.Option;

public class CreateEmployee implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database,History history) {
        System.out.println("Enter first name:");
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

        Employee e = null ; // Replace with appropriate subclass if needed
        e.setName(name);
        e.setEmail(email);
        e.setSalary(salary);
        e.setPassword(password);

        database.getEmployees().add(e);
        System.out.println("Employee created successfully");
        Calendar date = Calendar.getInstance();
        history.addEmployeeHistory("created", date, e);
    }

    @Override
    public String getOption() {
        return "Add New Employee";
    }
}
