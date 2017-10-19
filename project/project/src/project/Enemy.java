package project;

/*
 *This is used to create enemies in the game
 */
public class Enemy
{
		private String name;
		private int health;
		private int attack;

		private int exp;
		/**
		 * This constructor initializes the name, health, and attack fields
		 * @param  aName The name of the enemy
		 * @param  aHealth The amount of health
		 * @param  aAttack The amount of attack power
		 * @param  expVal The amount of exp it rewards
		 * @return        [description]
		 */
		public Enemy(String aName, int aHealth, int aAttack, int expVal)
		{
				name = aName;
				health = aHealth;
				attack = aAttack;
				exp = expVal;
		}
		/**
		 * This is the getter method for experience, returns exp.
		 */
		public int getExp()
		{
			return exp;
		}
		/**
		 * This is the setter method for health
		 * @param health The amount of health
		 */
		public void setHealth(int newHealth)
		{
				health = newHealth;
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
