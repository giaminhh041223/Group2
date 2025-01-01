package Model;

public class FinancialSystem {
    private double capital;

    public FinancialSystem(double initialCapital) {
        this.capital = initialCapital;
    }

    public double getCapital() {
        return capital;
    }

    public void addRevenue(double revenue) {
        this.capital += revenue;
    }

    public void subtractCost(double cost) {
        this.capital -= cost;
    }

    public double calculateNetProfit(double revenue, double costOfGoodsAdded, double totalSalaries) {
        return revenue - costOfGoodsAdded - totalSalaries;
    }

    @Override
    public String toString() {
        return "Current Capital: " + capital;
    }
}
