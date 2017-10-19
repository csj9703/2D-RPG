package project;

import java.util.Random;
/*
 * This class spawns enemies
 */
public class Spawner 
{
	private Enemy enemy;
	
	public Enemy spawnEnemy()
	{
		Random rng = new Random();
		//int num = rng.nextInt(7)+1;
		
		//***have purposely disabled spawning of other enemies
		//these other monsters are too strong
		//need to implement better weapons and growth system before enabling this
		
		int num = 1;
		switch (num)
		{
		case 1:
			enemy = spawnGoblin();
			break;
		case 2:
			enemy = spawnSkeleton();
			break;
		case 3:
			enemy = spawnZombie();
			break;
		case 4:
			enemy = spawnOgre();
			break;
		case 5:
			enemy = spawnCerberus();
			break;
		case 6:
			enemy = spawnMazeGuardian();
			break;
		case 7:
			enemy = spawnMazeSentinel();
			break;
		case 8:
			enemy = spawnFinalBoss();
			break;
		}
		return enemy;
	}
	
	public Enemy spawnGoblin()
	{
		return new Enemy("Goblin", 5, 1, 1);
	}
	public Enemy spawnSkeleton()
	{
		return new Enemy("Skeleton", 6, 2, 2);
	}
	public Enemy spawnZombie()
	{
		return new Enemy("Zombie", 7, 1, 3);
	}
	public Enemy spawnOgre()
	{
		return new Enemy("Ogre", 10, 3, 4);
	}
	public Enemy spawnCerberus()
	{
		return new Enemy("Cerberus", 20, 10, 5);
	}
	public Enemy spawnMazeGuardian()
	{
		return new Enemy("Maze Guardian", 25, 4, 6);
	}
	public Enemy spawnMazeSentinel()
	{
		return new Enemy("Maze Sentinel", 30, 5, 7);
	}
	public Enemy spawnFinalBoss()
	{
		return new Enemy("The God of Destruction, Perses", 100, 10, 10);
	}
}
