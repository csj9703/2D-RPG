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
		Map game = new Map();
		Gui gui = new Gui(game);
		while (game.getPlayer().isAlive() && game.mazeNotCompleted())
		{
			//game.displayMaze();
			//game.displayMenu();
			game.move();
			gui.update(game);
			game.checkStageCompletion();
		}
		if (game.getPlayer().isAlive())
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