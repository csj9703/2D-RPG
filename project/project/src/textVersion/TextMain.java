package textVersion;

import java.util.Scanner;
import game.*;
/**
 * This class runs the console text based version of Maze RPG
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.3
 * @since October 26, 2017
 * 
 * Game instructions:			Legend:
 * w : Move up			        X : The player
 * a : Move left		        ? : An item
 * s : Move down                E : An enemy
 * d : Move right		        # : Wall/obstacle
 * i : Open inventory           d : Wall/obstacle
 */
public class TextMain 
{
	/*
	 * This method prints the player input controls
	 */
	public static void displayMenu()
	{
		System.out.println(" ---------------------------------------");
		System.out.println("MOVEMENT OPTIONS");
		System.out.println("   w   ");
		System.out.println("a  i  d");
		System.out.println("   s   ");
		System.out.println("Type one of the letters above to indicate direction of movement");
		System.out.println("or i for character menu");
	}
	/*
	 * This method prints the maze grid
	 * @param game The map
	 */
	public static void displayMaze(Map game)
	{
		String[][] maze = game.getMaze();
		for (int i = 0; i<maze.length; i++)
		{
			System.out.print(" _");
		}
		System.out.println();
		for (int row = 0; row<maze.length; row++)
		{
		     for (int col = 0; col<maze[row].length; col++)
		     {
		    	 System.out.print("|" + maze[row][col]);
		     } 
		     System.out.print("|");
		     System.out.println();
		}
	}
	/*
	 * This method prints the inventory and player info
	 * @param player The player
	 * @param keyboard The scanner
	 */
	public static void displayInventory(Player player, Scanner keyboard)
	{
		boolean exit = false;
		while(!(exit)) 
		{
			System.out.println("Health: " + player.getHealth());
			System.out.println("Level: " + player.getCurrentLevel());
			System.out.println("EXP: " + player.getCurrentExp() + "/" + player.getExpToLvl() + "\n");
			System.out.println("Small Potion: " + player.getNumSmallPotions() + "  \tType 1 to consume a small potion");
			System.out.println("Medium Potion: " + player.getNumMediumPotions() + "\tType 2 to consume a medium potion");
			System.out.println("Large Potion: " + player.getNumLargePotions() + "  \tType 3 to consume a large potion");
			System.out.println("\nType i to exit menu");
			switch(keyboard.next())
			{
			case "1":
				player.useItem(1);
				break;
			case "2":
				player.useItem(2);
				break;
			case "3":
				player.useItem(3);
				break;
			case "i":
				exit = true;				
				break;
			}
		}
	}
	/*
	 * This method prints the player and enemy's interactions during battle
	 * @param player The player
	 * @param enemy The enemy
	 * @param game The map
	 * @param keyboard The scanner
	 */
	public static void startBattle(Player player, Enemy enemy, Map game, Scanner keyboard)
	{
		while(player.getHealth() > 0 && enemy.getHealth() > 0)
		{
			System.out.println("Player Name: " + player.getName());
			System.out.println("Player HP: " + player.getHealth());
			System.out.println("Enemy Name: " + enemy.getName());
			System.out.println("Enemy HP: " + enemy.getHealth());
			System.out.println("Type a to attack");
			String choice = keyboard.next();
			if (choice.equals("a"))
			{
				player.attack(player, enemy);
				System.out.println("You hit the " + enemy.getName() + " for " + player.getDamage() + " damage!");
				if (enemy.isAlive())
				{
					enemy.attack(player, enemy);
					System.out.println(enemy.getName() + " has hit you for " + enemy.getDamage() + " damage!");
				}
				else
				{
					game.foundEnemy(false);
					player.obtainExp(enemy);
					player.checkExp();
				}
			}	
		}
	}
	/*
	 * This main controls the game state. Game ends when either
	 * the player has completed the maze is defeated by an enemy
	 * @param keyboard The scanner
	 */
	public static void play(Scanner keyboard) 
	{
		Map game = new Map();
		Player player = new Player("Hero",20,1);
		while (!(game.gameWon()))
		{
			displayMaze(game); 
			displayMenu(); 
			String choice = keyboard.next();
			if (choice.equals("i"))
			{
				displayInventory(player, keyboard);
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
				startBattle(player, game.getEnemy(), game, keyboard);
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
	 /*
     * This method starts the game 
     */
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		play(keyboard);
		keyboard.close();
	}
}