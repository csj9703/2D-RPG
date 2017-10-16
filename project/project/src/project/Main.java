package project;

/**
 * This is the main manager class for the game.
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.2
 * @since October 15, 2017
 */

public class Main 
{
	/*
	 * This main controls the game state. Game ends when either
	 * the player has completed the maze is defeated by an enemy
	 */
	public static void play() 
	{
		Map stage1 = new Map();
		while (stage1.getPlayer().isAlive() && stage1.mazeNotCompleted())
		{
			stage1.displayMaze();
			stage1.displayMenu();
			stage1.move();
		}
		if (stage1.getPlayer().isAlive())
		{
			System.out.println("You have completed the maze!" + "\n" + "CONGRATULATIONS");
		}
		else
		{
			System.out.println("You are dead!" + "\n" + "GAME OVER");
		}
	}
	public static void main(String[] args) 
	{
		play();
	}
}