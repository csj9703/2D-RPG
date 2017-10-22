package project;
/*
 * This class spawns enemies
 */
public class Spawner 
{
	private Enemy enemy;
	
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
	
	public Enemy spawnZombie()
	{
		return new Enemy("Zombie", 5, 1, 1);
	}
	public Enemy spawnSkeleton()
	{
		return new Enemy("Skeleton", 5, 1, 1);
	}
	public Enemy spawnSkeletonKing()
	{
		return new Enemy("Skeleton King", 10, 1, 1);
	}
	public Enemy spawnBlackKnight()
	{
		return new Enemy("Black Knight", 5, 1, 1);
	}
	public Enemy spawnReaper()
	{
		return new Enemy("Reaper", 10, 1, 1);
	}
}
