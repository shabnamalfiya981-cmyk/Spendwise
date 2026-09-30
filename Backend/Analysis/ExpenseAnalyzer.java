package Analysis;

import Manager.ExpenseManager;

public class ExpenseAnalyzer {

    private ExpenseManager expenseManager;

    public ExpenseAnalyzer(ExpenseManager expenseManager) {
        this.expenseManager = expenseManager;
    }

    public void showTotalExpense() {
        double total = expenseManager.getTotalExpense();

        System.out.println("Total Expense: ₹" + total);
    }
}