package arrayutils;

public class ArrUtil {
	public static boolean arrayHasExactMatch(String arr[], String s, boolean b) {
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
	
	public static int[] indexOfOccuranceInArray(String arr[], String s, boolean b) {
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
}
