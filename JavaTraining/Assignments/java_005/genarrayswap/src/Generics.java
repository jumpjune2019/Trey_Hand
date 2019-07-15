
public class Generics {
	public static final <T> void swapArray(T arr[]) {
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
