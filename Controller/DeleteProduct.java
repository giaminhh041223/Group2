package Controller;

import java.util.Calendar;
import java.util.Scanner;
import History.History;
import Model.*;

public class DeleteProduct implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database, FinancialSystem financialSystem, History history) {
        System.out.println("Enter Product ID to delete:");
        String ID = s.next();
        
        Product product = database.findProductById(ID);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        // Kiểm tra nếu quantity != 0
        if (product.getQty() != 0) {
            System.out.println("Cannot delete product with remaining quantity: " + product.getQty());
            return;
        }
        
        database.getProducts().remove(product);
        System.out.println("Product deleted successfully.");
		Calendar date = Calendar.getInstance();
        history.addProductHistory("Deleted", date, product, product.getQty());
    }

    @Override
    public String getOption() {
        return "Delete Product";
    }
}
