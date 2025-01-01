package Controller;

import java.util.Calendar;
import java.util.Scanner;
import History.History;
import Model.*;

public class CreateProduct implements Option {

    public void operate(Employee user, Scanner s, Database database, History history) {
        System.out.println("Enter product name:");
        String name = s.next();
        System.out.println("Enter product ID:");
        String ID = s.next();

        if (database.findProductById(ID) != null) {
            System.out.println("Product ID already exists. Use UpdateProduct to modify quantity.");
            return;
        }

        System.out.println("Enter product purchase price:");
        double purchasePrice = s.nextDouble();
        System.out.println("Enter product selling price:");
        double sellingPrice = s.nextDouble();
        System.out.println("Enter product quantity:");
        int qty = s.nextInt();
        System.out.println("Enter type (Stationary, Toy, Book)");
        String type = s.next();

        Product product;
        switch (type) {
            case "Stationary":
                System.out.println("Enter brand:");
                String stationaryBrand = s.next();
                System.out.println("Enter stationary type:");
                String stationaryType = s.next();
                product = new Stationary(ID, name, purchasePrice, sellingPrice, qty, stationaryBrand, stationaryType);
                break;
            case "Toy":
                System.out.println("Enter brand:");
                String toyBrand = s.next();
                System.out.println("Enter suitable age:");
                String suitableAge = s.next();
                product = new Toy(ID, name, purchasePrice, sellingPrice, qty, toyBrand, suitableAge);
                break;
            case "Book":
                System.out.println("Enter publisher:");
                String publisher = s.next();
                System.out.println("Enter author:");
                String author = s.next();
                product = new Book(ID, name, purchasePrice, sellingPrice, qty, publisher, author);
                break;
            default:
                System.out.println("Invalid product type.");
                return;
        }

        database.getProducts().add(product);
        System.out.println("Product created successfully");
        Calendar date = Calendar.getInstance();
        history.addProductHistory("Created", date, product, 0);
    }
    public String getOption() {
        return "Add New Product";
    }
}