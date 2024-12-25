package Controller;

import java.util.Scanner;

import History.History;
import Model.Database;
import Model.Option;
import Model.Storekeeper;

import java.util.ArrayList;
import Model.Admin;
import Model.Cashier;
import Model.Database;
import Model.Employee;

public class ReadAllEmployees implements Option {
	private Database database;

    @Override
    public void operate(Employee user, Scanner s, Database database,History history) {
        new ReadAllEmployees(database);
    }

    @Override
    public String getOption() {
        return "View All Employees";
    }
    public ReadAllEmployees(Database database) {
        ArrayList<Employee> employees = database.getEmployees();
        for (Employee e : employees) {
            e.print();
        System.out.println("--------------------------------");
        }
    }

    
}
