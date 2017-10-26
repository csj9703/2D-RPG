package textVersion;

import java.util.Scanner;

import game.*;
/**
 * This is the main manager class for the game.
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.2
 * @since October 15, 2017
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
	 * This method prints the inventory and statistics
	 */
	public static void displayInventory(Player player)
	{
		Scanner keyboard = new Scanner(System.in);
		boolean exit = false;
		while(!(exit)) 
		{
			System.out.println("Small Potion: " + player.getNumSmallPotions());
			System.out.println("Medium Potion: " + player.getNumMediumPotions());
			System.out.println("Large Potion: " + player.getNumLargePotions());
			System.out.println("Small Potion: " + player.getNumSmallPotions());
			System.out.println("Medium Potion: " + player.getNumMediumPotions());
			System.out.println("Large Potion: " + player.getNumLargePotions());
			System.out.println("Type 1 to consume a small potion");
			System.out.println("Type 2 to consume a medium potion");
			System.out.println("Type 3 to consume a large potion");
			System.out.println("Type i to exit menu");
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
	 * This method prints the battle 
	 */
	public static void startBattle(Player player, Enemy enemy, Map game)
	{
		Scanner keyboard = new Scanner(System.in);
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
	 */
	public static void play() 
	{
		Scanner keyboard = new Scanner(System.in);
		Map game = new Map();
		Player player = new Player("Hero",20,1);
		while (player.isAlive())
		{
			displayMaze(game); 
			displayMenu(); 
			
			String choice = keyboard.next();
			System.out.println(choice);
			if (choice.equals("i"))
			{
				displayInventory(player);
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
				startBattle(player, game.getEnemy(), game);
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
	public static void main(String[] args) 
	{
		play();
	}
}