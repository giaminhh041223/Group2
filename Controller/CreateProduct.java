package Controller;

import java.util.Scanner;
import Model.*;

public class CreateProduct {
    public void execute(Product product, Database database) {
        database.addProduct(product);
        System.out.println("Product created successfully");
    }

    public void oper(Scanner s, Database database) {
        System.out.println("Enter product type (1. Stationary, 2. Toy, 3. Book):");
        int type = s.nextInt();

        System.out.println("Enter product name:");
        String name = s.next();
        System.out.println("Enter product ID:");
        String ID = s.next();
        System.out.println("Enter product purchaseprice:");
        double purchaseprice = s.nextDouble();
        System.out.println("Enter product sellingprice:");
        double sellingprice = s.nextDouble();
        System.out.println("Enter product quantity:");
        int qty = s.nextInt();

        Product product;

        switch (type) {
            case 1:
                product = new Stationary(ID, name, purchaseprice, sellingprice, qty);
                break;
            case 2:
                product = new Toy(ID, name, purchaseprice, sellingprice, qty);
                break;
            case 3:
                product = new Book(ID, name, purchaseprice, sellingprice, qty);
                break;
            default:
                System.out.println("Invalid product type.");
                return;
        }

        execute(product, database);
    }
}
