import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    ExpenseManager expenseManager = new ExpenseManager();
    BudgetManager budgetManager = new BudgetManager();
    CategoryAnalysis categoryAnalysis = new CategoryAnalysis();
    MonthlyAnalysis monthlyAnalysis = new MonthlyAnalysis();

    JTextArea output;
    JTextField amountField;
    JTextField descriptionField;
    JTextField incomeField;
    JTextField budgetField;

    JComboBox<String> categoryBox;

    public Main() {

        expenseManager.loadExpenses();

        setTitle("SpendWise - Monthly Spending Analysis");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel title = new JLabel(
                "💰 SpendWise",
                SwingConstants.CENTER);

        title.setFont(new Font("Arial", Font.BOLD, 28));

        mainPanel.add(title, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(
                new GridLayout(5, 2, 10, 10));

        inputPanel.add(new JLabel("Expense Amount:"));

        amountField = new JTextField();
        inputPanel.add(amountField);

        inputPanel.add(new JLabel("Description:"));

        descriptionField = new JTextField();
        inputPanel.add(descriptionField);

        inputPanel.add(new JLabel("Category:"));

        String[] categories = {
                "Food",
                "Travel",
                "Shopping",
                "Education",
                "Entertainment",
                "Other"
        };

        categoryBox = new JComboBox<>(categories);
        inputPanel.add(categoryBox);

        inputPanel.add(new JLabel("Monthly Income:"));

        incomeField = new JTextField();
        inputPanel.add(incomeField);

        inputPanel.add(new JLabel("Monthly Budget:"));

        budgetField = new JTextField();
        inputPanel.add(budgetField);

        mainPanel.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(
                new GridLayout(2, 3, 10, 10));

        JButton addButton = new JButton("➕ Add Expense");
        JButton expenseButton = new JButton("📋 Expenses");
        JButton budgetButton = new JButton("💰 Budget");
        JButton categoryButton = new JButton("📊 Category");
        JButton reportButton = new JButton("📈 Monthly Report");
        JButton clearButton = new JButton("🗑 Clear");

        buttonPanel.add(addButton);
        buttonPanel.add(expenseButton);
        buttonPanel.add(budgetButton);
        buttonPanel.add(categoryButton);
        buttonPanel.add(reportButton);
        buttonPanel.add(clearButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        output = new JTextArea();
        output.setEditable(false);
        output.setFont(new Font("Monospaced", Font.PLAIN, 14));

        add(mainPanel, BorderLayout.NORTH);
        add(new JScrollPane(output), BorderLayout.CENTER);

        // Add Expense
        addButton.addActionListener(e -> addExpense());

        // Show Expenses
        expenseButton.addActionListener(e -> showExpenses());

        // Budget
        budgetButton.addActionListener(e -> showBudget());

        // Category
        categoryButton.addActionListener(e -> showCategory());

        // Monthly Report
        reportButton.addActionListener(e -> showReport());

        // Clear
        clearButton.addActionListener(e -> {
            amountField.setText("");
            descriptionField.setText("");
            incomeField.setText("");
            budgetField.setText("");
            output.setText("");
        });
    }

    private void addExpense() {

        try {

            double amount =
                    Double.parseDouble(amountField.getText());

            String description =
                    descriptionField.getText();

            String category =
                    categoryBox.getSelectedItem().toString();

            Expense expense = new Expense(
                    java.time.LocalDate.now().toString(),
                    category,
                    description,
                    amount
            );

            expenseManager.addExpense(expense);

            output.setText(
                    "✓ Expense added successfully!\n\n" +
                    expense
            );

            amountField.setText("");
            descriptionField.setText("");

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid amount!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void showExpenses() {

        output.setText("===== ALL EXPENSES =====\n\n");

        for (Expense e : expenseManager.getExpenses()) {
            output.append(e + "\n");
        }

        output.append(
                "\nTotal Expense: ₹" +
                expenseManager.getTotalExpense()
        );
    }

    private void showBudget() {

        try {

            double budget =
                    Double.parseDouble(budgetField.getText());

            budgetManager.setBudget(budget);

            double expense =
                    expenseManager.getTotalExpense();

            double remaining =
                    budgetManager.getRemainingBudget(expense);

            output.setText(
                    "===== BUDGET ANALYSIS =====\n\n" +
                    "Monthly Budget : ₹" + budget + "\n" +
                    "Total Expense  : ₹" + expense + "\n" +
                    "Remaining      : ₹" + remaining + "\n\n" +
                    budgetManager.getBudgetStatus(expense)
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter a valid budget!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void showCategory() {

        output.setText("===== CATEGORY ANALYSIS =====\n\n");

        String[] categories = {
                "Food",
                "Travel",
                "Shopping",
                "Education",
                "Entertainment",
                "Other"
        };

        for (String category : categories) {

            double total =
                    categoryAnalysis.getCategoryTotal(
                            expenseManager.getExpenses(),
                            category
                    );

            output.append(
                    category + " : ₹" + total + "\n"
            );
        }

        output.append(
                "\nHighest Spending Category: " +
                categoryAnalysis.getHighestCategory(
                        expenseManager.getExpenses()
                )
        );
    }

    private void showReport() {

        try {

            double income =
                    Double.parseDouble(incomeField.getText());

            String report =
                    monthlyAnalysis.generateReport(
                            income,
                            expenseManager.getExpenses()
                    );

            output.setText(report);

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter a valid income!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}