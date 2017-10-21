package project;

import java.util.Scanner;
/*
 * This class is the maze that tracks the location of the
 * player, enemy, and items 
 */
public class Map
{
    private String maze[][];
    private Player player;
    String selectedStage = null;
    
    /*
     * This constructor initializes the game, loads all the game elements onto the map
     */
	public Map () 
	{	
		FileReader fileReader = new FileReader();
		maze = fileReader.translateData(fileReader.readFile(selectStage()));
		setPlayer(new Player());
	}
	/*
	 * This method prints the player input controls
	 */
	public void displayMenu()
	{
		System.out.println(" ---------------------------------------");
		System.out.println("MOVEMENT OPTIONS");
		System.out.println("   w   ");
		System.out.println("a  i  d");
		System.out.println("   s   ");
		System.out.println("Type a number on the key pad to indicate direction of movement");
		System.out.println("or i for character menu");
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
		String choice = keyboard.next();
		int playerRow = getRow();
		int playerCol = getCol();
		// remove player from current position
		maze[playerRow][playerCol] = " ";
		switch (choice)
		{
		case "s":
			playerRow += 1;
			break;
		case "a":
			playerCol -= 1;
			break;
		case "i":
			getPlayer().inventory();
			break;
		case "d":
			playerCol += 1;
			break;
		case "w":
			playerRow -= 1;
			break;
		}
		// checks if player encounters an object or challenge
		checkEvent(maze,playerRow,playerCol);
		// sets player to new position if move is valid
		if (moveValid(playerRow, playerCol))
		{
			maze[playerRow][playerCol] = "X";
		}
		else // player does not move, returns to origin
		{
			switch (choice)
			{
			case "s":
				playerRow -= 1;
				break;
			case "a":
				playerCol += 1;
				break;
			case "d":
				playerCol -= 1;
				break;
			case "w":
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
	 * and picks up a item when player encounters a object
	 * @param maze The 2d array the player is traversing
	 * @param playerRow The row index of player
	 * @param playerCow The column index of player
	 */
	public void checkEvent(String maze[][],int playerRow, int playerCol)
	{
		if (maze[playerRow][playerCol] == "?")
		{
			getPlayer().pickUp("Potion");
		}
		else if (maze[playerRow][playerCol] == "E")
		{
			Battle battle = new Battle();
			battle.start(getPlayer(), new Spawner().spawnEnemy(identifyEnemy(playerRow, playerCol)));
		}
	}
	/*
	 * This method returns true if player reaches the end of the maze,
	 * false otherwise
	 */
	public boolean mazeNotCompleted() 
	{
		return (maze[0][18] == "X") && selectedStage == "stage3.txt" ? false : true;
	}
	/*
	 * This is the getter method for player, returns player
	 */
	public Player getPlayer() 
	{
		return player;
	}
	/*
	 * This is the setter method for player
	 * @param player The instance of player
	 */
	public void setPlayer(Player player) 
	{
		this.player = player;
	}
	/*
	 * This method prints the stage selection menu
	 * Take input from player and returns the stage selected
	 */
	public String selectStage()
	{
		System.out.println("Enter which stage you would like to play");
		System.out.println("1. Stage 1 - start from the beginning!");
		System.out.println("2. Stage 2 - for veterans!");
		System.out.println("3. Stage 3 - for experts!");
		Scanner keyboard = new Scanner(System.in);
		String choice = keyboard.next();

		switch (choice)
		{
		case "1":
			selectedStage = "stage1.txt";
			break;
		case "2":
			selectedStage = "stage2.txt";
			break;
		case "3":
			selectedStage = "stage3.txt";
			break;
		}
		return selectedStage;
	}
	/*
	 * This method checks to see if a stage has been complete
	 * When a stage is complete it will load the next stage
	 */
	public void checkStageCompletion()
	{
		FileReader fileReader = new FileReader();
		if (selectedStage == "stage1.txt" && maze[9][19] == "X")
		{
			maze = fileReader.translateData(fileReader.readFile("stage2.txt"));
			selectedStage = "stage2.txt";
		}
		else if (selectedStage == "stage2.txt" && (maze[19][1] == "X"))
		{
			maze = fileReader.translateData(fileReader.readFile("stage3.txt"));
			selectedStage = "stage3.txt";
		}
	}
	/*
	 * This is the getter method for the grid, returns maze
	 */
	public String[][] getMaze()
	{
		return maze;
	}
	/*
	 * This is the getter method for the current stage, returns stage
	 */
	public int currentStage()
	{
		int stage = 0;
		if (selectedStage == "stage1.txt")
		{
			stage = 1;
		}
		else if (selectedStage == "stage2.txt")
		{
			stage = 2;
		}
		else if (selectedStage == "stage3.txt")
		{
			stage = 3;
		}
		return stage;
	}
	
	
	public int identifyEnemy(int playerRow, int playerCol)
	{
		int enemyID = 0;
		if (currentStage() == 1)
		{
			enemyID = 1;
		}
		else if (currentStage() == 2)
		{
			if (playerRow == 18 && playerCol == 1)
			{
				enemyID = 3;
			}
			else
			{
				enemyID = 2;
			}
		}
		else if (currentStage() == 3)
		{
			if (playerRow == 1 && playerCol == 18)
			{
				enemyID = 5;
			}
			else
			{
				enemyID = 4;
			}
		}
		return enemyID;
	}
}