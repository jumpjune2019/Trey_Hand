import java.util.Scanner;
import java.awt.Component;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import java.sql.SQLOutput;

public class KeyPressPOC {
	//String keyValue = e.getKeyText(e.getKeyCode());
	public static void main(String[] args) {
		
		//KeyListener listener = new KeyListener();
		//KeyEvent e = new KeyEvent(Component source, int id, long when, int modifiers, int keyCode, char keyChar, int keyLocation);
		KeyListener listener = new KeyListener();
		Scanner input = new Scanner(System.in);
		//controlKey(e);
		//String key = input.keyTyped();
		MyThread ob1 = new MyThread("1");
		MyThread ob2 = new MyThread("2");
		MyThread ob3 = new MyThread("3");
		MyThread ob4 = new MyThread("4");
		MyThread ob5 = new MyThread("5");
		MyThread[] threads = {ob1, ob2, ob3, ob4, ob5};
		JFrame jf = new JFrame("key event");
		jf.setSize(10,10);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.addKeyListener(new KeyListener());
		jf.setVisible(true);
	}

	static int grabKey() {
		int key;
		/*
		while (data != 27 ) {
			int data = System.in.read();
		}
		*/
		for(;;) {
			try {
				key = System.in.read();
				
				if (key == 27) {
					break;
				}
				return key;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return key;
	}

}
