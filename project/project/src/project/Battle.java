package project;

import java.util.Scanner;
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
					playerAttack();
					displayResult("player");
					if(!(enemy.getHealth() <= 0)) {
						enemyAttack();
						displayResult("enemy");
					}else {
						expReward();
					}
					break;
				case "2":
					if(player.useItem()) {
						enemyAttack();
						displayResult("enemy");
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
	 */
	public void playerAttack() 
	{
		int enemyHp = 0;
		int playerDmg = player.getAttack();
		enemyHp = enemy.getHealth();
		enemyHp -= playerDmg;
		enemy.setHealth(enemyHp);
	}
	/**
	 * This method reduces player health by the amount of damage inflicted by the enemy
	 */
	public void enemyAttack() 
	{
		int playerHp = 0;
		int enemyDmg = enemy.getAttack();
		playerHp = player.getHealth();
		playerHp -= enemyDmg;
		player.setHealth(playerHp);
	}
	/**
	 * This method opens the item menu
	 */
	public void displayMenu() 
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
	 */
	public void displayResult(String charID) 
	{
		String enemyName = enemy.getName();
		int playerDmg = player.getAttack();
		int enemyDmg = enemy.getAttack();
		if(charID == "player") {
			System.out.printf("You hit the %s for %d damage!\n",enemyName,playerDmg);
		}else if(charID == "enemy") {
			System.out.printf("The %s has hit you for %d damage!\n",enemyName,enemyDmg);
		}
	}
	
}