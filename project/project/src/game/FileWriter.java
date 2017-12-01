package game;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/* 
 * This class is used to write game data to a text file
 */
public class FileWriter 
{
	private Map map;
	private Player player;
	/*
	 * This constructor initializes the writer to a bufferedWriter and gives it the fileName
	 * this will also catch the possible fileNotFoundException.
	 * @param player The player
	 * @param map The map
	 */
	public FileWriter(Player player, Map map)
	{
		this.map = new Map(map);
		this.player = player;
	}
	/*
	 * This method saves the game to text file
	 */
	public void save()
	{
		saveMapData();
		savePlayerData();
		saveMazeData();
	}
	/*
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
			Writer writer2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("SaveMap.txt"), "utf-8"));
			writer2.write(gameData);
			writer2.close();
		}
		catch (IOException e)
		{
			System.out.println("ERROR: Could not write file");
		}
	}
	/*
	 * This method will write the player statistics to a 
	 * text file
	 */
	private void savePlayerData() 
	{
		// determines what weapon the player has obtained thus far
		boolean hasExcalibur = player.getCurrentWeapon().equals("Excalibur");
		boolean hasIronLongsword = player.getCurrentWeapon().equals("Iron Longsword");
		boolean hasDagger = player.getCurrentWeapon().equals("Rusty Dagger");
		// removes the space from weapon name
		String weapon = player.getCurrentWeapon();
		weapon = weapon.replaceAll("\\s+", "");
		
		try 
		{
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("SaveGame.txt"), "utf-8"));
			writer.write(player.getNumSmallPotions()+ " " + player.getNumMediumPotions() + " " + player.getNumLargePotions()
			+ " "+ player.getCurrentLevel() + " "+player.getCurrentExp()+" "+player.getExpToLvl() + " "+ player.getHealth() 
			+ " " + player.getAttack() + " " + weapon + " " + hasDagger + " " + hasIronLongsword + " " + hasExcalibur);
			writer.close();
		}
		catch (IOException e)
		{
			System.out.println("ERROR: Could not write file");
		}
	}
	/*
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
			System.out.println("ERROR: Could not write file");
		}
	}
}