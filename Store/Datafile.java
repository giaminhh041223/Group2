package Store;

import Model.*;
import java.io.*;
import java.util.ArrayList;

public class Datafile {
    public Datafile() {
        String fileName = "data.txt";

        // Step 1: Create multiple sample instances
        // Cashiers
        Cashier cashier1 = new Cashier("1", "Alice", "alice@example.com", "password123", 3500);
        Cashier cashier2 = new Cashier("2", "Bob", "bob@example.com", "securepass", 3700);
        Admin admin=new Admin("a1","admin","1","1",1000);

        // Products
        Stationary pen = new Stationary("101", "Ballpoint Pen", 0.5, 1.0, 100, "Bic", "Writing Tool");
        Stationary notebook = new Stationary("102", "Notebook", 2.0, 4.0, 50, "Camlin", "Writing Pad");
        Stationary eraser = new Stationary("103", "Eraser", 0.2, 0.5, 200, "Staedtler", "Rubber");

        // Receipts
        ArrayList<Product> products1 = new ArrayList<>();
        products1.add(pen);
        products1.add(notebook);

        ArrayList<Product> products2 = new ArrayList<>();
        products2.add(eraser);

        Receipt receipt1 = new Receipt("R001", cashier1, products1, 5.0, 1, 5.0, 0.0); // Cash
        Receipt receipt2 = new Receipt("R002", cashier2, products2, 0.5, 2, 0.5, 0.0); // Visa

        // Step 2: Write data to the file
        try (FileWriter writer = new FileWriter(fileName)) {
            // Write Cashier data
            writer.write("Cashier|1|Alice|alice@example.com|password123|3500\n");
            writer.write("Cashier|2|Bob|bob@example.com|securepass|3700\n");
            writer.write("Admin|a1|admin|1|1|1000\n");


            // Write Product data
            writer.write("Product|101|Ballpoint Pen|0.5|1.0|100|Bic|Writing Tool\n");
            writer.write("Product|102|Notebook|2.0|4.0|50|Camlin|Writing Pad\n");
            writer.write("Product|103|Eraser|0.2|0.5|200|Staedtler|Rubber\n");

            // Write Receipt data
            writer.write("Receipt|R001|Alice|Ballpoint Pen, Notebook|5.0|Cash|5.0|0.0\n");
            writer.write("Receipt|R002|Bob|Eraser|0.5|Visa|0.5|0.0\n");

            System.out.println("Data written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

}
