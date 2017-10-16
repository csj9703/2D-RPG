package project;

public class Enemy
{
		private String name;
		private int health;
		private int attack;
		
		/**
		 * This constructor initializes the name, health, and attack fields
		 * @param name The name of the enemy
		 * @param health The amount of health
		 * @param name The amount of attack power
		 */
		public Enemy(String name, int health, int attack)
		{
				this.name = name;
				this.health = health;
				this.attack = attack;
		}
		/**
		 * This is the setter method for health
		 * @param health The amount of health
		 */
		public void setHealth(int health)
		{
				this.health = health;	
		}		
		/**
		 * This is the getter method for attack, returns attack
		 */
		 public int getAttack()
		 {
		 		return attack;	 
		 }
		/**
		 * This is the getter method for health, returns health
		 */
		public int getHealth()
		{
				return health;
		}
		/**
		 * This is the getter method for name, returns name
		 */
		public String getName() 
		{
			return name;
		}
}