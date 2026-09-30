package Data;

import Model.Expense;
import java.io.FileWriter;
import java.io.IOException;

public class DataStorage {

    private static final String FILE_NAME = "expenses.txt";

    public static void saveExpense(Expense expense) {

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {

            writer.write(
                expense.getCategory() + "," +
                expense.getAmount() + "," +
                expense.getDate() + "," +
                expense.getDescription() + "\n"
            );

            System.out.println("Expense saved successfully!");

        } catch (IOException e) {

            System.out.println("Error while saving expense.");
        }
    }
}