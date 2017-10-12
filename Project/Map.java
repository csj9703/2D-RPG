import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Map
{
    String maze[][];
    Player player;

	public Map () 
	{
		maze = loadMaze();
		player = new Player();
	}
	
	
	// prints instructions
	public void displayMenu()
	{
		System.out.println("MOVEMENT OPTIONS");
		System.out.println("   8   ");
		System.out.println("4  5  6");
		System.out.println("   2   ");
		System.out.println("Type a number on the key pad to indicate direction of movement");
	}

	// prints game grid
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
	
	// moves the player on grid
	public void move()
	{
		Scanner keyboard = new Scanner(System.in);
		int choice = keyboard.nextInt();
		// current player coordinates
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
		case 6:
			playerCol += 1;
			break;
		case 8:
			playerRow -= 1;
			break;
		}
		
		if (moveValid(playerRow, playerCol))
		{
			// display player at new position
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
	// returns true if player is moving into an unoccupied space
	public boolean moveValid(int playerRow, int playerCol)
	{
		boolean empty;

		if (maze[playerRow][playerCol] == " ")
		{
			empty = true;
		}
		else
		{
			empty = false;
		}
		return empty;
	}
	
	// reads text file into a 2d array
	public static String [][] readFile() 
	{
		File file = new File("maze.txt");
		Scanner scanner = null;
		try 
		{
			scanner = new Scanner(file);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
		}
		
		final int rows = 20;
		final int cols = 20;
		String maze[][] = new String[rows][cols];
		for(int row=0; row<rows; row++) 
		{
			for(int col=0; col<cols; col++) 
			{
				maze[row][col] = scanner.next();
			}
		}
		return maze;
	}
	
	// translates letters in to map symbols
	private static void translateData(String [][] maze)
	{
		final int rows = maze.length;
		final int cols = maze[0].length;
		for(int row=0; row<rows; row++) 
		{
			for(int col=0; col<cols; col++) 
			{
				String letter = maze[row][col];
				
				switch(letter)
				{
				case "x":
					maze[row][col] = "#";
					break;
				case "y":
					maze[row][col] = " ";
					break;
				case "z":
					maze[row][col] = "X";
					break;
				case "i":
					maze[row][col] = "?";
					break;
				case "e":
					maze[row][col] = "E";
					break;
				}
			}
		}	
	}
	
	// creates maze
	public static String[][] loadMaze() 
	{
		String[][] grid = readFile();
		translateData(grid);
		return grid;
	}
	
	public String[][] getMaze()
	{
		return maze;
	}
	
	
	
}