package Manager;

public class IncomeManager {

    private double totalIncome;

    public IncomeManager() {
        totalIncome = 0;
    }

    public void addIncome(double amount) {

        if (amount > 0) {
            totalIncome += amount;
            System.out.println("Income added successfully!");
        } else {
            System.out.println("Invalid income amount!");
        }
    }

    public double getTotalIncome() {
        return totalIncome;
    }
}