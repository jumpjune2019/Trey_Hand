import java.awt.event.*;
import javax.swing.*;

public class FlipButton implements ActionListener {
	JLabel jlab;
	String first;
	String second;
	String waitMsg;
	String resultMsg;
	
	public void setButton(JPanel frm, String f, String s, String fMsg, String sMsg) {
		first = f;
		second = s;
		waitMsg = sMsg;
		resultMsg = fMsg;
		
		JButton jbtnUp = new JButton(first);
		JButton jbtnDown = new JButton(second);
		// Add action listeners.
		jbtnUp.addActionListener(this);
		jbtnDown.addActionListener(this);
		// Add the buttons to the content pane.
		frm.add(jbtnUp);
		frm.add(jbtnDown);
		// Create a label.
		jlab = new JLabel("Flip a coin!");
		// Add the label to the frame.
		frm.add(jlab);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(first)) {
			int coin = coin();
			String result = flipCoin(coin);
			resultMsg = result;
			jlab.setText(resultMsg);
		} else {
			jlab.setText(waitMsg);
		}
		
	}
	
	public int coin() {
		RandomNum ran = () -> {
			int coin = (Math.random() <= 0.5) ? 1 : 2;
			return coin;
		};
		int coin = ran.func();
		return coin;
	}
	
	public String flipCoin(int coin) {
		Flip flip = (coinVal) -> {
			String result;
			if (coinVal == 1) {
				result = "Head!";
				return result;
			} else {
				result = "Tail!";
				return result;
			}
			
		};
		String result = flip.func(coin);
		return result;
	}
	
	

}
