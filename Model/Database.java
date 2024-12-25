package Model;

import java.util.ArrayList;

public class Database {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Receipt> receipts =new ArrayList<>();

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Receipt> getReceipts() {
		return receipts;
	}

	public Product findProductById(String id) {
        return products.stream().filter(p -> p.getID().equals(id)).findFirst().orElse(null);
    }
    public Employee findEmployeeById(String id) {
        return employees.stream().filter(e -> e.getID().equals(id)).findFirst().orElse(null);
    }
    public Receipt findReceiptById(String id) {
        return receipts.stream().filter(p -> p.getID().equals(id)).findFirst().orElse(null);
    }
}