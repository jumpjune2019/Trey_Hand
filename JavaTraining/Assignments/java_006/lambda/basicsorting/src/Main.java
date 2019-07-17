import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int numArr[] = {10, 3, 4, 15, 7, 9, 1, 21};
		String strArr[] = {"claude", "Phil", "lois", "clark", "Arthur", "Mera", "bruce"};
		
		SwapInt swapInt = (arr, c, b) -> {
			Integer[] intArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
			GenericFunc.swapArray(intArr, c, b);
		};
		
		SwapString swapString = (arr, c, b) -> {
			GenericFunc.swapArray(arr, c, b);
		};
		
		System.out.print("Initial Integer Array: {");
		for (int i = 0; i < numArr.length - 1; i++) {
			System.out.print(numArr[i] + ", ");
		}
		System.out.print(numArr[numArr.length - 1] + "}\n ");
		
		System.out.print("Sorted Asc: ");
		swapInt.func(numArr, 'a', false);
		System.out.println();
		
		System.out.print("Sorted Desc: ");
		swapInt.func(numArr, 'd', false);
		System.out.println();
		
		System.out.print("Initial String Array: {");
		for (int i = 0; i < strArr.length - 1; i++) {
			System.out.print(strArr[i] + ", ");
		}
		System.out.print(strArr[strArr.length - 1] + "}\n ");
		
		//ASC and case sensitive on
		System.out.print("Sorted Asc and Case Sensitive ON: ");
		swapString.func(strArr, 'a', true);
		System.out.println();
		
		//asc and case sensitive off
		System.out.print("Sorted Asc and Case Sensitive OFF: ");
		swapString.func(strArr, 'a', false);
		System.out.println();
		
		//desc and case sensitive on
		System.out.print("Sorted Desc and Case Sensitive ON: ");
		swapString.func(strArr, 'd', true);
		System.out.println();
		
		//desc and case sensitive off
		System.out.print("Sorted Desc and Case Sensitive OFF: ");
		swapString.func(strArr, 'd', false);
		System.out.println();
	}
	/*
	private static <T> void printFormatArr(T [] arr) {
		
	}
	*/
}
