package project;

import java.util.Scanner;

public class Battle
{
	private Scanner keyboard = new Scanner(System.in);
	private Player player;
	private Enemy enemy;
	
	/**
	 * This method initials the combat between the player and an enemy
	 */
	public void start(Player aPlayer, Enemy aEnemy)
	{
		player = aPlayer;
		enemy = aEnemy;
		
		int enemyHp = 0;
		int playerHp = 0;
		int playerDmg = player.getAttack();
		int enemyDmg = enemy.getAttack();
		String enemyName = enemy.getName();

		System.out.println("You have encountered " + enemyName + "!");
		while (player.getHealth() > 0 && enemy.getHealth() > 0)
		{
			System.out.println("Your health: " + player.getHealth());
			System.out.println("Enemy health: " + enemy.getHealth());
			System.out.printf("Your actions:"      +"\n"+
							  "1: Attack enemy"    +"\n"+
							  "2: Drink potion(%d)"+"\n", player.getNumOfPot());
			String action = keyboard.next();
			switch(action)
			{
				case "1":
					enemyHp = enemy.getHealth();
					enemyHp -= playerDmg;
					enemy.setHealth(enemyHp);
					System.out.printf("You hit the %s for %d damage!\n",enemyName,playerDmg);
					if(!(enemyHp <= 0)) {
						playerHp = player.getHealth();
						playerHp -= enemyDmg;
						player.setHealth(playerHp);
						System.out.printf("The %s has hit you for %d damage!\n",enemyName,enemyDmg);
					}
					
					break;
				case "2":
					playerHp = player.getHealth();
					playerHp -= enemyDmg;
					player.setHealth(playerHp);
					System.out.printf("The %s has hit you for %d damage!\n",enemyName,enemyDmg);
					player.useItem();
					break;
				default:
					System.out.println("Invalid input");
					break;
			}
		}
		System.out.printf("You have defeated %s!\n" , enemyName);
	}
}
