package Service;

import Manager.IncomeManager;
import Manager.ExpenseManager;
import Model.Expense;

public class FinanceService implements FinanceOperations {

    private IncomeManager incomeManager;
    private ExpenseManager expenseManager;

    public FinanceService() {
        incomeManager = new IncomeManager();
        expenseManager = new ExpenseManager();
    }

    @Override
    public void addIncome(double amount) {
        incomeManager.addIncome(amount);
    }

    @Override
    public void addExpense(double amount) {

        Expense expense = new Expense(
            "General",
            amount,
            "Today",
            "Expense"
        );

        expenseManager.addExpense(expense);
    }

    @Override
    public double calculateBalance() {

        return incomeManager.getTotalIncome()
                - expenseManager.getTotalExpense();
    }

    public IncomeManager getIncomeManager() {
        return incomeManager;
    }

    public ExpenseManager getExpenseManager() {
        return expenseManager;
    }
}