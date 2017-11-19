package game;

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
		// something wrong here, need to fix, not sure why the second loop is needed
		for(int r = 0; r < ROWS; r++) 
		{
			for(int c = 0; c < COLS; c++) 
			{
				String letter = maze[r][c];

				switch(letter)
				{
				case "w":
					maze[r][c] = "w";
					break;
				case "v":
					maze[r][c] = "v";
					break;
				case "r":
					maze[r][c] = "r";
					break;
				case "x":
					maze[r][c] = "x";
					break;
				case "1":
					maze[r][c] = "1";
					break;
				case "2":
					maze[r][c] = "2";
					break;
				case "3":
					maze[r][c] = "3";
					break;
				case "4":
					maze[r][c] = "4";
					break;
				case "5":
					maze[r][c] = "5";
					break;
				case "6":
					maze[r][c] = "6";
					break;
				case "a":
					maze[r][c] = "a";
					break;
				case "b":
					maze[r][c] = "b";
					break;
				case "c":
					maze[r][c] = "c";
					break;
				case "d":
					maze[r][c] = "d";
					break;
				case "e":
					maze[r][c] = "e";
					break;
				case "n":
					maze[r][c] = "n";
					break;
				case "m":
					maze[r][c] = "m";
					break;
				}
			}
		}
		return maze;
	}
}