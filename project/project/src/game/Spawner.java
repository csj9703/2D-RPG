package game;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * This class spawns various game objects, including
 * potions, weapons, enemies, and the player
 */
public class Spawner
{
	private Scanner enemyScanner;
	private Scanner itemScanner;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<GameObject> items = new ArrayList<GameObject>();
	/**
	 * This constructor reads from a text file and 
	 * assigns the data values to an object
	 */
	public Spawner()
	{
		initializeGameValues();
	}
	/**
	 * This method extract game data from a text file 
	 * and assign each value to an object
	 */
	private void initializeGameValues()
	{
		try
		{	
			extractEnemyData();	
			extractItemData();
		}	
		catch (FileNotFoundException e)
		{
			FileWriter gameRepair = new FileWriter();
			gameRepair.reinstallGameFiles();
			initializeGameValues();
		}
	}
	/**
	 * This method extracts the enemy data from Enemies.txt
	 */
	private void extractEnemyData() throws FileNotFoundException
	{
		enemyScanner = new Scanner(new File("Enemies.txt"));
		enemies.add(null);
		for (int i = 0; i < 5; i++)
		{
			String name = enemyScanner.next();
			int health = enemyScanner.nextInt();
			int attack = enemyScanner.nextInt();
			int experience = enemyScanner.nextInt();
			enemies.add(new Enemy(name, health, attack, experience));
		}
		enemyScanner.close();
	}
	/**
	 * This method extracts the item data from Items.txt
	 */
	private void extractItemData() throws FileNotFoundException
	{
		itemScanner = new Scanner(new File("Items.txt"));
		items.add(null);
		for (int i = 0; i < 3; i++)
		{
			String name = itemScanner.next() + " " + itemScanner.next();
			int value = itemScanner.nextInt();
			items.add(new Potion(name, value));
		}
		for (int i = 0; i < 3; i++)
		{
			String name = itemScanner.next() + " " + itemScanner.next();
			int value = itemScanner.nextInt();
			items.add(new Weapon(name, value));
		}
		itemScanner.close();
	}
	/**
	 * This method returns an enemy based on the enemyID
	 * @param enemyID The ID number
	 */
	public Enemy spawnEnemy(int enemyID)
	{
		return new Enemy(enemies.get(enemyID));
	}
	/**
	 * This method returns an potion based on the itemID
	 * @param itemID The ID number
	 */
	public Potion createItem(int itemID)
	{
		return new Potion((Potion) items.get(itemID));
	}
	/**
	 * This method returns an weapon based on the itemID
	 * @param itemID The ID number
	 */
	public Weapon createWeapon(int itemID)
	{
		return new Weapon((Weapon) items.get(itemID));
	}
	/**
	 * This method creates and returns a new instance of player
	 * at its default values
	 */
	public Player spawnPlayer()
	{
		final int DEFAULT_MAX_HEALTH = 20;
		final int DEFAULT_STARTING_ATK = 1;
		String DEFAULT_HERO_NAME = "Hero";
		return new Player(DEFAULT_HERO_NAME, DEFAULT_MAX_HEALTH, DEFAULT_STARTING_ATK);
	}	
}