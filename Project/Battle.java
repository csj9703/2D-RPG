package project;

/**
*
* @author Ali
*
*/
import java.util.Scanner;
public class Battle
{
	private Scanner keyboard = new Scanner(System.in);
	private Player player;
	private Enemy enemy;
	/**
	 * This method starts the fight.
	 */

	public void start(Player aPlayer, Enemy aEnemy)
	{
		player = aPlayer;
		enemy = aEnemy;
		int enemyHp = 0;
		int playerHp = 0;
		int playerDmg = player.getAttack();
		int enemyDmg = enemy.getAttack();
		String attackMessage;
		String enemyName = enemy.getName();
		System.out.println("You have encountered " + enemyName + "!");
		while (player.getHealth() > 0 && enemy.getHealth() > 0)
		{
			System.out.println("Your health: " + player.getHealth());
			System.out.println("Enemy health: " + enemy.getHealth());
			System.out.printf("Your actions:"+"\n"+
													 "1: Attack enemy"+"\n"+
													 "2: Drink potion(%d)"+"\n" , player.getNumOfPot());
			String action = keyboard.next();
			switch(action)
			{
				case "1":
					attackMessage = "You hit the enemy for " + playerDmg + "damage";
					
					enemyHp = enemy.getHealth();
					enemyHp -= playerDmg;
					enemy.setHealth(enemyHp);
							
					playerHp = player.getHealth();
					playerHp -= enemyDmg;
					player.setHealth(playerHp);
					
					System.out.println("The " + enemyName + " has hit you for " + enemyDmg + " damage!");
					break;
				case "2":
					attackMessage = "You drank the potion and restored 2 health";
					playerHp = player.getHealth();
					playerHp -= enemyDmg;
					player.setHealth(playerHp);
					System.out.println("The " + enemyName + " has hit you for " + enemyDmg + " damage!");
					player.useItem();
					break;
				default:
					attackMessage = "Invalid input";
					break;
			}
			System.out.println(attackMessage);
		}
		System.out.println("You have defeated " + enemyName);
	}

}
