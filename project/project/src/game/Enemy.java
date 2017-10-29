package game;

/*
 * This class defines the enemies of the game
 */
public class Enemy extends Character
{
		private int experience;
		private int damage;
		/**
		 * This constructor accepts as arguments the name, health, 
		 * attack, and experience fields
		 * @param  name The name
		 * @param  health The amount of hit points
		 * @param  attack The attack rating
		 * @param  experience The amount of experience
		 */
		public Enemy(String name, int health, int attack, int experience)
		{
			super(name,health,attack);
			this.experience = experience;
		}
		/**
		 * This is the getter method for experience, returns experience
		 */
		public int getExperience()
		{
			return experience;
		}
		/**
		 * This method reduces the player's health by the amount of 
		 * damage inflicted by the enemy
		 *@param player The player
		 *@param enemy The enemy
		 */
		@Override 
		public void attack(Player player, Enemy enemy) 
		{			
			int totalDamage = (enemy.getAttack());
			player.setHealth(player.getHealth()-totalDamage);
			damage = totalDamage;
		}
		public int getDamage()
		{
			return damage;
		}
}