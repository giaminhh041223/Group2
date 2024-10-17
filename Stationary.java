class Stationary extends Product {
    private String brand;
    private String stationaryType;

    public Stationary(String productID, String name, double purchasePrice, double sellingPrice, int quantity,
                      String brand, String stationaryType) {
        super(productID, name, purchasePrice, sellingPrice, quantity);
        this.brand = brand;
        this.stationaryType = stationaryType;
    }

    @Override
    public void displayInfo() {
        System.out.println("Stationary: " + name + ", Brand: " + brand + ", Type: " + stationaryType);
    }
}

