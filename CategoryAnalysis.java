import java.util.ArrayList;

public class CategoryAnalysis {

    public double getCategoryTotal(
            ArrayList<Expense> expenses,
            String category) {

        double total = 0;

        for (Expense e : expenses) {

            if (e.getCategory().equalsIgnoreCase(category)) {
                total += e.getAmount();
            }
        }

        return total;
    }

    public String getHighestCategory(ArrayList<Expense> expenses) {

        String highestCategory = "No Data";
        double highestAmount = 0;

        String[] categories = {
            "Food",
            "Travel",
            "Shopping",
            "Education",
            "Entertainment",
            "Other"
        };

        for (String category : categories) {

            double amount =
                    getCategoryTotal(expenses, category);

            if (amount > highestAmount) {
                highestAmount = amount;
                highestCategory = category;
            }
        }

        return highestCategory;
    }
}