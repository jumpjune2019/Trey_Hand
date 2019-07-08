import java.util.Scanner;

public class SimpleDie {

	public static void main(String[] args) {
		int die;
		String userChoice;
		//scanner to take in user keyboard input
		Scanner scan = new Scanner(System.in);
		System.out.println("Press any key and 'Enter' to throw the die (or (Q/q) and Enter to Quit)");
		//the use of nextLine() instead of next() requires the program to wait for input AND the enter key
		userChoice = scan.nextLine();
		//checks if the user choice is to quit
		if (!(userChoice.equalsIgnoreCase("Q"))) {
			do {
				die = 1 + (int)(Math.random() * ((6-1) + 1));
				System.out.println("You have rolled a: " + die);
				System.out.println("Play again? (Y or y) and Enter, any other key and Enter to Quit");
				userChoice = scan.nextLine();
			} while (userChoice.equalsIgnoreCase("Y"));
			System.out.println("Thank you for playing!");
		} else {
			System.out.println("Thank you for playing!");
		}
	}

}
