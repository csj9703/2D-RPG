package game;

/*
 * This class defines the usable weapons in the game
 */
public class Weapon extends GameObject
{
	private int weaponDamage;
	/*
	 * This constructor accepts as arguments the name
	 * and damage rating of the weapon
	 * @param name The name
	 * @param weaponDamage The damage rating
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
		return weaponDamage;
	}
}