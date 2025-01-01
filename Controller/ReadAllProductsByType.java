package Controller;

import Model.*;

import java.util.Scanner;

import History.*;

public class ReadAllProductsByType implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database, History history) {
        System.out.println("Enter product type to view (Stationary, Toy, Book):");
        String type = s.next(); // Read the input as-is

        boolean isValidType = false; // Flag to check if the type is valid

        if (type.equalsIgnoreCase("Stationary") || type.equalsIgnoreCase("Toy") || type.equalsIgnoreCase("Book")) {
            System.out.println("Products of type: " + capitalize(type));
            for (Product product : database.getProducts()) {
                if ((type.equalsIgnoreCase("Stationary") && product instanceof Stationary) ||
                    (type.equalsIgnoreCase("Toy") && product instanceof Toy) ||
                    (type.equalsIgnoreCase("Book") && product instanceof Book)) {
                    product.print();
                    isValidType = true;
                }
            }
        } else {
            System.out.println("Invalid type. Please enter Stationary, Toy, or Book.");
        }
    }

    @Override
    public String getOption() {
        return "View Products by Type";
    }

    // Helper method to capitalize the first letter of a word
    private String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
