package Controller;

import History.*;
import Model.*;
import java.util.*;

public class CreateFinancialReport implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database, History history) {

        System.out.println("Enter the month (1-12) for the report:");
        int month = s.nextInt();
        System.out.println("Enter the year for the report:");
        int year = s.nextInt();

        double revenue = calculateRevenue(database, month, year);
        double netProfit = calculateNetProfit(database, month, year);
        double totalSalaries = calculateEmployeeSalaries(database);

        System.out.println("Financial Report for " + month + "/" + year + ":");
        System.out.println("-------------------------------------------");
        System.out.println("1. Revenue: " + revenue);
        System.out.println("2. Net Profit: " + netProfit);
        System.out.println("3. Total Employee Salaries: " + totalSalaries);
        System.out.println("-------------------------------------------");
    }

    private double calculateRevenue(Database database, int month, int year) {
        double revenue = 0;
        for (Receipt receipt : database.getReceipts()) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(receipt.getDate()); // Assuming Receipt has a getDate() method
            if (cal.get(Calendar.MONTH) + 1 == month && cal.get(Calendar.YEAR) == year) {
                revenue += receipt.getTotal();
            }
        }
        return revenue;
    }

    private double calculateNetProfit(Database database, int month, int year) {
        double netProfit = 0;
        for (Receipt receipt : database.getReceipts()) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(receipt.getDate()); // Assuming Receipt has a getDate() method
            if (cal.get(Calendar.MONTH) + 1 == month && cal.get(Calendar.YEAR) == year) {
                for (Product product : receipt.getProducts()) {
                    netProfit += product.getPurchasePrice() * product.getQty();
                }
            }
        }
        return netProfit;
    }

    private double calculateEmployeeSalaries(Database database) {
        double totalSalaries = 0;
        for (Employee employee : database.getEmployees()) {
            totalSalaries += employee.getSalary();
        }
        return totalSalaries;
    }

    @Override
    public String getOption() {
        return "Create Financial Report";
    }
}
