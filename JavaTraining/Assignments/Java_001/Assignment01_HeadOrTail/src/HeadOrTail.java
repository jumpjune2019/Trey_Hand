
public class HeadOrTail {

	public static void main(String[] args) {
		System.out.println("Coin Flip Program");
		//random value of 1 or 2 with 50% probability of each
		int flip = (Math.random() <= 0.5) ? 1 : 2;
		if (flip == 1) {
			System.out.println("The Coin Flip is: Heads");
		} else if (flip == 2) {
			System.out.println("The Coin Flip is: Tails");
		}

	}

}
