
class MyThread implements Runnable {
	Thread thrd;
	boolean suspended;
	boolean stopped;
	
	MyThread(String name) {
		thrd = new Thread(this, name);
		suspended = false;
		stopped = false;
		thrd.start();
		
	}

	@Override
	public void run() {
		System.out.println(thrd.getName() + " starting.");
		try {
			while (!stopped) {
				System.out.println("executing thread " + thrd.getName());
				Thread.sleep(2000);
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
		System.out.println("Permanently stopping execution of thread" + thrd.getName());

	}
	
	//stop the thread
	synchronized void mystop() {
		stopped = true;
		
		//Ensures that a suspended thread can be false
		suspended = false;
		notify();
	}
	//suspend the thread
	synchronized void mysuspend() {
		suspended = true;
	}
	//resuming thread
	synchronized void myresume() {
		suspended = false;
		notify();
	}
	synchronized void setPriorityHigh() {
		thrd.setPriority(Thread.MAX_PRIORITY);
		notify();
		System.out.println(thrd.getName() + " Priority has been set to High");
	}
	synchronized void setPriorityLow() {
		thrd.setPriority(Thread.MIN_PRIORITY);
		notify();
		System.out.println(thrd.getName() + " Priority has been set to Low");
	}
	synchronized void setPriorityNormal() {
		thrd.setPriority(Thread.NORM_PRIORITY);
		notify();
		System.out.println(thrd.getName() + " Priority has been set to Normal");
	}
	synchronized boolean getStopped() {
		if (stopped == true) {
			return true;
		} else {
			return false;
		}
	}

}
