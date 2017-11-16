package game;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/*
 * This class manages the game music and sound effects
 */
public class AudioPlayer 
{
	Clip menu;
	Clip battle;
	Clip game;
	Clip death;
	Clip victory;
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
	/**
	 * This method plays the death music
	 */
	public void startDeathMusic() 
	{
		File deathMusic = new File("src/sounds/deathMusic.wav");
		try
		{
			death = AudioSystem.getClip();
			death.open(AudioSystem.getAudioInputStream(deathMusic));
		}
		catch(Exception e)
		{
			System.out.println("Error: sound file not found");
		}
		death.start();
	}
	/**
	 * This method stops the death music
	 */
	public void stopDeathMusic()
	{
		death.close();
	}
	/**
	 * This method plays the victory music
	 */
	public void startVictoryMusic()
	{
		File victoryMusic = new File("src/sounds/victoryMusic.wav");
		try
		{
			victory = AudioSystem.getClip();
			victory.open(AudioSystem.getAudioInputStream(victoryMusic));
		}
		catch(Exception e)
		{
			System.out.println("Error: sound file not found");
		}
		victory.start();
	}
	/**
	 * This method stops the victory music
	 */
	public void stopVictoryMusic()
	{
		victory.close();
	}
	/**
	 * This method plays the menu music
	 */
	public void startMenuMusic()
	{
		File menuMusic = new File("src/sounds/menuMusic.wav");
		try
		{
			menu = AudioSystem.getClip();
			menu.open(AudioSystem.getAudioInputStream(menuMusic));
		}
		catch(Exception e)
		{
			System.out.println("Error: sound file not found");
		}
		menu.start();
	}
	/**
	 * This method stops the menu music
	 */
	public void stopMenuMusic()
	{
		menu.close();
	}
}