package game;

/*
 * The GamObject class is a abstract class that holds the name
 * of game objects, classes representing a game object should 
 * inherit from this class
 */
public abstract class GameObject 
{
	private String name;
	/**
	 * This constructor accepts name as the argument
	 * @param name The name
	 */
	public GameObject(String name)
	{
		this.name = name;
	}
	/**
	 * This is the getter method for name, returns name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * This is the setter method for name
	 * @param name The name of the game object
	 */
	public void setName(String name)
	{
		this.name = name;
	}
}