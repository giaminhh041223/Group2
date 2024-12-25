package Controller;

import java.util.Scanner;

import History.History;
import Model.*;

public class CreateProduct implements Option {

    public void operate(Employee user, Scanner s, Database database,History history) {
        System.out.println("Enter product name:");
        String name = s.next();
        System.out.println("Enter product ID:");
        String ID = s.next();
        System.out.println("Enter type");
        String type = s.next();
        System.out.println("Enter product purchaseprice:");
        double purchaseprice = s.nextDouble();
        System.out.println("Enter product sellingprice:");
        double sellingprice = s.nextDouble();
        System.out.println("Enter product quantity:");
        int qty = s.nextInt();

        Product product;

        switch (type) {
            case "Stationary":
                product = new Stationary(ID, name, purchaseprice, sellingprice, qty);
                break;
            case "Toy":
                product = new Toy(ID, name, purchaseprice, sellingprice, qty);
                break;
            case "Book":
                product = new Book(ID, name, purchaseprice, sellingprice, qty);
                break;
            default:
                System.out.println("Invalid product type.");
                return;
        }

        database.getProducts().add(product);
        System.out.println("Product created successfully");
    }
    public String getOption() {
        return "Add New Product";
    }
}