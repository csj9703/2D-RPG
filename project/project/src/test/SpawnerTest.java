package test;

import static org.junit.Assert.*;
import org.junit.Test;

import game.*;
/*
 * This class contains the unit test for Spawner.java
 */
public class SpawnerTest 
{
	/*
	 * These four methods below check that each instance variable 
	 * used in the constructors of two objects of the same
	 * class are equivalent, the spawner class may only manipulate the variables which
	 * are used in the constructor as its purpose is only to *spawn* objects, so it is unnecessary to check
	 * other instance variables.
	 * @param obja first object to be compared
	 * @param objb second object to be compared
	 * @return true if the objects are equal, false otherwise.
	 */
	public boolean enemyEquals(Enemy obja, Enemy objb)
	{
		return objb.getName().equals(obja.getName()) &&
				objb.getAttack() == obja.getAttack() &&
				objb.getHealth() == obja.getHealth() &&
				objb.getExperience() == obja.getExperience();
	}
	
	public boolean weaponEquals(Weapon obja, Weapon objb)
	{
		return obja.getName().equals(objb.getName()) &&
			   obja.getWeaponDamage() == objb.getWeaponDamage();
	}
	
	public boolean potionEquals(Potion obja, Potion objb)
	{
		return obja.getName().equals(objb.getName()) &&
			   obja.getHealingAmount() == objb.getHealingAmount();
	}
	
	public boolean playerEquals(Player obja, Player objb)
	{
		return obja.getName().equals(objb.getName()) &&
			   obja.getAttack()==objb.getAttack() &&
			   obja.getHealth()==objb.getHealth();
	}
	/*
	 * SpawnPlayer Test, checks to see if the player has the correct default values, using
	 * playerEquals() method.
	 */
	@Test
	public void SpawnPlayerTest()
	{
		Spawner spawn = new Spawner();
		Player test = spawn.spawnPlayer();
		Player holder = new Player("Hero", 20, 1);
		assertEquals("Spawned player, expected name of Hero, health 20 and attack 1", true, playerEquals(test, holder));
	}
	/*
	 * SpawnEnemy Tests, compares the instances created by the spawner to instances that
	 * were expected using enemyEquals() method.
	 */
	@Test
	public void spawnZombieTest()
	{
		Spawner spawn = new Spawner();
		Enemy test = spawn.spawnEnemy(1);
		Enemy holder = new Enemy("Zombie",10,1,1);
		assertEquals("Gave 1 as an enemy ID, expected Zombie", true, enemyEquals(test, holder));
	}
	
	@Test
	public void spawnSkeletonTest()
	{
		Spawner spawn = new Spawner();
		Enemy test = spawn.spawnEnemy(2);
		Enemy holder = new Enemy("Skeleton",15,2,1);
		assertEquals("Gave 2 as an enemy ID, expected Skeleton", true, enemyEquals(test, holder));
	}
	
	@Test
	public void spawnSkeletonKingTest()
	{
		Spawner spawn = new Spawner();
		Enemy test = spawn.spawnEnemy(3);
		Enemy holder = new Enemy("Skeleking",15,3,2);
		assertEquals("Gave 3 as an enemy ID, expected Skeleking", true, enemyEquals(test, holder));
	}
	
	@Test
	public void spawnBlackKnightTest()
	{
		Spawner spawn = new Spawner();
		Enemy test = spawn.spawnEnemy(4);
		Enemy holder = new Enemy("Knight",15,2,1);
		assertEquals("Gave 4 as an enemy ID, expected Knight", true, enemyEquals(test, holder));
	}
	
	@Test
	public void spawnReaperTest()
	{
		Spawner spawn = new Spawner();
		Enemy test = spawn.spawnEnemy(5);
		Enemy holder = new Enemy("Reaper",20,4,3);
		assertEquals("Gave 5 as an enemy ID, expected Black Knight", true, enemyEquals(test, holder));
	}
	/*  
	 *  CreateItem Tests, checks to see if the potions created by the spawner 
	 *  are the same as the ones that were expected using the potionEquals() method.
	 */
	
	@Test
	public void createSmallPotionTest()
	{
		Spawner spawn = new Spawner();
		Potion test = spawn.createItem(1);
		Potion holder = new Potion("Small Potion",3);
		assertEquals("Gave 1 as item ID, expected small potion", true, potionEquals(test, holder));
	}
	@Test
	public void createMediumPotionTest()
	{
		Spawner spawn = new Spawner();
		Potion test = spawn.createItem(2);
		Potion holder = new Potion("Medium Potion",5);
		assertEquals("Gave 2 as item ID, expected medium potion", true, potionEquals(test, holder));
	}
	@Test
	public void createLargePotionTest()
	{
		Spawner spawn = new Spawner();
		Potion test = spawn.createItem(3);
		Potion holder = new Potion("Large Potion",7);
		assertEquals("Gave 3 as item ID, expected large potion", true, potionEquals(test, holder));
	}
	/*
	 * CreateWeapon Tests, checks to see if the weapons created by the spawner
	 * are the same as the ones that were expected using the weaponEquals() method.
	 */
	
