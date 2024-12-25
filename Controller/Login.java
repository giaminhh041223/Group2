package Controller;

import java.util.Scanner;

import History.History;
import Model.Admin;
import Model.Cashier;
import Model.Database;
import Model.Employee;
import Model.Option;
import Model.Storekeeper;

public class Login implements Option {

    private Employee employee;
    private boolean loggedIn;
    
    public void operate(Employee user, Scanner s, Database database,History history) {
		System.out.println("Welcome to supermarket management system");
		System.out.println("Enter your email:");
		String email = s.next();
		System.out.println("Enter your password:");
		String password = s.next();
		Controller.Login login = new Controller.Login(email, password, database);
		if (login.isLoggedIn()) {
			Employee employee = login.getUser();
			System.out.println("Welcome "+employee.getName());
			employee.showList(s, database,history);
		} else {
			System.out.println("Wrong email or password!");
			System.out.println("Try agin later");
		}
	}

    public Login(String email, String password, Database database) {
        this.loggedIn = false;
        for (Employee e : database.getEmployees()) {
            if (e.getEmail().equals(email) && e.getPassword().equals(password)) {
                this.loggedIn = true;
                employee=e;
                e.generateOptions();
                break;
            }
        }
    }

    public Login() {
		// TODO Auto-generated constructor stub
	}

	public boolean isLoggedIn() {
        return loggedIn;
    }

    public Employee getUser() {
        return employee;
    }
    public String getOption() {
    	return "Login";
    }
}
