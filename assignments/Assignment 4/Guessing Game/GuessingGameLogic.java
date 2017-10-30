import java.util.Random;
import java.util.Scanner;

/**
 * Allows the user to play a guessing game: the computer guesses a number an the user gets
 * an infinite number of tries to guess it.
 * @author Nathaly Verwaal
 */
public class GuessingGameLogic {
	private int numToGuess;
	private int guessCounter = 1;
	private boolean numWasGuessed = false;
	/**
	 * Constructor chooses a random number between 1 and 10.
	 */
	public GuessingGameLogic() {
		numToGuess = new Random().nextInt(10) + 1;
	}
	/**
	 * Does the work required for a single guess.  It checks if the guess is valid (a number
	 * between 1 and 10) and if it is, if the guess is too high, too low or correct.
	 * @param guessAsString a guess in String format.
	 * @returns a message appropriate for the guess (invalid, too high, too low or correct)
	 */
	public String manageGuess(String guessAsString){
		String message = "\tGuess " + guessCounter + " is ";
		if (isValid(guessAsString)) {
			guessCounter++;
			int guess = Integer.parseInt(guessAsString);
			message += checkGuess(guess);
		} else {
			message = "\tThat is not a valid guess.  Make sure it is a number between 1 and 10.";
		}
		return message;
	}
	/**
	 * Checks if the guess provided contains only digits.
	 * @param guess the string to check.
	 * @returns true of the guess contains only digits.
	 */
	private boolean allDigits(String guess){
		boolean allDigits = true;
		for (int index = 0; index < guess.length(); index++) {
			if (!Character.isDigit(guess.charAt(index))) {
				allDigits = false;
			}
		}
		return allDigits;
	}
	/**
	 * Compares the guess with the number to guess for this instance of the game.
	 * @param guess the guess to compare with the number to guess
	 * @returns too low, too high or right!, depending on the value of the guess.
	 */
	private String checkGuess(int guess){
		String message = "";
		if (guess < numToGuess){
			message = "too low";
		} else if (guess > numToGuess) {
			message = "too high";
		} else {
			message = "right!";
			numWasGuessed = true;
		}
		return message;
	}
	/**
	 * Checks if the guess is valid (the string is a number between 1 and 10).
	 * @param guessAsString the guess to validate.
	 * @returns true if the guess is valid.
	 */
	private boolean isValid(String guessAsString){
		boolean validGuess = false;
		if (allDigits(guessAsString)){
			int guess = Integer.parseInt(guessAsString);
			if (guess >= 1 && guess <= 10){
				validGuess = true;
			}
		}
		return validGuess;
	}
// The next three methods are for the text based guessing game.
	/**
	 * Plays a console based version of the game.  The user is prompted for a guess
	 * until the user guessed the random number choosen for this game.
	 */
	public void play() {
		do {
			String message = manageGuess(getGuess());
			System.out.println(message);
		} while (!numWasGuessed);	
	}
	/**
	 * Prompts the user for a guess and returns it.
	 * @returns the guess entered by the user at the console.
	 */
	private String getGuess(){
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your guess: ");
		String guessAsString = keyboard.nextLine();
		return guessAsString;
	}
	
	public static void main(String[] args){
		GuessingGameLogic gg = new GuessingGameLogic();
		gg.play();
	}
}