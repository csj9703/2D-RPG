package game;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/*
 * This class spawns enemies
 */
public class Spawner 
{
	private Enemy enemy;
	private File file;
	private Scanner scanner;
	
	
	public Spawner(String EnemiesFile)
	{
		file = new File(EnemiesFile) ;
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
	}