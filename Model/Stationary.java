package Model;

public class Stationary extends Product {
    private String brand;
    private String stationaryType;
    
    public Stationary(String ID, String name, double purchasePrice, double sellingPrice, int qty,
                      String brand, String stationaryType) {
        super(ID, name, purchasePrice, sellingPrice, qty);
        this.brand = brand;
        this.stationaryType = stationaryType;
    }

    public String getBrand() {
        return brand;
    }

    public String getStationaryType() {
        return stationaryType;
    }

    @Override
    public void print() {
        System.out.println("-------------------------");
        System.out.println("ID: " + getID());
        System.out.println("Name: " + getName());
        System.out.println("Selling Price: " + getSellingPrice());
        System.out.println("Qty: " + getQty());
        System.out.println("Brand: " + getBrand());
        System.out.println("Stationary Type: " + getStationaryType());
        System.out.println("-------------------------");
    }
}

