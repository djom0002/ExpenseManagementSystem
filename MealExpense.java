// Class MealExpense
import java.util.Scanner;

public class MealExpense extends ExpenseRecord {
    private String restaurant;

    public MealExpense(int expenseId, String firstName, String lastName, double amount, String restaurant) {
        super(expenseId, firstName, lastName, amount);
        this.restaurant = restaurant;
    }

    @Override
    public String generateExpenseReport() {
        return String.format("Name: %s %s | Expense ID: %d | Yearly expense: %.2f | Expense type: Meal | Expense restaurant: %s",
                getFirstName(), getLastName(), getExpenseId(), getExpenseAmount(), restaurant);
    }

    @Override
    public void addExpense(Scanner input) {
        System.out.println("Adding meal expense:");
        System.out.print("Enter restaurant: ");
        this.restaurant = input.nextLine();
    }
}
