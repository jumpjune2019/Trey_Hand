
public class Main {

	public static void main(String[] args) {
		String myList[] = {"Bozo", "FooBar", "Delta", "Foozball", "Demo", "Money", "Zoo"};
		int foundIndexes[];
		boolean found;
		ExactMatch arrayHasExactMatch = (list, s, b) -> {
			boolean isFound = false;
			int n = list.length;
			for (int i = 0; i < n; i++) {
				if (b == false) {
					//found = arr[i].equalsIgnoreCase(s);
					if (list[i].equalsIgnoreCase(s)) {
						isFound = true;
						break;
					}
				}
				else {
					if (list[i].equals(s)) {
						isFound = true;
						break;
					}
				}
			}
			return isFound;
		};
		
		IndexOfOccurance indexOfOccuranceInArray = (list, s, b) -> {
			int n = list.length;
			int tempIndexes[] = new int[7];
			int indexes[];
			int indexCounter = 0;
			int foundCounter = 0;

			for (int i = 0; i < n; i++) {
				if (b == false) {
					if (list[i].equalsIgnoreCase(s)) {
						tempIndexes[indexCounter] = i;
						indexCounter++;
						foundCounter++;
					}
				}
				else {
					if (list[i].equals(s)) {
						tempIndexes[indexCounter] = i;
						indexCounter++;
						foundCounter++;
					}
				}
			}
			
			if (foundCounter == 0) {
				indexes = new int[1];
				indexes[0] = -1;
			} else {
				indexes = new int[foundCounter];
				for (int i = 0; i < indexes.length; i++) {
					indexes[i] = tempIndexes[i];
				}
			}
			tempIndexes = null;
			return indexes;
		};
		//testing the arrayHasExactMatch method
		System.out.println("This is a test of the arrayHasExactMatch and indexOfOccurenceInArray methods");
		System.out.println("The array to test contains the following items:");
		System.out.println("{'" + myList[0] + "', '" + myList[1] + "', '" + myList[2] + "', '" + myList[3] + "', '" + myList[4] + "', '" + myList[5] + "', '" + myList[6] + "'}");
		System.out.println("\n\n");
		System.out.println("Scenario 1");
		found = arrayHasExactMatch.func(myList, "zo", false);
		System.out.println("arrayHasExactMatch (myList, 'zo', false): is " + found);
		System.out.println();
		
		System.out.println("Scenario 2");
		found = arrayHasExactMatch.func(myList, "zoo", false);
		System.out.println("arrayHasExactMatch (myList, 'zoo', false): is " + found);
		System.out.println();
		
		System.out.println("Scenario 3");
		found = arrayHasExactMatch.func(myList, "zoo", true);
		System.out.println("arrayHasExactMatch (myList, 'zoo', true): is " + found);
		System.out.println();
		
		System.out.println("Scenario 4");
		found = arrayHasExactMatch.func(myList, "foo", true);
		System.out.println("arrayHasExactMatch (myList, 'foo', true): is " + found);
		System.out.println();
		
		System.out.println("Scenario 5");
		found = arrayHasExactMatch.func(myList, "foo", false);
		System.out.println("arrayHasExactMatch (myList, 'foo', false): is " + found);
		System.out.println();
		
		System.out.println("Scenario 6");
		found = arrayHasExactMatch.func(myList, "delta", true);
		System.out.println("arrayHasExactMatch (myList, 'delta', true): is " + found);
		System.out.println();
		
		System.out.println("Scenario 7");
		found = arrayHasExactMatch.func(myList, "Delta", true);
		System.out.println("arrayHasExactMatch (myList, 'Delta', true): is " + found);
		System.out.println();
		
		
		System.out.println("\n\n");
		//testing the indexOfOccurranceInArray method
		System.out.println("Scenario 8");
		foundIndexes = indexOfOccuranceInArray.func(myList, "zo", false);
		System.out.print("indexOfOccuranceInArray (myList, 'zo', false) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 9");
		foundIndexes = indexOfOccuranceInArray.func(myList, "zoo", false);
		System.out.print("indexOfOccuranceInArray (myList, 'zoo', false) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 10");
		foundIndexes = indexOfOccuranceInArray.func(myList, "zoo", true);
		System.out.print("indexOfOccuranceInArray (myList, 'zoo', true) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 11");
		foundIndexes = indexOfOccuranceInArray.func(myList, "foo", true);
		System.out.print("indexOfOccuranceInArray (myList, 'foo', true) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 12");
		foundIndexes = indexOfOccuranceInArray.func(myList, "foo", false);
		System.out.print("indexOfOccuranceInArray (myList, 'foo', false) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 13");
		foundIndexes = indexOfOccuranceInArray.func(myList, "delta", true);
		System.out.print("indexOfOccuranceInArray (myList, 'delta', true) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 14");
		foundIndexes = indexOfOccuranceInArray.func(myList, "Delta", true);
		System.out.print("indexOfOccuranceInArray (myList, 'Delta', true) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
	}

}
