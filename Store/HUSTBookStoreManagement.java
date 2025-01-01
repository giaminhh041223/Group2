package Store;

import java.util.ArrayList;
import java.util.Scanner;
import Model.*;
import Controller.*;
import History.*;

public class HUSTBookStoreManagement {
    public static void main(String[] args) {
        // Initialize the Database
        Database database = new Database();
        Cashier cashier1 = new Cashier("1", "Alice", "12", "1", 3500);
        Cashier cashier2 = new Cashier("2", "Bob", "bob@example.com", "securepass", 3700);
        Admin admin=new Admin("a1","admin","1","1",1000);
        
        // Products
        Stationary pen = new Stationary("101", "Ballpoint Pen", 0.5, 1.0, 100, "Bic", "Writing Tool");
        Stationary notebook = new Stationary("102", "Notebook", 2.0, 4.0, 50, "Camlin", "Writing Pad");
        Stationary eraser = new Stationary("103", "Eraser", 0.2, 0.5, 200, "Staedtler", "Rubber");
        ArrayList<Product> products1 = new ArrayList<>();
        products1.add(pen);
        products1.add(notebook);

        ArrayList<Product> products2 = new ArrayList<>();
        products2.add(eraser);
        Receipt receipt1 = new Receipt("R001", cashier1, products1, 5.0, 1, 5.0, 0.0); // Cash
        Receipt receipt2 = new Receipt("R002", cashier2, products2, 0.5, 2, 0.5, 0.0); // Visa
        
        database.getEmployees().add(cashier2);
        database.getEmployees().add(cashier1);
        database.getEmployees().add(admin);
        
        database.getProducts().add(pen);
        database.getProducts().add(notebook);        
        database.getProducts().add(eraser);


        new Login().operate(null, new Scanner(System.in), database, new History());
    }
}
