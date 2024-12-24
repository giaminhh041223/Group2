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

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product findProductById(String id) {
        return products.stream().filter(p -> p.getID().equals(id)).findFirst().orElse(null);
    }
}