package Controller;

import java.util.Scanner;
import History.History;
import Model.*;

public class ReadAllProducts implements Option {
	
    @Override
    public void operate(Employee user, Scanner s, Database database, History history) {
        System.out.println("Product List:");
        for (Product p : database.getProducts()) {
            p.print();
        }
    }

    @Override
    public String getOption() {
        return "View All Products";
    }
    
    
}
