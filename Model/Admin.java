package Model;

import java.util.ArrayList;

import Controller.*;

public class Admin extends Employee {
    public Admin() {
        generateOptions();
    }

    public Admin(String ID, String name, String email, String password) {
         super(ID, name, email, password);
         generateOptions();
    }

    public void generateOptions() {
        this.options = new Option[] {
            new CreateEmployee(),
            new ViewStore()
        };
    }
	public int getDepartment() {
		return 0;
	}
}
