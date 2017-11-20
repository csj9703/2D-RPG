package launcher;

import java.util.Scanner;
import game.TextGame;
/**
 * This class is the starting execution point of the game,
 * launches the text version of the game
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 3.0
 * @since November 20, 2017
 */
public class TextMain 
{
	/*
     * This method starts the game 
     */
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		TextGame textGame = new TextGame();
		textGame.play(keyboard);
		keyboard.close();
	}
}