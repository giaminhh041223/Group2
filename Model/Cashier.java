package Model;
public class Cashier extends Employee {

    public Cashier() {
        this.options = new Option[] {};    
    }
    
    public Cashier(String name, String email, String password, double salary) {
        super(name, email, password, salary);
    }
}
