
public class Main {

	public static void main(String[] args) {
		//Sample arrays
		String[] words = {"first", "second", "third", "forth", "fifth", "sixth"};
		Integer[] nums = {1, 2, 3, 4, 5, 6};
		Character[] letters = {'a', 'b', 'c', 'd', 'e', 'f'};
		
		System.out.println("Testing a swap function using generics:");
		
		System.out.println("Swapping strings: ");
		doWork(words);
		
		System.out.println("Swapping ints: ");
		doWork(nums);
		
		System.out.println("Swapping characters: ");
		doWork(letters);

	}
	
	private static <T> void doWork(T arr[]) {
		System.out.println("Before swapping: ");
		Generics.printArray(arr);
		Generics.swapArray(arr);
		System.out.println("After swapping: ");
		Generics.printArray(arr);
	}

}
