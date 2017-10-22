package project;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * This class is a panel that displays the battle scenes
 */
public class BattlePanel 
{
	JLabel enemyStatistics = new JLabel();
	JLabel playerStatistics = new JLabel();
	
	public JPanel createPanel(Player player, Enemy enemy)
	{
		JPanel battlePanel = new JPanel();
		battlePanel.setLayout(null);
		battlePanel.setBackground(Color.BLACK);
		battlePanel.setBounds(0, 0, 700, 700);

		enemyStatistics.setBounds(400,000,300,100);
		enemyStatistics.setFont(new Font("info", Font.PLAIN, 18));
		
		playerStatistics.setBounds(50,0,300,100);
		playerStatistics.setFont(new Font("info", Font.PLAIN, 18));

		battlePanel.add(playerStatistics);
		battlePanel.add(enemyStatistics);
		
		return battlePanel;
	}
	
	// this method is run after every input command
	public void update(Player player, Enemy enemy)
	{
		String enemyInfo = "<html>" + "Enemy Name: " + enemy.getName() 
                          + "<br/>" + "Enemy HP: " + enemy.getHealth() 
                          + "</html>";
		enemyStatistics.setText(enemyInfo);
		
		String playerInfo = "<html>" + "Player Name: " + player.getName()
                           + "<br/>" + "Player HP: " + player.getHealth() 
                                     + "</html>";
		playerStatistics.setText(playerInfo);
	}
}

