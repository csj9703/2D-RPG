package project;
/*
 * This class is the maze that tracks the location of the
 * player, enemy, and items 
 */
public class Map
{
    private String maze[][];
    private Enemy enemy = new Enemy("Default",1,1,1);
    private Potion item = new Potion("Default", 1);
    private String selectedStage = "stage1.txt";
    private boolean foundEnemy = false;
    private boolean foundItem = false;
    private int enemyID = 0;
    private int itemID = 0;
    /*
     * This constructor initializes the game, loads all the game elements onto the map
     */
	public Map () 
	{	
		FileReader fileReader = new FileReader();
		maze = fileReader.translateData(fileReader.readFile("stage1.txt"));
	}
	/*
	 * This method returns the row index of the player
	 */
	private int getRow()
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
	private int getCol()
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
	public void move(String choice)
	{
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
	 * @param playerCol The column index of player
	 */
	public boolean moveValid(int playerRow, int playerCol)
	{
		boolean empty;

		if (!(maze[playerRow][playerCol] == "#")&&!(maze[playerRow][playerCol] == "d"))
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
			foundItem = true;
			item = new ItemCreator().createItem(identifyItem(playerRow, playerCol));

		}
		else if (maze[playerRow][playerCol] == "E")
		{
			foundEnemy(true);
			enemy = new Spawner().spawnEnemy(identifyEnemy(playerRow, playerCol));
		}
	}
	/*
	 * This method returns true if player reaches the end of the maze,
	 * false otherwise
	 */
	public boolean gameWon() 
	{
		return (maze[0][18] == "X") && selectedStage == "stage3.txt" ? true : false;
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
	/*
	 * This method determines which enemy is encountered, returns the enemy ID 
	 * @param playerRow The player's row index on the array
	 * @param playerCol The player's column index on the array
	 */
	public int identifyEnemy(int playerRow, int playerCol)
	{
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
	/*
	 * This method determines which enemy is encountered, returns the enemy ID 
	 * @param playerRow The player's row index on the array
	 * @param playerCol The player's column index on the array
	 */
	public int identifyItem(int playerRow, int playerCol)
	{
		if (currentStage() == 1)
		{
			if (playerRow == 11 && playerCol == 6)
			{
				itemID = 4;
			}
			else
			{
				itemID = 1;
			}			
		}
		else if (currentStage() == 2)
		{
			if (playerRow == 16 && playerCol == 18)
			{
				itemID = 5;
			}
			else
			{
				itemID = 2;
			}			
		}
		else if (currentStage() == 3)
		{
			if (playerRow == 2 && playerCol == 6)
			{
				itemID = 6;
			}
			else
			{
				itemID = 3;
			}			
		}
		return itemID;
	}
	/*
	 * This is the getter method for the foundEnemy variable, returns foundEnemy
	 */
	public boolean foundEnemy()
	{
		return foundEnemy;
	}
	/*
	 * This is the setter method for the foundEnemy variable
	 * @param truthValue The foundEnemy variable
	 */
	public void foundEnemy(boolean truthValue)
	{
		foundEnemy = truthValue;
	}
	/*
	 * This is the getter method for the foundItem variable, returns foundItem
	 */
	public boolean foundItem()
	{
		return foundItem;
	}
	/*
	 * This is the setter method for the foundItem variable
	 * @param truthValue The foundItem variable
	 */
	public void foundItem(boolean truthValue)
	{
		foundItem = truthValue;
	}
	/*
	 * This is the getter method for the enemyID, returns enemyID
	 */
	public int getEnemyID()
	{
		return enemyID;
	}
	/*
	 * This is the getter method for the itemID, returns itemID
	 */
	public int getitemID()
	{
		return itemID;
	}
	/*
	 * This is the getter method for the enemy, returns enemy
	 */
	public Enemy getEnemy()
	{
		return enemy;
	}
	/*
	 * This is the getter method for the item, returns item
	 */
	public Potion getItem()
	{
		return item;
	}
}