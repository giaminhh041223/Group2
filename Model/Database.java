package Model;

import java.util.ArrayList;
import java.util.Calendar;
import History.History;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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

    public void loadData(String employeeFilePath, String productFilePath, Database database, History history) {
        loadEmployees(employeeFilePath, database, history);
        loadProducts(productFilePath, database, history);
    }
    
    public void loadEmployees(String fileName, Database database, History history) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            
            // Bỏ qua tiêu đề
            line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String id = values[0];
                String name = values[1];
                String email = values[2];
                String password = values[3];
                double salary = Double.parseDouble(values[4]);
                String type = values[5];

                Employee employee;
                switch (type) {
                    case "Admin":
                        employee = new Admin(id, name, email, password, salary);
                        break;
                    case "Cashier":
                        employee = new Cashier(id, name, email, password, salary);
                        break;
                    case "Storekeeper":
                        employee = new Storekeeper(id, name, email, password, salary);
                        break;
                    default:
                        System.out.println("Invalid employee type in file: " + type);
                        continue;
                }
                database.getEmployees().add(employee);

                // Lưu vào lịch sử
                Calendar date = Calendar.getInstance();
                history.addEmployeeHistory("Created", date, employee);
            }
        } catch (Exception e) {
            System.err.println("Error reading employee file: " + e.getMessage());
        }
    }
    
    public void loadProducts(String fileName, Database database, History history) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;

            // Bỏ qua dòng tiêu đề
            line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String id = values[0];
                String name = values[1];
                double purchasePrice = Double.parseDouble(values[2]);
                double sellingPrice = Double.parseDouble(values[3]);
                int quantity = Integer.parseInt(values[4]);
                String type = values[5];

                Product product;
                switch (type) {
                    case "Stationary":
                        String stationaryBrand = values[6];
                        String stationaryType = values[7];
                        product = new Stationary(id, name, purchasePrice, sellingPrice, quantity, stationaryBrand, stationaryType);
                        break;
                    case "Toy":
                        String toyBrand = values[6];
                        String suitableAge = values[7];
                        product = new Toy(id, name, purchasePrice, sellingPrice, quantity, toyBrand, suitableAge);
                        break;
                    case "Book":
                        String publisher = values[6];
                        String author = values[7];
                        product = new Book(id, name, purchasePrice, sellingPrice, quantity, publisher, author);
                        break;
                    default:
                        System.out.println("Invalid product type in file: " + type);
                        continue;
                }
                database.getProducts().add(product);

                // Lưu vào lịch sử
                Calendar date = Calendar.getInstance();
                history.addProductHistory("Created", date, product, 0);
            }
        } catch (Exception e) {
            System.err.println("Error reading product file: " + e.getMessage());
        }
    }
}