package Controller;
import java.util.Calendar;
import java.util.Scanner;

import History.History;
import Model.Database;
import Model.Employee;

public class UpdateEmployee {
	
	public void operate(String ID, Database database, Scanner s, History history) {
		Employee emp = database.findEmployeeById(ID);
		System.out.println("Enter first name (-1 to keep "+emp.getName()+"):");
		String name = s.next();
		if (!name.equals("-1")) {
			emp.setName(name);
		}
		
		System.out.println("Enter email (-1 to keep "+emp.getEmail()+"):");
		String email = s.next();
		if (!email.equals("-1")) {
			emp.setEmail(email);
		}
		
		System.out.println("Enter phone number (-1 to keep "+emp.getID()+"):");
		String Id = s.next();
		if (!Id.equals("-1")) {
			emp.setID(Id);
		}
		
		System.out.println("Enter address (-1 to keep "+emp.getPassword()+"):");
		String password = s.next();
		if (!password.equals("-1")) {
			emp.setPassword(password);
		}
		
		System.out.println("Enter salary (-1 to keep "+emp.getSalary()+"):");
		double salary = s.nextDouble();
		if (salary!=-1) {
			emp.setSalary(salary);
		}
		Calendar date = Calendar.getInstance();
		history.addEmployeeHistory("Update employee's information", date, database.findEmployeeById(ID));
	}
	public UpdateEmployee(Database database, Scanner s, History history) {
		System.out.println("Enter employee ID (-1 to show all employees):");
		String ID = s.nextLine();
		boolean checkID=true;
		while (checkID) {
			for (Employee e : database.getEmployees()) {
				if (ID==e.getID()) {
					checkID=false;
					break;
				}
			}
			new ReadAllEmployees(database);
			System.out.println("Enter employee ID (-1 to show all employees):");
			ID = s.nextLine();
		}
		operate(ID, database, s, history);
	}
}
