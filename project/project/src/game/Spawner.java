package game;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/*
 * This class creates the enemy, potion, 
 * and weapon game objects  
 */
public class Spawner
{
	private Player player;
	private Enemy enemy;
	private File file;
	private Scanner scanner;
	private Potion potion;
	private Weapon weapon;
	/*
	 * This method reads from a text file
	 * @param aFile The name of the text file
	 */
	public Spawner(String aFile)
	{
		file = new File(aFile) ;
		try
		{
			scanner = new Scanner(file);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error: " + file + " not found");
		}
	}
	/*
	 * This method returns an enemy based on the enemyID
	 * @param enemyID The ID number
	 */
	public Enemy spawnEnemy(int enemyID)
	{
		switch (enemyID)
		{
			case 1:
				enemy = spawnZombie();
				break;
			case 2:
				enemy = spawnSkeleton();
				break;
			case 3:
				enemy = spawnSkeletonKing();
				break;
			case 4:
				enemy = spawnBlackKnight();
				break;
			case 5:
				enemy = spawnReaper();
				break;
		}
		return enemy;
	}
	/*
	 * This method returns an potion based on the itemID
	 * @param itemID The ID number
	 */
	public Potion createItem(int itemID)
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
	/*
	 * This method returns an weapon based on the itemID
	 * @param itemID The ID number
	 */
	public Weapon createWeapon(int itemID)
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
	/**
	 * This method spawns the player.
	 * @return Player
	 */
	public Player spawnPlayer() 
	{
		return new Player(scanner.next(),Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()));
	}
	// these methods create different enemies
	private Enemy spawnZombie()
	{
		return new Enemy(scanner.next(), Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()));
	}
	private Enemy spawnSkeleton()
	{
		scanner.nextLine();
		return new Enemy(scanner.next(), Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()));
	}
	private Enemy spawnSkeletonKing()
	{
		scanner.nextLine();
		scanner.nextLine();
		return new Enemy(scanner.next()+" "+scanner.next(), Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()));
	}
	private Enemy spawnBlackKnight()
	{
		scanner.nextLine();
		scanner.nextLine();
		scanner.nextLine();
		return new Enemy(scanner.next()+" "+scanner.next(), Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()));

	}
	private Enemy spawnReaper()
	{
		scanner.nextLine();
		scanner.nextLine();
		scanner.nextLine();
		scanner.nextLine();
		return new Enemy(scanner.next(), Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()));
		}
	// these methods create different potions
	private Potion createSmallPotion()
	{
		return new Potion(scanner.next()+" "+scanner.next(), Integer.parseInt(scanner.next()));
	}
	private Potion createMediumPotion()
	{
		scanner.nextLine();
		return new Potion(scanner.next()+" "+scanner.next(), Integer.parseInt(scanner.next()));
	}
	private Potion createLargePotion()
	{
		scanner.nextLine();
		scanner.nextLine();
		return new Potion(scanner.next()+" "+scanner.next(), Integer.parseInt(scanner.next()));
	}
	// these methods create different weapons
	private Weapon createWeapon1()
	{
		scanner.nextLine();
		scanner.nextLine();
		scanner.nextLine();
		return new Weapon(scanner.next()+" "+scanner.next(), Integer.parseInt(scanner.next()));
	}
	private Weapon createWeapon2()
	{
		scanner.nextLine();
		scanner.nextLine();
		scanner.nextLine();
		scanner.nextLine();
		return new Weapon(scanner.next()+" "+scanner.next(), Integer.parseInt(scanner.next()));
	}
	private Weapon createWeapon3()
	{
		scanner.nextLine();
		scanner.nextLine();
		scanner.nextLine();
		scanner.nextLine();
		scanner.nextLine();
		return new Weapon(scanner.next()+" "+scanner.next(), Integer.parseInt(scanner.next()));
	}
}