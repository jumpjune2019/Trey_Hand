import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.Random.*;
import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.regex.*;

public class SeatingGrid extends JFrame implements ActionListener {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JPanel titlePanel;
   private JPanel listPanel;
   private String selectedId;
   JLabel[][] seatLabels;
   JButton[][] buttons;
   //String[] seated = new String[25];
   //int seatedCount = 0;
   LinkedList<String> seated = new LinkedList<String>();
   
   ClientStore myStore = new ClientStore("clients_list.csv");
   Client[] store = myStore.getClientStore();
   
   public SeatingGrid(){
      prepareGUI();
   }
   
   private void prepareGUI(){
      mainFrame = new JFrame("Grid Layout Example");
      mainFrame.setSize(1200,700);
      //mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.setLayout(new BorderLayout());
      headerLabel = new JLabel("",JLabel.CENTER );
      //statusLabel = new JLabel("",JLabel.CENTER);        
     // statusLabel.setSize(350,100);
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
        	 System.exit(0);
         }        
      });    
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      controlPanel.setSize(700, 700);
      titlePanel = new JPanel();
      listPanel = new JPanel();
      titlePanel.setSize(1000, 100);
      titlePanel.add(headerLabel);
      listPanel.setSize(300, 1000);
      //listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
      listPanel.setLayout(new BorderLayout());
      mainFrame.add(titlePanel, BorderLayout.NORTH);
      mainFrame.add(controlPanel, BorderLayout.CENTER);
      mainFrame.add(listPanel, BorderLayout.WEST);
     // mainFrame.add(statusLabel, BorderLayout.SOUTH);
      mainFrame.setVisible(true);  
   }
   
   private void showGridLayoutDemo() throws NullPointerException {
      headerLabel.setText("Theater Seating Grid"); 
      
      //reading in clients from XML file
      String[] clientNames = new String[store.length];
      for (int i = 0; i < store.length; i++) {
    	  clientNames[i] = store[i].getClientFirstName() + " " + store[i].getClientLastName();
      }
      
      JList<String> clientList = new JList<String>(clientNames);
      ListSelectionListener listener = new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			selectedId = clientList.getSelectedValue();
			//System.out.println("SelectedId: " + selectedId);
		}
    	  
      };
      clientList.addListSelectionListener(listener);
      JScrollPane scrlp = new JScrollPane(clientList);
      scrlp.setPreferredSize(new Dimension(200, 400));
      listPanel.add(scrlp, BorderLayout.NORTH);
      
      JPanel resetPanel = new JPanel();
      JButton reset = new JButton("Reset");
      ActionListener resetListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			resetAll(buttons, seatLabels);
			seated.clear();
		}
      };
      reset.addActionListener(resetListener);
      resetPanel.add(reset);
      JButton printButton = new JButton("Print All Booked");
      ActionListener printListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			printList(seated);
		}
    	  
      };
      printButton.addActionListener(printListener);
      resetPanel.add(printButton);
      
      
      
      listPanel.add(resetPanel, BorderLayout.SOUTH);
      
      
      JPanel panel = new JPanel();
      panel.setBackground(Color.CYAN);
      //panel.setLayout(new BorderLayout());
      panel.setSize(700,700);
      int x = 10;
      int y = 10;
      GridLayout layout = new GridLayout(x,y);
      layout.setHgap(5);
      layout.setVgap(5);
      panel.setLayout(layout);
      Dimension buttonSize = new Dimension(80, 30);
      buttons = new JButton[x][y];
      seatLabels = new JLabel[x][y];
      JPanel buttonPanel;

      for (int i = 0; i < x; i++) {
    	  for (int j = 0; j < y; j++) {
    		  switch(i) {
    		  case 0:
    			  buttonPanel = new JPanel();
    			  buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    			  seatLabels[i][j] = new JLabel("Empty");
    			  
    			  buttons[i][j] = new JButton("A".concat(Integer.toString(j + 1)));
    			  buttons[i][j].setActionCommand(Integer.toString(i) + " " + Integer.toString(j) + " " + buttons[i][j].getText());
    			  buttons[i][j].addActionListener(this);
    			  buttons[i][j].setPreferredSize(buttonSize);
    			  buttonPanel.add(seatLabels[i][j]);
    			  buttonPanel.add(buttons[i][j]);
    			  panel.add(buttonPanel);
    			  break;
    		  case 1:
    			  buttonPanel = new JPanel();
    			  buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    			  seatLabels[i][j] = new JLabel("Empty");
    			  
    			  buttons[i][j] = new JButton("B".concat(Integer.toString(j + 1)));
    			  buttons[i][j].setActionCommand(Integer.toString(i) + " " + Integer.toString(j) + " " + buttons[i][j].getText());
    			  buttons[i][j].addActionListener(this);
    			  buttons[i][j].setPreferredSize(buttonSize);
    			  buttonPanel.add(seatLabels[i][j]);
    			  buttonPanel.add(buttons[i][j]);
    			  panel.add(buttonPanel);
    			  break;
    		  case 2:
    			  buttonPanel = new JPanel();
    			  buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    			  seatLabels[i][j] = new JLabel("Empty");
    			  
    			  buttons[i][j] = new JButton("C".concat(Integer.toString(j + 1)));
    			  buttons[i][j].setActionCommand(Integer.toString(i) + " " + Integer.toString(j) + " " + buttons[i][j].getText());
    			  buttons[i][j].addActionListener(this);
    			  buttons[i][j].setPreferredSize(buttonSize);

    			  buttonPanel.add(seatLabels[i][j]);
    			  buttonPanel.add(buttons[i][j]);
    			  panel.add(buttonPanel);
    			  break;
    		  case 3:
    			  buttonPanel = new JPanel();
    			  buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    			  seatLabels[i][j] = new JLabel("Empty");
    			  
    			  buttons[i][j] = new JButton("D".concat(Integer.toString(j + 1)));
    			  buttons[i][j].setActionCommand(Integer.toString(i) + " " + Integer.toString(j) + " " + buttons[i][j].getText());
    			  buttons[i][j].addActionListener(this);
    			  buttons[i][j].setPreferredSize(buttonSize);

    			  buttonPanel.add(seatLabels[i][j]);
    			  buttonPanel.add(buttons[i][j]);
    			  panel.add(buttonPanel);
    			  break;
    		  case 4:
    			  buttonPanel = new JPanel();
    			  buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    			  seatLabels[i][j] = new JLabel("Empty");
    			  
    			  buttons[i][j] = new JButton("E".concat(Integer.toString(j + 1)));
    			  buttons[i][j].setActionCommand(Integer.toString(i) + " " + Integer.toString(j) + " " + buttons[i][j].getText());
    			  buttons[i][j].addActionListener(this);
    			  buttons[i][j].setPreferredSize(buttonSize);

    			  buttonPanel.add(seatLabels[i][j]);
    			  buttonPanel.add(buttons[i][j]);
    			  panel.add(buttonPanel);
    			  break;
    		  case 5:
    			  buttonPanel = new JPanel();
    			  buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    			  seatLabels[i][j] = new JLabel("Empty");
    			  
    			  buttons[i][j] = new JButton("F".concat(Integer.toString(j + 1)));
    			  buttons[i][j].setActionCommand(Integer.toString(i) + " " + Integer.toString(j) + " " + buttons[i][j].getText());
    			  buttons[i][j].addActionListener(this);
    			  buttons[i][j].setPreferredSize(buttonSize);

    			  buttonPanel.add(seatLabels[i][j]);
    			  buttonPanel.add(buttons[i][j]);
    			  panel.add(buttonPanel);
    			  break;
    		  case 6:
    			  buttonPanel = new JPanel();
    			  buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    			  seatLabels[i][j] = new JLabel("Empty");
    			  
    			  buttons[i][j] = new JButton("G".concat(Integer.toString(j + 1)));
    			  buttons[i][j].setActionCommand(Integer.toString(i) + " " + Integer.toString(j) + " " + buttons[i][j].getText());
    			  buttons[i][j].addActionListener(this);
    			  buttons[i][j].setPreferredSize(buttonSize);

    			  buttonPanel.add(seatLabels[i][j]);
    			  buttonPanel.add(buttons[i][j]);
    			  panel.add(buttonPanel);
    			  break;
    		  case 7:
    			  buttonPanel = new JPanel();
    			  buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    			  seatLabels[i][j] = new JLabel("Empty");
    			  
    			  buttons[i][j] = new JButton("H".concat(Integer.toString(j + 1)));
    			  buttons[i][j].setActionCommand(Integer.toString(i) + " " + Integer.toString(j) + " " + buttons[i][j].getText());
    			  buttons[i][j].addActionListener(this);
    			  buttons[i][j].setPreferredSize(buttonSize);

    			  buttonPanel.add(seatLabels[i][j]);
    			  buttonPanel.add(buttons[i][j]);
    			  panel.add(buttonPanel);
    			  break;
    		  case 8:
    			  buttonPanel = new JPanel();
    			  buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    			  seatLabels[i][j] = new JLabel("Empty");
    			  
    			  buttons[i][j] = new JButton("I".concat(Integer.toString(j + 1)));
    			  buttons[i][j].setActionCommand(Integer.toString(i) + " " + Integer.toString(j) + " " + buttons[i][j].getText());
    			  buttons[i][j].addActionListener(this);
    			  buttons[i][j].setPreferredSize(buttonSize);

    			  buttonPanel.add(seatLabels[i][j]);
    			  buttonPanel.add(buttons[i][j]);
    			  panel.add(buttonPanel);
    			  break;
    		  case 9:
    			  buttonPanel = new JPanel();
    			  buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    			  seatLabels[i][j] = new JLabel("Empty");
    			  
    			  buttons[i][j] = new JButton("J".concat(Integer.toString(j + 1)));
    			  buttons[i][j].setActionCommand(Integer.toString(i) + " " + Integer.toString(j) + " " + buttons[i][j].getText());
    			  buttons[i][j].addActionListener(this);
    			  buttons[i][j].setPreferredSize(buttonSize);

    			  buttonPanel.add(seatLabels[i][j]);
    			  buttonPanel.add(buttons[i][j]);
    			  panel.add(buttonPanel);
    			  break;
    		  }
    		  
    	  }
      }
      
      controlPanel.add(panel);
      mainFrame.setVisible(true);  
   }
 
   public void actionPerformed(ActionEvent ae) {
	   boolean isSeated;
	   int listIndex;
	   String[] arr = ae.getActionCommand().split(" ");
	   int x = Integer.parseInt(arr[0]);
	   int y = Integer.parseInt(arr[1]);
	   String rowAndSeat = arr[2];
	   for (int i = 0; i < 25; i++) {
		   if (selectedId.contains(store[i].getClientFirstName() + " " + store[i].getClientLastName())) {

			   isSeated = checkSeated(selectedId, seated);
			   
			   //if the selected person is seated in the seat in question
			   if ((isSeated == true) && seatLabels[x][y].getText().equals(store[i].getClientId() + " / " + store[i].getClientInitials())) {
				   buttons[x][y].setText(rowAndSeat);
				   seatLabels[x][y].setText("Empty");
				   listIndex = seated.indexOf(selectedId + " - " + rowAndSeat);
				   seated.remove(listIndex);
				   
				   //if the person is seated, but NOT in the seat in question
			   } else if ((isSeated == true) && !(seatLabels[x][y].getText().equals(store[i].getClientId() + " / " + store[i].getClientInitials()))) {
				  
				   //if the person is not seated, but the seat is not empty
			   } else if ((isSeated == false) && !(seatLabels[x][y].getText().equals("Empty"))) {
				   
			   } else {
				   seated.add(selectedId + " - " + rowAndSeat);
				   //System.out.println("added to list: " + seated.getLast());
				   buttons[x][y].setText("Booked");
				   seatLabels[x][y].setText(store[i].getClientId() + " / " + store[i].getClientInitials());

			   }
			   
		   } else if (selectedId == null){
			   
		   }
	   }
   }
   
   public boolean checkSeated (String selectedId, LinkedList<String> seated) {

	   boolean isSeated = false;
	   for (String temp : seated) {
		   if (temp.matches(selectedId + " - [A-J][0-9]+")) {
			   isSeated = true;
			   return isSeated;
		   } else {
			   continue;
		   }
	   }
	   return isSeated;
   }
   
   
   public static void resetAll(JButton[][] buttons, JLabel[][] seatLabels) {
	   char row = 'A';
	   for (int i = 0; i < 10; i++) {
		   for (int j = 0; j < 10; j++) {
			   buttons[i][j].setText(String.valueOf(row) + (j + 1));
			   seatLabels[i][j].setText("Empty");
		   }
		   row++;
	   }
   }
   
   
   public static void printList(LinkedList<String> seated) {
	   if (!(seated.isEmpty())) {
		   for (String seat: seated) {
			   System.out.println(seat);
		   }
	   } else {
		   System.out.println("No users seated!");
	   }
	   
   }
   
   public int getRandomRange(int min, int max) {
	   if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
   }
   //public void
   
   public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SeatingGrid gridLayout = new SeatingGrid();  
			    gridLayout.showGridLayoutDemo();
			}
		});      
   }
}