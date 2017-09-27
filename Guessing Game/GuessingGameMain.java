/**
 * This is a game where the user guesses at a number from 1 to 10
 * After each guess the results are printed to the console
 * The user will be notified whether their guess was correct, too high, too low, or not valid
 * The game continues to run until the user correctly guesses the number
 * Once the user enters the correct number, game is won and the program stops
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.1
 * @since September 27, 2017
 */

public class GuessingGameMain
{
	/**
	 * This is the main method that runs the GuessingGame class
	 * @param args Unused
	 */
	public static void main(String[] args)
	{
		GuessingGame game = new GuessingGame();
		game.play();
	}
}