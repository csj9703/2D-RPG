package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import game.Enemy;
/*
 * This class is a panel that game text
 */
public class TextPanel 
{
	private JLabel textLabel = new JLabel();
	/** 
	 * This method creates and returns a JPanel
	 */
	public JPanel createPanel()
	{
		JPanel textPanel = new JPanel();
		textPanel .setLayout(null);
		textPanel .setBackground(Color.BLACK);
		textPanel .setBounds(0, 0, 640, 50);

		textLabel.setBounds(0,0,640,50);
		textLabel.setFont(new Font("info", Font.PLAIN, 24));
		textLabel.setForeground(Color.WHITE);
		textLabel.setText("");

		textPanel.add(textLabel);
		
		return textPanel;
	}
	/** 
	 * This method is called to display a message when 
	 * an item is picked up 
	 * @param itemID The ID of the item
	 */
	public void update(int itemID)
	{
		String text = null;
		switch (itemID)
		{
		case 1:
			text = "You have acquired a Small potion!";
			break;
		case 2:
			text = "You have acquired a Medium potion!";
			break;
		case 3:
			text = "You have acquired a Large potion!";
			break;
		case 4:
			text = "You have acquired a Rusty Dagger!";
			break;
		case 5:
			text = "You have acquired a Iron Longsword!";
			break;
		case 6:
			text = "You have acquired the Excalibur!";
			break;
		}
		textLabel.setText(text);
	}
	/** 
	 * This method is called to display battle results when 
	 * an enemy is defeated
	 * @param enemy The enemy
	 */
	public void displayBattleResults(Enemy enemy)
	{
		String results = "You have defeated the " + enemy.getName() + " and gained " + enemy.getExperience() + " exp!";
		textLabel.setText(results);
	}
	/** 
	 * This method erases the label
	 */
	public void reset()
	{
		textLabel.setText("");
	}
}