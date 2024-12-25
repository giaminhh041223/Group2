package Controller;

import java.util.Scanner;

import History.History;
import Model.*;


import java.util.ArrayList;


public class ReadAllProducts implements Option {
	private Database database;
	
	public ReadAllProducts(Database database) {
        ArrayList<Product> products = database.getProducts();
        for (Product p : products) {
            p.print();
        System.out.println("--------------------------------");

        }
    }

    @Override
    public void operate(Employee user, Scanner s, Database database,History history) {
    	new ReadAllProducts(database);
    }

    @Override
    public String getOption() {
        return "View All Products";
    }
    
    
}
