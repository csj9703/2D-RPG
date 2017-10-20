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
	
	public Enemy spawnZombie()
	{
		return new Enemy("Zombie", 5, 1, 1);
	}
	public Enemy spawnSkeleton()
	{
		return new Enemy("Skeleton", 6, 2, 2);
	}
	public Enemy spawnSkeletonKing()
	{
		return new Enemy("Skeleton King", 10, 3, 4);
	}
	public Enemy spawnBlackKnight()
	{
		return new Enemy("Black Knight", 8, 2, 3);
	}
	public Enemy spawnReaper()
	{
		return new Enemy("Reaper", 20, 5, 5);
	}
}
