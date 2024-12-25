package Controller;

import Model.Admin;
import Model.Cashier;
import Model.Database;
import Model.Employee;
import Model.Storekeeper;

public class Login {

    private Employee employee;
    private boolean loggedIn;

    public Login(String email, String password, Database database) {
        this.loggedIn = false;
        for (Employee e : database.getEmployees()) {
            if (e.getEmail().equals(email) && e.getPassword().equals(password)) {
                this.loggedIn = true;
                e.generateOptions();
                break;
            }
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public Employee getUser() {
        return employee;
    }
}
