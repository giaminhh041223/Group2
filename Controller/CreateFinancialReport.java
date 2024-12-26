package Controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Scanner;

import History.History;
import Model.*;

public class CreateFinancialReport implements Option {
    @Override
    public void operate(Employee user, Scanner s, Database database, History history) {
        System.out.println("Generating financial report for the past month...");

        List<Receipt> receipts = database.getReceipts();
        if (receipts.isEmpty()) {
            System.out.println("No receipts available for the report.");
            return;
        }

        double totalIncome = 0;
        double totalExpenses = 0;

        LocalDate today = LocalDate.now();
        LocalDate oneMonthAgo = today.minusMonths(1);

        for (Receipt receipt : receipts) {
            LocalDate receiptDate = receipt.getDate().getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (!receiptDate.isBefore(oneMonthAgo) && !receiptDate.isAfter(today)) {
                totalIncome += receipt.getTotal();
                for (Product product : receipt.getProducts()) {
                    totalExpenses += product.getPurchasePrice() * product.getQty();
                }
            }
        }

        if (totalIncome > 0 || totalExpenses > 0) {
            double netProfit = totalIncome - totalExpenses;
            System.out.printf("Total Income: %.2f\n", totalIncome);
            System.out.printf("Total Expenses: %.2f\n", totalExpenses);
            System.out.printf("Net Profit: %.2f\n", netProfit);
        } else {
            System.out.println("No financial activity in the past month.");
        }
    }

    @Override
    public String getOption() {
        return "Generate Financial Report";
    }
}
