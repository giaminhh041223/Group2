package Controller;

import Model.*;
import java.util.Scanner;
import History.*;

public class ViewHistory implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database, FinancialSystem financialSystem, History history) {
        while (true) {
            System.out.println("History Options:");
            System.out.println("1. View Employee History");
            System.out.println("2. View Product History");
            System.out.println("3. View Receipt History");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Employee History:");
                    history.displayEmployeeHistories();
                    break;
                case 2:
                    System.out.println("Product History:");
                    history.displayProductHistories();
                    break;
                case 3:
                    System.out.println("Receipt History:");
                    history.displayReceiptHistories();
                    break;
                case 4:
                    System.out.println("Exiting History View.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    @Override
    public String getOption() {
        return "View History";
    }
}
