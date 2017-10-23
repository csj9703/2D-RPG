package project;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * This class is a panel that displays the victory scene
 */
public class VictoryScenePanel 
{
	private JLabel victoryMessage = new JLabel();
	
	public JPanel createPanel()
	{
		JPanel victoryScenePanel = new JPanel();
		victoryScenePanel.setLayout(null);
		victoryScenePanel.setBackground(Color.BLACK);
		victoryScenePanel.setBounds(0, 0, 700, 700);

		victoryMessage.setBounds(0,0,700,700);
		victoryMessage.setFont(new Font("info", Font.PLAIN, 48));
		victoryMessage.setForeground(Color.WHITE);
	
		String gameMessage = "CONGRATULATIONS";
	
		victoryMessage.setText(gameMessage);

		victoryScenePanel.add(victoryMessage);
		
		return victoryScenePanel;
	}
}
