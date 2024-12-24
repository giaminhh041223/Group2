package Controller;

import java.util.ArrayList;
import java.util.Scanner;
import Model.Database;
import Model.Product;
import Model.Receipt;


public class CreateReceipt {
    public void execute(Receipt receipt, Database database) {
        System.out.println("Receipt created successfully with the following products:");
        receipt.getProducts().forEach(Product::print);
    }

    public void oper(Scanner s, Database database) {
        ArrayList<Product> products = new ArrayList<>();
        double total = 0;

        System.out.println("Add products to the receipt (Enter -1 to finish):");
        while (true) {
            System.out.println("Enter product ID:");
            int id = s.nextInt();
            if (id == -1) break;

            Product product = database.findProductById(id);
            if (product == null) {
                System.out.println("Product not found.");
                continue;
            }

            System.out.println("Enter quantity:");
            int qty = s.nextInt();
            if (qty > product.getQty()) {
                System.out.println("Not enough stock available.");
                continue;
            }

            product.setQty(product.getQty() - qty);
            Product purchasedProduct = new Product(product.getID(), product.getName(), product.getDescription(), product.getPrice(), qty);
            products.add(purchasedProduct);
            total += product.getPrice() * qty;
        }

        System.out.println("Total amount: " + total);

        Receipt receipt = new Receipt();
        receipt.setProducts(products);
        receipt.setTotal(total);

        execute(receipt, database);
    }
}
