package game;

/*
 * This class defines the consumable items of the game
 */
public class Potion extends GameObject
{	
	private int healingAmount;
	/*
	 * This constructor initializes the potion fields
	 */
	public Potion(String name, int healingAmount) 
	{
		super(name);
		this.healingAmount = healingAmount;
	}
	/*
	 * This is the getter method for healing amount, returns healingAmount
	 */
	public int getHealingAmount()
	{
		return new Integer(healingAmount);
	}
}