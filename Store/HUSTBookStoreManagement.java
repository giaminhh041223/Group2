package Store;

import java.util.Scanner;
import Controller.*;
import History.History;
import Model.*;

public class HUSTBookStoreManagement {
    public static void main(String[] args) {
        Database database = new Database();

        Admin admin = new Admin("A001", "Alice Johnson", "alice.johnson@example.com", "adminPass789", 5000.00);
        Cashier cashier1 = new Cashier("C001", "John Doe", "john.doe@example.com", "password123", 2500.00);
        Storekeeper storekeeper1 = new Storekeeper("S001", "Jane Smith", "jane.smith@example.com", "securePass456", 3000.00);
        Cashier cashier2 = new Cashier("C002", "Emily Davis", "emily.davis@example.com", "password789", 2600.00);
        Storekeeper storekeeper2 = new Storekeeper("S002", "Michael Brown", "michael.brown@example.com", "storePass123", 3100.00);

        database.getEmployees().add(admin);
        database.getEmployees().add(cashier1);
        database.getEmployees().add(storekeeper1);
        database.getEmployees().add(cashier2);
        database.getEmployees().add(storekeeper2);

        new Login().operate(null, new Scanner(System.in), database, new History());
    }
}
