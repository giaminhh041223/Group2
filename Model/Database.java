package Model;

import java.util.ArrayList;

public class Database {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product findProductById(String id) {
        return products.stream().filter(p -> p.getID().equals(id)).findFirst().orElse(null);
    }
    public Employee findEmployeeById(String id) {
        return employees.stream().filter(e -> e.getID().equals(id)).findFirst().orElse(null);
    }
}