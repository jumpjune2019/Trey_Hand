import java.util.Scanner;
import java.awt.event.*;
import java.sql.SQLOutput;
import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {

	public static void main(String[] args) {
		MyThread ob1 = new MyThread("1");
		MyThread ob2 = new MyThread("2");
		MyThread ob3 = new MyThread("3");
		MyThread ob4 = new MyThread("4");
		MyThread ob5 = new MyThread("5");
		MyThread[] threads = {ob1, ob2, ob3, ob4, ob5};
		Scanner input = new Scanner(System.in);
		String controlInput;
		int stopCount = 0;
		boolean allStopped = false;
		controlInput= input.next();

		while (!allStopped) {
			try {
				Thread.sleep(1000);
				controlInput = input.next();
				switch (controlInput.toLowerCase()) {
				case "1" :
					if (ob1.getStopped() == false) {
						controlThread(ob1); //method to pass control of one particular thread over
						stopCount = countStops(ob1, stopCount); //method to count how many threads are stopped
						allStopped = checkStop(stopCount, allStopped, threads); //method to check if all are stopped, and if so, exit
						if (allStopped == true) {
							break; //exit do-while once all threads are stopped
						} else {
							continue;
						}
					} else {
						System.out.println("Thread " + ob1.thrd.getName() + " is already stopped.");
						continue;
					}
					
				case "2" :
					if (ob2.getStopped() == false) {
						controlThread(ob2);
						stopCount = countStops(ob2, stopCount);
						allStopped = checkStop(stopCount, allStopped, threads);
						if (allStopped == true) {
							break;
						} else {
							continue;
						}
					} else {
						System.out.println("Thread " + ob2.thrd.getName() + " is already stopped.");
						continue;
					}
					
				case "3" :
					if (ob3.getStopped() == false) {
						controlThread(ob3);
						stopCount = countStops(ob3, stopCount);
						allStopped = checkStop(stopCount, allStopped, threads);
						if (allStopped == true) {
							break;
						} else {
							continue;
						}
					} else {
						System.out.println("Thread " + ob3.thrd.getName() + " is already stopped.");
						continue;
					}
					
				case "4" :
					if (ob4.getStopped() == false) {
						controlThread(ob4);
						stopCount = countStops(ob4, stopCount);
						allStopped = checkStop(stopCount, allStopped, threads);
						if (allStopped == true) {
							break;
						} else {
							continue;
						}
					} else {
						System.out.println("Thread " + ob4.thrd.getName() + " is already stopped.");
						continue;
					}
					
				case "5" :
					if (ob5.getStopped() == false) {
						controlThread(ob5);
						stopCount = countStops(ob5, stopCount);
						allStopped = checkStop(stopCount, allStopped, threads);
						if (allStopped == true) {
							break;
						} else {
							continue;
						}
					} else {
						System.out.println("Thread " + ob5.thrd.getName() + " is already stopped.");
						continue;
					}
				}
			} catch (InterruptedException e) {
				//System.out.println("Thread " + .thrd.getName() + " interrupted");
				e.printStackTrace();
			}
			
		}
		

	}

	
	public static void controlThread(MyThread ob) {
		Scanner input = new Scanner(System.in);
		String controlInput = ob.thrd.getName();
		boolean exit = false;
		System.out.println("Taking control of thread " + ob.thrd.getName());
						do  {
							controlInput = input.next();
							if (controlInput.equalsIgnoreCase(ob.thrd.getName())) {
								ob.mysuspend();
								controlInput = input.next();
								if (controlInput.equalsIgnoreCase(ob.thrd.getName())) {
									ob.myresume();
									continue;
								}
							} else if (controlInput.equalsIgnoreCase("s")) {
								try {
									ob.mystop();
									//wait for thread to finish
									ob.thrd.join();
									exit = true;
								} catch (InterruptedException e) {
									System.out.println("Thread " + ob.thrd.getName() + " interrupted");
								}
							} else if (controlInput.equalsIgnoreCase("t")){
								ob.setPriorityHigh();
								continue;
							} else if (controlInput.equalsIgnoreCase("l")){
								ob.setPriorityLow();
								continue;
							}
							 else if (controlInput.equalsIgnoreCase("n")){
									ob.setPriorityNormal();
									continue;
							} else {
								exit = true;
							}
						} while (exit == false);
						//return ob;
	}
	
	//counts threads that are stopped, and then updates total stop count
	public static int countStops(MyThread ob, int stopCount) {
		if (ob.getStopped() == true) {
			stopCount++;
			return stopCount;
		} else {
			return stopCount;
		}
	}
	//checks if all threads are stopped, and if not, returns the number of stopped threads
	public static boolean checkStop(int stopCount, boolean allStopped, MyThread[] threads) {
		if (stopCount >= 5){
			allStopped = true;
			System.out.println("All threads stopped, exiting.");
			return allStopped;
		} else {
			allStopped = false;
			System.out.println("Stopped threads: " + stopCount);
			chooseAvailable(threads);
			return allStopped;
		}
	}
	
	public static void chooseAvailable(MyThread[] threads) {
		int runCount = 0;
		String[] threadIndex = new String[5];
		for (int i = 0; i < threads.length; i++) {
			if (threads[i].getStopped() == false) {
				Array.set(threadIndex, runCount, threads[i].thrd.getName());
				runCount++;
			}
		}
		System.out.println("Threads Still Running: ");
		for (int i = 0; i < runCount; i++) {
			System.out.println("Thread " + threadIndex[i]);
		}
	}
}
