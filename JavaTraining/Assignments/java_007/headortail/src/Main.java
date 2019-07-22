import javax.swing.*;
import java.awt.*;

public class Main {
	public static void centerAndSizeJFrameOnScreen(JFrame frm) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		
		frm.setSize(width/2, height/2);
		
		//center frame
		frm.setLocationRelativeTo(null);
		
	}
	public static JFrame setFrameStuff(JFrame frm, int onExit, String label) {
		
		centerAndSizeJFrameOnScreen(frm);
		
		frm.setDefaultCloseOperation(onExit);
		
		// Create a text-based label.
		JLabel lab = new JLabel(label);
		// Add the label to the content pane.
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		FlipButton fb1 = new FlipButton();
		fb1.setButton(panel1, "Click to Flip!", "Reset", null, "Waiting...");
		
		frm.add(panel1);
		return frm;
	}
	
	public static void main(String[] args) {
		
		
		SwingUtilities.invokeLater(new Runnable() {
			Frame frm;
			JFrame jfrm;
			public void run() {
				frm = new Frame("Head or Tail");
				jfrm = frm.getFrame();
				jfrm = setFrameStuff(jfrm, JFrame.EXIT_ON_CLOSE, "Head or Tail");
				jfrm.setVisible(true);
				
			}
		});
	}

}
