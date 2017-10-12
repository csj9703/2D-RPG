/**
  * CPSC 233 Project.
  * @author Muhammad Saadan Team 6
  * Date last modified: Oct 11, 2017.
  */
public class Enemy
{
		private String name;
		private int health;
		private int attack;
		
		
		
		/**
		 *	Constructor to set a particular enemy's stats
		 */
		public Enemy(String aName, int enemHp, int attk)
		{
				name = aName;
				health = enemHp;
				attack = attk;
		}
		
		/**
		 * Set method for name of enemy
		 * @param aName that is selected for this npc
		 */
		public void setName(String aName) 
		{
				name = aName;
		}
		
		/**
		 * Set method for health of enemy
		 * @param aHealth updated as the enemy is slain
		 */
		public void setHealth(int aHealth)
		{
				health = aHealth;	
		}
		
		/**
		 * Get method for name of enemy 
		 * @return name of enemy
		 */
		public String getName()
		{
				return name;
		}
		
		/**
		 * Get method for attack of enemy
		 * @return attack value
		 */
		 public int getAttack()
		 {
		 		return attack;	 
		 }
		 
		/**
		 * Enemy's attack method
		 * @param damage player based on enemy's ability to damage
		 * @return total damage inflicted by attack
		 */
		public int attack(int attack)
		{
				int damage = attack;
				return damage;
		}
}