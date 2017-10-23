package project;

/*
 * This class defines the usable weapons in the game
 */
public class Weapon 
{
	private String name;
	private int weaponDamage;
	/*
	 * This constructor initializes the weapon fields
	 */
	public Weapon(String name, int weaponDamage) 
	{
		this.name = name;
		this.weaponDamage = weaponDamage;
	}
	/*
	 * This is the getter method for name, returns name
	 */
	public String getName()
	{
		return name;
	}
	/*
	 * This is the getter method for weapon damage, returns weaponDamage
	 */
	public int getWeaponDamage()
	{
		return weaponDamage;
	}
}