package game;

import java.util.Random;
/*
 * This class holds data for the player
 */
public class Player extends Character
{
	private final int maxHealth;
	private int numSmallPotions;
	private int numMediumPotions;
	private int numLargePotions;
	private int level;
	private int currentEXP;
	private int expToLvl;
	private String currentWeapon;
	private boolean hasDagger = false;
	private boolean hasSword = false;
	private boolean hasExcalibur = false;
	private int damage;
	private AudioPlayer audioPlayer = new AudioPlayer();
	/**
	 * This constructor accepts as arguments the name, health, and attack
	 * It also sets the starting values of max hit points, level and experience
	 */
	public Player(String name, int health, int attack)
	{
		super(name,health,attack);
		maxHealth = 20;
		level = 1;
		currentEXP = 0;
		expToLvl = 1;
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
		if(level > 0) {
			this.level = level;
		}
	}
	/**
	 * This method checks whether the player has gain sufficient 
	 * experience to level up, if so the leveUp method is called
	 */
	public void checkExp()
	{
		if(currentEXP >= expToLvl) 
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
		if(currentEXP > expToLvl) 
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
		if(expVal > 0) {
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
		if(expVal > 0) {
			currentEXP = expVal;
		}
	}
	/**
	 * This method is called after defeating an enemy to increase experience
	 * @param player The player
	 * @param enemy The enemy
	 */
	public void obtainExp(Enemy enemy)
	{
		currentEXP += enemy.getExperience();
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
				restoreHp(3);
				numSmallPotions -= 1;
				audioPlayer.playDrinkPotionSFX();
			}
			break;
		case 2:
			if (getNumMediumPotions() > 0)
			{
				restoreHp(5);
				numMediumPotions -= 1;
				audioPlayer.playDrinkPotionSFX();
			}
			break;
		case 3:
			if (getNumLargePotions() > 0)
			{
				restoreHp(7);
				numLargePotions -= 1;
				audioPlayer.playDrinkPotionSFX();
			}
			break;
		}
	}
	/**
	 * This method picks up a item based on the itemID passed as argument
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
	}
	/**
	 * This method increases the player's health
	 * @param amount The amount to be restored
	 */
	private void restoreHp(int amount)
    {
		setHealth(getHealth()+amount);
		if(getHealth() > maxHealth) 
		{
			int excessHp = getHealth() - maxHealth;
			setHealth(getHealth()-excessHp);
		}
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
			weaponDamage = 3;
			currentWeapon = "Excalibur";
		}
		else if (hasSword)
		{
			weaponDamage = 2;
			currentWeapon = "Iron Longsword";
		}
		else if (hasDagger)
		{
			weaponDamage = 1;
			currentWeapon = "Rusty Dagger";
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
	 *@param player The player
	 *@param enemy The enemy
	 */
	@Override 
	public void attack(Player player, Enemy enemy) 
	{	
		// random number is introduced to create a damage range, varies damage
		Random rng = new Random();		
		int totalDamage = (player.getAttack() + player.getWeaponDamage() + rng.nextInt(4) - 2);
		enemy.setHealth(enemy.getHealth()-totalDamage);
		damage = totalDamage;
	}
	/**
	 * This is the getter method for damage, returns damage
	 */
	public int getDamage()
	{
		return damage;
	}
}