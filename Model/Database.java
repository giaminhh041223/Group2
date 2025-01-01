package Model;

import java.io.*;
import java.util.ArrayList;

public class Database {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Receipt> receipts = new ArrayList<>();

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
        return receipts.stream().filter(r -> r.getID().equals(id)).findFirst().orElse(null);
    }

    // Load data from a file
    public void loadData(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                switch (parts[0]) {
                    case "Cashier":
                        employees.add(new Cashier(parts[1], parts[2], parts[3], parts[4], Double.parseDouble(parts[5])));
                        break;
                    case "Admin":
                        employees.add(new Admin(parts[1], parts[2], parts[3], parts[4], Double.parseDouble(parts[5])));
                        break;
                    case "Product":
                        products.add(new Stationary(parts[1], parts[2], Double.parseDouble(parts[3]), Double.parseDouble(parts[4]), Integer.parseInt(parts[5]), parts[6], parts[7]));
                        break;
                    case "Receipt":
                        Employee employee = findEmployeeById(parts[2]);
                        String[] productNames = parts[3].split(", ");
                        ArrayList<Product> receiptProducts = new ArrayList<>();
                        for (String name : productNames) {
                            products.stream().filter(p -> p.getName().equals(name)).findFirst().ifPresent(receiptProducts::add);
                        }
                        receipts.add(new Receipt(parts[1], employee, receiptProducts, Double.parseDouble(parts[4]), 0, Double.parseDouble(parts[5]), Double.parseDouble(parts[6])));
                        break;
                }
            }
            System.out.println("Data loaded successfully from " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading from file.");
            e.printStackTrace();
        }
    }
}
