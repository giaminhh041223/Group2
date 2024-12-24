package Controller;

import java.util.ArrayList;

import History.History;
import java.util.Scanner;
import Model.Database;
import Model.Product;
import Model.Receipt;
import java.util.Calendar;

public class CreateReceipt {
	Calendar cur=Calendar.getInstance();

    public void execute(Receipt receipt, Database database) {
        System.out.println("Receipt created successfully with the following products:");
        receipt.getProducts().forEach(Product::print);
    }

    public void oper(Scanner s, Database database,History history) {
        ArrayList<Product> products = new ArrayList<>();
        double total = 0;

        System.out.println("Add products to the receipt (Enter -1 to finish):");
        while (true) {
            System.out.println("Enter product ID:");
            String id = s.next();
            if (id == "-1") break;

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
            Product purchasedProduct = null;
            purchasedProduct.setID(product.getID());
            purchasedProduct.setName(product.getName());
            purchasedProduct.setPurchasePrice(product.getPurchasePrice());
            purchasedProduct.setSellingPrice(product.getSellingPrice());
            purchasedProduct.setQty(product.getQty());
            products.add(purchasedProduct);
            total += product.getSellingPrice() * qty;
        }

        System.out.println("Total amount: " + total);

        Receipt receipt = new Receipt();
        receipt.setProducts(products);
        receipt.setTotal(total);
        Calendar cur= Calendar.getInstance();
        history.addReceiptHistory("execute", cur, receipt);
        execute(receipt, database);
    }
}