	@Test
	public void createRustyDaggerTest()
	{
		Spawner spawn = new Spawner();
		Weapon test = spawn.createWeapon(4);
		Weapon holder = new Weapon("Rusty Dagger",1);
		assertEquals("Gave 4 as item ID, expected rusty dagger", true, weaponEquals(test, holder));
	}
	@Test
	public void createIronLongswordTest()
	{
		Spawner spawn = new Spawner();
		Weapon test = spawn.createWeapon(5);
		Weapon holder = new Weapon("Iron Longsword",2);
		assertEquals("Gave 5 as item ID, expected Iron Longsword", true, weaponEquals(test, holder));
	}
	@Test
	public void createExcaliburTest()
	{
		Spawner spawn = new Spawner();
		Weapon test = spawn.createWeapon(6);
		Weapon holder = new Weapon("Blessed Excalibur",3);
		assertEquals("Gave 6 as item ID, expected Excalibur", true, weaponEquals(test, holder));
	}
	/*
	 * Below we test for privacy of the objects stored in the spawner
	 * if we get back the changed attack value then there is a leak.
	 */
	
	/*
	 * Testing Privacy of Enemy Objects
	 */
	@Test
	public void privacyEnemiesTest1()
	{
		Spawner spawn = new Spawner();
		Enemy a = spawn.spawnEnemy(1);
		a.setAttack(2);
		Enemy b = spawn.spawnEnemy(1);
		assertEquals("Tested for privacy of Zombie by changing attack", 1, b.getAttack());
	}
	@Test
	public void privacyEnemiesTest2()
	{
		Spawner spawn = new Spawner();
		Enemy a = spawn.spawnEnemy(2);
		a.setAttack(3);
		Enemy b = spawn.spawnEnemy(2);
		assertEquals("Tested for privacy of Skeleton by changing attack", 2, b.getAttack());
	}
	@Test
	public void privacyEnemiesTest3()
	{
		Spawner spawn = new Spawner();
		Enemy a = spawn.spawnEnemy(3);
		a.setAttack(5);
		Enemy b = spawn.spawnEnemy(3);
		assertEquals("Tested for privacy of Skeleton King by changing attack", 3, b.getAttack());
	}
	@Test
	public void privacyEnemiesTest4()
	{
		Spawner spawn = new Spawner();
		Enemy a = spawn.spawnEnemy(4);
		a.setAttack(3);
		Enemy b = spawn.spawnEnemy(4);
		assertEquals("Tested for privacy of Black Knight by changing attack", 2, b.getAttack());
	}
	@Test
	public void privacyEnemiesTest5()
	{
		Spawner spawn = new Spawner();
		Enemy a = spawn.spawnEnemy(5);
		a.setAttack(3);
		Enemy b = spawn.spawnEnemy(5);
		assertEquals("Tested for privacy of Reaper by changing attack", 4, b.getAttack());
	}
	/*
	 * Testing Privacy of Weapon Objects
	 */
	@Test
	public void privacyWeaponsTest1()
	{
		Spawner spawn = new Spawner();
		Weapon a = spawn.createWeapon(4);
		a.setName("SomethingWentWrongo");
		assertEquals("Changed the name of a weapon Object from Spawner", "Rusty Dagger", spawn.createWeapon(4).getName());
	}
	
	@Test
	public void privacyWeaponsTest2()
	{
		Spawner spawn = new Spawner();
		Weapon a = spawn.createWeapon(5);
		a.setName("SomethingWentWrongo");
		assertEquals("Changed the name of a weapon Object from Spawner", "Iron Longsword", spawn.createWeapon(5).getName());
	}
	
	@Test
	public void privacyWeaponsTest3()
	{
		Spawner spawn = new Spawner();
		Weapon a = spawn.createWeapon(6);
		a.setName("SomethingWentWrongo");
		assertEquals("Changed the name of a weapon Object from Spawner", "Blessed Excalibur", spawn.createWeapon(6).getName());
	}
	/*
	 * Testing Privacy of Potion Objects
	 */
	@Test
	public void privacyPotionsTest1()
	{
		Spawner spawn = new Spawner();
		Potion a = spawn.createItem(1);
		a.setName("SomethingWentWrongo");
		assertEquals("Changed the name of a potion object recieved from spawner,"
		+ " then called for object from spawner again","Small Potion", spawn.createItem(1).getName());
	}
	@Test
	public void privacyPotionsTest2()
	{
		Spawner spawn = new Spawner();
		Potion a = spawn.createItem(2);
		a.setName("SomethingWentWrongo");
		assertEquals("Changed the name of a potion object recieved from spawner,"
		+ " then called for object from spawner again","Medium Potion", spawn.createItem(2).getName());
	}
	@Test
	public void privacyPotionsTest3()
	{
		Spawner spawn = new Spawner();
		Potion a = spawn.createItem(3);
		a.setName("SomethingWentWrongo");
		assertEquals("Changed the name of a potion object recieved from spawner,"
		+ " then called for object from spawner again","Large Potion", spawn.createItem(3).getName());
	}
}