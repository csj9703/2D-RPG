package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Enemy;
import game.Player;
/*
 * This class is a panel that displays the battle scenes
 */
public class BattlePanel 
{
	private JLabel enemyStatistics = new JLabel();
	private JLabel playerStatistics = new JLabel();
	private JLabel battleResults = new JLabel();
	private JLabel background;
	private JLabel playerLB = new JLabel();
	private JLabel enemyLB = new JLabel();
	private ImageIcon player_Icon = new ImageIcon(new ImageIcon("src/graphics/player.gif").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	private ImageIcon BG_Icon = new ImageIcon(new ImageIcon("src/graphics/backgroundPH.gif").getImage().getScaledInstance(700, 350, Image.SCALE_DEFAULT));
	private ImageIcon enemy_Icon;
	/**
	 * This method creates and returns a JPanel
	 */
	public JPanel createPanel(Player player, Enemy enemy)
	{
		JPanel battlePanel = new JPanel();
		battlePanel.setLayout(null);
		battlePanel.setBackground(Color.BLACK);
		battlePanel.setBounds(0, 0, 700, 700);

		enemyStatistics.setBounds(400,350,300,100);
		enemyStatistics.setFont(new Font("info", Font.PLAIN, 18));
		enemyStatistics.setForeground(Color.RED);
		
		playerStatistics.setBounds(50,350,300,100);
		playerStatistics.setFont(new Font("info", Font.PLAIN, 18));
		playerStatistics.setForeground(Color.RED);
		
		battleResults.setBounds(50,400,300,200);
		battleResults.setFont(new Font("info", Font.PLAIN, 18));
		battleResults.setForeground(Color.RED);
		battleResults.setVisible(false);
		
		battlePanel.add(enemyLB);
		battlePanel.add(playerLB);
		battlePanel.add(getBackground());
		battlePanel.add(playerStatistics);
		battlePanel.add(enemyStatistics);
		battlePanel.add(battleResults);
		
		return battlePanel;
	}
	/**
	 * This method updates the battle interface after each input command
	 * @param player The player
	 * @param enemy The enemy
	 */
	public void update(Player player, Enemy enemy)
	{
		setPlayerModel();
		setEnemyModel(enemy.getName());
		String enemyInfo = "<html>" + "Enemy Name: " + enemy.getName() 
                         + "<br/>" + "Enemy HP: " + enemy.getHealth() 
                         + "</html>";
		enemyStatistics.setText(enemyInfo);
		
		String playerInfo = "<html>" + "Player Name: " + player.getName()
                          + "<br/>" + "Player HP: " + player.getHealth() + "/" + player.getMaxHealth()
                          + "</html>";
		playerStatistics.setText(playerInfo);
		
		String battleInfo ="<html>" + "You hit the " + enemy.getName() + " for " + player.getDamage() + " damage!"
						  + "<br/>" + "<br/>" + enemy.getName() + " has hit you for " + enemy.getDamage() + " damage!";
		battleResults.setText(battleInfo);
	}
	/**
	 * This method displays the battle results
	 */
	public void showBattleResults()
	{
		battleResults.setVisible(true);
	}
	/**
	 * This method hides the battle results
	 */
	public void hideBattleResults()
	{
		battleResults.setVisible(false);
	}
	/**
	 * Setter Method for the player model.
	 */
	private void setPlayerModel()
	{
		playerLB.setIcon(player_Icon);
		playerLB.setBounds(100,0,150,500);
	}
	/**
	 * Getter Method for the background returns background label.
	 */
	private JLabel getBackground() 
	{
		background = new JLabel();
		background.setIcon(BG_Icon);
		background.setBounds(0,0,700,350);
		return background;
	}
	/**
	 * Setter Method for the Enemy model.
	 * @param enemy Name
	 */
	private void setEnemyModel(String enemyName) 
	{
		int xCoord = 0;
		int yCoord = 0;
		if(enemyName.equals("Zombie")) 
		{
			enemy_Icon = new ImageIcon(new ImageIcon("src/graphics/zombie.gif").getImage().getScaledInstance(90, 125, Image.SCALE_DEFAULT));
			xCoord = 425; yCoord = 190;
		}
		else if(enemyName.equals("Skeleton")) 
		{
			enemy_Icon = new ImageIcon(new ImageIcon("src/graphics/skeleton.gif").getImage().getScaledInstance(115, 125, Image.SCALE_DEFAULT));
			xCoord = 350; yCoord = 175;
		}
		else if(enemyName.equals("Skeleking"))
		{
			enemy_Icon = new ImageIcon(new ImageIcon("src/graphics/skeletonKing.gif").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
			xCoord = 350; yCoord = 175;
		}
		else if(enemyName.equals("Knight")) 
		{
			enemy_Icon = new ImageIcon(new ImageIcon("src/graphics/blackKnight.gif").getImage().getScaledInstance(175, 175, Image.SCALE_DEFAULT));
			xCoord = 350; yCoord = 175;
		}
		else if(enemyName.equals("Reaper")) 
		{
			enemy_Icon = new ImageIcon(new ImageIcon("src/graphics/reaper.gif").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
			xCoord = 350; yCoord = 175;
		}
		enemyLB.setIcon(enemy_Icon);
		enemyLB.setBounds(xCoord,yCoord,250,150);
	}
}