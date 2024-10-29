import java.util.ArrayList;
import java.util.List;
class Store {
    private List<Product> products;
    private List<Employee> employees;
    private double otherCosts;
    private double revenue;

    public Store() {
        products = new ArrayList<>();
        employees = new ArrayList<>();
        otherCosts = 0;
        revenue = 0;
    }
    public int getNumberOfEmployees() {
        return employees.size();
    }

    // Method to get the number of products
    public int getNumberOfProducts() {
        return products.size();
    }
    public void addProduct(Product product) {
        products.add(product);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    public void paySalaries() {
        double totalSalaries = 0;
        for (Employee employee : employees) {
            totalSalaries += employee.getSalary();
        }
        otherCosts += totalSalaries;
        System.out.println("Paid total salaries: " + totalSalaries);
    }
    public double calculateRentCost() {
        double rentCost = 10000000+this.getNumberOfProducts();
        return rentCost;
    }
    public double calculateDepreciationCost() {
        double depreciationRate = 0.05; // 5% depreciation rate
        double totalProductValue = 0;
        for (Product product : products) {
            totalProductValue += product.getValue(); // Assuming Product has a getValue() method
        }
        return totalProductValue * depreciationRate;
    }
    public double calculateMaintenanceCost() {
        double maintenanceCostPerProduct = 5000; // Cost per product
        return products.size() * maintenanceCostPerProduct;
    }
    public double calculateAdditionalCosts() {
        double rentCost = calculateRentCost();
        double depreciationCost = calculateDepreciationCost();
        double maintenanceCost = calculateMaintenanceCost();

        double totalAdditionalCosts = rentCost + depreciationCost + maintenanceCost;
        otherCosts += totalAdditionalCosts;

        return totalAdditionalCosts;
    }
    public void generateReport() {
        System.out.println("Total Revenue: " + revenue);
        System.out.println("Total Costs: " + otherCosts);
        System.out.println("Net Profit: " + (revenue - otherCosts));
    }
}
