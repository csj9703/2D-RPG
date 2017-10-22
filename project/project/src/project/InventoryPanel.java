package project;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * This class is a panel that displays the player's inventory
 */
public class InventoryPanel 
{
	JLabel weaponInventory = new JLabel();
	JLabel potionInventory = new JLabel();
	JLabel playerHealth = new JLabel();
	
	public JPanel createPanel(Player player)
	{
		JPanel inventoryPanel = new JPanel();
		inventoryPanel.setLayout(null);
		inventoryPanel.setBackground(Color.BLACK);
		inventoryPanel.setBounds(0, 0, 700, 700);

		potionInventory.setBounds(400,000,300,100);
		potionInventory.setFont(new Font("info", Font.PLAIN, 18));
		
		weaponInventory.setBounds(50,0,300,100);
		weaponInventory.setFont(new Font("info", Font.PLAIN, 18));
	
		playerHealth.setBounds(400,50,300,100);
		playerHealth.setFont(new Font("info", Font.PLAIN, 18));
		
		inventoryPanel.add(potionInventory);
		inventoryPanel.add(weaponInventory);
		inventoryPanel.add(playerHealth);
		
		return inventoryPanel;
	}

	// this method is run after every input command
	public void update(Player player)
	{
		String weaponInfo = "Weapon: Novice Shortsword";
		weaponInventory.setText(weaponInfo);

		String potionInfo = "Num of Potions: " + player.getNumOfPot();
		potionInventory.setText(potionInfo);
		
		String playerInfo = "<html>" + "Current HP: " + player.getHealth()
		                   + "<br/>" + "PRESS U TO USE A POTION (cannot use during combat)"
			               + "</html>";
		playerHealth.setText(playerInfo);
	}
}

