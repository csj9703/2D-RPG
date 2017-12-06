package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
/*
 * This class is used to read text files 
 * 
 * Text file character mapping		
 * w : wall		      a : zombie       1 : small potion         
 * v : wall2		  b : skeleton     2 : medium potion
 * r : road           c : skeleking    3 : large potion
 * n : check point    d : knight       4 : rusty dagger
 * m : end of maze    e : reaper	   5 : iron longsword
 * x : player			               6 : blessed excalibur
 */
public class FileReader 
{
	/**
	 * This method reads a stage file into a 2d array,
	 * if the text file is not found, a backup will be
	 * generated
	 * @return maze The 2d array
	 */
	public String[][] readFile(String fileName) 
	{
		String name = fileName;
		File file = new File(fileName);
		Scanner scanner = null;
		final int ROWS = 20;
		final int COLS = 20;
		String maze[][] = new String[ROWS][COLS];
		try 
		{
			scanner = new Scanner(file);
			// loops through text file and stores each letter
			// separated by a space into a array index
			for(int r = 0; r < ROWS; r++) 
			{
				for(int c = 0; c < COLS; c++) 
				{
					maze[r][c] = scanner.next();
				}
			}
			// translates each character code to a letter
			for(int r = 0; r < ROWS; r++) 
			{
				for(int c = 0; c < COLS; c++) 
				{
					String letter = maze[r][c];
					// converts to string
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
			scanner.close();
		} 
		catch (FileNotFoundException|NoSuchElementException|ArrayIndexOutOfBoundsException e) 
		{
			FileWriter gameRepair = new FileWriter();
			gameRepair.reinstallGameFiles();
			return readFile(name);
		}
		return maze;
	}
	/**
	 * This methods reads the saved stage level
	 * @param fileName The name of the text file
	 */
	public String readStageLevel(String fileName) 
	{
		File file = new File(fileName);
		Scanner scanner = null;
		String defaultStage = "stage1.txt";
		String selectedStage = "";
		try 
		{
			scanner = new Scanner(file);
			selectedStage = scanner.next();
		} 
		catch (FileNotFoundException e) 
		{
			selectedStage = defaultStage;
		}
		return selectedStage;
	}
}