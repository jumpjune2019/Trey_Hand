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
			/*
			BufferedInputStream fis1 = new BufferedInputStream(new FileInputStream(args[1]));
			BufferedInputStream fis2 = new BufferedInputStream(new FileInputStream(args[2]));
			int b1 = 0;
			int b2 = 0;
			int pos = 1;
			int fileSize1 = 0;
			int fileSize2 = 0;
			boolean same = true;
			while (b1 != -1 || b2 != -1) {
				if (b1 != b2) {
					same = false;
				}
				pos++;
				b1 = fis1.read();
				b2 = fis2.read();
			}
			
			if (same == false) {
				System.out.println("Result: Different Content");
				System.out.println("Character length for file " + args[1] + ": " + fis1.getContentLength());
			}
			*/
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
