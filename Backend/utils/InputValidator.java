package Utils;

public class InputValidator {

    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public static boolean isValidText(String text) {
        return text != null && !text.trim().isEmpty();
    }
}