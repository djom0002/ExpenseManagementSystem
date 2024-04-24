import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseManagementSystem {

    private ArrayList<ExpenseRecord> expenseList;

    public ExpenseManagementSystem() {
        expenseList = new ArrayList<>();
    }

    public void readExpenseFromCsvFile() {
        String filePath = "C:\\CST8116 Homework\\CST8116 Eclipse Workspace\\In-LabExercises05\\src\\Expense.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); 

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 7) continue; 

                String firstName = data[0].trim();
                String lastName = data[1].trim();
                int id = Integer.parseInt(data[2].trim());
                String expenseType = data[3].trim();
                double amount = Double.parseDouble(data[4].trim());
                String travelDestination = data[5].trim().equals("NULL") ? null : data[5].trim();
                String mealRestaurant = data[6].trim().equals("NULL") ? null : data[6].trim();

                ExpenseRecord expense;
                if ("Travel".equalsIgnoreCase(expenseType) && travelDestination != null) {
                    expense = new TravelExpense(id, firstName, lastName, amount, travelDestination);
                } else if ("Meal".equalsIgnoreCase(expenseType) && mealRestaurant != null) {
                    expense = new MealExpense(id, firstName, lastName, amount, mealRestaurant);
                } else {
                    continue; 
                }
                expenseList.add(expense);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the CSV file: " + e.getMessage());
        }
    }

    public void addExpense(Scanner input) {
        System.out.println("\nEnter the type of the expense ('t' for Travel, 'me' for Meal): ");
        String type = input.nextLine().trim();
        System.out.println("Enter the first name of the employee: ");
        String firstName = input.nextLine().trim();
        System.out.println("Enter the last name of the employee: ");
        String lastName = input.nextLine().trim();
        System.out.println("Enter the ID of the expense: ");
        int id = Integer.parseInt(input.nextLine().trim());
        System.out.println("Enter the amount of the expense: ");
        double amount = Double.parseDouble(input.nextLine().trim());

        if ("t".equalsIgnoreCase(type)) {
            System.out.println("Enter the destination of the travel expense: ");
            String destination = input.nextLine().trim();
            TravelExpense travelExpense = new TravelExpense(id, firstName, lastName, amount, destination);
            expenseList.add(travelExpense);
            System.out.println("Travel expense added.");
        } else if ("me".equalsIgnoreCase(type)) {
            System.out.println("Enter the name of the restaurant for the meal expense: ");
            String restaurant = input.nextLine().trim();
            MealExpense mealExpense = new MealExpense(id, firstName, lastName, amount, restaurant);
            expenseList.add(mealExpense);
            System.out.println("Meal expense added.");
        } else {
            System.out.println("Invalid expense type entered.");
        }
    }

    public void printExpenseDetails() {
        if (expenseList.isEmpty()) {
            System.out.println("No expenses to display.");
        } else {
            System.out.println("Number of expenses: " + expenseList.size());
            System.out.println("\nList of expenses:");
            for (ExpenseRecord expense : expenseList) {
                System.out.println(expense.generateExpenseReport());
            }
            System.out.println("--------------------------------------------------");
        }
    }

    public void monthlyTotalExpense() {
        double total = 0;
        for (ExpenseRecord expense : expenseList) {
            total += expense.getExpenseAmount();
        }
        double tax = total * 0.13; 
        System.out.printf("Total expenses: $%.2f\n", total);
        System.out.printf("Total expenses with tax: $%.2f\n", total + tax);
    }
}
