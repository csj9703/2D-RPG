package project;
/*
 *This class defines the enemies of the game
 */
public class Enemy extends Characters
{
		private int exp;
		
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
}