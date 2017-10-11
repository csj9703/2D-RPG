import java.util.Scanner;

public class Map
{
	Player player = new Player();
	
	String y = " ";
	String x = "#";
	String z = "X";
	
    String i = "?";
	// 2D array setup
	String maze[][] = 
		{
			{x,x,x,x,x,x,x,x,y,x},
			{x,y,y,y,y,y,x,x,y,y},
			{x,y,x,x,x,y,x,x,y,x},
			{x,y,y,y,x,x,x,x,y,x},
			{x,y,x,y,y,y,y,y,y,x},
			{x,y,x,x,x,x,y,x,y,x},
			{x,y,y,y,y,x,y,x,y,x},
			{x,y,x,x,y,x,y,x,y,x},
			{z,y,x,y,y,x,y,x,y,x},
			{x,x,x,x,x,x,x,x,x,x}
		};

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
			
		case 5:
		
			System.out.println("got it");
			statsMenu();
		

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
	
	public void statsMenu()
	{
		System.out.println("What do you want to do");
		System.out.println("Type 1 to see hit points");
		System.out.println("Type 2 to see number of pots");
		System.out.println("Type 3 to see attack stat");
		System.out.println("Type 4 to use potion");
		System.out.println("Type 5 to what swords you have");

		
		
		System.out.println("you have " + player.getHealth() + " hit_points");
		Scanner keyboard = new Scanner(System.in);
		int decision = keyboard.nextInt();
		
		
		
		
		
	}
	
	
	
	
}