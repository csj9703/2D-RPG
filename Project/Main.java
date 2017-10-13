package project;

/**
 * This is the main manager class for the game
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.0
 * @since October 12, 2017
 */

public class Main 
{
	public static void play() 
	{
		Map stage1 = new Map();
		
		while (stage1.maze[0][18] != "X")
		{
			stage1.displayMaze();
			stage1.displayMenu();
			stage1.move();
		}
		System.out.println("Congratulations! You Win!");
	}

	public static void main(String[] args) 
	{
		play();
	}
}