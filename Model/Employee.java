package Model;

import java.util.Scanner;
import History.History;

public abstract class Employee {
	protected String ID;
    protected String name;
    protected String email;
    protected String password;
    protected int department;
    protected Option[] options;
    protected double salary;

    public Employee() {

    }

    public Employee(String ID,String name, String email, String password, double salary) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.salary= salary;
        this.ID=ID;
    }
    
    public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public abstract void generateOptions();

    public String getName() {
        return name;
    }

    public Option[] getOptions() {
		return options;
	}

	public void setOptions(Option[] options) {
		this.options = options;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public abstract int getDepartment();
	// 0 ==> Admin
	// 1 ==> Cashier
	// 2 ==> Storekeeper
    
    public String getDepartmentToString() {
		String dept;
		switch (getDepartment()) {
		case 0:
			dept = "Manager";
			break;
		case 1:
			dept = "Cashier";
			break;
		case 2:
			dept = "Storekeeper";
			break;
			default:
				dept = "Invalid";
				break;
		}
		return dept;
	}
    public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public void print() {
		System.out.println("--------------------------------");
		System.out.println("ID: "+getID());
		System.out.println("Name: "+getName());
		System.out.println("Email: "+getEmail());
		System.out.println("Department: "+getDepartmentToString());
	}

	public void showList(Scanner s, Database database, FinancialSystem financialSystem, History history) {
		System.out.println("-----------------------");
		for (int i=1; i<=options.length; i++) {
			System.out.println(i+". "+options[i-1].getOption());
		}
		System.out.println("-----------------------");
		
		int selected = s.nextInt();
		options[selected-1].operate(this, s, database, financialSystem, history);
		showList(s, database, financialSystem, history);
	}
	
}
