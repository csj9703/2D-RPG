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
	private Writer writer;
	private Writer writer2;
	private Writer writer3;
	private String maze[][];
	private Map map;
	private Player player;
	private String stage = "";
	
	/**
	 * This constructor initializes the writer to a bufferedWriter and gives it the fileName
	 * this will also catch the possible fileNotFoundException.
	 * @param maze2 the 2d array maze
	 * @param player2 the instance of the player, containing all relevant info
	 */
	public FileWriter(String maze2[][], Player player2, Map map2)
	{
		maze=maze2;
		player=player2;
		map = map2;
	
	try 
	{
	writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("SaveGame.txt"), "utf-8"));
	writer2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("SaveMap.txt"), "utf-8"));
	writer3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("currentStage.txt"), "utf-8"));
	}
	catch (Exception e) {}
	}
	
	/** This is the save class, this class will actually save to file,
	 * it organizes all the relevant info and goes through the 2d array
	 * turning it into a 1D string with newline characters. It writes all
	 * info to file, and then closes the writer.
	 * 
	 */
	public void save()
	{
		boolean hasDagger = false;
		boolean hasIronLongsword = false;
		boolean hasExcalibur = false;
		String maze2="";
		for(int i = 0; i < maze.length; i++)
		{
	        for(int j = 0; j < maze[i].length; j++)
	        {
	        	maze2=maze2+maze[i][j]+" ";
	        }
	        maze2 = maze2 + "\r\n";
	    }
		
		if (player.getCurrentWeapon().equals("Excalibur"))
		{
			hasExcalibur = true;
		}
		else if (player.getCurrentWeapon().equals("Iron Longsword"))
		{
			hasIronLongsword = true;
		}
		else if (player.getCurrentWeapon().equals("Rusty Dagger"))
		{
			hasDagger = true;
		}

		String weapon = player.getCurrentWeapon();
		weapon = weapon.replaceAll("\\s+","");
		
		if (map.currentStage() == 1)
		{
			stage = "stage1.txt";
		}
		else if (map.currentStage() == 2)
		{
			stage = "stage2.txt";
		}
		else if (map.currentStage() == 3)
		{
			stage = "stage3.txt";
		}
		
		try 
		{
			writer.write
			
			(player.getNumSmallPotions()+" "+player.getNumMediumPotions()+" "+player.getNumLargePotions()+
			 " "+player.getCurrentLevel()+ " "+player.getCurrentExp()+" "+player.getExpToLvl()+
		     " "+player.getHealth()+" "+player.getAttack()+" "+weapon+
		     " "+hasDagger+" "+hasIronLongsword+" "+hasExcalibur);
			writer2.write(maze2);
			writer3.write(stage);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("ERROR: Could not write file");
		}
		finally 
		{
			try 
			{
				writer.close();
				writer2.close();
				writer3.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				System.out.println("ERROR: Could not write file");
			}
		}
	}
}