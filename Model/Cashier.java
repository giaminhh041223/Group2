package Model;
public class Cashier extends Employee {

    public Cashier() {
        this.options = new Option[] {};    
    }
    
    public Cashier(String name, String email, String password, String workingtime, double salary) {
        super(name, email, password, workingtime, salary);
    }

    @Override
    public String getRole() {
        return "Cashier";
    }
}
