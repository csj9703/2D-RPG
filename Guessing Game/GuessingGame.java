/*
 * A guessing game where the user guesses at a number from 1 to 10.
 * Game is won when the user correctly guesses the number.
 */

import java.util.Random;
import java.util.Scanner;

public class GuessingGame 
{
	// generates and returns a random number from 1 to 10
	public static int randomNum()
	{
		int number = new Random().nextInt(10)+1;
		return number;
	}
	
	// returns true if all digits, false otherwise
	public static boolean allDigits(String aString) 
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
	
	// returns true if guess is between 1 and 10, false otherwise
	public static boolean guessValid(int guess)
	{
		return (guess >= 1 && guess <= 10);	
	}
	
	// displays guess results
	public static void compareGuessToAnswer(int guess, int numberToGuess)
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
	
	// returns true if guess is correct, false otherwise
	public static boolean guessCorrect(int guess, int numberToGuess)
	{
		return (guess == numberToGuess);	
	}
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String guessAsString;
		int guess = 0;
		int numberToGuess = randomNum();
		
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