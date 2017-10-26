package game;
/*
 * This class spawns enemies
 */
public class Spawner 
{
	private Enemy enemy;
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
	// these methods create different enemies
	private Enemy spawnZombie()
	{
		return new Enemy("Zombie", 10, 1, 1);
	}
	private Enemy spawnSkeleton()
	{
		return new Enemy("Skeleton", 15, 2, 1);
	}
	private Enemy spawnSkeletonKing()
	{
		return new Enemy("Skeleton King", 15, 3, 2);
	}
	private Enemy spawnBlackKnight()
	{
		return new Enemy("Black Knight", 15, 2, 1);
	}
	private Enemy spawnReaper()
	{
		return new Enemy("Reaper", 20, 4, 3);
	}
}