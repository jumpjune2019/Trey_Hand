package app;
import arrayutils.ArrUtil;

public class StringArrayUtilities2 {

	public static void main(String[] args) {
		String myList[] = {"Bozo", "FooBar", "Delta", "Foozball", "Demo", "Money", "Zoo"};
		int foundIndexes[];
		boolean found;
		
		//testing the arrayHasExactMatch method

		System.out.println("This is a test of the arrayHasExactMatch and indexOfOccurenceInArray methods");
		System.out.println("The array to test contains the following items:");
		System.out.println("{'" + myList[0] + "', '" + myList[1] + "', '" + myList[2] + "', '" + myList[3] + "', '" + myList[4] + "', '" + myList[5] + "', '" + myList[6] + "'}");
		System.out.println("\n\n");
		System.out.println("Scenario 1");
		found = ArrUtil.arrayHasExactMatch(myList, "zo", false);
		System.out.println("arrayHasExactMatch (myList, 'zo', false): is " + found);
		System.out.println();
		
		System.out.println("Scenario 2");
		found = ArrUtil.arrayHasExactMatch(myList, "zoo", false);
		System.out.println("arrayHasExactMatch (myList, 'zoo', false): is " + found);
		System.out.println();
		
		System.out.println("Scenario 3");
		found = ArrUtil.arrayHasExactMatch(myList, "zoo", true);
		System.out.println("arrayHasExactMatch (myList, 'zoo', true): is " + found);
		System.out.println();
		
		System.out.println("Scenario 4");
		found = ArrUtil.arrayHasExactMatch(myList, "foo", true);
		System.out.println("arrayHasExactMatch (myList, 'foo', true): is " + found);
		System.out.println();
		
		System.out.println("Scenario 5");
		found = ArrUtil.arrayHasExactMatch(myList, "foo", false);
		System.out.println("arrayHasExactMatch (myList, 'foo', false): is " + found);
		System.out.println();
		
		System.out.println("Scenario 6");
		found = ArrUtil.arrayHasExactMatch(myList, "delta", true);
		System.out.println("arrayHasExactMatch (myList, 'delta', true): is " + found);
		System.out.println();
		
		System.out.println("Scenario 7");
		found = ArrUtil.arrayHasExactMatch(myList, "Delta", true);
		System.out.println("arrayHasExactMatch (myList, 'Delta', true): is " + found);
		System.out.println();
		
		
		System.out.println("\n\n");
		//testing the indexOfOccurranceInArray method
		System.out.println("Scenario 8");
		foundIndexes = ArrUtil.indexOfOccuranceInArray(myList, "zo", false);
		System.out.print("indexOfOccuranceInArray (myList, 'zo', false) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 9");
		foundIndexes = ArrUtil.indexOfOccuranceInArray(myList, "zoo", false);
		System.out.print("indexOfOccuranceInArray (myList, 'zoo', false) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 10");
		foundIndexes = ArrUtil.indexOfOccuranceInArray(myList, "zoo", true);
		System.out.print("indexOfOccuranceInArray (myList, 'zoo', true) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 11");
		foundIndexes = ArrUtil.indexOfOccuranceInArray(myList, "foo", true);
		System.out.print("indexOfOccuranceInArray (myList, 'foo', true) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 12");
		foundIndexes = ArrUtil.indexOfOccuranceInArray(myList, "foo", false);
		System.out.print("indexOfOccuranceInArray (myList, 'foo', false) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 13");
		foundIndexes = ArrUtil.indexOfOccuranceInArray(myList, "delta", true);
		System.out.print("indexOfOccuranceInArray (myList, 'delta', true) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");
		
		System.out.println("Scenario 14");
		foundIndexes = ArrUtil.indexOfOccuranceInArray(myList, "Delta", true);
		System.out.print("indexOfOccuranceInArray (myList, 'Delta', true) returns ");
		for (int i = 0; i < foundIndexes.length; i++) {
			System.out.print("[" + foundIndexes[i] + "] ");
		}
		System.out.println("\n");

	}

}
