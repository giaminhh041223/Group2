package Controller;

import Model.*;
import java.util.Scanner;
import History.*;

public class ReadAllProductsByType implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database, FinancialSystem financialSystem, History history) {
        System.out.println("Enter product type to view (Stationary, Toy, Book):");
        String type = s.next();

        System.out.println("Products of type: " + type);
        for (Product product : database.getProducts()) {
            if ((type.equalsIgnoreCase("Stationary") && product instanceof Stationary) ||
                (type.equalsIgnoreCase("Toy") && product instanceof Toy) ||
                (type.equalsIgnoreCase("Book") && product instanceof Book)) {
                product.print();
            }
        }
    }

    @Override
    public String getOption() {
        return "View Products by Type";
    }    
}
