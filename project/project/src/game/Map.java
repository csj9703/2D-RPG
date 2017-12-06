package game;

import java.util.Scanner;

/*
 * This class is the maze that tracks the location of the
 * player, enemy, and items 
 */
public class Map
{
    private String maze[][];
    private Enemy enemy = new Enemy("Default",1,1,1);
    private AudioPlayer audioPlayer = new AudioPlayer();
    private String selectedStage = "stage1.txt";
    private boolean foundEnemy = false;
    private boolean foundItem = false;
    private int itemID = 0;
    private boolean stageComplete = false;
    private boolean gameWon = false;
	/**
     * This constructor initializes the game, loads all the game elements onto the map
     */
	public Map () 
	{	
		audioPlayer.startGameMusic();
		FileReader fileReader = new FileReader();
		maze = fileReader.readFile(selectedStage);
	}
	/**
	 * This is the copy constructor for map
	 * @param map The map object to be copied
	 */
	public Map(Map map)
	{
		maze = map.getMaze();
		enemy = map.getEnemy();
		audioPlayer = map.getAudioPlayer();
		selectedStage = map.getSelectedStage();
		foundEnemy = map.foundEnemy();
		foundItem = map.foundItem();
		itemID = map.getitemID();
		stageComplete = map.getStageComplete();
		gameWon = map.gameWon();
	}
	/**
	 * This method prints the player input controls
	 */
	public void displayMenu()
	{
		System.out.println(" ---------------------------------------");
		System.out.println("MOVEMENT OPTIONS");
		System.out.println("   w   ");
		System.out.println("a  i  d");
		System.out.println("   s   ");
		System.out.println("Type one of the letters above to indicate direction");
		System.out.println("of movement or i for character menu");
	}
	/**
	 * This method prints the maze grid borders
	 */
	public void displayMaze()
	{
		String[][] maze = textMaze();
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
	/**
	 * This method converts the maze elements to a letter
	 * to be displayed in the console, returns a text maze
	 */
	private String[][] textMaze()
	{
		final int ROWS = 20;
		final int COLS = 20;
		String[][] maze = getMaze();
		String[][] textMaze = new String[ROWS][COLS];
		for(int r = 0; r < ROWS; r++) 
		{
			for(int c = 0; c < COLS; c++) 
			{
				String letter = maze[r][c];

				switch(letter)
				{
				case "w":
					textMaze[r][c] = "#";
					break;
				case "v":
					textMaze[r][c] = "#";
					break;
				case "r":
					textMaze[r][c] = " ";
					break;
				case "x":
					textMaze[r][c] = "X";
					break;
				case "1":
					textMaze[r][c] = "?";
					break;
				case "2":
					textMaze[r][c] = "?";
					break;
				case "3":
					textMaze[r][c] = "?";
					break;
				case "4":
					textMaze[r][c] = "?";
					break;
				case "5":
					textMaze[r][c] = "?";
					break;
				case "6":
					textMaze[r][c] = "?";
					break;
				case "a":
					textMaze[r][c] = "E";
					break;
				case "b":
					textMaze[r][c] = "E";
					break;
				case "c":
					textMaze[r][c] = "E";
					break;
				case "d":
					textMaze[r][c] = "E";
					break;
				case "e":
					textMaze[r][c] = "E";
					break;
				case "n":
					textMaze[r][c] = " ";
					break;
				case "m":
					textMaze[r][c] = " ";
					break;
				}
			}
		}
		return textMaze;
	}
	/**
	 * This method prints the inventory and player info
	 * @param player The player
	 * @param keyboard The scanner
	 */
	public void displayInventory(Player player, Scanner keyboard)
	{
		boolean exit = false;
		while(!(exit)) 
		{
			System.out.println("Health: " + player.getHealth());
			System.out.println("Level: " + player.getCurrentLevel());
			System.out.println("EXP: " + player.getCurrentExp() + "/" + player.getExpToLvl() + "\n");
			System.out.println("Small Potion: " + player.getNumSmallPotions() + "  \tType 1 to consume a small potion");
			System.out.println("Medium Potion: " + player.getNumMediumPotions() + "  \tType 2 to consume a medium potion");
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
	/**
	 * This method prints the player and enemy's interactions during battle
	 * @param player The player
	 * @param enemy The enemy
	 * @param keyboard The scanner
	 */
	public void startBattle(Player player, Enemy enemy, Scanner keyboard)
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
				audioPlayer.playAttackSFX();
				player.attack(enemy);
				System.out.println("You hit the " + enemy.getName() + " for " + player.getDamage() + " damage!");
				if (enemy.isAlive())
				{
					enemy.attack(player);
					System.out.println(enemy.getName() + " has hit you for " + enemy.getDamage() + " damage!");
				}
				else
				{
					audioPlayer.startGameMusic();
					audioPlayer.stopBattleMusic();
					foundEnemy(false);
					player.obtainExp(enemy);
					player.checkExp();
				}
			}	
		}
	}
	/**
	 * This method returns the row index of the player
	 */
	private int getRow()
	{
		int playerRow = 0;
		for (int row = 0; row<maze.length; row++)
		{
		     for (int col = 0; col<maze[row].length; col++)
		     {
		    	 if (maze[row][col] == "x")
		    	 {
		    		 playerRow = row;
		    	 }
		     } 
		}
		return playerRow;
	}
	/**
	 * This method returns the column index of the player
	 */
	private int getCol()
	{
		int playerCol = 0;
		for (int row = 0; row<maze.length; row++)
		{
		     for (int col = 0; col<maze[row].length; col++)
		     {
		    	 if (maze[row][col] == "x")
		    	 {
		    		 playerCol = col;
		    	 }
		     } 
		}
		return playerCol;
	}
	/**
	 * This method moves the player on the grid
	 */
	public void move(String choice)
	{
		int playerRow = getRow();
		int playerCol = getCol();
		// remove player from current position
		maze[playerRow][playerCol] = "r";
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
			maze[playerRow][playerCol] = "x";
			audioPlayer.playMovementSFX();
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
			maze[playerRow][playerCol] = "x";	
		}
	}
	/**
	 * This method returns true if player is moving into an valid space
	 * @param playerRow The row index of player
	 * @param playerCol The column index of player
	 */
	private boolean moveValid(int playerRow, int playerCol)
	{
		return (!(maze[playerRow][playerCol] == "w")
			  &&!(maze[playerRow][playerCol] == "v")) ? true : false;
	}
	/**
	 * This method starts a battle when player encounters a challenge, 
	 * and picks up a item when player encounters a object
	 * @param maze The 2d array the player is traversing
	 * @param playerRow The row index of player
	 * @param playerCow The column index of player
	 */
	private void checkEvent(String maze[][],int playerRow, int playerCol)
	{
		if ((maze[playerRow][playerCol]).matches("[1-6]"))
		{
			audioPlayer.playPotionSFX();
			foundItem = true;
			itemID = Integer.parseInt(maze[playerRow][playerCol]);
		}
		else if ((maze[playerRow][playerCol]).matches("[a-e]"))
		{
			audioPlayer.stopGameMusic(); 
			audioPlayer.startBattleMusic();
			foundEnemy(true);
			enemy = new Spawner().spawnEnemy(convertLetterToID(maze[playerRow][playerCol]));
		}
		else if ((maze[playerRow][playerCol])== "n")
		{
			stageComplete = true;
		}
		else if ((maze[playerRow][playerCol])== "m")
		{
			gameWon = true;
		}
	}
	/**
	 * This method returns true if player reaches the end of the maze,
	 * false otherwise
	 */
	public boolean gameWon() 
	{
		return gameWon;
	}
	/**
	 * This method checks to see if a stage has been complete
	 * When a stage is complete it will load the next stage
	 */
	public void checkStageCompletion()
	{
		FileReader fileReader = new FileReader();
		if (selectedStage.equals("stage1.txt") && stageComplete)
		{
			maze = fileReader.readFile("stage2.txt");
			selectedStage = "stage2.txt";
			stageComplete = false;
		}
		else if (selectedStage.equals("stage2.txt") && stageComplete)
		{
			maze = fileReader.readFile("stage3.txt");
			selectedStage = "stage3.txt";
			stageComplete = false;
		}
	}
	/**
	 * This is the getter method for the grid, returns maze
	 */
	public String[][] getMaze()
	{
		return maze;
	}
	/**
	 * This method converts letter id to number id
	 */
	private int convertLetterToID(String letterID)
	{
		int id = 0;
		switch (letterID)
		{
		case "a":
			id = 1;
			break;
		case "b":
			id = 2;
			break;
		case "c":
			id = 3;
			break;
		case "d":
			id = 4;
			break;
		case "e":
			id = 5;
			break;
		}
		return id;
	}
	/**
	 * This method will load maze from saved game file
	 */
	public void loadMapData()
	{
		FileReader fileReader = new FileReader();
		maze = fileReader.readFile("SaveMap.txt");
		selectedStage = fileReader.readStageLevel("currentStage.txt");
	}
	/**
	 * This is the getter method for the foundEnemy variable, returns foundEnemy
	 */
	public boolean foundEnemy()
	{
		return foundEnemy;
	}
	/**
	 * This is the setter method for the foundEnemy variable
	 * @param truthValue The foundEnemy variable
	 */
	public void foundEnemy(boolean truthValue)
	{
		foundEnemy = truthValue;
	}
	/**
	 * This is the getter method for the foundItem variable, returns foundItem
	 */
	public boolean foundItem()
	{
		return foundItem;
	}
	/**
	 * This is the setter method for the foundItem variable
	 * @param truthValue The foundItem variable
	 */
	public void foundItem(boolean truthValue)
	{
		foundItem = truthValue;
	}
	/**
	 * This is the getter method for the itemID, returns itemID
	 */
	public int getitemID()
	{
		return itemID;
	}
	/**
	 * This is the getter method for the enemy, returns enemy
	 * There is a potential privacy leak here, but the reason for returning 
	 * the original reference is because the enemy should not be cloned because
	 * it would not be possible to defeat the enemy since the enemy's original 
	 * health would not be decreased by battle, instead the copy of it would
	 */
	public Enemy getEnemy()
	{
		return enemy;
	}
	/**
	 * This is the getter method for the audio player, returns audioPlayer
	 * There is a potential privacy leak here, but the reason for returning 
	 * the original reference is because the audio should only come from one 
	 * player, it does not make sense to have the same sounds playing at the 
	 * same time in multiple audio players
	 */
	public AudioPlayer getAudioPlayer()
	{
		return audioPlayer;
	}
	/**
	 * This is the getter method for the selected stage, returns selectedStage
	 */
	public String getSelectedStage()
	{
		return selectedStage;
	}
	/**
	 * This is the getter method for the stageComplete variable, returns stageComplete
	 */
	public Boolean getStageComplete()
	{
		return stageComplete;
	}
}