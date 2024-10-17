import java.util.ArrayList;
import java.util.List;
class Order {
    private List<Product> products;
    private double totalCost;

    public Order() {
        products = new ArrayList<>();
        totalCost = 0;
    }

    public void addProduct(Product product, int quantity) {
        if (product.quantity >= quantity) {
            product.quantity -= quantity;
            products.add(product);
            totalCost += product.sellingPrice * quantity;
        } else {
            System.out.println("Not enough stock for product: " + product.name);
        }
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void displayOrder() {
        for (Product product : products) {
            product.displayInfo();
        }
        System.out.println("Total Cost: " + totalCost);
    }
}
