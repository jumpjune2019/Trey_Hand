// A simple Swing Program
import java.awt.*;
import javax.swing.*;
public class Main {
	
	public static void centerAndSizeJFrameOnScreen(JFrame frm, int width, int height) {
		CenterAndSize centerAndSize = (f, w, h) -> {
			f.setSize(w/2, h/2);
			f.setLocationRelativeTo(null);
		};
		centerAndSize.func(frm, width, height);
	}

	public static JFrame setFrameStuff(JFrame frm, int onExit, int width, int height) {
		SetFrame setFrame = (f, e, w, h) -> {
			centerAndSizeJFrameOnScreen(f, w, h);
			f.setDefaultCloseOperation(e);
			
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();
			
			panel1.setLayout(new FlowLayout());
			panel2.setLayout(new FlowLayout());
			
			ButtonDemo bd = new ButtonDemo();
			bd.setButtons(panel1, "First", "Second", "You Pressed First", "You Pressed Second");
			ButtonDemo bd2 = new ButtonDemo();
			bd2.setButtons(panel2, "Up", "Down", "Going Up!", "Going Down!");
			
			f.add(panel1);
			f.add(panel2);
			return f;
		};
		frm = setFrame.func(frm, onExit, width, height);
		return frm;
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			SwingDemo demo;
			JFrame frm;
			
			public void run() {
				demo = new SwingDemo("Playing with JButton using a FlowLayout");
				frm = demo.getFrame();
				frm = setFrameStuff(frm, JFrame.EXIT_ON_CLOSE, 400, 380);
				frm.setVisible(true);
			}
		});
	}
}