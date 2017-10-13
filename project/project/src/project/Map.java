package project;

import java.util.Scanner;

public class Map
{
    String maze[][];
    Player player;
	public Map () 
	{
		maze = loadMaze();
		player = new Player();
	}
	/*
	 * This method prints the input instructions
	 */
	public void displayMenu()
	{
		System.out.println(" ---------------------------------------");
		System.out.println("MOVEMENT OPTIONS");
		System.out.println("   8   ");
		System.out.println("4  5  6");
		System.out.println("   2   ");
		System.out.println("Type a number on the key pad to indicate direction of movement");
		System.out.println("or 5 for character menu");
	}
	/*
	 * This method prints the maze grid
	 */
	public void displayMaze()
	{
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
	 * This method returns the row index of the player
	 */
	public int getRow()
	{
		int playerRow = 0;
		
		for (int row = 0; row<maze.length; row++)
		{
		     for (int col = 0; col<maze[row].length; col++)
		     {
		    	 if (maze[row][col] == "X")
		    	 {
		    		 playerRow = row;
		    	 }
		     } 
		}
		return playerRow;
	}
	/*
	 * This method returns the column index of the player
	 */
	public int getCol()
	{
		int playerCol = 0;
		
		for (int row = 0; row<maze.length; row++)
		{
		     for (int col = 0; col<maze[row].length; col++)
		     {
		    	 if (maze[row][col] == "X")
		    	 {
		    		 playerCol = col;
		    	 }
		     } 
		}
		return playerCol;
	}
	
	/*
	 * This method moves the player on the grid 
	 */
	public void move()
	{
		Scanner keyboard = new Scanner(System.in);
		int choice = keyboard.nextInt();
		int playerRow = getRow();
		int playerCol = getCol();
		// remove player from current position
		maze[playerRow][playerCol] = " ";
		switch (choice)
		{
		case 2:
			playerRow += 1;
			break;
		case 4:
			playerCol -= 1;
			break;
		case 5:
			player.statsScreen();
			break;
		case 6:
			playerCol += 1;
			break;
		case 8:
			playerRow -= 1;
			break;
		}
		// checks if player encounters an object or challenge
		checkEvent(maze,playerRow,playerCol);
		if (moveValid(playerRow, playerCol))
		{
			// set player to new position
			maze[playerRow][playerCol] = "X";
		}
		else // player does not move, returns to origin
		{
			switch (choice)
			{
			case 2:
				playerRow -= 1;
				break;
			case 4:
				playerCol += 1;
				break;
			case 6:
				playerCol -= 1;
				break;
			case 8:
				playerRow += 1;
				break;
			}
			maze[playerRow][playerCol] = "X";	
		}
	}
	/*
	 * This method returns true if player is moving into an valid space
	 * @param playerRow The row index of player
	 * @param playerCow The column index of player
	 */
	public boolean moveValid(int playerRow, int playerCol)
	{
		boolean empty;

		if (!(maze[playerRow][playerCol] == "#"))
		{
			empty = true;
		}
		else
		{
			empty = false;
		}
		return empty;
	}
	/*
	 * This method starts a battle when player encounters a challenge, 
	 * and picks up a potion when player encounters a object
	 * @param maze The 2d array the player is traversing
	 * @param playerRow The row index of player
	 * @param playerCow The column index of player
	 */
	public void checkEvent(String maze[][],int playerRow, int playerCol)
	{
		if (maze[playerRow][playerCol] == "?")
		{
			player.pickUp("Potion");
		}
		else if (maze[playerRow][playerCol] == "E")
		{
			Battle battle = new Battle();
			battle.start(player, new Enemy("Slime", 5, 1));
		}
	}
	/*
	 * This method initializes the maze
	 * @return grid The 2d maze
	 */
	public static String[][] loadMaze() 
	{
		FileReader fileReader = new FileReader();
		String[][] grid = fileReader.readFile();
		return fileReader.translateData(grid);
	}
	/*
	 * This method returns true if player reaches the end of the maze,
	 * false otherwise
	 */
	public boolean mazeNotCompleted() 
	{
		boolean reachedExit = false;
		if (maze[0][18] == "X")
		{
			reachedExit = true;
		}
		else
		{
			reachedExit = false;
		}
		return reachedExit;
	}
}