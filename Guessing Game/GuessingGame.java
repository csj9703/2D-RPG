/**
 * This class contains the methods for a guessing game
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.0
 * @since September 25, 2017
 */

import java.util.Random;

public class GuessingGame
{
	/**
	 * This method generates a random integer from 1 to 10
	 * @return returns an integer
	 */
	public int randomNum()
	{
		int number = new Random().nextInt(10)+1;
		return number;
	}
	/**
	 * This method checks the inputed string and determines
	 * whether it contains only digits
	 * @param aString This is the string being checked
	 * @return returns true when string contains all digits, false otherwise
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
	 * @param guess This is the integer being checked
	 * @return returns true if guess is between 1 and 10, false otherwise
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
	 * @param guess This is the user's guess
	 * @param numberToGuess This is the answer
	 * @return returns true when guess is correct, false otherwise
	 */
	public boolean guessCorrect(int guess, int numberToGuess)
	{
		return (guess == numberToGuess);	
	}
}