package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
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
	private JLabel weaponIcon = new JLabel();
	private JLabel smallPotionIcon = new JLabel();
	private JLabel mediumPotionIcon = new JLabel();
	private JLabel largePotionIcon = new JLabel();
	private JLabel inventoryHeaderIcon = new JLabel();
	private ImageIcon rustyDagger = new ImageIcon("src/graphics/rusty_dagger.png");
	private ImageIcon ironLongsword = new ImageIcon("src/graphics/iron_longsword.png");
	private ImageIcon excalibur = new ImageIcon("src/graphics/excalibur.png");
	private ImageIcon smallPotion = new ImageIcon("src/graphics/small_potion.png");
	private ImageIcon mediumPotion = new ImageIcon("src/graphics/medium_potion.png");
	private ImageIcon largePotion = new ImageIcon("src/graphics/large_potion.png");
	private ImageIcon inventoryHeader = new ImageIcon("src/graphics/inventory_header.png");
	/**
	 * This method creates and returns a JPanel
	 * @param player The player
	 */
	public JPanel createPanel(Player player)
	{
		JPanel inventoryPanel = new JPanel();
		inventoryPanel.setLayout(null);
		inventoryPanel.setBackground(Color.BLACK);
		inventoryPanel.setBounds(0, 0, 700, 700);
		
		inventoryHeaderIcon.setBounds(125,0,400,100);
		inventoryHeaderIcon.setIcon(inventoryHeader);
		
		potionInventory.setBounds(350,70,400,400);
		potionInventory.setFont(new Font("info", Font.PLAIN, 18));
		potionInventory.setForeground(Color.WHITE);
		
		smallPotionIcon.setBounds(350,100,56,56);
		smallPotionIcon.setIcon(smallPotion);
		
		mediumPotionIcon.setBounds(406,100,56,56);
		mediumPotionIcon.setIcon(mediumPotion);
		
		largePotionIcon.setBounds(462,100,56,56);
		largePotionIcon.setIcon(largePotion);

		playerStatistics.setBounds(50,193,300,100);
		playerStatistics.setFont(new Font("info", Font.PLAIN, 18));
		playerStatistics.setForeground(Color.WHITE);
		
		weaponInventory.setBounds(50,70,280,100);
		weaponInventory.setFont(new Font("info", Font.PLAIN, 18));
		weaponInventory.setForeground(Color.WHITE);
		
		weaponIcon.setBounds(50,25,300,300);
		
		inventoryPanel.add(playerStatistics);
		inventoryPanel.add(weaponInventory);
		inventoryPanel.add(potionInventory);
		inventoryPanel.add(weaponIcon);
		inventoryPanel.add(inventoryHeaderIcon);
		inventoryPanel.add(smallPotionIcon);
		inventoryPanel.add(mediumPotionIcon);
		inventoryPanel.add(largePotionIcon);
		
		return inventoryPanel;
	}
	/**
	 * This method updates the inventory interface after each input command
	 * @param player The player
	 */
	public void update(Player player)
	{
		// displays currently equipped weapon
		player.getWeaponDamage();
		String weaponInfo = "<html>" + "Equipped Weapon: " 
						   + "<br/>" + player.getCurrentWeapon()
						   + "</html>"; 
		weaponInventory.setText(weaponInfo);
		// displays player statistics
		String playerInfo = "<html>" + "Health: " + player.getHealth() + "/" + player.getMaxHealth()
		                   + "<br/>" + "Level: " + player.getCurrentLevel()
		                   + "<br/>" + "EXP: " + player.getCurrentExp() + "/" + player.getExpToLvl()
		                   + "</html>"; 
			
		playerStatistics.setText(playerInfo);
		// updates weapon icon to currently equipped weapon
		switch(player.getCurrentWeapon())
		{
			case "Rusty Dagger":
				weaponIcon.setIcon(rustyDagger);
				break;
			case "Iron Longsword":
				weaponIcon.setIcon(ironLongsword);
				break;
			case "Blessed Excalibur":
				weaponIcon.setIcon(excalibur);
				break;
		}
		// number of potions the player has
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