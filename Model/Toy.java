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
        System.out.println("ID:\t\t" + getID());
        System.out.println("Name:\t\t" + getName());
        System.out.println("Selling Price:\t\t" + getSellingPrice());
        System.out.println("Qty:\t\t" + getQty());
        System.out.println("Brand:\t\t" + getBrand());
        System.out.println("Suitable Age:\t\t" + getSuitableAge());
        System.out.println("-------------------------");
    }
}
