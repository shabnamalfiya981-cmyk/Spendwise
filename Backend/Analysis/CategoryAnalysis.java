package Analysis;

import Model.Expense;
import Manager.ExpenseManager;
import java.util.HashMap;

public class CategoryAnalysis {

    private ExpenseManager expenseManager;

    public CategoryAnalysis(ExpenseManager expenseManager) {
        this.expenseManager = expenseManager;
    }

    public void showCategoryWiseExpense() {

        HashMap<String, Double> categoryTotal = new HashMap<>();

        for (Expense expense : expenseManager.getExpenses()) {

            String category = expense.getCategory();
            double amount = expense.getAmount();

            categoryTotal.put(
                category,
                categoryTotal.getOrDefault(category, 0.0) + amount
            );
        }

        System.out.println("===== Category Wise Expense =====");

        for (String category : categoryTotal.keySet()) {
            System.out.println(
                category + " : ₹" + categoryTotal.get(category)
            );
        }
    }
}