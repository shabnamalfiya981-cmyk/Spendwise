import java.util.ArrayList;

public class MonthlyAnalysis {

    public double calculateTotalExpense(
            ArrayList<Expense> expenses) {

        double total = 0;

        for (Expense e : expenses) {
            total += e.getAmount();
        }

        return total;
    }

    public double calculateSavings(
            double income,
            ArrayList<Expense> expenses) {

        double expense = calculateTotalExpense(expenses);

        return income - expense;
    }

    public String generateReport(
            double income,
            ArrayList<Expense> expenses) {

        double totalExpense =
                calculateTotalExpense(expenses);

        double savings =
                income - totalExpense;

        return "===== MONTHLY REPORT =====\n" +
               "Income       : ₹" + income + "\n" +
               "Total Expense: ₹" + totalExpense + "\n" +
               "Savings      : ₹" + savings + "\n" +
               "==========================";
    }
}