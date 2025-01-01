package Controller;

import Model.*;
import java.util.Calendar;
import java.util.Scanner;
import History.*;

public class UpdateProduct implements Option {
	
    @Override
    public void operate(Employee user, Scanner s, Database database, History history) {
    	Calendar date= Calendar.getInstance();
        System.out.println("Enter product ID to update:");
        String ID = s.next();

        Product product = database.findProductById(ID);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.println("Enter new name (-1 to keep current: " + product.getName() + "):");
        String name = s.next();
        if (!name.equals("-1")) {
            history.addProductHistory("Update "+product.getName()+" 's name to "+name+" at "+date.toString(), date, product);
            product.setName(name);
        }

        System.out.println("Enter new purchase price (-1 to keep current: " + product.getPurchasePrice() + "):");
        double purchasePrice = s.nextDouble();
        if (purchasePrice != -1) {
            history.addProductHistory("Update "+product.getPurchasePrice()+" 's purchase price to "+purchasePrice+" at "+date.toString(), date, product);
            product.setPurchasePrice(purchasePrice);
        }

        System.out.println("Enter new selling price (-1 to keep current: " + product.getSellingPrice() + "):");
        double sellingPrice = s.nextDouble();
        if (sellingPrice != -1) {
            history.addProductHistory("Update "+product.getSellingPrice()+" 's selling price to "+sellingPrice+" at "+date.toString(), date, product);
            product.setSellingPrice(sellingPrice);
        }

        System.out.println("Enter new quantity (-1 to keep current: " + product.getQty() + "):");
        int qty = s.nextInt();

        if (qty != -1 && qty < product.getQty()) {
        	int changeQty=product.getQty()-qty;
            product.setQty(qty);
            history.addProductHistory("Remove "+changeQty+" "+product.getType()+": "+product.getName()+" at "+date.toString(), date, product);
        }else {
        	if (qty != -1 && qty > product.getQty()) {
            	int changeQty=-product.getQty()+qty;
        		 product.setQty(qty);
                 history.addProductHistory("Add "+changeQty+" "+product.getType()+": "+product.getName()+" at "+date.toString(), date, product);
        	}
        }
        System.out.println("Product updated successfully.");
    }

    @Override
    public String getOption() {
        return "Update Product";
    }
}
