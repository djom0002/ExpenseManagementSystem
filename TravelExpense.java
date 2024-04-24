
// Class TravelExpense
import java.util.Scanner;

public class TravelExpense extends ExpenseRecord {
    private String destination;

    public TravelExpense(int expenseId, String firstName, String lastName, double amount, String destination) {
        super(expenseId, firstName, lastName, amount);
        this.destination = destination;
    }

    @Override
    public String generateExpenseReport() {
        return String.format("Name: %s %s | Expense ID: %d | Yearly expense: %.2f | Expense type: Travel | Expense destination: %s",
                getFirstName(), getLastName(), getExpenseId(), getExpenseAmount(), destination);
    }

    @Override
    public void addExpense(Scanner input) {
        System.out.println("Adding travel expense:");
        System.out.print("Enter destination: ");
        this.destination = input.nextLine();
    }
}
