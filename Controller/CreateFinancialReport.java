package Controller;

import History.*;
import Model.*;
import java.util.*;

public class CreateFinancialReport implements Option {

    @Override
    public void operate(Employee user, Scanner s, Database database, FinancialSystem financialSystem, History history) {

        System.out.println("Enter the month (1-12) for the report:");
        int month = s.nextInt();
        System.out.println("Enter the year for the report:");
        int year = s.nextInt();

        // Tính toán các chỉ số tài chính
        double revenue = calculateRevenue(database, month, year);
        double costOfGoodsAdded = calculateCostOfGoodsAdded(database, history, month, year);
        double totalSalaries = calculateEmployeeSalaries(database);

        // Trừ lương cuối tháng
        financialSystem.subtractCost(totalSalaries);

        double netProfit = revenue - costOfGoodsAdded - totalSalaries;

        System.out.println("Financial Report for " + month + "/" + year + ":");
        System.out.println("-------------------------------------------");
        System.out.println("1. Revenue: " + revenue);
        System.out.println("2. Net Profit: " + netProfit);
        System.out.println("3. Total Employee Salaries: " + totalSalaries);
        System.out.println("4. Updated Capital: " + financialSystem.getCapital());
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

    private double calculateCostOfGoodsAdded(Database database, History history, int month, int year) {
        double costOfGoods = 0;
    
        for (String log : history.getProductHistories()) {
            Calendar logDate = history.getLogDate(log);

            if (logDate.get(Calendar.MONTH) + 1 == month && logDate.get(Calendar.YEAR) == year) {
                String[] details = history.getProductDetails(log);
                String action = details[0];
    
                if (action.equals("Created")) {
                    // Xử lý Created
                    int addedQuantity = Integer.parseInt(details[3]);
                    double purchasePrice = Double.parseDouble(details[4]);
                    costOfGoods += addedQuantity * purchasePrice;
                } 
                if (action.equals("Updated")) {
                    // Xử lý Updated
                    int previousQuantity = Integer.parseInt(details[5]);
                    int updatedQuantity = Integer.parseInt(details[3]);
                    if (updatedQuantity > previousQuantity) {
                        int addedQuantity = updatedQuantity - previousQuantity;
                        double purchasePrice = Double.parseDouble(details[4]);
                        costOfGoods += addedQuantity * purchasePrice;
                    }
                }
            }
        }
        return costOfGoods;
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
