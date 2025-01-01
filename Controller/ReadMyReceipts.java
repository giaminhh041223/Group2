package Controller;

import Model.*;
import java.util.Scanner;
import History.*;

public class ReadMyReceipts implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database, FinancialSystem financialSystem, History history) {

        System.out.println("Receipts created by: " + user.getName());
        for (Receipt receipt : database.getReceipts()) {
            if (receipt.getCashier().getID().equals(user.getID())) {
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
        return "View My Receipts";
    }
}
