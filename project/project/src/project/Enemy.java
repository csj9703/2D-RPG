package project;

public class Enemy
{
		private String name;
		private int health;
		private int attack;
		/**
		 *	Constructor that sets the enemy's name, health, and attack rating
		 */
		public Enemy(String enemyName, int enemyHealth, int enemyAttack)
		{
				name = enemyName;
				health = enemyHealth;
				attack = enemyAttack;
		}
		/**
		 * Setter method for enemy health
		 * @param aHealth updated as the enemy is slain
		 */
		public void setHealth(int newHealth)
		{
				health = newHealth;	
		}		
		/**
		 * Getter method for enemy attack
		 * @return The attack value
		 */
		 public int getAttack()
		 {
		 		return attack;	 
		 }
		/**
		 * Getter method for enemy health
		 * @return The health value
		 */
		public int getHealth()
		{
				return health;
		}
		/**
		 * Getter method for enemy name
		 * @return The name
		 */
		public String getName() 
		{
			return name;
		}
}