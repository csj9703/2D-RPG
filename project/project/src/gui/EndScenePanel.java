package gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * This class is a panel that displays the death scene
 */
public class EndScenePanel 
{
	private JLabel background = new JLabel();
	private JLabel gameInstructions = new JLabel();	
	private ImageIcon BG_Icon = new ImageIcon(new ImageIcon("src/graphics/gameOver.png").getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT));
	private ImageIcon title = new ImageIcon(new ImageIcon("src/graphics/YouDied.png").getImage().getScaledInstance(500, 700, Image.SCALE_DEFAULT));
	/**
	 * This method creates and returns a JPanel
	 */
	public JPanel createPanel()
	{
		JPanel endScenePanel   = new JPanel();
		endScenePanel .setLayout(null);
		endScenePanel .setBackground(Color.BLACK);
		endScenePanel .setBounds(0, 0, 700, 700);

		background.setIcon(BG_Icon);
		background.setBounds(0, 0, 700, 700);
		
		gameInstructions.setIcon(title);
		gameInstructions.setBounds(65, 50, 700, 700);
		
		endScenePanel .add(gameInstructions);
		endScenePanel .add(background);
		
		return endScenePanel;
	}
}