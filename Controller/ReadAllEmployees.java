package Controller;

import java.util.Scanner;
import java.util.ArrayList;
import Model.*;
import History.*;

public class ReadAllEmployees implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database, History history) {
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
