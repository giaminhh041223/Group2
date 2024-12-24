package Store;
import java.util.Scanner;

import Store;
import Model.Book;
import Model.Product;
import Model.Stationary;
import Model.Toy;
public class HUSTBookStoreManagement {
    private static void addProduct(Store store, Scanner scanner) {
        System.out.println("Add Product Menu:");
        System.out.println("1. Add Book");
        System.out.println("2. Add Stationary");
        System.out.println("3. Add Toy");
    
        System.out.print("Choose product type: ");
        int productType = scanner.nextInt();
        scanner.nextLine();  
    
        System.out.print("Enter product ID: ");
        String productID = scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter purchase price: ");
        double purchasePrice = scanner.nextDouble();
        System.out.print("Enter selling price: ");
        double sellingPrice = scanner.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  
    
        switch (productType) {
            case 1:
                System.out.print("Enter publisher: ");
                String publisher = scanner.nextLine();
                System.out.print("Enter author: ");
                String author = scanner.nextLine();
                System.out.print("Enter ISBN: ");
                String ISBN = scanner.nextLine();
                Product book = new Book(productID, name, purchasePrice, sellingPrice, quantity, publisher, author, ISBN);
                store.addProduct(book);
                System.out.println("Book added successfully.");
                break;
            case 2:
                System.out.print("Enter brand: ");
                String brand = scanner.nextLine();
                System.out.print("Enter stationary type: ");
                String stationaryType = scanner.nextLine();
                Product stationary = new Stationary(productID, name, purchasePrice, sellingPrice, quantity, brand, stationaryType);
                store.addProduct(stationary);
                System.out.println("Stationary added successfully.");
                break;
            case 3:
                System.out.print("Enter brand: ");
                String toyBrand = scanner.nextLine();
                System.out.print("Enter suitable age: ");
                String suitableAge = scanner.nextLine();
                Product toy = new Toy(productID, name, purchasePrice, sellingPrice, quantity, toyBrand, suitableAge);
                store.addProduct(toy);
                System.out.println("Toy added successfully.");
                break;
            default:
                System.out.println("Invalid product type.");
        }
    }
    
    public static void main(String[] args) {
        

        System.out.println("Welcome to Hust Book Store Management System!\n"
                           + "Are you a Customer or an Employee?\n1. Customer\n2. Employee\n0. Exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: login();
            case 2: login();
            case 0: break;
            default: System.out.println("");
        }
        boolean running = true;
    
        while (running) {
            System.out.println("\n====== HUST Book Store Management ======");
            System.out.println("1. Add Product");
            System.out.println("2. View Inventory");
            System.out.println("3. Process Order");
            System.out.println("4. Pay Salaries");
            System.out.println("5. Add Other Costs");
            System.out.println("6. Generate Financial Report");
            System.out.println("7. Save Data");
            System.out.println("8. Load Data");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
    
            int choice = scanner.nextInt();
            scanner.nextLine(); 
    
            switch (choice) {
                case 1:
                    addProduct(store, scanner);
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
                    break;
            }
        }
        scanner.close();
    }

}
    
