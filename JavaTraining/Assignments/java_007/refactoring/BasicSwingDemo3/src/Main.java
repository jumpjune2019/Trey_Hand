// A simple Swing Program
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
public class Main {
	public static void centerAndSizeJFrameOnScreen(JFrame frm, int width, int height) {
		
		CenterAndSize centerAndSize = (f, w, h) -> {
			f.setSize(w/2, h/2);
			f.setLocationRelativeTo(null);
		};
		centerAndSize.func(frm, width, height);
	}

	public static void setLabelsToFrame(JFrame frm) {
		
		SetLabels setLabels = (f) -> {
			int labelsEnumLength = LabelsEnum.values().length;
			int count = 0;
			JLabel myLabels[] = new JLabel[labelsEnumLength];
			MyLabel tempLabel;
			for(LabelsEnum le : LabelsEnum.values()) {
				tempLabel = new MyLabel();
				myLabels[count] = tempLabel.setLabel(le.getLabel(), le.getPosition(), f);
				count++;
			}
		};
		setLabels.func(frm);
		
	}
	
	public static JFrame setFrameStuff(JFrame frm, int onExit, int width, int height) {
		SetFrame setFrame = (f, e, w, h) -> {
			centerAndSizeJFrameOnScreen(f, 400, 400);
			f.setDefaultCloseOperation(onExit);
			setLabelsToFrame(f);
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
				demo = new SwingDemo("Centered JFrame 400 by 200 with 5 labels");
				frm = demo.getFrame();
				frm = setFrameStuff(frm, JFrame.EXIT_ON_CLOSE, 400, 200);
				frm.setVisible(true);
			}
		});
	}
}