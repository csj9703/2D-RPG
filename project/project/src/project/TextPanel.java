package project;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * This class is a panel that game text
 */
public class TextPanel 
{
	private JLabel textLabel = new JLabel();
	
	public JPanel createPanel()
	{
		JPanel textPanel   = new JPanel();
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
			text = "You have acquired the legendary Excalibur!";
			break;
		}
		textLabel.setText(text);
	}
	
	public void displayBattleResults(Enemy enemy)
	{
		String results = "You have defeated the " + enemy.getName() + " and gained " + enemy.getExp() + " exp!";
		textLabel.setText(results);
	}
	
	
	public void reset()
	{
		textLabel.setText("");
	}
	
}
