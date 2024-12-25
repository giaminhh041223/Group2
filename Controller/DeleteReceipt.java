package Controller;

import java.util.Calendar;
import java.util.Scanner;
import java.util.stream.Collectors;

import History.History;
import Model.Database;
import Model.Employee;
import Model.Option;
import Model.Receipt;

public class DeleteReceipt implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database,History history) {
        System.out.println("Enter receipt ID (-1 to show all receipts):");
        String ID = s.nextLine();
		boolean checkID=true;
		while (checkID) {
			for (Receipt r : database.getReceipts()) {
				if (ID==r.getID()) {
					checkID=false;
					break;
				}
			}
		}
        // Remove the receipt and associated products
        database.getReceipts().remove(database.findReceiptById(ID));
        Calendar date =Calendar.getInstance();
        history.addReceiptHistory("remove", date, database.findReceiptById(ID));
        System.out.println("Receipt deleted successfully.");
    }

    @Override
    public String getOption() {
        return "Remove Receipt";
    }
}
