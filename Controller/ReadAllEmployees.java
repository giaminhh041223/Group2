package Controller;

import java.util.Scanner;
import History.History;
import Model.*;

public class ReadAllEmployees implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database, History history) {
        System.out.println("Employee List:");
        for (Employee e : database.getEmployees()) {
            e.print();
        }
    }

    @Override
    public String getOption() {
        return "View All Employees";
    }
}
