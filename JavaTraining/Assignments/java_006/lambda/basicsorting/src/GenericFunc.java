import java.util.Arrays;
public class GenericFunc {
	@SuppressWarnings("unchecked")
	public static final <T> void swapArray (T arr[], char d, boolean c) {
		//T arr[] = generic array
		//char d = direction -- (a = ascending) (d = descending)
		//boolean c = case (1 for case sensitive, 0 for case insensitive)
		if (arr[0] instanceof String && d == 'a' && c == false) {
			String[] words = (String []) arr.clone();
			Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
			printArray(words);
		} else if (arr[0] instanceof String && d == 'a' && c == true){
			String[] words = (String []) arr.clone();
			Arrays.sort(words);
			printArray(words);
			
		} else if (arr[0] instanceof String && d == 'd' && c == false){
			String[] words = (String []) arr.clone();
			Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
			reverseArray(words);
			printArray(words);
			
		} else if (arr[0] instanceof String && d == 'd' && c == true) {
			String[] words = (String []) arr.clone();
			Arrays.sort(words);
			reverseArray(words);
			printArray(words);
		} else if (arr[0] instanceof Integer && d == 'a') {
			int temp;
			Integer[] array = (Integer[]) arr.clone();
			for (int i = 0; i < arr.length; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					if (array[i] > array[j]) {
						temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
			}
			//arr = (T[]) array.clone();
			printArray(array);
		} else if (arr[0] instanceof Integer && d == 'd') {
			int temp;
			Integer[] array = (Integer[]) arr.clone();
			for (int i = 0; i < arr.length; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					if (array[i] < array[j]) {
						temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
			}
			//arr = (T[]) array.clone();
			printArray(array);
		}
	}
	
	public static final <T> void reverseArray(T arr[]) {
		for (int i = 0; i < arr.length/2; i++) {
			T temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
	}
	public static final <T> void printArray(T arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
