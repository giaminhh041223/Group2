package Controller;

import java.util.Calendar;
import java.util.Scanner;
import History.History;
import Model.*;

public class DeleteReceipt implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database, History history) {
        System.out.println("Enter receipt ID to delete:");
        String ID = s.next();

        Receipt receipt = database.findReceiptById(ID);
        if (receipt == null) {
            System.out.println("Receipt not found.");
            return;
        }

        database.getReceipts().remove(receipt);
        System.out.println("Receipt deleted successfully.");
        Calendar date = Calendar.getInstance();
        history.addReceiptHistory("Delete", date, receipt);
    }

    @Override
    public String getOption() {
        return "Delete Receipt";
    }
}
