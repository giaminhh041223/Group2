class Toy extends Product {
    private String brand;
    private String suitableAge;

    public Toy(String productID, String name, double purchasePrice, double sellingPrice, int quantity,
               String brand, String suitableAge) {
        super(productID, name, purchasePrice, sellingPrice, quantity);
        this.brand = brand;
        this.suitableAge = suitableAge;
    }

    @Override
    public void displayInfo() {
        System.out.println("Toy: " + name + ", Brand: " + brand + ", Suitable for Ages: " + suitableAge);
    }
}
