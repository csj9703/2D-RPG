package game;

/*
 * This class defines the usable weapons in the game
 */
public class Weapon extends GameObject
{
	private int weaponDamage;
	/*
	 * This constructor initializes the weapon fields
	 */
	public Weapon(String name, int weaponDamage) 
	{
		super(name);
		this.weaponDamage = weaponDamage;
	}
	/*
	 * This is the getter method for weapon damage, returns weaponDamage
	 */
	public int getWeaponDamage()
	{
		return new Integer(weaponDamage);
	}
}