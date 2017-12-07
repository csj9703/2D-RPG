package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;
/*
 * This class holds data for the player
 */
public class Player extends Character
{
	private final int DEFAULT_MAX_HEALTH = 20;
	private int numSmallPotions;
	private int numMediumPotions;
	private int numLargePotions;
	private int level = 1;
	private int currentEXP = 0;
	private int expToLvl = 1;
	private int damage;
	private String currentWeapon = "No Weapon";
	private boolean hasDagger = false;
	private boolean hasSword = false;
	private boolean hasExcalibur = false;
	private AudioPlayer audioPlayer = new AudioPlayer();
	private Spawner spawner = new Spawner();
	/**
	 * This constructor accepts as arguments the name, health, and attack
	 * It also sets the starting values of max hit points, level and experience
	 * @param name, name of player 
	 * @param health, health of player
	 * @param attack, attack of player
	 */
	public Player(String name, int health, int attack)
	{
		super(name,health,attack);
	}
		public Player(Player player)
	{
		super(player.getName(), player.getHealth(), player.getAttack());
		numSmallPotions = player.getNumSmallPotions();
		numMediumPotions = player.getNumMediumPotions();
		numLargePotions = player.getNumLargePotions();
		level = player.getCurrentLevel();
		currentEXP = player.getCurrentExp();
		expToLvl = player.getExpToLvl();
		currentWeapon = player.getCurrentWeapon();
		damage = player.getDamage();
		hasExcalibur = player.hasExcalibur;
		hasSword = player.hasSword;
		hasDagger = player.hasDagger;
	}
	/**
	 * This is the getter method for level, returns level
	 */
	public int getCurrentLevel()
	{
		return level;
	}
	/**
	 * This is the setter method for level
	 * @param level The level 
	 */
	public void setLevel(int level)
	{
		if (level > 0) 
		{
			this.level = level;
		}
	}
	/**
	 * This method checks whether the player has gain sufficient 
	 * experience to level up, if so the leveUp method is called
	 */
	public void checkExp()
	{
		if (currentEXP >= expToLvl) 
		{
			levelUp();
		}
	}
	/**
	 * This method increases the level of the player by one
	 */
	private void levelUp()
	{
		level += 1;
		if (currentEXP > expToLvl) 
		{
			currentEXP -= expToLvl;
		}
		expToLvl *= 2;
		setAttack(getAttack() + 1);
	}
	/**
	 * This is the getter method for experience required to level up, returns expToLvl
	 */
	public int getExpToLvl()
	{
		return expToLvl;
	}
	/**
	 * This is the setter method for required experience to level up
	 * @param expVal The experience value
	 */
	public void setExpToLvl(int expVal)
	{
		if (expVal > 0) 
		{
			expToLvl = expVal;
		}
	}
	/**
	 * This is the getter method for current experience, returns currentEXP
	 */
	public int getCurrentExp()
	{
		return currentEXP;
	}
	/**
	 * This is the setter method for current player experience
	 * @param expVal The experience value
	 */
	public void setCurrentExp(int expVal)
	{
		if (expVal > 0) 
		{
			currentEXP = expVal;
		}
	}
	/**
	 * This method is called after defeating an enemy to increase experience
	 * @param enemy The enemy
	 */
	public void obtainExp(Enemy enemy)
	{
		currentEXP += new Enemy(enemy).getExperience();
	}
	/**
	 * This method consumes a item based on the itemID passed as argument
	 * @param itemID The ID of the item
	 */
	public void useItem(int itemID)
	{
		switch (itemID)
		{
		case 1:
			if (getNumSmallPotions() > 0)
			{
				restoreHp(spawner.createItem(1).getHealingAmount());
				numSmallPotions -= 1;
				audioPlayer.playDrinkPotionSFX();
			}
			break;
		case 2:
			if (getNumMediumPotions() > 0)
			{
				restoreHp(spawner.createItem(2).getHealingAmount());
				numMediumPotions -= 1;
				audioPlayer.playDrinkPotionSFX();
			}
			break;
		case 3:
			if (getNumLargePotions() > 0)
			{
				restoreHp(spawner.createItem(3).getHealingAmount());
				numLargePotions -= 1;
				audioPlayer.playDrinkPotionSFX();
			}
			break;
		}
	}
	/**
	 * This method picks up a item based on the itemID passed as argument, 
	 * then the getWeaponDamage() method is called to update the currentWeapon variable
	 * @param itemID The ID of the item
	 */
	public void pickUp(int itemID)
	{
		switch (itemID)
		{
		case 1:
			numSmallPotions += 1;
			break;
		case 2:
			numMediumPotions += 1;
			break;
		case 3:
			numLargePotions += 1;
			break;
		case 4:
			hasDagger = true;
			break;
		case 5:
			hasSword = true;
			break;
		case 6:
			hasExcalibur = true;
			break;
		}
		getWeaponDamage();
	}
	/**
	 * This method increases the player's health
	 * @param amount The amount to be restored
	 */
	private void restoreHp(int amount)
    {
		setHealth(getHealth()+amount);
		if(getHealth() > DEFAULT_MAX_HEALTH) 
		{
			int excessHp = getHealth() - DEFAULT_MAX_HEALTH;
			setHealth(getHealth()-excessHp);
		}
    }
	/**
	 * This is the getter method for MAX_HEALTH, returns MAX_HEALTH
	 */
	public int getMaxHealth()
	{
		return DEFAULT_MAX_HEALTH;
	}
	/**
	 * This is the getter method for small potions, returns numSmallPotions
	 */
	public int getNumSmallPotions()
	{
		return numSmallPotions;
	}
	/**
	 * This is the getter method for medium potions, returns numMediumPotions
	 */
	public int getNumMediumPotions()
	{
		return numMediumPotions;
	}
	/**
	 * This is the getter method for large potions, returns numLargePotions
	 */
	public int getNumLargePotions()
	{
		return numLargePotions;
	}
	/**
	 * This is the getter method for current weapon, returns currentWeapon
	 */
	public String getCurrentWeapon()
	{
		return currentWeapon;
	}
	/**
	 * This is the getter method for weapon damage, returns weaponDamage
	 */
	public int getWeaponDamage()
	{
		int weaponDamage = 0;
		if (hasExcalibur)
		{
			weaponDamage = spawner.createWeapon(6).getWeaponDamage();
			currentWeapon = spawner.createWeapon(6).getName();
		}
		else if (hasSword)
		{
			weaponDamage = spawner.createWeapon(5).getWeaponDamage();
			currentWeapon = spawner.createWeapon(5).getName();
		}
		else if (hasDagger)
		{
			weaponDamage = spawner.createWeapon(4).getWeaponDamage();
			currentWeapon = spawner.createWeapon(4).getName();		
		}
		else
		{
			currentWeapon = "No Weapon";
		}
		return weaponDamage;
	}
	/**
	 * This method reduces the enemy's health by the amount of damage 
	 * inflicted by the player
	 *@param enemy The enemy
	 */
	@Override 
	public void attack(Character character) 
	{	
		// random number is introduced to create a damage range, varies damage
		Random rng = new Random();		
		int totalDamage = (getAttack() + getWeaponDamage() + rng.nextInt(4) - 2);
		character.setHealth(character.getHealth()-totalDamage);
		damage = totalDamage;
	}
	/**
	 * This is the getter method for damage, returns damage
	 */
	public int getDamage()
	{
		return damage;
	}
	/**
	 * This method sets the player data to the values saved in file
	 */
	public void loadPlayerData()
	{
		File file = new File("SaveGame.txt");
		Scanner scanner = null;
		final int SIZE = 12;
		String[] playerData = new String[SIZE];
		try 
		{
			scanner = new Scanner(file);
		
			for(int i = 0; i < SIZE; i++) 
			{
				playerData[i] = scanner.next();
			}
			numSmallPotions = Integer.parseInt(playerData[0]);
			numMediumPotions = Integer.parseInt(playerData[1]);
			numLargePotions = Integer.parseInt(playerData[2]);
			level = Integer.parseInt(playerData[3]);
			currentEXP = Integer.parseInt(playerData[4]);
			expToLvl = Integer.parseInt(playerData[5]);
			setHealth(Integer.parseInt(playerData[6]));
			setAttack(Integer.parseInt(playerData[7]));
			hasDagger = Boolean.parseBoolean(playerData[9]);
			hasSword = Boolean.parseBoolean(playerData[10]);
			hasExcalibur = Boolean.parseBoolean(playerData[11]);
		}
		catch (FileNotFoundException|ArrayIndexOutOfBoundsException|NoSuchElementException e) 
		{
			Object[] options = {"OK"};
			JOptionPane.showOptionDialog(null, "Saved file was not found. Press enter to start a new game.", "LOADING ERROR",
			JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			null, options, options[0]);
		}
		if (hasDagger)
		{
			currentWeapon = "Rusty Dagger";
		}
		if (hasSword)
		{
			currentWeapon = "Iron Longsword";
		}
		if (hasExcalibur)
		{
			currentWeapon = "Blessed Excalibur";
		}
	}
}