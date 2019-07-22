import javax.swing.*;
import java.awt.event.*;

public class RollButton implements ActionListener{
	JLabel jlab;
	JLabel userResult;
	JLabel compResult;
	JLabel winLoss;
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
		jlab = new JLabel("Roll the Dice!");
		userResult = new JLabel();
		compResult = new JLabel();
		winLoss = new JLabel();
		// Add the label to the frame.
		frm.add(jlab);
		frm.add(userResult);
		frm.add(compResult);
		frm.add(winLoss);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(first)) {
			//int coin = coin();
			//String result = flipCoin(coin);
			String[][] labels = setArray();
			
			int userDie1 = diceThrow();
			int userDie2 = diceThrow();
			int compDie1 = diceThrow();
			int compDie2 = diceThrow();
			int userSum = dieSum(userDie1, userDie2);
			int compSum = dieSum(compDie1, compDie2);
			String compDice = compDice(compDie1, compDie2, labels);
			String userDice = userDice(userDie1, userDie2, labels);
			String result = diceResult(userSum, userDie1, userDie2, compSum, compDie1, compDie2);
			
			resultMsg = "Rolling the Dice!";
			jlab.setText(resultMsg + "\n");
			userResult.setText(userDice + "\n");
			compResult.setText(compDice + "\n");
			winLoss.setText(result);
			
			
		} else {
			jlab.setText(waitMsg);
			userResult.setText("");
			compResult.setText("");
			winLoss.setText("");
		}
		
	}
	public int diceThrow() {
		DiceThrow diceThrow = () -> {
			int dice = 1 + (int)(Math.random() * ((6-1) + 1));
			return dice;
		};
		int dice = diceThrow.func();
		return dice;
	}
	
	public int dieSum(int dice1, int dice2) {
		DieSum dieSum = (die1, die2) -> {
			int sum = die1 + die2;
			return sum;
		};
		int sum = dieSum.func(dice1, dice2);
		return sum;
	}
	
	public String compDice(int die1, int die2, String[][] labels) {
		String compResult = "I have rolled a " + die1 + " and " + die2 + " > the " + labels[die1 - 1][die2 - 1];
		return compResult;
	}
	public String userDice(int die1, int die2, String[][] labels) {
		String userResult = "I have rolled a " + die1 + " and " + die2 + " > the " + labels[die1 - 1][die2 - 1];
		return userResult;
	}
	
	public String diceResult(int userSum, int userDie1, int userDie2, int compSum, int compDie1, int compDie2) {
		String result;
		if (compSum > userSum) {
			result = "I win!!";
			return result;
		} else if ((compSum == userSum) && (userDie1 == userDie2)){
			result = "Damn! You win on a Double! What luck!";
			return result;
		} else if ((compSum == userSum) && (compDie1 == compDie2)){
			result = "Damn! I win on a Double! Ah! I pity you fool!";
			return result;
		} else if((compSum == userSum) && ((compDie1 != compDie2) && (userDie1 != userDie2))) {
			result = "Stalemate! You're tough, let's go again!";
			return result;
		} else {
			result = "You win!!";
			return result;
		}
		//return result;
	}
	
	public String[][] setArray() {
		String[][] diceLabels = new String[6][6];
		diceLabels[0][0] = "Snake Eyes";
		diceLabels[0][1] = "Australian yo";
		diceLabels[0][2] = "Little Joe From Kokomo";
		diceLabels[0][3] = "No field five";
		diceLabels[0][4] = "Easy six";
		diceLabels[0][5] = "Six one you're done";
		diceLabels[1][0] = "Ace caught a deuce";
		diceLabels[1][1] = "Ballerina";
		diceLabels[1][2] = "The fever";
		diceLabels[1][3] = "Jimmie Hicks";
		diceLabels[1][4] = "Benny Blue";
		diceLabels[1][5] = "Easy eight";
		diceLabels[2][0] = "Easy four";
		diceLabels[2][1] = "OJ";
		diceLabels[2][2] = "Brooklyn Forest";
		diceLabels[2][3] = "Big Red";
		diceLabels[2][4] = "Eighter from Decatur";
		diceLabels[2][5] = "Nina from Pasadena";
		diceLabels[3][0] = "Little Phoebe";
		diceLabels[3][1] = "Easy six";
		diceLabels[3][2] = "Skinny McKinney";
		diceLabels[3][3] = "Square pair";
		diceLabels[3][4] = "Railroad nine";
		diceLabels[3][5] = "Big one on the end";
		diceLabels[4][0] = "Sixie from Dixie";
		diceLabels[4][1] = "Skinny Dugan";
		diceLabels[4][2] = "Easy eight";
		diceLabels[4][3] = "Jesse James";
		diceLabels[4][4] = "Puppy paws";
		diceLabels[4][5] = "Yo";
		diceLabels[5][0] = "The Devil";
		diceLabels[5][1] = "Easy eight";
		diceLabels[5][2] = "Lou Brown";
		diceLabels[5][3] = "Tennessee";
		diceLabels[5][4] = "Six five no jive";
		diceLabels[5][5] = "Midnight";
		
		return diceLabels;
		
	}

	
}
