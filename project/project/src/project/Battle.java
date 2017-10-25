package project;

import java.util.Random;
/*
 * This class manages the combat system of the game
 */
public class Battle
{
	private Random rng = new Random();
	private int playerDamage;
	private int enemyDamage;
	/**
	 * This method reduces the enemy's health by the amount of damage inflicted by the player
	 *@param player The player
	 *@param enemy The enemy
	 */
	public void playerAttack(Player player, Enemy enemy)
	{
		int damageRange = -2 + rng.nextInt(4);
		int attackModifier = rng.nextInt(8);		
		if (attackModifier == 0)
		{
			playerDamage = 0;
		}
		else if (attackModifier == 7)
		{
			playerDamage = 2 * player.getAttack() + player.getWeaponDamage();
		}
		else 
		{
			playerDamage = player.getAttack() + player.getWeaponDamage();
			playerDamage += damageRange;
		}
		enemy.setHealth(enemy.getHealth()-playerDamage);
	}
	/**
	 * This method reduces the player's health by the amount of damage inflicted by the enemy
	 *@param player The player
	 *@param enemy The enemy
	 */
	public void enemyAttack(Player player, Enemy enemy)
	{
		int damageRange = -1 + rng.nextInt(2);
		int attackModifier = rng.nextInt(8);
		if (attackModifier == 0)
		{
			enemyDamage = 0;
		}
		else if (attackModifier == 7)
		{
			enemyDamage = 2 * enemy.getAttack();
		}
		else 
		{
			enemyDamage = enemy.getAttack();
			enemyDamage += damageRange;
		}
		player.setHealth(player.getHealth()-enemyDamage);
	}
	/**
	 * This method rewards the player corresponding exp after defeating an enemy
	 * @param a player
	 * @param an enemy
	 */
	public void expReward(Player player, Enemy enemy)
	{
		int playerExp = player.getCurrentExp();
		int enemyExp = enemy.getExp();
		player.setCurrentExp(playerExp += enemyExp); 
	}
	/*
	 * This method returns true if enemy is alive, false otherwise
	 * @param enemy The enemy
	 */
	public boolean enemyIsAlive(Enemy enemy)
	{
		return enemy.getHealth() > 0 ? true : false;
	}
	/*
	 * This is the getter method for player damage, returns playerDamage
	 */
	public int getPlayerDamage()
	{
		return new Integer(playerDamage);
	}
	/*
	 * This is the getter method for enemy damage, returns enemyDamage
	 */
	public int getEnemyDamage()
	{
		return new Integer(enemyDamage);
	}
}