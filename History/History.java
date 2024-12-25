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

    public void addProductHistory(String action, Calendar date, Product product) {
        ProductHistory pH = new ProductHistory(action, date, product);
        productHistories.add(pH);
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
