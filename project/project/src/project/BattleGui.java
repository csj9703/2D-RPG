package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BattleGui
{
	private Player player;
	private Enemy enemy;
	
	private JFrame window = new JFrame();
	
	JPanel battlePanel;
	
	private JLabel playerLB;
	private JLabel enemyLB;
	private JLabel background;
	private JLabel battleInfo;
	
	private ImageIcon player_Icon = new ImageIcon(new ImageIcon("playerPH.gif").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	private ImageIcon BG_Icon = new ImageIcon(new ImageIcon("backgroundPH.gif").getImage().getScaledInstance(700, 350, Image.SCALE_DEFAULT));
	private ImageIcon enemy_Icon = new ImageIcon(new ImageIcon("enemyPH.gif").getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT));
	
	public BattleGui(Player aPlayer, Enemy aEnemy) 
	{
		player = aPlayer;
		enemy = aEnemy;
		
		final int WIDTH = 700;
		final int HEIGHT = 700;
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH, HEIGHT);
		window.setLayout(null);
		
		battlePanel = new JPanel();
		battlePanel.setLayout(null);
		battlePanel.setBackground(Color.BLACK);
		battlePanel.setBounds(0, 0, 700, 700);
		
		battleInfo = new JLabel();
		battleInfo.setFont(new Font("info", Font.PLAIN, 18));
		battleInfo.setBorder(BorderFactory.createEmptyBorder(0, 100, 100, 100));
		battleInfo.setBounds(0,315,WIDTH,300);
		
		battlePanel.add(battleInfo);
		battlePanel.add(getPlayerModel());
		battlePanel.add(getEnemyModel());
		battlePanel.add(getBackground());
		
		window.add(battlePanel);
	}
	public void updateMenu()
	{
		battlePanel.remove(battleInfo);
		battleInfo.setText(getMenu());
		battlePanel.add(battleInfo);
	}
	
	public void showGui(boolean bool) {
		window.setVisible(bool);
	}
	
	private JLabel getBackground() {
		background = new JLabel();
		background.setIcon(BG_Icon);
		background.setBounds(0,0,700,350);
		return background;
	}
	private JLabel getPlayerModel()
	{
		playerLB = new JLabel();
		playerLB.setIcon(player_Icon);
		playerLB.setBounds(100,0,150,500);
		return playerLB;
	}
	
	private JLabel getEnemyModel() 
	{
		enemyLB = new JLabel();
		enemyLB.setIcon(enemy_Icon);
		enemyLB.setBounds(350,200,250,150);
		return enemyLB;
	}
	private String getMenu() 
	{
		String menu = 
			  "<html><font color='red'>Your health: "+player.getHealth()+"<br />"
			+ "Enemy health: "+enemy.getHealth()+"<br />"
			+ "Your actions:<br />"
			+ "1: Attack enemy<br />"
			+ "2: Drink potion("+player.getNumOfPot()+")<br /><html>";
		return menu;
	}
	
	//public static void main(String[] args) {
	//}
}
