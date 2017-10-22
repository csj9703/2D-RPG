package project;

import java.util.Scanner;
import java.util.Random;
/*
 * This class manages the combat system of the game
 */
public class Battle
{
	private Player player;
	private Enemy enemy;
	
	/**
	 * This method initiates a battle between a player and enemy object
	 * @param player an instance of the Player class
	 * @param enemy an instance of the Enemy class
	 */
	public void start(Player player, Enemy enemy)
	{
		BattleGui gui = new BattleGui(player, enemy);
		Scanner keyboard = new Scanner(System.in);
		this.player = player;
		this.enemy = enemy;
		String enemyName = enemy.getName();
		
		Random attackModifier = new Random();

		System.out.println("You have encountered " + enemyName + "!");
		// battle continues until one side's health is reduced to zero
		while (player.getHealth() > 0 && enemy.getHealth() > 0)
		{
			gui.showGui(true);
			gui.updateMenu();
			
			displayMenu();
			String action = keyboard.next();
			switch(action)
			{
				case "1":
					displayResult("player", playerAttack(attackModifier.nextInt(10)));
					if(!(enemy.getHealth() <= 0))
					{
						displayResult("enemy",enemyAttack(attackModifier.nextInt(10)));
					}
					else 
					{
						expReward();
					}
					break;
				case "2":
					if(player.useItem()) 
					{
						displayResult("enemy",enemyAttack(attackModifier.nextInt(10)));
					}
					break;
				default:
					System.out.println("Invalid input");
					break;
			}
		}
		gui.showGui(false);
	}
	private void expReward() 
	{
		int playerExp = player.getCurrentExp();
		int enemyExp = enemy.getExp();
		player.setCurrentExp(playerExp += enemyExp); 
		System.out.printf("You have defeated %s!\n" , enemy.getName());
		System.out.printf("You gained %d EXP!\n" , enemyExp);
		player.checkExp();
	}
	/**
	 * This method reduces enemy health by the amount of damage inflicted by the player
	 *@param attackModifier integer, 0 its a miss, 9 its a critical hit, else its a normal hit
	 *@return integer, 0 if its a miss, 1 if its a regular hit, 2 if critical
	 */
	private int playerAttack(int attackModifier) 
	{
		int enemyHp = enemy.getHealth();
		int playerDmg;
		if (attackModifier == 0) 
		{
			System.out.println("You Missed!");
			playerDmg = 0;
			return 0;
		}
		else if (attackModifier == 9)
		{
			System.out.println("You hit a critical shot!");
			playerDmg = 2 * player.getAttack();
			enemyHp -= playerDmg;
			enemy.setHealth(enemyHp);
			return 2;
		}
		else 
		{
			playerDmg = player.getAttack();
			enemyHp -= playerDmg;
			enemy.setHealth(enemyHp);
			return 1;
		}
	}
	/**
	 * This method reduces player health by the amount of damage inflicted by the enemy
	 * @param attackModifier integer, 0 its a miss, 9 its a critical hit, else its a normal hit
	 * @return integer, 0 if its a miss, 1 if its a regular hit, 2 if critical
	 */
	private int enemyAttack(int attackModifier) 
	{
		int playerHp = player.getHealth();
		int enemyDmg;
		if (attackModifier == 0)
		{
			System.out.println("The Enemy Missed!");
			enemyDmg = 0;
			return 0;
			
		}
		else if (attackModifier == 9)
		{
			System.out.println("The enemy hit a critical shot!");
			enemyDmg = 2*enemy.getAttack();
			playerHp -= enemyDmg;
			player.setHealth(playerHp);
			return 2;
		}
		else 
		{
			enemyDmg = enemy.getAttack();
			playerHp -= enemyDmg;
			player.setHealth(playerHp);
			return 1;
		}
	}
	/**
	 * This method opens the item menu
	 */
	private void displayMenu() 
	{
		System.out.println("Your health: " + player.getHealth());
		System.out.println("Enemy health: " + enemy.getHealth());
		System.out.printf("Your actions:"      +"\n"+
						  "1: Attack enemy"    +"\n"+
						  "2: Drink potion(%d)"+"\n", player.getNumOfPot());
	}
	
	public String getDisplayMenu() 
	{
		String menu = "<html><font color='red'>Your health:"+player.getHealth()+"<br>"
				+ "Enemy health:"+enemy.getHealth()+"<br>"
				+ "Your actions:<br>"
				+ "1: Attack enemy<br>"
				+ "2: Drink potion("+player.getNumOfPot()+")</font><html>";
		return menu;
	}
	/**
	 * This method displays the result of a turn of combat
	 * @param charID String of either player or enemy.
	 * @param attackType 0 if miss, 1 if normal hit, 2 if critical
	 */
	private void displayResult(String charID, int attackType) 
	{
		String enemyName = enemy.getName();
		int playerDmg = player.getAttack();
		int enemyDmg = enemy.getAttack();
		if (attackType == 2)
		{
			playerDmg = 2*playerDmg;
			enemyDmg = 2*enemyDmg;
		}
		if(charID == "player" && attackType != 0) {
			System.out.printf("You hit the %s for %d damage!\n",enemyName,playerDmg);
		}else if(charID == "enemy" && attackType != 0) {
			System.out.printf("The %s has hit you for %d damage!\n",enemyName,enemyDmg);
		}
	}
}