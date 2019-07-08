import java.util.Scanner;

public class PairOfDice {

	public static void main(String[] args) {
		int die1;
		int die2;
		String userChoice;
		//scanner to take in user keyboard input
		Scanner scan = new Scanner(System.in);
		System.out.println("Press any key and 'Enter' to throw a pair of dice (or (Q/q) and Enter to Quit)");
		//the use of nextLine() instead of next() requires the program to wait for input AND the enter key
		userChoice = scan.nextLine();
		//checks if the user choice is to quit
		if (!(userChoice.equalsIgnoreCase("Q"))) {
			do {
				System.out.println("You have rolled the following: ");
				die1 = 1 + (int)(Math.random() * ((6-1) + 1));
				System.out.println("First Die: " + die1);
				die2 = 1 + (int)(Math.random() * ((6-1) + 1));
				System.out.println("Second Die: " + die2);
				System.out.println("Play again? (Y or y) and Enter, any other key and Enter to Quit");
				userChoice = scan.nextLine();
			} while (userChoice.equalsIgnoreCase("Y"));
			System.out.println("Thank you for playing!");
		} else {
			System.out.println("Thank you for playing!");
		}

	}

}
