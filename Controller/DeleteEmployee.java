package Controller;

import java.util.Calendar;
import java.util.Scanner;
import History.History;
import Model.Database;
import Model.Employee;
import Model.Option;

public class DeleteEmployee implements Option {

	@Override
	public void operate(Employee user, Scanner s, Database database, History history) {
		System.out.println("Enter employee ID to delete:");
		String ID = s.next();

		Employee e = database.findEmployeeById(ID);
		if (e == null) {
			System.out.println("Employee not found.");
			return;
		}
		database.getEmployees().remove(e);
		System.out.println("Employee deleted successfully.");
		Calendar date = Calendar.getInstance();
		history.addEmployeeHistory("Fire", date, e);
	}

	@Override
	public String getOption() {
		return "Fire Employee";
	}

}
