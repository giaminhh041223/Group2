package Model;
public class Cashier extends Employee {
	private double salary;
	
    public Cashier() {
        this.options = new Option[] {};    
    }
    
    public Cashier(String ID, String name, String email, String password) {
        super(ID, name, email, password);
    }
    
    public Cashier(String ID, String name, String email, String password, double salary) {
        super(ID, name, email, password);
        this.salary=salary;
        
    }

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDepartment() {
		return 1;
	}
}
