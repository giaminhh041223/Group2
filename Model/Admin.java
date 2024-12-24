package Model;

import Controller.*;

public class Admin extends Employee {

    public Admin() {
        generateOptions();
    }

    public Admin(String name, String email, String password, double salary) {
         super(name, email, password, salary);
         generateOptions();
    }

    private void generateOptions() {
        this.options = new Option[] {
            new CreateEmployee(),
            new ViewStore()
        };
    }
}
