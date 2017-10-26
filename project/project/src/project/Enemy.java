package project;

import java.util.Random;
/*
 *This class defines the enemies of the game
 */
public class Enemy extends Character
{
		private int exp;
		private int damage;
		/**
		 * This constructor initializes the name, health, attack and experience fields
		 * @param  aName The name of the enemy
		 * @param  aHealth The amount of health
		 * @param  aAttack The amount of attack power
		 * @param  expVal The amount of experience
		 */
		public Enemy(String name, int health, int attack, int exp)
		{
				super(name,health,attack);
				this.exp = exp;
		}
		/**
		 * This is the getter method for experience, returns experience
		 */
		public int getExp()
		{
			return new Integer(exp);
		}
		/**
		 * This method reduces the player's health by the amount of damage inflicted by the enemy
		 *@param player The player
		 *@param enemy The enemy
		 */
		@Override 
		public void attack(Player player, Enemy enemy) 
		{	
			Random rng = new Random();		
			int totalDamage = (enemy.getAttack() + rng.nextInt(2));
			player.setHealth(player.getHealth()-totalDamage);
			damage = totalDamage;
		}
		public int getDamage()
		{
			return damage;
		}
}