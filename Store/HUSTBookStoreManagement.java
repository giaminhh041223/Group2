package Store;

import java.util.Scanner;
import Controller.*;
import History.History;
import Model.*;

public class HUSTBookStoreManagement {
    public static void main(String[] args) {
        Database database = new Database();
        FinancialSystem financialSystem = new FinancialSystem(1000000000.0);
        History history = new History();

        // Load employees and products
        database.loadData("employees.csv", "products.csv", database, history);

        new Login().operate(null, new Scanner(System.in), database, financialSystem, history);
    }
}
