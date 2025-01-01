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
        double totalPurchaseCost=calculateTotalPurchaseCost(database, history, month, year);
        double netProfit = revenue-calculateTotalPurchaseCost(database, history, month, year);
        double totalSalaries = calculateEmployeeSalaries(database);

        System.out.println("Financial Report for " + month + "/" + year + ":");
        System.out.println("-------------------------------------------");
        System.out.println("1. Revenue: " + revenue);
        System.out.println("2. Total purchase cost: " + totalPurchaseCost);
        System.out.println("3. Net Profit: " + netProfit);
        System.out.println("4. Total Employee Salaries: " + totalSalaries);
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


    private double calculateEmployeeSalaries(Database database) {
        double totalSalaries = 0;
        for (Employee employee : database.getEmployees()) {
            totalSalaries += employee.getSalary();
        }
        return totalSalaries;
    }
    private double calculateTotalPurchaseCost(Database database, History history, int month, int year) {
        double totalPurchaseCost = 0;

        // Iterate through all product histories
        for (ProductHistory pH : history.getProductHistories()) {
            if (pH instanceof ProductHistory) {
                ProductHistory productHistory = (ProductHistory) pH;

                // Get the action date
                Calendar actionDate = pH.getDate();

                // Check if the action occurred in the specified month and year
                if (actionDate.get(Calendar.MONTH) + 1 == month && actionDate.get(Calendar.YEAR) == year) {
                    // Parse the action description to identify added quantities and calculate costs
                    String actionDescription = productHistory.getAction();

                    if (actionDescription.startsWith("Add") || actionDescription.startsWith("Launch")) {
                        Product product = productHistory.getProduct();
                        String[] words = actionDescription.split(" ");
                        
                        try {
                            // Extract quantity from the action description
                            int quantity = Integer.parseInt(words[1]);
                            totalPurchaseCost += product.getPurchasePrice() * quantity;
                        } catch (NumberFormatException e) {
                            System.err.println("Error parsing quantity from action: " + actionDescription);
                        }
                    }
                }
            }
        }

        return totalPurchaseCost;
    }


    @Override
    public String getOption() {
        return "Create Financial Report";
    }
}
