package Analysis;

import Manager.ExpenseManager;

public class MonthlyAnalysis {

    private ExpenseManager expenseManager;

    public MonthlyAnalysis(ExpenseManager expenseManager) {
        this.expenseManager = expenseManager;
    }

    public void showMonthlySummary() {

        double totalExpense = expenseManager.getTotalExpense();

        System.out.println("===== Monthly Summary =====");
        System.out.println("Total Monthly Expense: ₹" + totalExpense);
    }
}