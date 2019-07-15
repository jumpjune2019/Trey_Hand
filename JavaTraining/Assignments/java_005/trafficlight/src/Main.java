import java.util.Scanner;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String userChoice;
		System.out.println("Traffic Light Program (press 'Enter' to end)");
		MyThread light = new MyThread("Light");
		
		userChoice = input.nextLine();
		do {
			if (userChoice.equals("")) {
				light.mystop();
			}
		} while (light.getStopped() == false);
		System.out.println("Program finished!");
		

	}


}
