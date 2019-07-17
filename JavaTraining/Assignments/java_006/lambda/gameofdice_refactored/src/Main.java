import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Dice labels imported from Assignment06_DiceLabels
		String[][] diceLabels = new String[6][6];
		//arrangement: diceLabels[horizontal index][vertical index]
		diceLabels[0][0] = "Snake Eyes";
		diceLabels[0][1] = "Australian yo";
		diceLabels[0][2] = "Little Joe From Kokomo";
		diceLabels[0][3] = "No field five";
		diceLabels[0][4] = "Easy six";
		diceLabels[0][5] = "Six one you're done";
		diceLabels[1][0] = "Ace caught a deuce";
		diceLabels[1][1] = "Ballerina";
		diceLabels[1][2] = "The fever";
		diceLabels[1][3] = "Jimmie Hicks";
		diceLabels[1][4] = "Benny Blue";
		diceLabels[1][5] = "Easy eight";
		diceLabels[2][0] = "Easy four";
		diceLabels[2][1] = "OJ";
		diceLabels[2][2] = "Brooklyn Forest";
		diceLabels[2][3] = "Big Red";
		diceLabels[2][4] = "Eighter from Decatur";
		diceLabels[2][5] = "Nina from Pasadena";
		diceLabels[3][0] = "Little Phoebe";
		diceLabels[3][1] = "Easy six";
		diceLabels[3][2] = "Skinny McKinney";
		diceLabels[3][3] = "Square pair";
		diceLabels[3][4] = "Railroad nine";
		diceLabels[3][5] = "Big one on the end";
		diceLabels[4][0] = "Sixie from Dixie";
		diceLabels[4][1] = "Skinny Dugan";
		diceLabels[4][2] = "Easy eight";
		diceLabels[4][3] = "Jesse James";
		diceLabels[4][4] = "Puppy paws";
		diceLabels[4][5] = "Yo";
		diceLabels[5][0] = "The Devil";
		diceLabels[5][1] = "Easy eight";
		diceLabels[5][2] = "Lou Brown";
		diceLabels[5][3] = "Tennessee";
		diceLabels[5][4] = "Six five no jive";
		diceLabels[5][5] = "Midnight";
				
		//Creating global variables
		int userDie1;
		int userDie2;
		int compDie1;
		int compDie2;
		int userSum;
		int compSum;
		Scanner scan = new Scanner(System.in);
		String userChoice;
		
		//Creating lambdas
		DiceThrow diceThrow = () -> {
			int dice = 1 + (int)(Math.random() * ((6-1) + 1));
			return dice;
		};
		
		DieSum dieSum = (die1, die2) -> {
			int sum = die1 + die2;
			return sum;
		};
		
		DiceResult diceResult = (uDie1, uDie2, cDie1, cDie2) -> {
			System.out.println("You have rolled a " + uDie1 + " and " + uDie2 + " > the " + diceLabels[uDie1 - 1][uDie2 - 1]);
			System.out.println("I have rolled a " + cDie1 + " and " + cDie2 + " > the " + diceLabels[cDie1 - 1][cDie2 - 1]);
		};
		
		System.out.println("Welcome to the dice throw challenge!");
		System.out.println("Do you feel lucky? Punk... Do ya?");
		System.out.println("Press any key and ENTER to throw your dice or press (Q or q) to chicken your butt off...");
		userChoice = scan.nextLine();
		if (!(userChoice.equalsIgnoreCase("Q"))) {
			do {
				System.out.println("Rolling the dice!!");
				userDie1 = diceThrow.func();
				userDie2 = diceThrow.func();
				
				compDie1 = diceThrow.func();
				compDie2 = diceThrow.func();
				
				diceResult.func(userDie1, userDie2, compDie1, compDie2);
				
				userSum = dieSum.func(userDie1, userDie2);
				compSum = dieSum.func(compDie1, compDie2);
				if (compSum > userSum) {
					System.out.println("I win!!");
					System.out.println("Wanna try again? Press any key and ENTER to throw your dice or (Q or q) to quit");
					userChoice = scan.nextLine();
				} else if ((compSum == userSum) && (userDie1 == userDie2)){
					System.out.println("Damn! You win on a Double! What luck!");
					System.out.println("Did you cheat?? Gimme another try, c'mon press any key and ENTER to throw your dice or (Q or q) to quit");
					userChoice = scan.nextLine();
				} else if ((compSum == userSum) && (compDie1 == compDie2)){
					System.out.println("Damn! I win on a Double! Ah! I pity you fool!");
					System.out.println("Wanna try again? Press any key and ENTER to throw your dice or (Q or q) to quit");
					userChoice = scan.nextLine();
				} else if((compSum == userSum) && ((compDie1 != compDie2) && (userDie1 != userDie2))) {
					System.out.println("Stalemate! You're tough, let's try for a tie-breaker. Press any key and ENTER to throw your dice or (Q or q) to quit");
					userChoice = scan.nextLine();
				} else {
					System.out.println("You win!!");
					System.out.println("Did you cheat?? Gimme another try, c'mon press any key and ENTER to throw your dice or (Q or q) to quit");
					userChoice = scan.nextLine();
				}
				
			} while (!(userChoice.equalsIgnoreCase("Q")));
			System.out.println("Thanks for being a sport! Laters!");
		} else {
			System.out.println("See ya later alligator!");
		}

	}

}
