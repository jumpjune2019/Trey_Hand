import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class MyThread implements Runnable {
	
	Thread thrd;
	//boolean suspended;
	boolean stopped;
	
	MyThread(String name) {
		thrd = new Thread(this, name);
		//suspended = false;
		stopped = false;
		thrd.start();
		
	}

	@Override
	public void run() {
		
		try {
			while (!stopped) {

				for(Light light : Light.values()) {
					synchronized(this) {
						if(stopped) {
							break;
						}
					}
					System.out.print("Light is " + light.getLight());
					switch (light.getLight()) {
					case "Green" :
						System.out.println(" - Go!");
						TimeUnit.SECONDS.sleep(5);
						synchronized(this) {
							if(stopped) {
								break;
							}
						}
						break;
					case "Yellow" :
						System.out.println(" - Beware!");
						TimeUnit.SECONDS.sleep(2);
						synchronized(this) {
							if(stopped) {
								break;
							}
						}
						break;
					case "Red" :
						System.out.println(" - Stop!");
						TimeUnit.SECONDS.sleep(3);
						synchronized(this) {
							if(stopped) {
								break;
							}
						}
						break;
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		System.out.println(thrd.getName() + " starting.");
		try {
			while (!stopped) {
				System.out.println("executing thread " + thrd.getName());
				Thread.sleep(5000);
				synchronized(this) {
					while(suspended) {
						System.out.println("Pausing thread" + thrd.getName());
						wait();
					}
					if(stopped) {
						//System.out.println("Thread " + thrd.getName() + " stopping permanently");
						break;
					}
				}
				
			}
			
		} catch (InterruptedException e) {
			System.out.println(thrd.getName() + " interrupted.");
		}
		System.out.println("Permanently stopping execution of thread " + thrd.getName());
		*/

	}
	
	//stop the thread
	synchronized void mystop() {
		stopped = true;
		
		//Ensures that a suspended thread can be false
		//suspended = false;
		notify();
	}
	/*
	//suspend the thread
	synchronized void mysuspend() {
		//suspended = true;
	}
	//resuming thread
	synchronized void myresume() {
		//suspended = false;
		notify();
	}
	*/
	//imported from multithreading project
	synchronized boolean getStopped() {
		if (stopped == true) {
			return true;
		} else {
			return false;
		}
	}

}
