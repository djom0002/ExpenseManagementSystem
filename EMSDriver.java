import java.util.Scanner;

/**
 * @author Brice Djomo
 * @version 4/11/20224
 */
public class EMSDriver {
	/**
	 * Main method
	 * @param args  
	 */
	public static void main(String[] args) {	

		Scanner input = new Scanner (System.in); 
		String userInput = "";
		ExpenseManagementSystem ems = new ExpenseManagementSystem(); 		

		System.out.println("======= Welcome to the Expense Management System  =======");

		// Main Menu
		while (true)
		{
			System.out.println("r: Read a list of expense from the CSV file ");	
			System.out.println("a: Add a new expense ");				
			System.out.println("p: Print the info of all expense");
			System.out.println("m: Total expense");
			System.out.println("q: Quit");
			System.out.print("\nEnter your option: ");

			userInput = input.nextLine();
			userInput = userInput.toLowerCase();
			System.out.println();
			switch (userInput)
			{
			case "r":
				ems.readExpenseFromCsvFile();
				break;					

			case "a":
				ems.addExpense(input);
				break;								

			case "p":
				ems.printExpenseDetails();
				break;

			case "m":
				ems.monthlyTotalExpense();
				break;

			case "q":
				System.out.println("Quit: Successfully exited the program.");
				input.close();
				return; // Returns nothing with main's void method to exit the program

			default:
				System.out.println("\nError: did not receive one of the listed inputs. Please enter one of the listed inputs.");
			} //End of switch
			System.out.println("----------------------***************************-------------------");
		} //end of while	
	}
}


