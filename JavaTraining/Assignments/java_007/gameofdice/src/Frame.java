import javax.swing.JFrame;

public class Frame {
	private JFrame jfrm;
	Frame(String title) {
		jfrm = new JFrame(title);
	}
	
	public JFrame getFrame() {
		return jfrm;
	}
}
