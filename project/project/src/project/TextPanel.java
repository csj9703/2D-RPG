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
	JLabel textLabel = new JLabel();
	
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

	public void update()
	{
		String text = "You have acquired a Potion!";
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
