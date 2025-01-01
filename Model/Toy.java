package Model;

public class Toy extends Product {
    private String brand;
    private String suitableAge;

    public Toy(String ID, String name, double purchasePrice, double sellingPrice, int qty,
               String brand, String suitableAge) {
        super(ID, name, purchasePrice, sellingPrice, qty);
        this.brand = brand;
        this.suitableAge = suitableAge;
    }
    
    public String getBrand() {
        return brand;
    }

    public String getSuitableAge() {
        return suitableAge;
    }

    @Override
    public void print() {
        System.out.println("-------------------------");
        System.out.println("ID: " + getID());
        System.out.println("Name: " + getName());
        System.out.println("Selling Price: " + getSellingPrice());
        System.out.println("Qty: " + getQty());
        System.out.println("Brand: " + getBrand());
        System.out.println("Suitable Age: " + getSuitableAge());
        System.out.println("-------------------------");
    }
}
