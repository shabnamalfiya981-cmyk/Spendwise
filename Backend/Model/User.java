package Model;

public class User {

    private String name;
    private String email;
    private double income;
    private double totalExpense;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.income = 0;
        this.totalExpense = 0;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getIncome() {
        return income;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getBalance() {
        return income - totalExpense;
    }
}