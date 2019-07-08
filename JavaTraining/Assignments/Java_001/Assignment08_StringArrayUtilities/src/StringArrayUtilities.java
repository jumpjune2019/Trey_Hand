import java.util.Arrays;

public class StringArrayUtilities {
	boolean arrayHasExactMatch(String arr[], String s, boolean b) {
		boolean found = false;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (b == false) {
				//found = arr[i].equalsIgnoreCase(s);
				if (arr[i].equalsIgnoreCase(s)) {
					found = true;
					break;
				}
			}
			else {
				if (arr[i].equals(s)) {
					found = true;
					break;
				}
				//found = arr[i].equals(s);
			}
		}
		return found;
	}
	
	int[] indexOfOccuranceInArray(String arr[], String s, boolean b) {
		int n = arr.length;
		int tempIndexes[] = new int[7];
		int foundIndexes[];
		int indexCounter = 0;
		int foundCounter = 0;

		for (int i = 0; i < n; i++) {
			if (b == false) {
				if (arr[i].equalsIgnoreCase(s)) {
					tempIndexes[indexCounter] = i;
					indexCounter++;
					foundCounter++;
				}
			}
			else {
				if (arr[i].equals(s)) {
					tempIndexes[indexCounter] = i;
					indexCounter++;
					foundCounter++;
				}
			}
		}
		
		if (foundCounter == 0) {
			foundIndexes = new int[1];
			foundIndexes[0] = -1;
		} else {
			foundIndexes = new int[foundCounter];
			for (int i = 0; i < foundIndexes.length; i++) {
				foundIndexes[i] = tempIndexes[i];
			}
		}
		tempIndexes = null;
		return foundIndexes;
	}
	public static void main(String[] args) {
		String myList[] = {"Bozo", "FooBar", "Delta", "Foozball", "Demo", "Money", "Zoo"};
		int foundIndexes[];
		boolean found;
		
		//testing the arrayHasExactMatch method
		StringArrayUtilities ob = new StringArrayUtilities();
		System.out.println("This is a test of the arrayHasExactMatch and indexOfOccurenceInArray methods");
		System.out.println("The array to test contains the following items:");
		System.out.println("{'" + myList[0] + "', '" + myList[1] + "', '" + myList[2] + "', '" + myList[3] + "', '" + myList[4] + "', '" + myList[5] + "', '" + myList[6] + "'}");
		System.out.println("\n\n");
		System.out.println("Scenario 1");
		found = ob.arrayHasExactMatch(myList, "zo", false);
		System.out.println("arrayHasExactMatch (myList, 'zo', false): is " + found);
		System.out.println();
		
		System.out.println("Scenario 2");
		found = ob.arrayHasExactMatch(myList, "zoo", false);
		System.out.println("arrayHasExactMatch (myList, 'zoo', false): is " + found);
		System.out.println();
		
		System.out.println("Scenario 3");
		found = ob.arrayHasExactMatch(myList, "zoo", true);
		System.out.println("arrayHasExactMatch (myList, 'zoo', true): is " + found);
		System.out.println();
		
		System.out.println("Scenario 4");
		found = ob.arrayHasExactMatch(myList, "foo", true);
		System.out.println("arrayHasExactMatch (myList, 'foo', true): is " + found);
		System.out.println();
		
		System.out.println("Scenario 5");
		found = ob.arrayHasExactMatch(myList, "foo", false);
		System.out.println("arrayHasExactMatch (myList, 'foo', false): is " + found);
		System.out.println();
		
		System.out.println("Scenario 6");
		found = ob.arrayHasExactMatch(myList, "delta", true);
		System.out.println("arrayHasExactMatch (myList, 'delta', true): is " + found);
		System.out.println();
		
		System.out.println("Scenario 7");
		found = ob.arrayHasExactMatch(myList, "Delta", true);
		System.out.println("arrayHasExactMatch (myList, 'Delta', true): is " + found);
		System.out.println();
		
		
		System.out.println("\n\n");
		//testing the indexOfOccurranceInArray method
		System.out.println("Scenario 8");
		foundIndexes = ob.indexOfOccuranceInArray(myList, "zo", false);
		System.out.print("indexOfOccuranceInArray (myList, 'zo', false) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 9");
		foundIndexes = ob.indexOfOccuranceInArray(myList, "zoo", false);
		System.out.print("indexOfOccuranceInArray (myList, 'zoo', false) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 10");
		foundIndexes = ob.indexOfOccuranceInArray(myList, "zoo", true);
		System.out.print("indexOfOccuranceInArray (myList, 'zoo', true) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 11");
		foundIndexes = ob.indexOfOccuranceInArray(myList, "foo", true);
		System.out.print("indexOfOccuranceInArray (myList, 'foo', true) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 12");
		foundIndexes = ob.indexOfOccuranceInArray(myList, "foo", false);
		System.out.print("indexOfOccuranceInArray (myList, 'foo', false) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 13");
		foundIndexes = ob.indexOfOccuranceInArray(myList, "delta", true);
		System.out.print("indexOfOccuranceInArray (myList, 'delta', true) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 14");
		foundIndexes = ob.indexOfOccuranceInArray(myList, "Delta", true);
		System.out.print("indexOfOccuranceInArray (myList, 'Delta', true) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
	}

}
