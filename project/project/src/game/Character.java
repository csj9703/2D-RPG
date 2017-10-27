package game;

/*
 * This class creates the characters of the game
 */
public abstract class Character extends GameObject
{	
	private int health;
	private int attack;
	/**
	 * This constructor initializes the name, health, and attack.
	 * @param name
	 * @param health
	 * @param attack
	 */
	public Character(String name, int health, int attack) 
	{
		super(name);
		this.health = health;
		this.attack = attack;
	}
	/**
	 * Getter Method for character health. Returns health.
	 */
	public int getHealth() 
	{
		return new Integer(health);
	}
	/**
	 * Setter method for character health.
	 * @param health The amount of the health.
	 */
	public void setHealth(int health) 
	{
		this.health = health;
	}
	/**
	 * Getter Method for character attack. Returns attack.
	 */
	public int getAttack() 
	{
		return new Integer(attack);
	}
	/**
	 * Setter method for character attack.
	 * @param attack The amount of attack power.
	 */
	public void setAttack(int attack) 
	{
		this.attack = attack;
	}
	/*
	 * This method checks to see if the player is alive (more than zero health)
	 * Returns true if is alive, false otherwise
	 */
	public boolean isAlive()
	{
		return getHealth() > 0 ? true : false;
	}
	/*
	 * Abstract method that does nothing
	 */
	public abstract void attack(Player player, Enemy enemy);
}