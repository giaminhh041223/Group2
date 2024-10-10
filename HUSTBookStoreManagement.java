public class HUSTBookStoreManagement {
    public static void main(String[] args) {
        Store store = new Store();
        Product book1 = new Book("01", "Sach giai tich", 10000, 15000, 100, "NXB bach khoa", "TS Bui Xuan Dieu", "89-****");
        Product book2 = new Book("02", "Xac suat", 8000, 12000, 100, "NXB bach khoa", "Nguyen Huu Du", "89-****");
        Product stationary1 = new Stationary("03", "Notebook", 5000, 8000, 100, "MIT dai co viet", "A4 Notebook");
        Product toy1 = new Toy("04", "ipad", 25000000, 35000000, 10, "APPLE", "0+");
        store.addProduct(book1);
        store.addProduct(book2);
        store.addProduct(stationary1);
        store.addProduct(toy1);
        Employee emp1 = new Employee("Lam", 1500, "Thu ngan");
        Employee emp2 = new Employee("Quang", 2000, "Bao ve");
        store.addEmployee(emp1);
        store.addEmployee(emp2);
        Order order1 = new Order();
        order1.addProduct(book1, 2); 
        order1.addProduct(toy1, 3); 
        store.processOrder(order1);
        System.out.println("hoa don:");
        order1.displayOrder();
        store.paySalaries();
        store.addOtherCost(0);  
        System.out.println("Bao cao doanh thu:");
        store.generateReport();
    }
}
