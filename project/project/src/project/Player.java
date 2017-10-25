package project;

/*
 * This class contains the player logic
 */

public class Player
{
	private String name;
	private int health;
	private int attack;
	private int maxHealth;
	
	private int numSmallPotions;
	private int numMediumPotions;
	private int numLargePotions;

	private int currentLevel;
	private int currentEXP;
	private int expToLvl;
	
	private String currentWeapon;
	
	private boolean hasDagger = false;
	private boolean hasSword = false;
	private boolean hasExcalibur = false;
	

	/**
	 * This constructor initializes the player weapon, inventory, and statistics
	 */
	public Player()
	{
		name = "Not Ed";
		
		health = 20;
		attack = 1;
		maxHealth = 20;

		currentLevel = 1;
		currentEXP = 0;
		expToLvl = 1;

	}
	/**
	 * This is the getter method for level, returns currentLvl
	 */
	public int getCurrentLevel()
	{
		return new Integer(currentLevel);
	}
	/**
	 * This is the setter method for player level
	 * @param aLvl The level value
	 */
	public void setLvl(int aLvl)
	{
		currentLevel = aLvl;
	}
	/**
	 * This method increases the player's level when sufficient experience is gained
	 */
	public void checkExp()
	{
		if(currentEXP >= expToLvl) 
		{
			levelUp();
		}
	}
	/**
	 * This method increases the level of the player
	 */
	private void levelUp()
	{
		currentLevel += 1;
		if(currentEXP > expToLvl) 
		{
			currentEXP -= expToLvl;
		}
		expToLvl *= 2;
		attack += 1;
	}
	/**
	 * This is the getter method for experience required to level up, returns expToLvl
	 */
	public int getExpToLvl()
	{
		return new Integer(expToLvl);
	}
	/**
	 * This is the setter method for required experience to level up
	 * @param expVal The experience value
	 */
	public void setExpToLvl(int expVal)
	{
		expToLvl = expVal;
	}
	/**
	 * This is the getter method for current experience, returns currentEXP
	 */
	public int getCurrentExp()
	{
		return new Integer(currentEXP);
	}
	/**
	 * This is the setter method for current player experience
	 * @param expVal The experience value
	 */
	public void setCurrentExp(int expVal)
	{
		currentEXP = expVal;
	}
	/**
	 * This is the setter method for the player name
	 * @param aName The name
	 */
	public void setName(String aName)
	{
		name = aName;
	}
	/**
	 * This is the getter method for health, returns health
	 */
	public int getHealth()
	{
		return new Integer(health);
	}
	/**
	 * This is the setter method for health
	 * @param health The amount of health
	 */
	public void setHealth(int aHealth)
	{
		health = aHealth;
	}
	/**
	 * This is the getter method for attack, returns attack
	 */
	public int getAttack()
	{
		return new Integer(attack);
	}
	/**
	 * This method allows the player to consume a item to restore their health points
	 * @return itemUsed The item consumed
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
			}
				break;
		case 2:
			if (getNumMediumPotions() > 0)
			{
				restoreHp(5);
				numMediumPotions -= 1;
			}
				break;
		case 3:
			if (getNumLargePotions() > 0)
			{
				restoreHp(7);
				numLargePotions -= 1;
			}
				break;
		}
	}
	/**
	 * This method checks to see what item the player has obtained
	 * @param item The item the player obtained
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
		health += amount;
		if(health > maxHealth) 
		{
			int excessHp = health - maxHealth;
			health -= excessHp;
		}
    }
	/*
	 * This method checks to see if the player is alive
	 * Returns true if player is alive, false otherwise
	 */
	public boolean isAlive()
	{
		boolean isAlive = true;
		if (health < 1)
		{
			isAlive = false;
		}
		return isAlive;
	}
	/**
	 * This is the getter method for the player name, returns name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * This is the getter method for small potions, returns numSmallPotions
	 */
	public int getNumSmallPotions()
	{
		return new Integer(numSmallPotions);
	}
	/**
	 * This is the getter method for medium potions, returns numMediumPotions
	 */
	public int getNumMediumPotions()
	{
		return new Integer(numMediumPotions);
	}
	/**
	 * This is the getter method for large potions, returns numLargePotions
	 */
	public int getNumLargePotions()
	{
		return new Integer(numLargePotions);
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
		return new Integer(weaponDamage);
	}
}