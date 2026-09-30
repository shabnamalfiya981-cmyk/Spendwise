package Manager;

public class BudgetManager {

    private double monthlyBudget;

    public BudgetManager() {
        monthlyBudget = 0;
    }

    public void setBudget(double budget) {
        if (budget > 0) {
            monthlyBudget = budget;
            System.out.println("Monthly budget set: ₹" + budget);
        } else {
            System.out.println("Invalid budget!");
        }
    }

    public double getBudget() {
        return monthlyBudget;
    }

    public boolean isBudgetExceeded(double totalExpense) {
        return totalExpense > monthlyBudget;
    }

    public void showBudgetStatus(double totalExpense) {

        if (totalExpense > monthlyBudget) {
            System.out.println("⚠️ Budget exceeded!");
        } else {
            double remaining = monthlyBudget - totalExpense;
            System.out.println("Remaining Budget: ₹" + remaining);
        }
    }
}