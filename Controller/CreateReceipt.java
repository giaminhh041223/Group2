package Controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import History.*;
import Model.*;

public class CreateReceipt implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database, History history) {
        System.out.println("Enter Receipt ID:");
        String ID = s.next();
        
        System.out.println("Enter Cashier ID:");
        String cashierID = s.next();
        Employee cashier = database.findEmployeeById(cashierID);
        
        if (cashier == null || !(cashier instanceof Cashier)) {
            System.out.println("Invalid cashier ID.");
            return;
        }
        
        ArrayList<Product> products = new ArrayList<>();
        System.out.println("Enter number of products:");
        int productCount = s.nextInt();
        
        for (int i = 0; i < productCount; i++) {
            System.out.println("Enter Product ID:");
            String productID = s.next();
            Product product = database.findProductById(productID);
            
            if (product == null) {
                System.out.println("Invalid Product ID. Skipping...");
                continue;
            }
            products.add(product);
        }
        
        System.out.println("Enter total amount:");
        double total = s.nextDouble();
        System.out.println("Enter payment type (1 for Cash, 2 for Visa):");
        int payment = s.nextInt();
        System.out.println("Enter amount paid:");
        double paid = s.nextDouble();
        
        double change = paid - total;
        Receipt receipt = new Receipt(ID, cashier, products, total, payment, paid, change);
        database.getReceipts().add(receipt);
        System.out.println("Receipt created successfully.");
        Calendar date = Calendar.getInstance();
        history.addReceiptHistory("Created", date, receipt);
    }

    @Override
    public String getOption() {
        return "Create New Receipt";
    }
}
