/**
 * This class contains the methods for a guessing game
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.2
 * @since September 28, 2017
 */

import java.util.Scanner;
import java.util.Random;

public class GuessingGame
{
	/**
	 * This method generates and returns a random integer from 1 to 10
	 */
	public int randomNum()
	{
		int number = new Random().nextInt(10)+1;
		return number;
	}
	/**
	 * This method checks the inputed string and determines whether it contains only digits
	 * Returns true when string contains all digits, false otherwise
	 * @param aString This is the string being checked
	 */
	public boolean allDigits(String aString) 
	{
		boolean noDigits = true;
		for (int index = 0; index < aString.length(); index++)
		{
			char aChar = aString.charAt(index);
			if (!Character.isDigit(aChar))
				noDigits = false;
		}
		return noDigits;
	}
	/**
	 * This method checks if the guess is in range 
	 * Returns true if guess is between 1 and 10, false otherwise
	 * @param guess This is the integer being checked
	 */
	public boolean guessValid(int guess)
	{
		return (guess >= 1 && guess <= 10);	
	}
	/**
	 * This method compares the guess to the answer and displays results
	 * @param guess This is the user's guess
	 * @param numberToGuess This is the answer
	 */
	public void compareGuessToAnswer(int guess, int numberToGuess)
	{
		if (guess < numberToGuess) 
		{
			System.out.println("Too low\n");
		} 
		else if (guess > numberToGuess) 
		{
			System.out.println("Too high\n");
		} 
		else 
		{
			System.out.println("You guessed it.\n");
		}
	}
	/**
	 * This method determines if the user's guess is correct
	 * Returns true when guess is correct, false otherwise
	 * @param guess This is the user's guess
	 * @param numberToGuess This is the answer
	 */
	public boolean guessCorrect(int guess, int numberToGuess)
	{
		return (guess == numberToGuess);	
	}
	/**
	 * This is the main method that starts and plays the game
	 */
	public void play()
	{
		Scanner keyboard = new Scanner(System.in);
		String guessAsString;
		int guess = 0;
		int numberToGuess = randomNum();
		System.out.println("Number to guess is: " + numberToGuess);
		
		do 
		{
			System.out.print("Enter your guess(1 to 10): ");
			guessAsString = keyboard.next();
			if (allDigits(guessAsString))
			{
				guess = Integer.parseInt(guessAsString);
				if (guessValid(guess))
				{
					compareGuessToAnswer(guess, numberToGuess);	
				}
				else
				{
					System.out.println("Not valid\n");
				}
			}
			else
			{
				System.out.println("Not valid\n");
			}
		}
		while (!guessCorrect(guess, numberToGuess));
		keyboard.close();
	}
}