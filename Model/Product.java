package Model;

public abstract class Product {
    protected String ID;
    protected String name;
    protected double purchasePrice;
    protected double sellingPrice;
    protected int qty;

    public Product() {
    }

    public Product(String ID, String name, double purchasePrice, double sellingPrice, int qty) {
        this.ID = ID;
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.qty = qty;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double price) {
        this.purchasePrice = price;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double price) {
        this.sellingPrice = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public abstract void print();
}