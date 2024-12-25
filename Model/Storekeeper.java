package Model;

import Controller.*;

public class Storekeeper extends Employee {
	public Storekeeper(String ID, String name, String email,String password, double salary) {
		super(ID,name,email,password,salary);
	}
	public Storekeeper(){
		generateOptions();
	}
	
	public void generateOptions() {
        this.options = new Option[] {
        };
	}
	
	@Override
	public int getDepartment() {
		return 2;
	}

}

