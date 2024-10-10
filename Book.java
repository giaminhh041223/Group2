package HustBookStore;

class Book extends Product {
    private String publisher;
    private String author;
    private String ISBN;

    public Book(String productID, String name, double purchasePrice, double sellingPrice, int quantity,
                String publisher, String author, String ISBN) {
        super(productID, name, purchasePrice, sellingPrice, quantity);
        this.publisher = publisher;
        this.author = author;
        this.ISBN = ISBN;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book: " + name + ", Author: " + author + ", Publisher: " + publisher + ", ISBN: " + ISBN);
    }
}
