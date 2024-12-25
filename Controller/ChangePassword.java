package Controller;

import java.util.Calendar;
import java.util.Scanner;
import Model.Database;
import Model.Employee;
import Model.Option;
import History.History;

public class ChangePassword implements Option {

    @Override
    public void operate(Employee user, Scanner scanner, Database database, History history) {
        System.out.println("Enter old password:");
        String oldPass = scanner.next();

        if (!oldPass.equals(user.getPassword())) {
            System.out.println("Incorrect password\nTry again later");
            return;
        }

        System.out.println("Enter new password:");
        String newPass = scanner.next();
        System.out.println("Confirm password:");
        String confirmPass = scanner.next();

        if (!newPass.equals(confirmPass)) {
            System.out.println("Password doesn't match\nTry again later");
            return;
        }

        user.setPassword(confirmPass);
        Calendar date= Calendar.getInstance();
        history.addEmployeeHistory("Changed password to "+newPass,date,user);
    }

    @Override
    public String getOption() {
        return "Change Password";
    }
}
