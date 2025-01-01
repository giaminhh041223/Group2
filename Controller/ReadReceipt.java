package Controller;

import Model.*;
import java.util.Scanner;
import History.*;

public class ReadReceipt implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database, FinancialSystem financialSystem, History history) {
        System.out.println("Enter receipt ID to view:");
        String ID = s.next();

        Receipt receipt = database.findReceiptById(ID);
        if (receipt == null) {
            System.out.println("Receipt not found.");
            return;
        }

        System.out.println("Receipt Details:");
        System.out.println("ID: " + receipt.getID());
        System.out.println("Cashier: " + receipt.getCashier().getName());
        System.out.println("Total: " + receipt.getTotal());
        System.out.println("Payment: " + receipt.getPaymentToString());
        System.out.println("Paid: " + receipt.getPaid());
        System.out.println("Change: " + receipt.getChange());
        System.out.println("Products:");
        for (Product product : receipt.getProducts()) {
            product.print();
        }
    }

    @Override
    public String getOption() {
        return "View Receipt";
    }
}
