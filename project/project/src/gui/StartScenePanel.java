package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * This class is a panel that displays the starting game menu
 */
public class StartScenePanel 
{
	private JLabel background = new JLabel();
	private JLabel gameInstructions = new JLabel();
	private JLabel gameInstructions2 = new JLabel();
	private ImageIcon BG_Icon = new ImageIcon(new ImageIcon("src/graphics/titleBG.gif").getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT));
	private ImageIcon title = new ImageIcon(new ImageIcon("src/graphics/Title.png").getImage().getScaledInstance(609, 114, Image.SCALE_DEFAULT));
	/** 
	 * This method creates and returns a JPanel
	 */
	public JPanel createPanel()
	{
		JPanel startScenePanel  = new JPanel();
		startScenePanel.setLayout(null);
		startScenePanel.setBackground(Color.BLACK);
		startScenePanel.setBounds(0, 0, 665, 750);

		background.setIcon(BG_Icon);
		background.setBounds(0, 0, 700, 700);
		
		gameInstructions.setIcon(title);
		gameInstructions.setBounds(15, 25, 700, 200);
		
		gameInstructions2.setBounds(15,300,665,300);
		gameInstructions2.setFont(new Font("info", Font.PLAIN, 20));
		gameInstructions2.setForeground(Color.WHITE);
		String gameInfo2 = "<html>" + "PLAYER CONTROLS:" + "<br/>"
						  + "<br/>" + "Press ENTER to start a new game"
						  + "<br/>" + "Press L then ENTER to resume game"	
						  + "<br/>" 
						  + "<br/>" + "Press ARROW keys to move"
			              + "<br/>" + "Press A to attack" 
			              + "<br/>" + "Press I to open or close the inventory menu" 
			              + "</html>";
		gameInstructions2.setText(gameInfo2);
		
		startScenePanel.add(gameInstructions);
		startScenePanel.add(gameInstructions2);
		startScenePanel.add(background);
		
		return startScenePanel;
	}
}