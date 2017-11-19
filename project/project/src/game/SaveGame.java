package game;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/* This class writes to a file called SaveGame.txt which
 * hold all the necessary information of the character and the maze.
 */
public class SaveGame 
{
	private Writer writer = null;
	private String maze[][];
	private Player player;
	
	/**
	 * This constructor initializes the writer to a bufferedWriter and gives it the fileName
	 * this will also catch the possible fileNotFoundException.
	 * @param maze2 the 2d array maze
	 * @param player2 the instance of the player, containing all relevant info
	 */
	public SaveGame(String maze2[][], Player player2)
	{
		maze=maze2;
		player=player2;
	
	try 
	{
	writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("SaveGame.txt"), "utf-8"));
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
		String maze2="";
		for(int i = 0; i < maze.length; i++){
	        for(int j = 0; j < maze[i].length; j++)
	        {
	        maze2=maze2+maze[i][j];
	        }
	        maze2=maze2+"\r\n";
	        }
		try {
		writer.write
		(maze2+"\r\n"+player.getName()+" Level: "+player.getCurrentLevel()+" Experience: "+player.getCurrentExp()+
		" ExpToLevel: "+player.getExpToLvl()+" Health: "+player.getHealth()+"\r\n"+player.getCurrentWeapon()+
		" SmallPot: "+player.getNumSmallPotions()+" Mediumpot: "+player.getNumMediumPotions()+
		" LargePot: "+player.getNumLargePotions());
		}
		catch (IOException e)
		{
		}
		finally 
		{
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}