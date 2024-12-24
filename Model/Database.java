package Model;
import java.util.ArrayList;

public class Database {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Employee findEmployee(String email, String password) {
        for (Employee e : employees) {
            if (e.getEmail().equals(email) && e.getPassword().equals(password)) {
                return e;
            }
        }
        return null;
    }

    public Customer findCustomer(String email, String password) {
        for (Customer c : customers) {
            if (c.getEmail().equals(email) && c.getPassword().equals(password)) {
                return c;
            }
        }
        return null;
    }
}
