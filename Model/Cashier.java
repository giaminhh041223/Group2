package Model;

public class Cashier extends Employee {
	
    public Cashier() {
        this.options = new Option[] {};    
    }
    
    public Cashier(String ID, String name, String email, String password, double salary) {
        super(ID, name, email, password,salary);
    }

    public void generateOptions() {
        this.options = new Option[] {
            
        };
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
