package Model;

import Controller.*;

public class Cashier extends Employee {
	
    public Cashier() {
        generateOptions(); 
    }
    
    public Cashier(String ID, String name, String email, String password, double salary) {
        super(ID, name, email, password, salary);
        generateOptions();
    }

    public void generateOptions() {
        this.options = new Option[] {
            new CreateReceipt(),
            new ReadAllReceipts(),
            new ReadReceipt(),
            new ReadMyReceipts(),
            new ReadAllProducts(),
            new ReadAllProductsByType(),
            new CreateFinancialReport(),
            new ChangePassword(),
            new ExitSystem(),
        };
    }
    
	public int getDepartment() {
		return 1;
	}
}
