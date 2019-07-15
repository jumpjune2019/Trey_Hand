//import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class KeyListener implements java.awt.event.KeyListener {

	public KeyListener() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	public void doSomething(KeyEvent e){
		MyThread ob1 = new MyThread("1");
		MyThread ob2 = new MyThread("2");
		MyThread ob3 = new MyThread("3");
		MyThread ob4 = new MyThread("4");
		MyThread ob5 = new MyThread("5");
		MyThread[] threads = {ob1, ob2, ob3, ob4, ob5};
        int keyPressed = e.getKeyCode();  //1==49 //2==50 //3==51 //4==52  //5==53  //S==83 //T==84 //L==76 // N==78
        String controlInput;
		int stopCount = 0;
		boolean allStopped = false;
		do {
			switch (keyPressed) {
	        case 49:
	        	if (ob1.getStopped() == false) {
					//controlThread(ob1); //method to pass control of one particular thread over
					//stopCount = countStops(ob1, stopCount); //method to count how many threads are stopped
					//allStopped = checkStop(stopCount, allStopped, threads); //method to check if all are stopped, and if so, exit
					if (allStopped == true) {
						break; //exit do-while once all threads are stopped
					} else {
						continue;
					}
				} else {
					System.out.println("Thread " + ob1.thrd.getName() + " is already stopped.");
					continue;
				}
	        	//doSomething(e);
	        	//break;
	        case 50:
	        	System.out.println(" 2 is is being pressed do something with it");
	        	break;
	        case 51:
	        	System.out.println(" 3 is is being pressed do something with it");
	        	break;
	        case 52:
	        	System.out.println(" 4 is is being pressed do something with it");
	        	break;
	        case 53:
	        	System.out.println(" 5 is is being pressed do something with it");
	        	break;
	        case 83:
	        	System.out.println(" s is is being pressed do something with it");
	        	break;
	        case 84:
	        	System.out.println(" t is is being pressed do something with it");
	        	break;
	        case 76:
	        	System.out.println(" l is is being pressed do something with it");
	        	break;
	        case 78:
	        	System.out.println(" n is is being pressed do something with it");
	        	break;

	        }
		}while (!allStopped);
        
    }

}
