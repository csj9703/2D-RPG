package project;

/**
 /**
 * CPSC 233 Project.
 * @author Jason ShuJi Chen Team 6
 * Version 1.4
 * Date last modified: Oct 12, 2017.
 */
import java.util.Scanner;

public class Player {
	private String name;
	private int health;
	private int attack;
	private int numOfPot;
	private boolean swordInInventory;
	private boolean swordEquipped;
	private Scanner keyboard = new Scanner(System.in);
	//Potion potion = new Potion();
	
	/**
	 * Constructor that sets the beginner player stats.
	 */
	public Player(){
		health = 10;
		attack = 1;
		numOfPot = 0;
		swordInInventory = true;
		swordEquipped = false;
	}
	/**
	 * Setter for Player name
	 * @param aName a name that user wishes to set.
	 */
	public void setName(String aName) {
		name = aName;
	}
	/**
	 * Getter for player health.
	 * @return player health.
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * Getter for number of potion.
	 * @return number of potion.
	 */
	public int getNumOfPot() {
		return numOfPot;
	}
	/**
	 * Setter for play health
	 * @param aHealth a new health.
	 */
	public void setHealth(int aHealth) {
		health = aHealth;
	}
	/**
	 * Getter for player attack.
	 * @return attack value.
	 */
	public int getAttack() {
		return attack;
	}
	/**
	 * Uses potion.
	 * @param potNum the type of potion (in int)
	 */
	public void useItem() {
		if(numOfPot > 0 && health < 10) {
			restoreHp(2);
			numOfPot--;
		}else {
			System.out.println("You don't have any potions!");
		}
	}
	/**
	 * Player attack method use during battle
	 * @param attack player base attack value
	 * @param weaponDmg weapon damage
	 * @return total damage value.
	 */
	public int attack(int attack) {
		int damage = attack;
		return damage;
	}
	/**
	 * Player pick up method.
	 * @param item the item the player picked up.
	 */
	public void pickUp(String item) {
		int length = item.length();
		//Checks if the item has "Sword" in the name.
		if (item.charAt(length-5) == 'S'){
			System.out.println("Picked up a Sword!");
			swordInInventory = true;
		//Checks if the item has "Potion in the name.
		}else if(item.charAt(length-6) == 'P') {
			System.out.println("Picked up a Potion!");
			numOfPot ++;
		}
	}
	/**
	 * Restores the amount of hp based on the amount.
	 * @param amount amount of hp the player to restore.
	 */
	public void restoreHp(int amount)
    {
		health += amount;
		if(health > 10) {
			int excessHp = health - 10;
			health -= excessHp;
		}
    }
	/**
	 * Equips the sword for the player.
	 * @param swordDmg the damage of the sword.
	 */
	public void equipSword(int swordDmg) {
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
	 * A statistics menu that prompts the player for choice.
	 */
	public void statsMenu() {
		System.out.println("What would you like to do?");
		System.out.println("Press 1 to see Health");
		System.out.println("Press 2 to see Number of Potions");
		System.out.println("Press 3 to see Attack Value");
		String input = keyboard.next();
		String decision;
		switch(input) {
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
	 * A simplier statistics menu for player.
	 */
	public void statsScreen() {
<<<<<<< HEAD
		System.out.printf("\t"+"Health: %d\n",health);
=======
		System.out.printf("\t"+"Health: "+health+"\n");
>>>>>>> 2a14003898f6520a87105b840c883b0e3fdf528b
		System.out.printf("\t"+"Potions: "+numOfPot+"\n");
		System.out.printf("\t"+"ATK: "+attack+"\n");
		System.out.println("Press 1 to restore your health.");
		String input = keyboard.next();
		switch(input) {
			case "1": 
				useItem();
				break;
			default:
				System.out.println("Invalid Input");
		}
		
	}
}
