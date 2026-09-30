package Service;

public interface FinanceOperations {

    void addIncome(double amount);

    void addExpense(double amount);

    double calculateBalance();
}