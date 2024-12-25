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
            new CreateProduct(),
            new DeleteEmployee(),
            new DeleteProduct(),
            new ChangePassword(),
            new ReadAllEmployees(),
            new ReadAllProducts(),
        };
    }

	public int getDepartment() {
		return 0;
	}
}
