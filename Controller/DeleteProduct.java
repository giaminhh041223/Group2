package Controller;

import java.util.Calendar;
import java.util.Scanner;
import History.History;
import Model.*;

public class DeleteProduct implements Option {
	public void deleteProduct(String ID,Database database) {
		database.getProducts().remove(database.findProductById(ID));
	}

	@Override
	public void operate(Employee user, Scanner s, Database database,History history) {
		System.out.println("Enter product ID (-1 to show all products):");
		String ID = s.nextLine();
		boolean checkID=true;
		while (checkID) {
			for (Product p : database.getProducts()) {
				if (ID==p.getID()){
					checkID=false;
					break;
				}
			}
			new ReadAllProducts(database);
			System.out.println("Enter product ID (-1 to show all products):");
			ID = s.nextLine();
			
		}
		Calendar date = Calendar.getInstance();
		history.addProductHistory("Remove", date, database.findProductById(ID));
		deleteProduct(ID, database);
	}

	@Override
	public String getOption() {
		return "Delete Product";
	}

}
