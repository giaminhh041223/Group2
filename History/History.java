package History;

import java.util.ArrayList;
import java.util.Calendar;
import Model.Product;
import Model.Receipt;
import Model.Employee;

public class History {
    private ArrayList<ProductHistory> productHistories;
    private ArrayList<ReceiptHistory> receiptHistories;
    private ArrayList<EmployeeHistory> employeeHistories;

    public History() {
        this.productHistories = new ArrayList<>();
        this.receiptHistories = new ArrayList<>();
        this.employeeHistories = new ArrayList<>();
    }

    public void addProductHistory(String action, Calendar date, Product product, int previousQuantity) {
        productHistories.add(new ProductHistory(action, date, product, previousQuantity));
    }

    public void addReceiptHistory(String action, Calendar date, Receipt receipt) {
        ReceiptHistory receiptHistory = new ReceiptHistory(action, date, receipt);
        receiptHistories.add(receiptHistory);
    }

    public void addEmployeeHistory(String action, Calendar date, Employee employee) {
        EmployeeHistory employeeHistory = new EmployeeHistory(action, date, employee);
        employeeHistories.add(employeeHistory);
    }

    public void displayProductHistories() {
        for (ProductHistory ph : productHistories) {
            System.out.println(ph);
        }
    }

    public ArrayList<String> getProductHistories() {
        ArrayList<String> logs = new ArrayList<>();
        for (ProductHistory ph : productHistories) {
            logs.add(ph.toString());
        }
        return logs;
    }

    public Calendar getLogDate(String log) {
        String[] parts = log.split(", ");
        Calendar cal = Calendar.getInstance();
        try {
            String[] dateParts = parts[1].split("-");
            int year = Integer.parseInt(dateParts[2]);
            int month = Integer.parseInt(dateParts[1]) - 1;
            int day = Integer.parseInt(dateParts[0]);
            cal.set(year, month, day);
        } 
        catch (Exception e) {
            System.err.println("Error parsing log date: " + e.getMessage());
        }
        return cal;
    }

    public String[] getProductDetails(String log) {
        return log.split(", ");
    }

    public void displayReceiptHistories() {
        for (ReceiptHistory rh : receiptHistories) {
            System.out.println(rh);
        }
    }

    public void displayEmployeeHistories() {
        for (EmployeeHistory eh : employeeHistories) {
            System.out.println(eh);
        }
    }
}
