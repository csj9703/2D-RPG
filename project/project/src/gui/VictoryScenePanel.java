package gui;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * This class is a panel that displays the victory scene
 */
public class VictoryScenePanel 
{
	private JLabel background = new JLabel();
	private JLabel victoryMessage = new JLabel();
	private ImageIcon BG_Icon = new ImageIcon(new ImageIcon("src/graphics/victory.gif").getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT));
	private ImageIcon title = new ImageIcon(new ImageIcon("src/graphics/congratulations.png").getImage().getScaledInstance(609, 114, Image.SCALE_DEFAULT));
	/** 
	 * This method creates and returns a JPanel
	 */
	public JPanel createPanel()
	{
		JPanel victoryScenePanel = new JPanel();
		victoryScenePanel.setLayout(null);
		victoryScenePanel.setBackground(Color.BLACK);
		victoryScenePanel.setBounds(0, 0, 700, 700);

		background.setIcon(BG_Icon);
		background.setBounds(0, 0, 700, 700);
		
		victoryMessage.setIcon(title);
		victoryMessage.setBounds(15, 100, 700, 200);

		victoryScenePanel.add(victoryMessage);
		victoryScenePanel.add(background);
		
		return victoryScenePanel;
	}
}