package game;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
/*
 * This class creates the enemy, potion, 
 * and weapon game objects
 */
public class Spawner
{
	private Enemy enemy;
	private File file;
	private Scanner scanner;
	private Potion potion;
	private Weapon weapon;
	private Enemy[] enemyArray = new Enemy[6];
	private GameObject[] itemArray = new GameObject[7];
	private Player player;
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
			if (file.equals(new File("Enemies.txt")))
			{
			Enemy zombie = new Enemy(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			Enemy skeleton = new Enemy(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			Enemy skeletonKing = new Enemy(scanner.next()+" "+scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			Enemy blackKnight = new Enemy(scanner.next()+" "+scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			Enemy reaper =  new Enemy(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			enemyArray[0] = null;
			enemyArray[1] = zombie;
			enemyArray[2] = skeleton;
			enemyArray[3]= skeletonKing;
			enemyArray[4] = blackKnight;
			enemyArray[5] = reaper;
			}
			if (file.equals(new File("Items.txt")))
			{
				
			itemArray[0] = null;
			Potion smallPotion = new Potion(scanner.next()+" "+scanner.next(), scanner.nextInt());
			Potion mediumPotion = new Potion(scanner.next()+" "+scanner.next(), scanner.nextInt());
			Potion largePotion = new Potion(scanner.next()+" "+scanner.next(), scanner.nextInt());
			itemArray[1] = smallPotion;
			itemArray[2] = mediumPotion;
			itemArray[3] = largePotion;
			Weapon rustyDagger = new Weapon(scanner.next()+" "+scanner.next(), scanner.nextInt());
			Weapon ironLongsword = new Weapon(scanner.next()+" "+scanner.next(), scanner.nextInt());
			Weapon excalibur = new Weapon(scanner.next(), scanner.nextInt());
			itemArray[4] = rustyDagger;
			itemArray[5] = ironLongsword;
			itemArray[6] = excalibur;
			}
			if (file.equals(new File("Player.txt")))
			{
			player = new Player(scanner.next(), scanner.nextInt(),scanner.nextInt());
			}
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
				enemy = objectGrabberEnemy(1);
				break;
			case 2:
				enemy = objectGrabberEnemy(2);
				break;
			case 3:
				enemy = objectGrabberEnemy(3);
				break;
			case 4:
				enemy = objectGrabberEnemy(4);
				break;
			case 5:
				enemy = objectGrabberEnemy(5);
				break;
			default:
				enemy = null;
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
				potion = objectGrabberPotion(1);
				break;
			case 2:
				potion = objectGrabberPotion(2);
				break;
			case 3:
				potion = objectGrabberPotion(3);
				break;
			default:
				potion = null;
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
				weapon = objectGrabberWeapon(4);
				break;
			case 5:
				weapon = objectGrabberWeapon(5);
				break;
			case 6:
				weapon = objectGrabberWeapon(6);
				break;
			default:
				weapon = null;
				break;
		}
		return weapon;
	}
	
	public Player spawnPlayer()
	{
		return new Player("Hero", 20, 1);
	}
	
	
	/** Below are the object grabber methods, they take either
	 * an enemyID or an itemID and they grab
	 * the corresponding object from the corresponding array.
	 * 
	 * Note that all of these return new objects, 
	 * however this is not necessary since the only changes to these
	 * objects occurs in the map class which is conveniently creating an new instance of the 
	 * spawner class each time it is called, 
	 * so changes to the objects in the enemy array will have no effect.
	 * This is merely to prevent privacy leaks.
	 */
	
	/**
	 * 
	 * @param enemyID
	 * @return Enemy object corresponding to enemyID
	 */
	public Enemy objectGrabberEnemy(int enemyID)
	{
		return new Enemy(enemyArray[enemyID]);
	}
	/**
	 * 
	 * @param itemID
	 * @return Weapon object corresponding to itemID
	 */
	public Weapon objectGrabberWeapon(int itemID)
	{
		return new Weapon((Weapon) itemArray[itemID]);
	}
	/**
	 * 
	 * @param itemID
	 * @return Potion object corresponding to itemID
	 */
	public Potion objectGrabberPotion(int itemID)
	{
		return new Potion((Potion) itemArray[itemID]);
	}
}