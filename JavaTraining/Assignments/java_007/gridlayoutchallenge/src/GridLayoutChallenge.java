import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.Random.*;

import javax.swing.*;

public class GridLayoutChallenge  implements ActionListener {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public GridLayoutChallenge(){
      prepareGUI();
   }
   
   private void prepareGUI(){
      mainFrame = new JFrame("Grid Layout Example");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      headerLabel = new JLabel("",JLabel.CENTER );
      statusLabel = new JLabel("",JLabel.CENTER);        
      statusLabel.setSize(350,100);
      
      // old school way to close a window
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
             // this is the way to force a java application to gracefully exit
        	 // when not going to end via the main method entry point
        	 System.exit(0);
         }        
      });    
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   
   private void showGridLayoutDemo() throws NullPointerException {
      headerLabel.setText("Layout in action: GridLayout");      
      statusLabel.setText("Press a button, I dare you...");
      JPanel panel = new JPanel();
      panel.setBackground(Color.CYAN);
      panel.setSize(300,300);
      int x = getRandomRange(2, 5);
      int y = getRandomRange(2, 5);
      GridLayout layout = new GridLayout(x,y);
      layout.setHgap(10);
      layout.setVgap(10);
      panel.setLayout(layout);
      
      JButton[][] buttons = new JButton[x][y];

      /*
      String prefixLabel = "Button ";
      for (x = 0; x < length; x++) {
    	  buttons[x] = new JButton(prefixLabel.concat(Integer.toString(x + 1)));
    	  buttons[x].addActionListener(this);
    	  panel.add(buttons[x]);
      }
      */
      for (int i = 0; i < x; i++) {
    	  for (int j = 0; j < y; j++) {
    		  switch(i) {
    		  case 0:
    			  buttons[i][j] = new JButton("A".concat(Integer.toString(j + 1)));
    			  buttons[i][j].addActionListener(this);
    			  panel.add(buttons[i][j]);
    			  break;
    		  case 1:
    			  buttons[i][j] = new JButton("B".concat(Integer.toString(j + 1)));
    			  buttons[i][j].addActionListener(this);
    			  panel.add(buttons[i][j]);
    			  break;
    		  case 2:
    			  buttons[i][j] = new JButton("C".concat(Integer.toString(j + 1)));
    			  buttons[i][j].addActionListener(this);
    			  panel.add(buttons[i][j]);
    			  break;
    		  case 3:
    			  buttons[i][j] = new JButton("D".concat(Integer.toString(j + 1)));
    			  buttons[i][j].addActionListener(this);
    			  panel.add(buttons[i][j]);
    			  break;
    		  case 4:
    			  buttons[i][j] = new JButton("E".concat(Integer.toString(j + 1)));
    			  buttons[i][j].addActionListener(this);
    			  panel.add(buttons[i][j]);
    			  break;
    		  }
    		  
    	  }
      }
      
      controlPanel.add(panel);
      mainFrame.setVisible(true);  
   }
 
   public void actionPerformed(ActionEvent ae) {
	   statusLabel.setText(ae.getActionCommand());
   }
   public int getRandomRange(int min, int max) {
	   if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
   }
   
   public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GridLayoutChallenge gridLayoutDemo = new GridLayoutChallenge();  
			    gridLayoutDemo.showGridLayoutDemo();
			}
		});      
   }
}