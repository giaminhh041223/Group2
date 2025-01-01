package Controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import History.*;
import Model.*;

public class CreateReceipt implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database, History history) {
        System.out.println("Enter Receipt ID:");
        String ID = s.next();

        if (database.findReceiptById(ID) != null) {
            System.out.println("Receipt ID already exists. Aborting receipt creation.");
            return;
        }
        
        ArrayList<Product> products = new ArrayList<>();
        System.out.println("Enter number of products:");
        int productCount = s.nextInt();

        double total = 0;
        for (int i = 0; i < productCount; i++) {
            System.out.println("Enter Product ID:");
            String productID = s.next();
            Product product = database.findProductById(productID);
            
            if (product == null) {
                System.out.println("Invalid product ID. Aborting receipt creation.");
                return;
            }
            
            System.out.println("Enter quantity to purchase:");
            int qty = s.nextInt();
            if (qty > product.getQty()) {
                System.out.println("Insufficient stock. Aborting..");
                return;
            }

            if (qty <= 0) {
                System.out.println("Invalid quantity. Aborting...");
                return;
            }

            Product purchasedProduct = null;
            
            if (product instanceof Toy) {
                Toy toy = (Toy) product;
                purchasedProduct = new Toy(toy.getID(), toy.getName(), toy.getPurchasePrice(), toy.getSellingPrice(), qty, toy.getBrand(), toy.getSuitableAge());
            } else if (product instanceof Book) {
                Book book = (Book) product;
                purchasedProduct = new Book(book.getID(), book.getName(), book.getPurchasePrice(), book.getSellingPrice(), qty, book.getPublisher(), book.getAuthor());
            } else if (product instanceof Stationary) {
                Stationary stationary = (Stationary) product;
                purchasedProduct = new Stationary(stationary.getID(), stationary.getName(), stationary.getPurchasePrice(), stationary.getSellingPrice(), qty, stationary.getBrand(), stationary.getStationaryType());
            } 

            product.setQty(product.getQty() - qty);
            if (purchasedProduct != null) {
                products.add(purchasedProduct);
                total += purchasedProduct.getSellingPrice() * qty;
            }
        }

        int payment = 0;
        while (true) {
            System.out.println("Enter payment type (1 for Cash, 2 for Visa):");
            payment = s.nextInt();
            if (payment == 1 || payment == 2) {
                break;
            } else {
                System.out.println("Invalid payment type. Please enter 1 for Cash or 2 for Visa.");
            }
        }
        double paid = 0;
        while (true) {
            System.out.println("Enter amount paid:");
            paid = s.nextDouble();
            if (paid < total) {
                System.out.println("Insufficient payment. Please enter an amount greater than or equal to the total: " + total);
            } else {
                break;
            }
        }

        double change = paid - total;
        Receipt receipt = new Receipt(ID, user, products, total, payment, paid, change);
        database.getReceipts().add(receipt);
        System.out.println("Receipt created successfully.");
        Calendar date = Calendar.getInstance();
        history.addReceiptHistory("Create receipt "+receipt.getID()+" at "+date.toString(), date, receipt);
    }

    @Override
    public String getOption() {
        return "Create New Receipt";
    }
}
