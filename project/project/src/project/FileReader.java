package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * This class is used to read text files into an array
 */
public class FileReader 
{
	/*
	 * This method reads a text file into a 2d array
	 * @return maze The 2d array
	 */
	public String[][] readFile(String fileName) 
	{
		File file = new File(fileName);
		Scanner scanner = null;
		try 
		{
			scanner = new Scanner(file);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error: " + fileName + " not found");
		}
		final int ROWS = 20;
		final int COLS = 20;
		String maze[][] = new String[ROWS][COLS];
		for(int r = 0; r < ROWS; r++) 
		{
			for(int c = 0; c < COLS; c++) 
			{
				maze[r][c] = scanner.next();
			}
		}
		return maze;
	}
	/*
	 * This method translates the letters from the array into map symbols
	 * @param maze The 2d array 
	 * @return maze The 2d array
	 */
	public String[][] translateData(String[][] maze)
	{
		final int ROWS = maze.length;
		final int COLS = maze[0].length;
		for(int r = 0; r < ROWS; r++) 
		{
			for(int c= 0; c < COLS; c++) 
			{
				String letter = maze[r][c];
				
				switch(letter)
				{
				case "x":
					maze[r][c] = "#";
					break;
				case "y":
					maze[r][c] = " ";
					break;
				case "z":
					maze[r][c] = "X";
					break;
				case "i":
					maze[r][c] = "?";
					break;
				case "e":
					maze[r][c] = "E";
					break;
				}
			}
		}
		return maze;
	}
}