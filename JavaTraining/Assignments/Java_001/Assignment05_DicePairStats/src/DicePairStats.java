
public class DicePairStats {
	/*
	void sort(int arr[], String combos[]) {
		int n = arr.length;
		for (int i = 0; i < n-1; i++) {
			//find the maximum element in unsorted array
			int max_idx = i;
			for (int j = i+1; j < n; j++) {
				if (arr[j] > arr[max_idx]) {
					max_idx = j;
				}
				int temp = arr[max_idx];
				String tempCom = combos[max_idx];
				arr[max_idx] = arr[i];
				combos[max_idx] = combos[i];
				arr[i] = temp;
				combos[i] = tempCom;
			}
		}
	}
	*/
	void bubbleSort(int arr[], String combos[]) {
		int n = arr.length;
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) {
				if (arr[j] < arr[j + 1]) {
					//swap them
					int temp = arr[j];
					String tempCom = combos[j];
					arr[j] = arr[j+1];
					combos[j] = combos[j + 1];
					arr[j + 1] = temp;
					combos[j + 1] = tempCom;
				}
			}
		}
	}
	public static void main(String[] args) {
		/* Dice pair assignments:
		 * [0] = 6,1
		 * [1] = 6,2
		 * [2] = 6,3
		 * [3] = 6,4
		 * [4] = 6,5
		 * [5] = 6,6
		 * [6] = 5,1
		 * [7] = 5,2
		 * [8] = 5,3
		 * [9] = 5,4
		 * [10] = 5,5
		 * [11] = 4,1
		 * [12] = 4,2
		 * [13] = 4,3
		 * [14] = 4,4
		 * [15] = 3,1
		 * [16] = 3,2
		 * [17] = 3,3
		 * [18] = 2,1
		 * [19] = 2,1
		 * [20] = 1,1
		 */
		int die1;
		int die2;
		int[] diceTally = new int[21];
		String[] diceCombo = {"6 and 1", "6 and 2", "6 and 3", "6 and 4", "6 and 5", "6 and 6", "5 and 1", "5 and 2", "5 and 3", "5 and 4", "5 and 5", "4 and 1", "4 and 2", "4 and 3", "4 and 4", "3 and 1", "3 and 2", "3 and 3", "2 and 1", "2 and 2", "1 and 1"};
		System.out.println("1000 Random 2 dice toss stats");
		for (int i = 0; i < 1000; i++) {
			die1 = 1 + (int)(Math.random() * ((6-1) + 1));
			die2 = 1 + (int)(Math.random() * ((6-1) + 1));
			//Assigning dice tally values (predetermined, listed above)
			if ((die1 == 6 && die2 == 1) || (die2 == 6 && die1 == 1)) {
				diceTally[0]++;
			} else if ((die1 == 6 && die2 == 2) || (die2 == 6 && die1 == 2)) {
				diceTally[1]++;
			} else if ((die1 == 6 && die2 == 3) || (die2 == 6 && die1 == 3)) {
				diceTally[2]++;
			} else if ((die1 == 6 && die2 == 4) || (die2 == 6 && die1 == 4)) {
				diceTally[3]++;
			} else if ((die1 == 6 && die2 == 5) || (die2 == 6 && die1 == 5)) {
				diceTally[4]++;
			} else if (die1 == 6 && die2 == 6) {
				diceTally[5]++;
			} else if ((die1 == 5 && die2 == 1) || (die2 == 5 && die1 == 1)) {
				diceTally[6]++;
			} else if ((die1 == 5 && die2 == 2) || (die2 == 5 && die1 == 2)) {
				diceTally[7]++;
			} else if ((die1 == 5 && die2 == 3) || (die2 == 5 && die1 == 3)) {
				diceTally[8]++;
			} else if ((die1 == 5 && die2 == 4) || (die2 == 5 && die1 == 4)) {
				diceTally[9]++;
			} else if (die1 == 5 && die2 == 5) {
				diceTally[10]++;
			} else if ((die1 == 4 && die2 == 1) || (die2 == 4 && die1 == 1)) {
				diceTally[11]++;
			}else if ((die1 == 4 && die2 == 2) || (die2 == 4 && die1 == 2)) {
				diceTally[12]++;
			}else if ((die1 == 4 && die2 == 3) || (die2 == 4 && die1 == 3)) {
				diceTally[13]++;
			}else if (die1 == 4 && die2 == 4) {
				diceTally[14]++;
			} else if ((die1 == 3 && die2 == 1) || (die2 == 3 && die1 == 1)) {
				diceTally[15]++;
			} else if ((die1 == 3 && die2 == 2) || (die2 == 3 && die1 == 2)) {
				diceTally[16]++;
			} else if (die1 == 3 && die2 == 3) {
				diceTally[17]++;
			} else if ((die1 == 2 && die2 == 1) || (die2 == 2 && die1 == 1)) {
				diceTally[18]++;
			} else if (die1 == 2 && die2 == 2) {
				diceTally[19]++;
			} else if (die1 == 1 && die2 == 1) {
				diceTally[20]++;
			}
			
		}
		//begin sorting of dice tally and combos
		DicePairStats ob = new DicePairStats();
		ob.bubbleSort(diceTally, diceCombo);
		//arrays are now sorted
		System.out.println("1000 Random 2 dice toss stats:");
		for (int i = 0; i < 21; i++) {
			if (diceTally[i] != 0) {
				System.out.println("Dice " + diceCombo[i] + ": " + diceTally[i]);
			} else {
				System.out.println("Dice " + diceCombo[i] + ": 0 occurrence");
			}
			
		}
		
		
	}

}
