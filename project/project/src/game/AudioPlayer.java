package game;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/*
 * This class manages the game music and sound effects
 */
public class AudioPlayer 
{
	Clip battle;
	Clip game;
	/*
	 * This method plays a wave audio file
	 * @param sound The sound file
	 */
	private void playSound(File sound)
	{
		try
		{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
		}
		catch(Exception e)
		{
			System.out.println("Error: sound file not found");
		}
	}
	/*
	 * This method plays a attacking sound effect
	 */
	public void playAttackSFX()
	{
		File attackSFX = new File("src/sounds/attackSFX.wav");
		playSound(attackSFX);
	}
	/*
	 * This method plays a attacking sound effect
	 */
	public void playPotionSFX()
	{
		File potionSFX = new File("src/sounds/potionSFX.wav");
		playSound(potionSFX);
	}
	/*
	 * This method plays the battle music
	 */
	public void playBattleMusic()
	{
		File battleMusic = new File("src/sounds/battleMusic.wav");
		playSound(battleMusic);
	}
	/*
	 * This method plays the drink potion sound effect
	 */
	public void playDrinkPotionSFX()
	{
		File drinkPotionSFX = new File("src/sounds/drinkPotionSFX.wav");
		playSound(drinkPotionSFX);
	}
	/*
	 * This method plays the inventory sound effect
	 */
	public void playInventorySFX()
	{
		File inventorySFX = new File("src/sounds/inventorySFX.wav");
		playSound(inventorySFX);
	}
	/*
	 * This method plays the movement sound effect
	 */
	public void playMovementSFX()
	{
		File moveSFX = new File("src/sounds/moveSFX.wav");
		playSound(moveSFX);
	}
	/*
	 * This method plays the battle music
	 */
	public void startBattleMusic()
	{
		File battleMusic = new File("src/sounds/battleMusic.wav");
		try
		{
			battle = AudioSystem.getClip();
			battle.open(AudioSystem.getAudioInputStream(battleMusic));
		}
		catch(Exception e)
		{
			System.out.println("Error: sound file not found");
		}
		battle.start();
	}
	/*
	 * This method stops the battle music
	 */
	public void stopBattleMusic()
	{
		battle.close();
	}
	/*
	 * This method plays the game music
	 */
	public void startGameMusic()
	{
		File gameMusic = new File("src/sounds/gameMusic.wav");
		try
		{
			game = AudioSystem.getClip();
			game.open(AudioSystem.getAudioInputStream(gameMusic));
		}
		catch(Exception e)
		{
			System.out.println("Error: sound file not found");
		}
		game.start();
	}
	/*
	 * This method stops the game music
	 */
	public void stopGameMusic()
	{
		game.close();
	}
}