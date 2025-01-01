package Controller;

import Model.*;
import java.util.Calendar;
import java.util.Scanner;
import History.*;

public class UpdateProduct implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database, History history) {
        System.out.println("Enter product ID to update:");
        String ID = s.next();

        Product product = database.findProductById(ID);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        int previousQuantity = product.getQty();
        boolean isUpdate = false;

        System.out.println("Enter new name (-1 to keep current: " + product.getName() + "):");
        String name = s.next();
        if (!name.equals("-1")) {
            product.setName(name);
            isUpdate = true;
        }

        System.out.println("Enter new purchase price (-1 to keep current: " + product.getPurchasePrice() + "):");
        double purchasePrice = s.nextDouble();
        if (purchasePrice != -1) {
            product.setPurchasePrice(purchasePrice);
            isUpdate = true;
        }

        System.out.println("Enter new selling price (-1 to keep current: " + product.getSellingPrice() + "):");
        double sellingPrice = s.nextDouble();
        if (sellingPrice != -1) {
            product.setSellingPrice(sellingPrice);
            isUpdate = true;
        }

        System.out.println("Enter new quantity (-1 to keep current: " + product.getQty() + "):");
        int qty = s.nextInt();
        if (qty != -1) {
            product.setQty(qty);
            isUpdate = true;
        }

        if (isUpdate) {
            Calendar date = Calendar.getInstance();
            history.addProductHistory("Updated", date, product, previousQuantity);
            System.out.println("Product updated successfully.");
        }
        else System.out.println("Nothing has changed.");
    }

    @Override
    public String getOption() {
        return "Update Product";
    }
}
