import javax.swing.SwingUtilities;
import javax.swing.*;
public class Main {

	public static JFrame setFrameStuff(JFrame frm, int width, int height, int onExit, String label) {
		SetFrame setFrame = (f, w, h, e, l) -> {
			f.setSize(w, h);
			f.setDefaultCloseOperation(e);
			JLabel lab = new JLabel(l);
			f.add(lab);
			return f;
		};
		frm = setFrame.func(frm, width, height, onExit, label);
		return frm;
	}
	
	public static void main(String args[]) {
	
		
		SwingUtilities.invokeLater(new Runnable() {
			SwingDemo demo;
			JFrame frm;
			public void run() {
				demo = new SwingDemo("Demo 1");
				frm = demo.getFrame();
				frm = setFrameStuff(frm, 375, 100, JFrame.EXIT_ON_CLOSE, "My label");
				frm.setVisible(true);
			}
		});
	}
}