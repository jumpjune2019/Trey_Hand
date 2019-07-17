import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String userInput;
		String flipResult;
		RandomNum ran = () -> {
			int coin = (Math.random() <= 0.5) ? 1 : 2;
			return coin;
		};
		
		
		Flip flip = (coinVal) -> {
			String result;
			if (coinVal == 1) {
				result = "Head!";
				return result;
			} else {
				result = "Tail!";
				return result;
			}
			
		};
		System.out.println("Welcome to the game of Head or Tail where you will flip your life away!");
		System.out.println("Press the F key and flip your luck!");
		userInput = input.nextLine();
		while (userInput.equalsIgnoreCase("f") && !(userInput.equalsIgnoreCase("q"))) {
			int coin = ran.func();
			flipResult = flip.func(coin);
			System.out.println("The coin flip is: " + flipResult);
			System.out.println("Press the F key to try again, press Q or q to Quit");
			userInput = input.nextLine();
		}
		System.out.println("Thank you for playing");
		

	}

}
