public class BudgetManager {

    private double monthlyBudget;

    public void setBudget(double budget) {
        if (budget >= 0) {
            monthlyBudget = budget;
        }
    }

    public double getBudget() {
        return monthlyBudget;
    }

    public double getRemainingBudget(double totalExpense) {
        return monthlyBudget - totalExpense;
    }

    public String getBudgetStatus(double totalExpense) {

        if (totalExpense > monthlyBudget) {
            return "⚠ Budget Exceeded!";
        } else {
            return "✓ You are within your budget.";
        }
    }
}