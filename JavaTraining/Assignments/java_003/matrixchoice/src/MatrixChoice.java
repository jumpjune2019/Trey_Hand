import java.io.*;
import java.util.Scanner;

public class MatrixChoice {
	static void printToScreen(String arr[][]) {
		
		System.out.println("Dice Combinations Label Matrix");
		String format = "%-28s";
		System.out.printf("%-30s", "\t\tDice 1");
		for (int i = 1; i < 6; i++) {
			System.out.printf(format, "Dice " + (i + 1));
		}
		System.out.println();
		System.out.println();
		//Nested for-loops iterate across the horizontal axis, then down one, then across again, etc.
		//Example: 1,1 -> 1,2 -> 1,3 -> etc.
		for (int i = 0; i < 6; i++) {
			System.out.print("Dice " + (i + 1) + "\t\t");
			for (int j = 0; j < 6; j++) {
				System.out.printf(format, arr[i][j]);
			}
			System.out.println();
			System.out.println();
		}
	}
	
	static void printToFile(String arr[][]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the file name below:");
		String fileName = input.nextLine();
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File(fileName));
			writer.println("Dice Combinations Label Matrix");
			String format = "%-28s";
			writer.printf("%-30s", "\t\tDice 1");
			for (int i = 1; i < 6; i++) {
				writer.printf(format, "Dice " + (i + 1));
			}
			writer.println();
			writer.println();
			for (int i = 0; i < 6; i++) {
				writer.print("Dice " + (i + 1) + "\t\t");
				for (int j = 0; j < 6; j++) {
					writer.printf(format, arr[i][j]);
				}
				writer.println();
				writer.println();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("The file could not be created");
		}
		writer.close();
		
		
	}
	public static void main(String[] args) {
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
		Scanner scan = new Scanner(System.in);
		String userChoice;
		
		
		System.out.println("Welcome to the Dice Labels Matrix Example! Do you want to: ");
		System.out.println("A. Print the Matrix on screen only");
		System.out.println("B. Print the Matrix to a file");
		System.out.println("C. Print to Both the screen and a file");
		System.out.print("Please enter your choice and press enter: ");
		userChoice = scan.nextLine();
		
		switch (userChoice.toLowerCase()) {
		case "a" :
			printToScreen(diceLabels);
			break;
		case "b" :
			printToFile(diceLabels);
			break;
		case "c" :
			printToScreen(diceLabels);
			printToFile(diceLabels);
		}
			
		
	}

}
