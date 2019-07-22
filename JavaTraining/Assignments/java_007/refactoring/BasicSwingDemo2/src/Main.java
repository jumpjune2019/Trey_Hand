// A simple Swing Program
import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class Main {

	public static void centerAndSizeJFrameOnScreen(JFrame frm) {
	    CenterAndSize centerAndSize = (f) -> {
	    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    	int height = screenSize.height;
			int width = screenSize.width;

			f.setSize(width/2, height/2);

			f.setLocationRelativeTo(null);
	    };
	    
	    centerAndSize.func(frm);
	}
	
	public static JFrame setFrameStuff(JFrame frm, int onExit, String label) {
		SetFrame setFrame = (f, e, l) -> {
			centerAndSizeJFrameOnScreen(f);
			f.setDefaultCloseOperation(e);
			JLabel lab = new JLabel(l);
			f.add(lab);
			return f;
		};
		frm = setFrame.func(frm, onExit, label);
		return frm;
	}
	
	public static void main(String args[]) {
		
		SwingUtilities.invokeLater(new Runnable() {
			SwingDemo demo;
			JFrame frm;
			public void run() {
				demo = new SwingDemo("Centered JFrame");
				frm = demo.getFrame();
				frm = setFrameStuff(frm, JFrame.EXIT_ON_CLOSE, "My label in a centered JFrame");
				frm.setVisible(true);
			}
		});
	}
}