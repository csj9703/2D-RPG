package project;

/**
 * This is the main manager class for the game
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.1
 * @since October 13, 2017
 */

public class Main 
{
	/*
	 * This method controls the game state. Game ends when either
	 * the player dies or has completed the maze
	 */
	public static void play() 
	{
		Map stage1 = new Map();
		while (stage1.player.isAlive() && stage1.mazeNotCompleted())
		{
			stage1.displayMaze();
			stage1.displayMenu();
			stage1.move();
		}
		if (stage1.player.isAlive())
		{
			System.out.println("You have completed the maze!");
			System.out.println("CONGRATULATIONS");
		}
		else
		{
			System.out.println("You are dead!");
			System.out.println("GAME OVER");
		}
	}
	public static void main(String[] args) 
	{
		play();
	}
}