package project;

public class Characters {
	
	private String name;
	private int health;
	private int attack;
	
	/**
	 * This constructor initializes the name, health, and attack.
	 * @param name
	 * @param health
	 * @param attack
	 */
	public Characters(String name, int health, int attack) {
		this.name = name;
		this.health = health;
		this.attack = attack;
	}
	/**
	 * Getter Method for character name. Returns name.
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Setter method for character name.
	 * @param name The name of the character.
	 */
	public void setName(String name)
	{
		this.name = name;
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
}
