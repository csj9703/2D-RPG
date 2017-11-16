package game;

/*
 * This class defines the consumable items of the game
 */
public class Potion extends GameObject
{	
	private int healingAmount;
	/*
	 * This constructor accepts as arguments the name
	 * and damage healing amount of the potion
	 * @param name The name
	 * @param healingAmount The healing amount 
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
		return healingAmount;
	}
}