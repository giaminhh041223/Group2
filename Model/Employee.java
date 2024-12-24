package Model;

public abstract class Employee {
    protected String name;
    protected String email;
    protected String password;
    protected double salary;
    protected Option[] options;

    public Employee() {

    }

    public Employee(String name, String email, String password, double salary) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getSalary() {
        return salary;
    }
}
