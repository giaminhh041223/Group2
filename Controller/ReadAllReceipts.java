package Controller;

import Model.*;
import java.util.Scanner;
import History.*;

public class ReadAllReceipts implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database, History history) {
        System.out.println("All Receipts:");
        for (Receipt receipt : database.getReceipts()) {
            System.out.println("Receipt ID: " + receipt.getID());
            System.out.println("Total: " + receipt.getTotal());
            System.out.println("Cashier: " + receipt.getCashier().getName());
            System.out.println("Payment: " + receipt.getPaymentToString());
            System.out.println("Products:");
            for (Product product : receipt.getProducts()) {
                product.print();
            }
            System.out.println("--------------------------------");
        }
    }

    @Override
    public String getOption() {
        return "View All Receipts";
    }    
}
