package Controller;

import Model.*;
import java.util.Scanner;
import History.*;

public class ReadCashierReceipts implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database, FinancialSystem financialSystem, History history) {
        System.out.println("Enter cashier ID to view their receipts:");
        String cashierID = s.next();

        Employee cashier = database.findEmployeeById(cashierID);
        if (cashier == null || cashier instanceof Storekeeper) {
            System.out.println("Invalid cashier ID.");
            return;
        }

        System.out.println("Receipts created by: " + cashier.getName());
        for (Receipt receipt : database.getReceipts()) {
            if (receipt.getCashier().getID().equals(cashierID)) {
                System.out.println("Receipt ID: " + receipt.getID());
                System.out.println("Total: " + receipt.getTotal());
                System.out.println("Payment: " + receipt.getPaymentToString());
                System.out.println("Paid: " + receipt.getPaid());
                System.out.println("Change: " + receipt.getChange());
                System.out.println("Products:");
                for (Product product : receipt.getProducts()) {
                    product.print();
                }
                System.out.println("--------------------------------");
            }
        }
    }

    @Override
    public String getOption() {
        return "View Cashier Receipts";
    }
}
