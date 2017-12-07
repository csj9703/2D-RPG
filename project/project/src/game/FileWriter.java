package game;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.swing.JOptionPane;

/* 
 * This class is used to write game data to a text file
 */
public class FileWriter 
{
	private Map map;
	private Player player;
	/**
	 * This is the default constructor
	 */
	public FileWriter() {}
	/**
	 * This constructor initializes the writer to a bufferedWriter and gives it the fileName
	 * this will also catch the possible fileNotFoundException.
	 * @param player The player
	 * @param map The map
	 */
	public FileWriter(Player player, Map map)
	{
		this.map = new Map(map);
		this.player = new Player(player);
	}
	/**
	 * This method saves the game to text file
	 */
	public void save()
	{
		if (player.getHealth() > 0)
		{
			saveMapData();
			savePlayerData();
			saveMazeData();
		}
	}
	/**
	 * This method will write the maze array values to a 
	 * text file and save the location of the player
	 */
	private void saveMazeData() 
	{
		// concatenates the maze array values into a string separated by a single space
		String gameData = "";
		for(int i = 0; i < map.getMaze().length; i++)
		{
	        for(int j = 0; j < map.getMaze()[i].length; j++)
	        {
	        	gameData += map.getMaze()[i][j] + " ";
	        }
	        gameData += "\r\n";
	    }
		// writes the string data to a text file
		try 
		{
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("SaveMap.txt"), "utf-8"));
			writer.write(gameData);
			writer.close();
		}
		catch (IOException e)
		{
			displayErrorMessage();
		}
	}
	/**
	 * This method will write the current data to a text file
	 */
	private void savePlayerData() 
	{
		// determines what weapon the player has obtained thus far
		boolean hasExcalibur = player.getCurrentWeapon().equals("Blessed Excalibur");
		boolean hasIronLongsword = player.getCurrentWeapon().equals("Iron Longsword");
		boolean hasDagger = player.getCurrentWeapon().equals("Rusty Dagger");
		// removes the space from weapon name
		String weapon = player.getCurrentWeapon();
		weapon = weapon.replaceAll("\\s+", "");
		
		try 
		{
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("SaveGame.txt"), "utf-8"));
			writer.write(player.getNumSmallPotions() + " " 
						+ player.getNumMediumPotions() + " " 
						+ player.getNumLargePotions() + " "
						+ player.getCurrentLevel() + " "
						+ player.getCurrentExp()+ " "
						+ player.getExpToLvl() + " "
						+ player.getHealth() + " " 
						+ player.getAttack() + " " 
						+ weapon + " " 
						+ hasDagger + " " 
						+ hasIronLongsword + " " 
						+ hasExcalibur);
			writer.close();
		}
		catch (IOException e)
		{
			displayErrorMessage();
		}
	}
	/**
	 * This method will write the current stage the
	 * player is on to a text file
	 */
	private void saveMapData() 
	{
		try 
		{
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("currentStage.txt"), "utf-8"));
			writer.write(map.getSelectedStage());
			writer.close();
		}
		catch (IOException e) 
		{
			displayErrorMessage();
		}
	}
	/**
	 * This method contains back up data for the text files 
	 * and is used to repair game text files 
	 */
	public void reinstallGameFiles()
	{
		//hard coded maze data used for backup
		String[][] stage1txtBackUp = new String[][] {
		    {"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "v", "v", "v", "w", "w", "w", "w", "v", "v", "v", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "r", "r", "r", "w", "w", "w", "w", "r", "r", "1", "w", "w", "w", "w", "w", "w"},
			{"w", "v", "v", "v", "r", "w", "r", "w", "v", "v", "v", "r", "w", "r", "w", "v", "v", "v", "v", "v"},
			{"w", "x", "r", "r", "r", "w", "r", "w", "r", "r", "a", "r", "w", "r", "w", "r", "r", "r", "a", "n"},
			{"w", "w", "w", "w", "w", "w", "r", "v", "r", "w", "w", "w", "w", "r", "v", "r", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "4", "r", "r", "w", "w", "w", "w", "r", "r", "r", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"}};
		//hard coded maze data used for backup
		String[][] stage2txtBackUp = new String[][] {
		    {"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"},
			{"w", "v", "w", "v", "v", "v", "v", "v", "v", "v", "v", "v", "v", "w", "v", "v", "v", "w", "v", "w"},
			{"w", "r", "w", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "w", "r", "r", "r", "w", "x", "w"},
			{"w", "r", "v", "v", "v", "r", "r", "w", "r", "v", "v", "v", "r", "w", "r", "w", "r", "v", "r", "w"},
			{"w", "b", "r", "r", "r", "r", "w", "v", "r", "r", "r", "2", "v", "w", "r", "w", "r", "r", "r", "w"},
			{"w", "r", "v", "v", "w", "r", "w", "r", "r", "w", "r", "r", "r", "w", "2", "w", "v", "v", "r", "w"},
			{"w", "r", "r", "r", "v", "v", "v", "v", "r", "w", "v", "v", "r", "w", "r", "v", "r", "r", "r", "w"},
			{"w", "r", "w", "r", "r", "r", "r", "r", "r", "w", "r", "r", "r", "w", "r", "r", "r", "w", "r", "w"},
			{"w", "r", "v", "v", "v", "w", "r", "w", "r", "w", "r", "w", "v", "w", "v", "v", "r", "w", "v", "w"},
			{"w", "r", "r", "r", "r", "w", "r", "w", "r", "v", "r", "v", "r", "w", "r", "r", "r", "w", "5", "w"},
			{"w", "r", "w", "v", "r", "w", "r", "w", "r", "r", "b", "r", "r", "v", "r", "v", "v", "v", "r", "w"},
			{"w", "c", "w", "2", "r", "w", "r", "w", "r", "w", "r", "w", "r", "r", "r", "r", "r", "r", "r", "w"},
			{"w", "n", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"}};
		//hard coded maze data used for backup
		String[][] stage3txtBackUp = new String[][] {
		    {"w", "v", "v", "v", "v", "v", "w", "w", "v", "v", "v", "w", "v", "v", "w", "v", "v", "w", "m", "w"},
			{"w", "r", "r", "r", "r", "r", "v", "w", "r", "r", "r", "v", "r", "r", "w", "3", "r", "w", "e", "w"},
			{"w", "r", "v", "v", "w", "r", "6", "w", "r", "w", "r", "r", "r", "w", "v", "w", "r", "w", "r", "w"},
			{"w", "r", "r", "r", "v", "v", "v", "v", "r", "w", "v", "r", "v", "v", "r", "w", "r", "w", "r", "w"},
			{"w", "r", "w", "r", "r", "r", "r", "d", "r", "w", "r", "r", "r", "r", "r", "w", "r", "w", "r", "w"},
			{"w", "r", "v", "v", "v", "w", "r", "w", "r", "w", "v", "r", "v", "v", "v", "v", "r", "w", "r", "w"},
			{"w", "r", "r", "r", "r", "w", "r", "w", "r", "w", "r", "r", "r", "r", "r", "r", "r", "w", "r", "w"},
			{"w", "r", "w", "v", "r", "w", "r", "w", "r", "v", "v", "r", "v", "w", "r", "v", "v", "w", "r", "w"},
			{"w", "3", "w", "r", "r", "w", "r", "w", "r", "r", "r", "r", "r", "w", "d", "r", "r", "w", "r", "w"},
			{"w", "v", "w", "r", "w", "v", "v", "w", "v", "w", "v", "v", "v", "w", "r", "w", "r", "w", "r", "w"},
			{"w", "r", "v", "r", "v", "r", "r", "w", "r", "v", "r", "r", "r", "w", "r", "w", "r", "v", "r", "w"},
			{"w", "r", "r", "r", "r", "r", "w", "v", "r", "r", "r", "v", "v", "w", "r", "w", "r", "r", "r", "w"},
			{"w", "r", "v", "v", "w", "r", "w", "r", "r", "w", "r", "r", "r", "w", "3", "w", "v", "v", "r", "w"},
			{"w", "d", "r", "r", "v", "v", "v", "v", "r", "w", "v", "v", "r", "v", "v", "w", "r", "r", "r", "w"},
			{"w", "r", "w", "r", "r", "r", "r", "r", "r", "w", "r", "r", "r", "r", "r", "w", "r", "w", "r", "w"},
			{"w", "r", "v", "v", "v", "w", "r", "w", "r", "w", "r", "w", "w", "w", "v", "v", "r", "w", "v", "w"},
			{"w", "r", "r", "r", "r", "w", "r", "w", "r", "v", "r", "v", "r", "w", "r", "r", "r", "w", "3", "w"},
			{"w", "r", "w", "v", "r", "w", "r", "w", "r", "r", "d", "r", "r", "v", "r", "v", "v", "v", "r", "w"},
			{"w", "x", "w", "3", "r", "w", "r", "w", "r", "w", "r", "w", "r", "r", "r", "r", "r", "r", "r", "w"},
			{"w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"}};
		//hard coded enemy data used for backup
		String enemyData = "Zombie 10 1 1\r\n" + "Skeleton 15 2 1\r\n" + "Skeleking 15 3 2\r\n" 
				 + "Knight 15 2 1\r\n" + "Reaper 20 4 3";
		//hard coded item data used for backup
		String itemData = "Small Potion 3\r\n" + "Medium Potion 5\r\n" + "Large Potion 7\r\n" 
					    + "Rusty Dagger 1\r\n" + "Iron Longsword 2\r\n" + "Blessed Excalibur 3";
		
		String stage1Data = "";
		for(int i = 0; i < stage1txtBackUp.length; i++)
		{
	        for(int j = 0; j < stage1txtBackUp[i].length; j++)
	        {
	        	stage1Data += stage1txtBackUp[i][j] + " ";
	        }
	        stage1Data += "\r\n";
	    }
		String stage2Data = "";
		for(int i = 0; i < stage2txtBackUp.length; i++)
		{
	        for(int j = 0; j < stage2txtBackUp[i].length; j++)
	        {
	        	stage2Data += stage2txtBackUp[i][j] + " ";
	        }
	        stage2Data += "\r\n";
	    }
		String stage3Data = "";
		for(int i = 0; i < stage3txtBackUp.length; i++)
		{
	        for(int j = 0; j < stage3txtBackUp[i].length; j++)
	        {
	        	stage3Data += stage3txtBackUp[i][j] + " ";
	        }
	        stage3Data += "\r\n";
	    }
		// regenerates the missing text files	
		try 
		{
			Writer writer1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("stage1.txt"), "utf-8"));
			writer1.write(stage1Data);
			Writer writer2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("stage2.txt"), "utf-8"));
			writer2.write(stage2Data);
			Writer writer3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("stage3.txt"), "utf-8"));
			writer3.write(stage3Data);
			Writer writer4 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Enemies.txt"), "utf-8"));
			writer4.write(enemyData);
			Writer writer5 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Items.txt"), "utf-8"));
			writer5.write(itemData);
			writer1.close();
			writer2.close();
			writer3.close();
			writer4.close();
			writer5.close();
		}
		catch (IOException e)
		{
			displayErrorMessage();
		}
	}
	/**
	 * This method will display a pop up error message to alert 
	 * the user an error was encountered
	 */
	private void displayErrorMessage()
	{
		Object[] options = {"EXIT"};
		JOptionPane.showOptionDialog(null, "Reinstall Game", "CRITICAL ERROR",
		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
		null, options, options[0]);
	}
}