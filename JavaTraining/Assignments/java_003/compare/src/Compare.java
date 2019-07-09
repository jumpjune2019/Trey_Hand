import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Compare {
	static boolean compareContents(byte arr1[], byte arr2[]) {
		boolean same;
		
		//compare two byte arrays to test if they are the same
		/*
		for (int i = 0; i < arr1.length;i++) {
			if(Arrays.equals(arr1[i], arr2[i]) == false) {
				
			}
		}
		*/
		same = Arrays.equals(arr1, arr2);
		return same;
	}

	public static void main(String[] args) throws FileNotFoundException{
		if (args.length == 2) {
			FileInputStream fis1 = new FileInputStream(args[0]);
			FileInputStream fis2 = new FileInputStream(args[1]);
			int fileSize1 = 0;
			int fileSize2 = 0;
			byte[] buffer1 = new byte[1024];
			byte[] buffer2 = new byte[1024];
			int i = 0;
			int j = 0;
			boolean same;
			//NOTE: separate while loops, while (i=fis1.read() != -1), iterate counter
			//then check if counters are the same
			try {
				while ((i=fis1.read(buffer1)) != -1) {
					fileSize1 += i;
				}
				while ((j=fis2.read(buffer2)) != -1) {
					fileSize2 += j;
				}
				System.out.println("Output: " + args[0] + " and " + args[1] + ":");
				if (fileSize1 == fileSize2) {
					same = compareContents(buffer1, buffer2);
					
					if (same == true) {
						System.out.println("Result: identical content");
						System.out.println("\tcharacter length for both: " + fileSize1);
					} else {
						System.out.println("Result: identical length, different content");
						System.out.println("\tcharacter length for both: " + fileSize1);
					}
				} else {
					System.out.println("Result: different content");
					System.out.println("\tcharacter length for " + args[0] + ": " + fileSize1);
					System.out.println("\tcharacter length for " + args[1] + ": " + fileSize2);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("Incorrect number of command line arguments");
		}

	}

}
