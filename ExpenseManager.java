import java.io.*;
import java.util.ArrayList;

public class ExpenseManager {

    private ArrayList<Expense> expenses = new ArrayList<>();

    private final String FILE_NAME = "expenses.dat";

    public void addExpense(Expense expense) {
        expenses.add(expense);
        saveExpenses();
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public double getTotalExpense() {

        double total = 0;

        for (Expense e : expenses) {
            total += e.getAmount();
        }

        return total;
    }

    private void saveExpenses() {

        try {

            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream(FILE_NAME));

            out.writeObject(expenses);
            out.close();

        } catch (IOException e) {

            System.out.println("Error saving expenses.");
        }
    }

    @SuppressWarnings("unchecked")
    public void loadExpenses() {

        try {

            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(FILE_NAME));

            expenses =
                    (ArrayList<Expense>) in.readObject();

            in.close();

        } catch (Exception e) {

            expenses = new ArrayList<>();
        }
    }
}
