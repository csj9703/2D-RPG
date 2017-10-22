package project;

import java.util.Random;
/*
 * This class manages the combat system of the game
 */
public class Battle
{
	Random rng = new Random();
	/**
	 * This method reduces the enemy's health by the amount of damage inflicted by the player
	 *@param player The player
	 *@param enemy The enemy
	 */
	public void playerAttack(Player player, Enemy enemy)
	{
		int attackModifier = rng.nextInt(10);
		int damage;
		
		if (attackModifier == 0)
		{
			damage = 0;
		}
		else if (attackModifier == 9)
		{
			damage = 2 * player.getAttack();
		}
		else 
		{
			damage = player.getAttack();
		}
		enemy.setHealth(enemy.getHealth()-damage);
	}
	/**
	 * This method reduces the player's health by the amount of damage inflicted by the enemy
	 *@param player The player
	 *@param enemy The enemy
	 */
	public void enemyAttack(Player player, Enemy enemy)
	{
		int attackModifier = rng.nextInt(10);
		int damage;
		
		if (attackModifier == 0)
		{
			damage = 0;
		}
		else if (attackModifier == 9)
		{
			damage = 2 * enemy.getAttack();
		}
		else 
		{
			damage = enemy.getAttack();
		}
		player.setHealth(player.getHealth()-damage);
	}
	/*
	 * This method returns true if enemy is alive, false otherwise
	 * @param enemy The enemy
	 */
	public boolean enemyIsAlive(Enemy enemy)
	{
		return enemy.getHealth() > 0 ? true : false;
	}
}

