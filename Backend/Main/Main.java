
import Model.Expense;
import Manager.ExpenseManager;
import Manager.BudgetManager;
import Manager.IncomeManager;
import Analysis.ExpenseAnalyzer;
import Analysis.CategoryAnalysis;
import Analysis.MonthlyAnalysis;
import Data.DataStorage;
import Model.Admin;
public class Main {

    public static void main(String[] args) {Admin admin = new Admin("SpendWise Admin", "admin@spendwise.com", "Administrator");
    admin.showRole();
        IncomeManager incomeManager = new IncomeManager();
BudgetManager budgetManager = new BudgetManager();
        ExpenseManager expenseManager = new ExpenseManager();
        Expense expense = new Expense(
    "Food",
    200,
    "30-09-2026",
    "Lunch"
);
expenseManager.addExpense(expense);
DataStorage.saveExpense(expense);
ExpenseAnalyzer analyzer = new ExpenseAnalyzer(expenseManager);
analyzer.showTotalExpense();
CategoryAnalysis categoryAnalysis = new CategoryAnalysis(expenseManager);
categoryAnalysis.showCategoryWiseExpense();
MonthlyAnalysis monthlyAnalysis = new MonthlyAnalysis(expenseManager);

budgetManager.setBudget(500);
budgetManager.showBudgetStatus(expenseManager.getTotalExpense());
monthlyAnalysis.showMonthlySummary();
System.out.println("Total Expense: ₹" + expenseManager.getTotalExpense());
incomeManager.addIncome(1000);
System.out.println("Total Income: ₹" + incomeManager.getTotalIncome());
System.out.println("Balance: ₹" + (incomeManager.getTotalIncome() - expenseManager.getTotalExpense()));
System.out.println("Available Balance: ₹" + (incomeManager.getTotalIncome() - expenseManager.getTotalExpense()));

        System.out.println("=================================");
        System.out.println("       💰 SPENDWISE 💰");
        System.out.println(" Monthly Spending Analysis System");
        System.out.println("=================================");

        System.out.println("SpendWise Application Started!");

    }
}