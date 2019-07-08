
public class HeadOrTailTally {

	public static void main(String[] args) {
		System.out.println("1000 Coin Flips");
		//array with tallied coin flips
		int[] tally = {0, 0};
		//int variable for coin flip value
		int flip;
		//flipping loop
		for (int i = 0; i < 1000; i++) {
			//Coin flip with 50% probability of heads or tails
			flip = (Math.random() <= 0.5) ? 1 : 2;
			if (flip == 1) {
				tally[0]++;
			} else if (flip == 2) {
				tally[1]++;
			}
		}
		//if-else statement to catch error in coin flips (mainly for testing)
		if (tally[0] + tally[1] == 1000) {
			System.out.println("Count of Head: " + tally[0]);
			System.out.println("Count of Tail: " + tally[1]);
		} else {
			System.out.println("The program failed: total != 1000");
		}
		
	}

}
