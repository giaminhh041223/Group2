package Model;
public class Book extends Product {
    private String publisher;
    private String author;
    
    public Book(String ID, String name, double purchasePrice, double sellingPrice, int qty,
                String publisher, String author) {
        super(ID, name, purchasePrice, sellingPrice, qty);
        this.publisher = publisher;
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void print() {
        System.out.println("-------------------------");
        System.out.println("ID: " + getID());
        System.out.println("Name: " + getName());
        System.out.println("Selling Price: " + getSellingPrice());
        System.out.println("Qty: " + getQty());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Author: " + getAuthor());
        System.out.println("-------------------------");
    }
}
