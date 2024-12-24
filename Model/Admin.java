package Model;

public class Admin extends Employee {

    public Admin() {
        generateOptions();
    }

    public Admin(String name, String email, String password, String workingtime, double salary) {
         super(name, email, password, workingtime, salary);
         generateOptions();
    }

    @Override
    public String getRole() {
        return "Admin";
    }

    private void generateOptions() {
        this.options = new Option[] {
            new CreateEmployee(),
            new DeleteEmployee(),
            new AddProduct(),
            new DeleteProduct(),
            new ViewStore()
        };
    }
}
