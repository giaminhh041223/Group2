package Model;
import Controller.*;

public class Admin extends Employee {

    public Admin() {
        generateOptions();
    }

    public Admin(String ID, String name, String email, String password, double salary) {
         super(ID, name, email, password,salary);
         generateOptions();
    }

    public void generateOptions() {
        this.options = new Option[] {
            new CreateEmployee(),
            new ReadAllEmployees(),
            new UpdateEmployee(),
            new DeleteEmployee(),
            new CreateProduct(),
            new ReadAllProducts(),
            new ReadAllProductsByType(),
            new UpdateProduct(),
            new DeleteProduct(),
            new CreateReceipt(),
            new ReadMyReceipts(),
            new ReadReceipt(),
            new ReadAllReceipts(),
            new ReadCashierReceipts(),
            new ChangePassword(),
            new ViewHistory(),
            new CreateFinancialReport(),
            new ExitSystem(),
        };
    }

    @Override
	public int getDepartment() {
		return 0;
	}
}
