package project;

/*
 * This class contains the player logic
 */

public class Player
{
	private String name;
	private int health;
	private int attack;

	private int numOfPot;
	private boolean swordInInventory;
	private boolean swordEquipped;

	private int currentLvl;
	private int currentEXP;
	private int expToLvl;

	/**
	 * This constructor initializes the player weapon, inventory, and statistics
	 */
	public Player()
	{
		name = "Not Ed";
		
		health = 10;
		attack = 1;
		numOfPot = 0;

		currentLvl = 1;
		currentEXP = 0;
		expToLvl = 1;

		swordInInventory = true;
		swordEquipped = false;
	}
	/**
	 * This is the getter method for level, returns currentLvl
	 */
	public int getLvl()
	{
		return currentLvl;
	}
	/**
	 * This is the setter method for player level
	 * @param aLvl The level value
	 */
	public void setLvl(int aLvl)
	{
		currentLvl = aLvl;
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
		currentLvl++;
		if(currentEXP > expToLvl) {
			currentEXP -= expToLvl;
		}
		expToLvl *= 2;
		attack += 1;
		//System.out.println("You Leveled Up!");
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
		expToLvl = expVal;
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
		return health;
	}
	/**
	 * This is the getter method for numOfPot, returns numOfPot
	 */
	public int getNumOfPot()
	{
		return numOfPot;
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
		return attack;
	}
	/**
	 * This method allows the player to consume a item to restore their health points
	 * @return itemUsed The item consumed
	 */
	public boolean useItem()
	{
		boolean itemUsed = false;
		if(numOfPot > 0 && health < 10) {
			restoreHp(5);
			//System.out.println("You drank the potion and restored 2 health!");
			//System.out.printf("\tHealth: %d\n",health);
			numOfPot--;
			itemUsed = true;
		}else if(numOfPot <= 0){
			//System.out.println("You don't have any potions!");
		}else {
			//System.out.println("You are already at full health!");
		}
		return itemUsed;
	}
	/**
	 * This method checks to see what item the player has obtained
	 * @param item The item the player obtained
	 */
	public void pickUp(String item)
	{
		int length = item.length();
		if (item.charAt(length-5) == 'S'){
			//System.out.println("Picked up a Sword!");
			swordInInventory = true;
		}else if(item.charAt(length-6) == 'P') {
			//System.out.println("Picked up a Potion!");
			numOfPot ++;
		}
	}
	/**
	 * This method increases the player's health
	 * @param amount The amount to be restored
	 */
	private void restoreHp(int amount)
    {
		health += amount;
		if(health > 10) 
		{
			int excessHp = health - 10;
			health -= excessHp;
		}
    }
	/**
	 * This method equips a sword onto the player
	 * @param swordDmg The damage rating of the sword
	 */
	public void equipSword(int swordDmg)
	{
		if(swordInInventory == true) 
		{
			//System.out.println("You have equipped the Sword!");
			attack += swordDmg;
			swordInInventory = false;
			swordEquipped = true;
		}else 
		{
			//System.out.println("You don't have a Sword!");
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
}
