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
        System.out.println("Enter type");
        String type = s.next();
        System.out.println("Enter product purchase price:");
        double purchasePrice = s.nextDouble();
        System.out.println("Enter product selling price:");
        double sellingPrice = s.nextDouble();
        System.out.println("Enter product quantity:");
        int qty = s.nextInt();

        Product existingProduct = database.findProductById(ID);
        if (existingProduct != null &&
            existingProduct.getName().equals(name) &&
            existingProduct.getPurchasePrice() == purchasePrice &&
            existingProduct.getSellingPrice() == sellingPrice) {
            System.out.println("Product with same details already exists. Use UpdateProduct to modify quantity.");
            return;
        }

        Product product;
        switch (type) {
            case "Stationary":
                product = new Stationary(ID, name, purchasePrice, sellingPrice, qty);
                break;
            case "Toy":
                product = new Toy(ID, name, purchasePrice, sellingPrice, qty);
                break;
            case "Book":
                product = new Book(ID, name, purchasePrice, sellingPrice, qty);
                break;
            default:
                System.out.println("Invalid product type.");
                return;
        }

        database.getProducts().add(product);
        System.out.println("Product created successfully");
        Calendar date = Calendar.getInstance();
        history.addProductHistory(type, date, product);
    }
    public String getOption() {
        return "Add New Product";
    }
}