import java.io.*;
import java.util.Scanner;


public class Phone {
static void printToScreen(String arr[][]) {
		
		System.out.println("PhoneBook App");
		String format = "%-30s";
		System.out.printf(format, "Name");
		System.out.printf(format, "Phone Number");
		System.out.printf(format, "City");

		System.out.println();
		System.out.println();
		
		//Nested for-loops iterate by row, and then within each row iterate across each column
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf(format, arr[i][j]);
			}
			System.out.println();
			System.out.println();
		}
	}
	
	static void printToFile(String arr[][]) {

		String fileName = "phone.txt";
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File(fileName));
			writer.println("PhoneBook App");
			String format = "%-30s";
			writer.printf(format, "Name");
			writer.printf(format, "Phone Number");
			writer.printf(format, "City");
			
			writer.println();
			writer.println();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					writer.printf(format, arr[i][j]);
				}
				writer.println();
				writer.println();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("The file could not be created");
			//e.printStackTrace();
		}
		writer.close();
		
		
	}
	static void enterData(String arr[][]) {
		for (int i = 0; i < 5; i++) {
			Scanner input = new Scanner(System.in);
			String userInput;
			String confirm;
			System.out.println("Please enter the data for customer " + (i + 1) + ", pressing 'Enter' after each entry: ");
			
			try {
				for (int j = 0; j < 3; j++) {
					//Not gonna lie, pretty proud of this. Wanted to use a for loop, but also wanted the text to be different each time
					//I had the idea to use a switch based on the for loop iterator and it worked beautifully
					//Might not be terribly memory/time efficient (I'm guessing) but it looks cool
					switch (j) {
					case 0:
						System.out.print("Name: ");
						do {
							userInput = input.nextLine();
							verifyInput(userInput);
							System.out.println("Name Entered: " + userInput);
							System.out.println("Enter (Y or y) to confirm, enter any other key to change your entry ");
							confirm = input.nextLine();
							
						} while (!(confirm.equalsIgnoreCase("y")));
						arr[i][j] = userInput;
						break;
					case 1:
						System.out.print("Phone Number: ");
						do {
							userInput = input.nextLine();
							verifyInput(userInput);
							System.out.println("Phone Entered: " + userInput);
							System.out.println("Enter (Y or y) to confirm, enter any other key to change your entry: ");
							confirm = input.nextLine();
							
						} while (!(confirm.equalsIgnoreCase("y")));
						arr[i][j] = userInput;
						break;
					case 2:
						System.out.print("City of Residence: ");
						do {
							userInput = input.nextLine();
							verifyInput(userInput);
							System.out.println("City Entered: " + userInput);
							System.out.println("Enter (Y or y) to confirm, enter any other key to change your entry: ");
							confirm = input.nextLine();
							
						} while (!(confirm.equalsIgnoreCase("y")));
						arr[i][j] = userInput;
						break;
					} //end of switch
				
				} //end of for-loop
			} catch (FieldEmptyException e) {
				System.out.println(e.getMessage());
				i--;
				continue;
				
			} //end of try-catch
		}
	}
	public static void main(String[] args) {
		//new String [row_index][column index]
		String[][] phoneBook = new String[5][3];
		//Scanner scan = new Scanner(System.in);
		enterData(phoneBook);
		printToScreen(phoneBook);
		printToFile(phoneBook);
		
		

	}
	static void verifyInput(String s) throws FieldEmptyException {
		if (s.equals("")) {
			throw new FieldEmptyException("You didn't enter a value! Please try that customer again!");
		}
	}

}
