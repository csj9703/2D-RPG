package game;

/*
 * This class defines the consumable items of the game
 */
public class Potion 
{	
	private String name;
	private int healingAmount;
	/*
	 * This constructor initializes the potion fields
	 */
	public Potion(String name, int healingAmount) 
	{
		this.name = name;
		this.healingAmount = healingAmount;
	}
	/*
	 * This is the getter method for name, returns name
	 */
	public String getName()
	{
		return name;
	}
	/*
	 * This is the getter method for healing amount, returns healingAmount
	 */
	public int getHealingAmount()
	{
		return new Integer(healingAmount);
	}
}