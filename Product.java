abstract class Product {
    protected String productID;
    protected String name;
    protected double purchasePrice;
    protected double sellingPrice;
    protected int quantity;

    public Product(String productID, String name, double purchasePrice, double sellingPrice, int quantity) {
        this.productID = productID;
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
    }

    public double calculateProfit() {
        return (sellingPrice - purchasePrice) * quantity;
    }

    public abstract void displayInfo();
}
