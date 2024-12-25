package Controller;

import java.util.Calendar;
import java.util.Scanner;
import History.History;
import Model.*;

public class CreateEmployee implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database,History history) {
        System.out.println("Enter name:");
        String name = s.next();
        System.out.println("Enter email:");
        String email = s.next();
        System.out.println("Enter ID:");
        String ID = s.nextLine();
        System.out.println("Enter password:");
        String password = s.next();
        System.out.println("Enter department");
        int department = s.nextInt();
        System.out.println("Enter salary");
        double salary = s.nextDouble();

        Employee e;
		switch (department) {
		case 0:
			e = new Admin();
			break;
		case 1:
			e = new Cashier();
			break;
		case 2:
			e = new Storekeeper();
			break;
			default:
				System.out.println("Invalid department");
				e = new Cashier();
				break;
		}
        e.setName(name);
        e.setEmail(email);
        e.setID(ID);
        e.setPassword(password);
        e.setSalary(salary);
        
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