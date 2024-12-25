package Controller;

import java.util.Calendar;
import java.util.Scanner;

import History.History;
import Model.Database;
import Model.Employee;
import Model.Option;

public class DeleteEmployee implements Option {
	public void deleteEmployee(String ID,Database database) {
		database.getEmployees().remove(database.findEmployeeById(ID));
	}

	@Override
	public void operate(Employee user, Scanner s, Database database,History history) {
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
		Calendar date = Calendar.getInstance();
		history.addEmployeeHistory("Remove", date, database.findEmployeeById(ID));
		deleteEmployee(ID, database);
	}

	@Override
	public String getOption() {
		return "Fire Employee";
	}

}
