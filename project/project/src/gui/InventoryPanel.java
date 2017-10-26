package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Player;
/*
 * This class is a panel that displays the player's inventory
 */
public class InventoryPanel 
{
	private JLabel weaponInventory = new JLabel();
	private JLabel playerStatistics = new JLabel();
	private JLabel potionInventory = new JLabel();
	
	public JPanel createPanel(Player player)
	{
		JPanel inventoryPanel = new JPanel();
		inventoryPanel.setLayout(null);
		inventoryPanel.setBackground(Color.BLACK);
		inventoryPanel.setBounds(0, 0, 700, 700);

		playerStatistics.setBounds(350,000,300,100);
		playerStatistics.setFont(new Font("info", Font.PLAIN, 18));
		playerStatistics.setForeground(Color.WHITE);
		
		weaponInventory.setBounds(50,0,300,100);
		weaponInventory.setFont(new Font("info", Font.PLAIN, 18));
		weaponInventory.setForeground(Color.WHITE);
	
		potionInventory.setBounds(350,50,300,400);
		potionInventory.setFont(new Font("info", Font.PLAIN, 18));
		potionInventory.setForeground(Color.WHITE);
		
		inventoryPanel.add(playerStatistics);
		inventoryPanel.add(weaponInventory);
		inventoryPanel.add(potionInventory);
		
		return inventoryPanel;
	}

	// this method is run after every input command
	public void update(Player player)
	{
		player.getWeaponDamage();
		String weaponInfo = "Weapon: " + player.getCurrentWeapon();
		weaponInventory.setText(weaponInfo);

		String playerInfo = "<html>" + "Health: " + player.getHealth()
		                   + "<br/>" + "Level: " + player.getCurrentLevel()
		                   + "<br/>" + "EXP: " + player.getCurrentExp() + "/" + player.getExpToLvl()
		                   + "</html>"; 
			
		playerStatistics.setText(playerInfo);
		
		String potionInfo = "<html>" 
		                   + "<br/>" + "<br/>" +"All Items:"
		                   + "<br/>" + "Small Potion: " + player.getNumSmallPotions()
		                   + "<br/>" + "Medium Potion: " + player.getNumMediumPotions()
		                   + "<br/>" + "Large Potion: " + player.getNumLargePotions()
		                   + "<br/>" + "<br/>" + "Press 1 to consume a small potion"
		                   + "<br/>" + "Press 2 to consume a medium potion"
		                   + "<br/>" + "Press 3 to consume a large potion"
			               + "</html>"; 
		potionInventory.setText(potionInfo);
	}
}
