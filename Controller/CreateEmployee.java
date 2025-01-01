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
        s.nextLine(); // Consume the leftover newline from previous input
        String ID = s.nextLine();

        if (database.findEmployeeById(ID) != null) {
            System.out.println("Employee ID already exists.");
            return;
        }
        
        System.out.println("Enter password:");
        String password = s.next();
        System.out.println("Enter department");
        int department = s.nextInt();
        System.out.println("Enter salary");
        double salary = s.nextDouble();

        Employee e;
		switch (department) {
		case 0:
			e = new Admin(ID, name, email, password, salary);
			break;
		case 1:
			e = new Cashier(ID, name, email, password, salary);
			break;
		case 2:
			e = new Storekeeper(ID, name, email, password, salary);
			break;
		default:
			System.out.println("Invalid department");
			return;
		}
        
        database.getEmployees().add(e);
        System.out.println("Employee created successfully");
        Calendar date = Calendar.getInstance();
        history.addEmployeeHistory("Created", date, e);
    }

    @Override
    public String getOption() {
        return "Add New Employee";
    }
}