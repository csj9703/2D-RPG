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
		super(name, health, attack);
		if(experience > 0) 
		{
			this.experience = experience;
		}
		else 
		{
			this.experience = 1;
		}
	}
	/**
	 * This is the copy constructor for enemy
	 * @param enemy The enemy object to be copied
	 */
	public Enemy(Enemy enemy)
	{
		super(enemy.getName(), enemy.getHealth(), enemy.getAttack());
		experience = enemy.getExperience();
		damage = enemy.getDamage();
	}
	/**
	 * This method reduces the player's health by the amount of 
	 * damage inflicted by the enemy
	 *@param player The player
	 */
	@Override 
	public void attack(Character player) 
	{			
		int totalDamage = getAttack();
		player.setHealth(player.getHealth()-totalDamage);
		damage = totalDamage;
	}
	/**
	 * This is the getter method for damage, returns damage
	 */
	public int getDamage()
	{
		return damage;
	}
	/**
	 * This is the getter method for experience, returns experience
	 */
	public int getExperience()
	{
		return experience;
	}
}