package game;

import java.util.Scanner;
/*
 * This class runs the console text based version of Maze RPG
 * and acts as the controller 
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.3
 * @since October 26, 2017
 * 
 * Game instructions:			Legend:
 * w : Move up			        X : The player
 * a : Move left		        ? : An item
 * s : Move down                E : An enemy
 * d : Move right		        # : Wall/obstacle
 * i : Open inventory           
 */
public class TextGame 
{
	/**
	 * This method starts and runs the program, game ends when either
	 * the player has completed the maze is defeated by an enemy
	 * @param keyboard The scanner
	 */
	public void play(Scanner keyboard) 
	{
		Map game = new Map();
		Player player = new Spawner().spawnPlayer();
		while (!(game.gameWon()) && player.isAlive())
		{
			game.displayMaze(); 
			game.displayMenu(); 
			String choice = keyboard.next();
			if (choice.equals("i"))
			{
				game.displayInventory(player, keyboard);
			}
			else
			{
				game.move(choice);
			}
			if (game.foundItem())
			{
				player.pickUp(game.getitemID());
				game.foundItem(false);
			}
			if (game.foundEnemy())
			{
				game.startBattle(player, game.getEnemy(), keyboard);
			}
			game.checkStageCompletion();
		}
		if (player.isAlive())
		{
			System.out.println("You have completed the maze!" + "\n" + "CONGRATULATIONS");
		}
		else
		{
			System.out.println("You are dead!" + "\n" + "GAME OVER");
		}
	}
}