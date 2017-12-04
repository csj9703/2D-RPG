package game;

/*
 * This class defines the usable weapons in the game
 */
public class Weapon extends GameObject
{
	private int weaponDamage;
	/**
	 * This constructor accepts as arguments the name
	 * and damage rating of the weapon
	 * @param name The name
	 * @param weaponDamage The damage rating
	 */
	public Weapon(String name, int weaponDamage) 
	{
		super(name);
		if(weaponDamage > 0) 
		{
			this.weaponDamage = weaponDamage;
		}
		else 
		{
			this.weaponDamage = 1;
		}
	}
	/**
	 * This is the copy constructor for weapon
	 * @param weapon The weapon object to be copied
	 */
	public Weapon(Weapon weapon) 
	{
		super(weapon.getName());
		weaponDamage = weapon.getWeaponDamage();
	}
	/**
	 * This is the getter method for weapon damage, returns weaponDamage
	 */
	public int getWeaponDamage()
	{
		return weaponDamage;
	}
}