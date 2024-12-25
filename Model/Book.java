package Model;
public class Book extends Product {
    private String publisher;
    private String author;
    
    public Book(String ID, String name, double purchasePrice, double sellingPrice, int qty) {
    	super(ID, name, purchasePrice, sellingPrice, qty);
    }

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
        System.out.println("ID:\t\t" + getID());
        System.out.println("Name:\t\t" + getName());
        System.out.println("Selling Price:\t\t" + getSellingPrice());
        System.out.println("Qty:\t\t" + getQty());
        System.out.println("Publisher:\t\t" + getPublisher());
        System.out.println("Author:\t\t" + getAuthor());
        System.out.println("-------------------------");
    }
}
