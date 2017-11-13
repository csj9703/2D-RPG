//THIS CLASS IS NO LONGER IN USE, ONLY KEPT HERE IN CASE OF ERRORS WITH SPAWNER.JAVA







package game;

/*
 * This class creates game items
 */
public class ItemCreator 
{
	private Potion potion;
	private Weapon weapon;
	/*
	 * This method returns a potion based on the itemID
	 * @param itemID The ID number
	 */
	public Potion createItem(int itemID)
	{
		{
			switch (itemID)
			{
			case 1:
				potion = createSmallPotion();
				break;
			case 2:
				potion = createMediumPotion();
				break;
			case 3:
				potion = createLargePotion();
				break;
			}
			return potion;
		}
	}
	// these methods create different potions
	private Potion createSmallPotion()
	{
		return new Potion("Small Potion", 3);
	}
	private Potion createMediumPotion()
	{
		return new Potion("Medium Potion", 5);
	}
	private Potion createLargePotion()
	{
		return new Potion("Large Potion", 7);
	}
	/*
	 * This method returns a weapon based on the itemID
	 * @param itemID The ID number
	 */
	public Weapon createWeapon(int itemID)
	{
		{
			switch (itemID)
			{
			case 4:
				weapon = createWeapon1();
				break;
			case 5:
				weapon = createWeapon2();
				break;
			case 6:
				weapon = createWeapon3();
				break;
			}
			return weapon;
		}
	}
	// these methods create different weapons
	private Weapon createWeapon1()
	{
		return new Weapon("Rusty Dagger", 1);
	}
	private Weapon createWeapon2()
	{
		return new Weapon("Iron Longsword", 2);
	}
	private Weapon createWeapon3()
	{
		return new Weapon("Excalibur", 3);
	}
}