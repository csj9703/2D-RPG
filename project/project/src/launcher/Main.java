package launcher;

import game.Game;
/**
 * This class is the starting execution point of the game,
 * launches the GUI version of the game
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 2.1
 * @since October 26, 2017
 */
public class Main 
{
	 /*
     * This method starts the game 
     */
	public static void main(String[] args)
	{
		Game game = new Game();
		game.play();
	}
}