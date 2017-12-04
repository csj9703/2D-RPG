package game;

/*
 * The Character class is a abstract class that holds general
 * data about a game character, classes representing a type of 
 * character should inherit from this class
 */
public abstract class Character extends GameObject
{	
	private int health;
	private int attack;
	/**
	 * This constructor accepts as arguments the name, health, and attack
	 * @param name The name
	 * @param health The amount of hit points
	 * @param attack The attack rating
	 */
	public Character(String name, int health, int attack) 
	{
		super(name);
		this.health = health;
		setAttack(attack);
	}
	/**
	 * This is the getter method for health, returns health
	 */
	public int getHealth() 
	{
		return health;
	}
	/**
	 * This is the setter method for health
	 * @param health The amount of hit points
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
	 * This is the setter method for attack
	 * @param attack The amount rating
	 */
	public void setAttack(int attack) 
	{
		this.attack = 1;
		if (attack > 0) 
		{
			this.attack = attack;
		}
	}
	/**
	 * This method checks to see if the character is alive (more than zero health)
	 * Returns true if is alive, false otherwise
	 */
	public boolean isAlive()
	{
		return getHealth() > 0 ? true : false;
	}
	/**
	 * This abstract method does nothing and must
	 * be overridden in a subclass
	 */
	public abstract void attack(Character character);
}