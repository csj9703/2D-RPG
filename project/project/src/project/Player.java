package project;

import java.util.Scanner;

public class Player 
{
	private int health = 10;
	private int attack = 1;
	private int numOfPot = 0;
	private boolean swordInInventory;
	private boolean swordEquipped;

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
	public void setHealth(int health) 
	{
		this.health = health;
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
		if(numOfPot > 0 && health < 10) 
		{
			restoreHp(2);
			System.out.println("You drank the potion and restored 2 health!");
			System.out.printf("\tHealth: %d\n", health);
			numOfPot--;
			itemUsed = true;
		}
		else if
		(numOfPot <= 0)
		{
			System.out.println("You don't have any potions!");
		}
		else 
		{
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
		if (item.charAt(length-5) == 'S')
		{
			System.out.println("Picked up a Sword!");
			swordInInventory = true;
		}
		else if(item.charAt(length-6) == 'P') 
		{
			System.out.println("Picked up a Potion!");
			numOfPot ++;
		}
	}
	/**
	 * This method increases the player's health 
	 * @param amount The amount to be restored
	 */
	public void restoreHp(int amount)
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
		if(swordInInventory == true) {
			System.out.println("You have equipped the Sword!");
			attack += swordDmg;
			swordInInventory = false;
			swordEquipped = true;
		}
		else 
		{
			System.out.println("You don't have a Sword!");
		}
	}
	/**
	 * This method prints the in game player menu
	 */
	public void statsMenu()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What would you like to do?");
		System.out.println("Press 1 to see Health");
		System.out.println("Press 2 to see Number of Potions");
		System.out.println("Press 3 to see Attack Value");
		String input = keyboard.next();
		String decision;
		switch(input) 
		{
			case "1":
				decision = "You have " +health+ " Health";
				break;
			case "2":
				decision = "You have " +numOfPot+ " Potions";
				break;
			case "3":
				decision = "You have " +attack+ " Attack Value";
				break;
			default:
				decision = "Invalid Input";
				break;
		}
		System.out.println(decision);
	}
	/**
	 * This method displays the item menu
	 */
	public void statsScreen()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("\t"+"Health: %d\n",health);
		System.out.printf("\t"+"Potions: %d\n",numOfPot);
		System.out.printf("\t"+"ATK: %d\n",attack);
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
		else{
			isAlive = true;
		}
		return isAlive;
	}
}