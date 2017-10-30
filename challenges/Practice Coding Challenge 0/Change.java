/*
 *  Practice Coding Challenge 0
 */

import java.util.Scanner;

public class Change 
{
	// This method returns the number of toonies in change
	public static int getNumOfToonies(int changeNeeded)
	{
		return changeNeeded / 200;
	}
	
	// This method returns the number of loonies in change
	public static int getNumOfLoonies(int changeNeeded)
	{
		return (changeNeeded % 200) / 100;
	}
	
	// This method returns the number of quarters in change
	public static int getNumOfQuarters(int changeNeeded) 
	{
		return ((changeNeeded % 200) % 100) / 25;
	}
	
	// This method returns the number of dimes in change
	public static int getNumOfDimes(int changeNeeded)
	{
		return (((changeNeeded % 200) % 100) % 25) / 10;
	}
	
	// This method returns the number of nickels in change
	public static int getNumOfNickels(int changeNeeded)
	{
		return ((((changeNeeded % 200) % 100) % 25) % 10) / 5;
	}
	
	// This method returns the number of pennies in change
	public static int getNumOfPennies(int changeNeeded)
	{
		return (((((changeNeeded % 200) % 100) % 25) % 10) % 5);		
	}
}
