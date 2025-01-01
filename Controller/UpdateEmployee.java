package Controller;

import java.util.Calendar;
import java.util.Scanner;
import History.*;
import Model.*;

public class UpdateEmployee implements Option {
	
    @Override
    public void operate(Employee user, Scanner s, Database database, History history) {
        Calendar date = Calendar.getInstance();

        System.out.println("Enter employee ID to update:");
        String ID = s.next();

        Employee emp = database.findEmployeeById(ID);
        if (emp == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.println("Enter new name (-1 to keep current: " + emp.getName() + "):");
        String name = s.next();
        if (!name.equals("-1")) {
            history.addEmployeeHistory("Update "+emp.getName()+" 's name to "+name+" at "+date.toString(), date, emp);
            emp.setName(name);


        }

        System.out.println("Enter new email (-1 to keep current: " + emp.getEmail() + "):");
        String email = s.next();
        if (!email.equals("-1")) {
            history.addEmployeeHistory("Update "+emp.getEmail()+" 's mail to "+email+" at "+date.toString(), date, emp);
            emp.setEmail(email);
        }

        System.out.println("Enter new salary (-1 to keep current: " + emp.getSalary() + "):");
        double salary = s.nextDouble();
        if (salary != -1) {
            history.addEmployeeHistory("Update "+emp.getSalary()+" 's salary to "+salary+" at "+date.toString(), date, emp);
            emp.setSalary(salary);
        }
        System.out.println("Employee's data has been updated successfully");
    }

    @Override
    public String getOption() {
        return "Update Employee";
    }
}
