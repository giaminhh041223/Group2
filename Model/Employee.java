package Model;
import java.util.Scanner;

public abstract class Employee implements UserType {
    protected String name;
    protected String email;
    protected String password;
    protected double salary;
    protected Option[] options;

    public Employee() {

    }

    public Employee(String name, String email, String password, String workingtime, double salary) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.workingtime = workingtime;
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

    public abstract String getRole();

    @Override
    public void showOptions(Scanner scanner, Database database) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i+1) + ". " + options[i].getOption());
        }

        int choice = scanner.nextInt();
        options[choice - 1].operate(this, scanner, database);
    }
}
