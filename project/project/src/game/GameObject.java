package game;

/*
 * This class is the starting point for all game objects
 */
public class GameObject 
{
	private String name;
	/**
	 * This constructor initializes the name of all game objects
	 */
	public GameObject(String name)
	{
		this.name = name;
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
}