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
	private JLabel gameInstructions = new JLabel();
	private JLabel gameInstructions2 = new JLabel();
	
	public JPanel createPanel()
	{
		JPanel startScenePanel  = new JPanel();
		startScenePanel.setLayout(null);
		startScenePanel.setBackground(Color.BLACK);
		startScenePanel.setBounds(0, 0, 665, 750);
		// first label
		gameInstructions.setBounds(0,0,665,300);
		gameInstructions.setFont(new Font("info", Font.PLAIN, 100));
		gameInstructions.setForeground(Color.WHITE);
		String gameInfo = "MAZE RPG";
		gameInstructions.setText(gameInfo);
		/// second label
		gameInstructions2.setBounds(0,300,665,300);
		gameInstructions2.setFont(new Font("info", Font.PLAIN, 20));
		gameInstructions2.setForeground(Color.WHITE);
		String gameInfo2 = "<html>" + "PLAYER CONTROLS:" + "<br/>"
						  + "<br/>" + "Press ENTER to start game"
						  + "<br/>" + "Press ARROW keys to move"
			              + "<br/>" + "Press A to attack" 
			              + "<br/>" + "Press I to open or close the inventory menu" 
			              + "</html>";
		gameInstructions2.setText(gameInfo2);

		startScenePanel.add(gameInstructions);
		startScenePanel.add(gameInstructions2);
		
		return startScenePanel;
	}
}
