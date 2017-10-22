package project;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * This class is a panel that displays the starting game menu
 */
public class StartScenePanel 
{
	JLabel gameInstructions = new JLabel();
	JLabel gameInstructions2 = new JLabel();
	
	public JPanel createPanel()
	{
		JPanel startScenePanel  = new JPanel();
		startScenePanel.setLayout(null);
		startScenePanel.setBackground(Color.BLACK);
		startScenePanel.setBounds(0, 0, 665, 750);
		// first label
		gameInstructions.setBounds(0,0,665,300);
		gameInstructions.setFont(new Font("info", Font.PLAIN, 46));
		gameInstructions.setForeground(Color.WHITE);
		String gameInfo = "HIT ENTER TO START GAME";
		gameInstructions.setText(gameInfo);
		/// second label
		gameInstructions2.setBounds(0,300,665,300);
		gameInstructions2.setFont(new Font("info", Font.PLAIN, 20));
		gameInstructions2.setForeground(Color.WHITE);
		String gameInfo2 = "<html>" + "PRESS THE ARROW KEYS TO MOVE"
			              + "<br/>" + "PRESS A TO ATTACK" 
			              + "<br/>" + "PRESS I TO OPEN INVENTORY (cannot use potion during combat)" 
			              + "</html>";
		gameInstructions2.setText(gameInfo2);

		startScenePanel.add(gameInstructions);
		startScenePanel.add(gameInstructions2);
		
		return startScenePanel;
	}
}
