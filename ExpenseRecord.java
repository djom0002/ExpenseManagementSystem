import java.util.Scanner;

//ExpenseRecord class
import java.util.Scanner;

public abstract class ExpenseRecord implements Expense {
    protected int expenseId;
    protected String firstName;
    protected String lastName;
    protected double amount;

    public ExpenseRecord(int expenseId, String firstName, String lastName, double amount) {
        this.expenseId = expenseId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public double getExpenseAmount() {
        return amount;
    }

    public void setExpenseAmount(double amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return String.format("$%.2f", amount);
    }

    public abstract String generateExpenseReport();
}