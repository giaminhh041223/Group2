package Model;

import Controller.*;

public class Storekeeper extends Employee {
	private double salary;
	public Storekeeper(String ID, String name, String email,
			double salary, String password) {
		super(ID,name,email,password);
		this.salary = salary;
	}
	public Storekeeper(){
		generateOptions();
	}
	
	private void generateOptions() {
        this.options = new Option[] {
        };
	}
	
	@Override
	public int getDepartment() {
		return 2;
	}

}

