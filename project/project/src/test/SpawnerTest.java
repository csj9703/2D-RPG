package test;

import static org.junit.Assert.*;
import org.junit.Test;

import game.*;

public class SpawnerTest 
{
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
	
	
	//SpawnPlayer Test
	
	@Test
	public void SpawnPlayerTest()
	{
		Spawner spawn = new Spawner("player.txt");
		Player test = spawn.spawnPlayer();
		Player holder = new Player("Hero",20,1);
		assertEquals("Spawned player, expected name of Hero, health 20 and attack 1", true,playerEquals(test,holder));
	}
	
	//SpawnEnemy Tests
	
	@Test
	public void spawnZombieTest()
	{
	Spawner spawn = new Spawner("Enemies.txt");
	Enemy test = spawn.spawnEnemy(1);
	Enemy holder = new Enemy("Zombie",10,1,1);
	assertEquals("Gave 1 as an enemy ID, expected Zombie",true,enemyEquals(test,holder));
	}
	@Test
	public void spawnSkeletonTest()
	{
	Spawner spawn = new Spawner("Enemies.txt");
	Enemy test = spawn.spawnEnemy(2);
	Enemy holder = new Enemy("Skeleton",15,2,1);
	assertEquals("Gave 2 as an enemy ID, expected Skeleton",true,enemyEquals(test,holder));
	}
	@Test
	public void spawnSkeletonKingTest()
	{
	Spawner spawn = new Spawner("Enemies.txt");
	Enemy test = spawn.spawnEnemy(3);
	Enemy holder = new Enemy("Skeleton King",15,3,2);
	assertEquals("Gave 3 as an enemy ID, expected SkeletonKing",true,enemyEquals(test,holder));
	}
	@Test
	public void spawnBlackKnightTest()
	{
	Spawner spawn = new Spawner("Enemies.txt");
	Enemy test = spawn.spawnEnemy(4);
	Enemy holder = new Enemy("Black Knight",15,2,1);
	assertEquals("Gave 4 as an enemy ID, expected Black Knight",true,enemyEquals(test,holder));
	}
	@Test
	public void spawnReaperTest()
	{
	Spawner spawn = new Spawner("Enemies.txt");
	Enemy test = spawn.spawnEnemy(5);
	Enemy holder = new Enemy("Reaper",20,4,3);
	assertEquals("Gave 5 as an enemy ID, expected Black Knight",true,enemyEquals(test,holder));
	}
	@Test
	public void InvalidEnemyTest()
	{
	Spawner spawn = new Spawner("Enemies.txt");
	Enemy test = spawn.spawnEnemy(6);
	Enemy test2 = spawn.spawnEnemy(0);
	Enemy test3 = spawn.spawnEnemy(-40);
	assertEquals("Gave invalid Enemy ID, expected default instance for Enemy",null,test);
	assertEquals("Gave invalid Enemy ID, expected default instance for Enemy",null,test2);
	assertEquals("Gave invalid Enemy ID, expected default instance for Enemy",null,test3);
	}
	
	//CreateItem Tests
	
	@Test
	public void createSmallPotionTest()
	{
	Spawner spawn = new Spawner("Items.txt");
	Potion test = spawn.createItem(1);
	Potion holder = new Potion("Small Potion",3);
	assertEquals("Gave 1 as item ID, expected small potion",true,potionEquals(test,holder));
	}
	@Test
	public void createMediumPotionTest()
	{
	Spawner spawn = new Spawner("Items.txt");
	Potion test = spawn.createItem(2);
	Potion holder = new Potion("Medium Potion",5);
	assertEquals("Gave 2 as item ID, expected medium potion",true,potionEquals(test,holder));
	}
	@Test
	public void createLargePotionTest()
	{
	Spawner spawn = new Spawner("Items.txt");
	Potion test = spawn.createItem(3);
	Potion holder = new Potion("Large Potion",7);
	assertEquals("Gave 3 as item ID, expected large potion",true,potionEquals(test,holder));
	}
	@Test
	public void IncorrectItemTest()
	{
	Spawner spawn = new Spawner("Items.txt");
	Potion test = spawn.createItem(-40);
	Potion test2 = spawn.createItem(4);
	Potion test3 = spawn.createItem(0);
	assertEquals("Gave invalid Item ID, expected default instance of Potion",null,test);
	assertEquals("Gave invalid Item ID, expected default instance of Potion",null,test2);
	assertEquals("Gave invalid Item ID, expected default instance of Potion",null,test3);
	}
	
	//CreateWeapon Tests
	
	@Test
	public void createRustyDaggerTest()
	{
	Spawner spawn = new Spawner("Items.txt");
	Weapon test = spawn.createWeapon(4);
	Weapon holder = new Weapon("Rusty Dagger",1);
	assertEquals("Gave 4 as item ID, expected rusty dagger",true,weaponEquals(test,holder));
	}
	@Test
	public void createIronLongswordTest()
	{
	Spawner spawn = new Spawner("Items.txt");
	Weapon test = spawn.createWeapon(5);
	Weapon holder = new Weapon("Iron Longsword",2);
	assertEquals("Gave 5 as item ID, expected Iron Longsword",true,weaponEquals(test,holder));
	}
	@Test
	public void createExcaliburTest()
	{
	Spawner spawn = new Spawner("Items.txt");
	Weapon test = spawn.createWeapon(6);
	Weapon holder = new Weapon("Excalibur",3);
	assertEquals("Gave 6 as item ID, expected Excalibur",true,weaponEquals(test,holder));
	}
	@Test
	public void IncorrectWeaponTest()
	{
	Spawner spawn = new Spawner("Items.txt");
	Weapon test = spawn.createWeapon(7);
	Weapon test2 = spawn.createWeapon(3);
	Weapon test3 = spawn.createWeapon(-400);
	assertEquals("Gave invalid Weapon ID, expected default instance of Weapon",null,test);
	assertEquals("Gave invalid Weapon ID, expected default instance of Weapon",null,test2);
	assertEquals("Gave invalid Weapon ID, expected default instance of Weapon",null,test3);
	}
}
