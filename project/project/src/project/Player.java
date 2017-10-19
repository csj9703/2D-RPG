package project;

import java.util.Scanner;

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
	//Potion potion = new Potion();

	/**
	 * Constructor that sets the beginner player stats.
	 */
	public Player()
	{
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
	 * This is the getter method for level, returns level.
	 */
	public int getLvl()
	{
		return currentLvl;
	}
	/**
	 * Setter for player level.
	 * @param aLvl a level value
	 */
	public void setLvl(int aLvl)
	{
		currentLvl = aLvl;
	}
	/**
	 * Checks if the player has enough exp to level up.
	 */
	public void checkExp()
	{
		if(currentEXP >= expToLvl) {
			levelUp();
		}
	}
	/**
	 * Level-ups the player while carrying excess exp towards next level.
	 */
	private void levelUp()
	{
		currentLvl++;
		if(currentEXP > expToLvl) {
			currentEXP -= expToLvl;
			expToLvl = expToLvl * 2;
		}
		System.out.println("You Leveled Up!");
	}
	/**
	 * This is the getter method for experience required to level up, returns expToLvl.
	 */
	public int getExpToLvl()
	{
		return expToLvl;
	}
	/**
	 * Setter for required experience to level up.
	 * @param expVal an experience value.
	 */
	public void setExpToLvl(int expVal)
	{
		expToLvl = expVal;
	}
	/**
	 * This is the getter method for current experience, returns currentEXP.
	 */
	public int getCurrentExp()
	{
		return currentEXP;
	}
	/**
	 * Setter for current player experience.
	 * @param an experience value.
	 */
	public void setCurrentExp(int expVal)
	{
		currentEXP = expVal;
	}
	/**
	 * Setter for Player name
	 * @param aName a name that user wishes to set.
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
			restoreHp(2);
			System.out.println("You drank the potion and restored 2 health!");
			System.out.printf("\tHealth: %d\n",health);
			numOfPot--;
			itemUsed = true;
		}else if(numOfPot <= 0){
			System.out.println("You don't have any potions!");
		}else {
			System.out.println("You are already at full health!");
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
			System.out.println("Picked up a Sword!");
			swordInInventory = true;
		}else if(item.charAt(length-6) == 'P') {
			System.out.println("Picked up a Potion!");
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
		if(health > 10) {
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
		if(swordInInventory == true) {
			System.out.println("You have equipped the Sword!");
			attack += swordDmg;
			swordInInventory = false;
			swordEquipped = true;
		}else {
			System.out.println("You don't have a Sword!");
		}
	}
	/**
	 * This method displays player statistics.
	 */
	private void displayStats()
	{
		System.out.printf("\t"+"LEVEL: %d\n",currentLvl);
		System.out.printf("\t"+"-----------------------\n");
		System.out.printf("\t"+"Health: %d\n",health);
		System.out.printf("\t"+"Potions: %d\n",numOfPot);
		System.out.printf("\t"+"ATK: %d\n",attack);
		System.out.printf("\t"+"-----------------------\n");
		System.out.printf("\t"+"EXP: %d/%d\n",currentEXP,expToLvl);
		System.out.printf("\t"+"EXP Until Level %d: %d\n",(currentLvl + 1),
				(expToLvl - currentEXP));
		System.out.println(" ");
	}
	/**
	 * A statistics menu for player.
	 */
	public void statsMenu()
	{
		Scanner keyboard = new Scanner(System.in);
		displayStats();
		System.out.println("Press 1 to restore your health.");
		System.out.println("Press 2 to exit the screen.");
		String input = keyboard.next();
		switch(input) {
			case "1":
				useItem();
				break;
			case "2":
				System.out.println("Back to navigation");
				break;
			default:
				System.out.println("Invalid Input");
				break;
		}
	}
	/*
	 * This method checks to see if the player is alive
	 * Returns true if player is alive, false otherwise
	 */
	public boolean isAlive()
	{
		boolean isAlive = true;
		if (health < 1){
			isAlive = false;
		}
		return isAlive;
	}
}
