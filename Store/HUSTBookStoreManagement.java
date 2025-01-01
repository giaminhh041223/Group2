package Store;

import java.util.Scanner;
import Model.*;
import Controller.*;
import History.*;

public class HUSTBookStoreManagement {
    public static void main(String[] args) {
        // Initialize the Database
        Database database = new Database();

        // Load data into the Database
        String fileName = "data.txt";
        database.loadData(fileName);

        // Start the login system
        new Login().operate(null, new Scanner(System.in), database, new History());
    }
}
