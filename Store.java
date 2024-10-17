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

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void processOrder(Order order) {
        revenue += order.getTotalCost();
    }

    public void paySalaries() {
        double totalSalaries = 0;
        for (Employee employee : employees) {
            totalSalaries += employee.getSalary();
        }
        otherCosts += totalSalaries;
        System.out.println("Paid total salaries: " + totalSalaries);
    }

    public void addOtherCost(double cost) {
        otherCosts += cost;
    }

    public void generateReport() {
        System.out.println("Total Revenue: " + revenue);
        System.out.println("Total Costs: " + otherCosts);
        System.out.println("Net Profit: " + (revenue - otherCosts));
    }
}
