package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import gui.BattlePanel;
import gui.EndScenePanel;
import gui.GamePanel;
import gui.Gui;
import gui.InventoryPanel;
import gui.StartScenePanel;
import gui.TextPanel;
import gui.VictoryScenePanel;
/**
 * This class manages player input
 */
public class Game implements KeyListener
{	
	private Player player = new Spawner("player.txt").spawnPlayer();
	private Map game = new Map();
	private AudioPlayer audioPlayer = game.getAudioPlayer();

	private GamePanel gamePanel = new GamePanel();
	private JPanel gameInterface = gamePanel.createPanel(game);

	private BattlePanel battlePanel = new BattlePanel();
	private JPanel battleInterface = battlePanel.createPanel(player, game.getEnemy());

	private InventoryPanel inventoryPanel = new InventoryPanel();
	private JPanel inventoryInterface = inventoryPanel.createPanel(player);

	private StartScenePanel startScenePanel = new StartScenePanel();
	private JPanel startingScene = startScenePanel.createPanel();

	private EndScenePanel endScenePanel = new EndScenePanel();
	private JPanel endingScene = endScenePanel.createPanel();

	private VictoryScenePanel victoryScenePanel = new VictoryScenePanel();
	private JPanel victoryScene = victoryScenePanel.createPanel();	
	
	private TextPanel textPanel = new TextPanel();
	private JPanel textBox = textPanel.createPanel();
	
	private Gui gui = new Gui(this, gameInterface, battleInterface, inventoryInterface, 
									startingScene, endingScene, victoryScene, textBox);
	
	// flags used to keep track of which scene is being displayed
	private boolean inBattleScene = false;
	private boolean inventoryOpen = false;
	private boolean inStartScene = true;
	private boolean inGameScene = false;
	private boolean inEndScene = false;
	private boolean inVictoryScene = false;
	private boolean textBoxDisplayed = false;
	private boolean justDefeatedEnemy = false;
	/*
	 * This method displays the game
	 */
	private void startGame()
	{
		if (inStartScene)
    	{
			audioPlayer.stopMenuMusic();
			audioPlayer.startGameMusic();
    		startingScene.setVisible(false);
        	inStartScene = false;
        	gameInterface.setVisible(true);
        	inGameScene = true;
        	textBox.setVisible(true);
        	textBoxDisplayed = true;
    	}
	}
	/*
	 * This method opens and closes the inventory menu
	 */
	private void accessInventory()
	{
		if ((inGameScene) && (!(inStartScene)))
    	{
			audioPlayer.playInventorySFX();
    		gameInterface.setVisible(false);
    		inGameScene = false;
    		inventoryInterface.setVisible(true);
    		inventoryOpen = true;
    	}
    	else
    	{
    		gameInterface.setVisible(true);
    		inGameScene = true;
    		inventoryInterface.setVisible(false);
    		inventoryOpen = false;
    	}
	}
	/*
	 * This method initiates a turn of combat
	 */
	private void attack()
	{
		if (inBattleScene)
    	{
			audioPlayer.playAttackSFX();
    		player.attack(player, game.getEnemy());
    		// after player attacks:
    		if (game.getEnemy().isAlive())
    		{
    			battlePanel.showBattleResults();
    			game.getEnemy().attack(player, game.getEnemy());
    		}
    		else
    		{
    			battleInterface.setVisible(false);
    			inBattleScene = false;
    			gameInterface.setVisible(true);
    			inGameScene = true;
    			game.foundEnemy(false);
    			battlePanel.hideBattleResults();
    			textPanel.displayBattleResults(game.getEnemy());
    			justDefeatedEnemy = true;
    			player.obtainExp(game.getEnemy());
    			player.checkExp();
    			audioPlayer.stopBattleMusic();
    			audioPlayer.startGameMusic();
    		}
    	}
	}
	private void updateGUI()
	{
		 // switches panel when an enemy is found
        if (game.foundEnemy())
        {
        	battleInterface.setVisible(true);
        	inBattleScene = true;
        	gameInterface.setVisible(false);
        	inGameScene = false;
        }
        // displays a message when you find an item
        if ((game.foundItem()) && (!(justDefeatedEnemy)))
        {
        	audioPlayer.playPotionSFX();
        	textPanel.update(game.getitemID());
        	player.pickUp(game.getitemID());
        	game.foundItem(false);
        }
        else
        {
        	if (!(justDefeatedEnemy))
        		textPanel.reset();
        		justDefeatedEnemy = false;
        }
        // ends the game when player dies
        if (!(player.isAlive()))
        {
        	audioPlayer.stopBattleMusic();
        	audioPlayer.startDeathMusic();
        	gameInterface.setVisible(false);
        	inGameScene = false;
        	battleInterface.setVisible(false);
        	inBattleScene = false;
        	inventoryInterface.setVisible(false);
        	endingScene.setVisible(true);
        	inEndScene = true;
        }
        // switches to victory screen when game is complete
        if (game.gameWon())
        {
        	audioPlayer.stopGameMusic();
        	audioPlayer.startVictoryMusic();
        	gameInterface.setVisible(false);
        	inGameScene = false;
        	victoryScene.setVisible(true);
        	inVictoryScene = true;
        }
        // updates the user interface after each key press
        battlePanel.update(player, game.getEnemy());
        inventoryPanel.update(player);
        gamePanel.update(game);
        game.checkStageCompletion();        
	}
	/*
	 * This method manages the player input
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
    public void keyReleased(KeyEvent e) 
    {
    	// Movement buttons
        if(e.getKeyCode()== KeyEvent.VK_RIGHT)
        {
        	if (inGameScene)
        		game.move("d");
        }
        else if(e.getKeyCode()== KeyEvent.VK_LEFT) 
        {
        	if (inGameScene)
        		game.move("a");
        }
        else if(e.getKeyCode()== KeyEvent.VK_DOWN) 
        {
        	if (inGameScene)
        		game.move("s");
        }
        else if(e.getKeyCode()== KeyEvent.VK_UP) 
        {
        	if (inGameScene)
        		game.move("w");
        }
        // Inventory button
        else if(e.getKeyCode()== KeyEvent.VK_I) 
        {
        	accessInventory();
        }
        // Use item button
        else if(e.getKeyCode()== KeyEvent.VK_1) 
        {
        	if (inventoryOpen)
        		player.useItem(1);
        }
        // Use item button
        else if(e.getKeyCode()== KeyEvent.VK_2) 
        {
        	if (inventoryOpen)
        		player.useItem(2);
        }
        // Use item button
        else if(e.getKeyCode()== KeyEvent.VK_3) 
        {
        	if (inventoryOpen)
        		player.useItem(3);
        }
        // Start button
        else if(e.getKeyCode()== KeyEvent.VK_ENTER) 
        {
        	startGame();
        }
        // Attack button
        else if(e.getKeyCode()== KeyEvent.VK_A) 
        {
        	attack();
        }
        // Updates the GUI after each input command
        updateGUI();
    }
    /*
     * This method is not used but is required by the key listener 
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    public void keyPressed(KeyEvent e) {}
    /*
     * This method is not used but is required by the key listener 
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    public void keyTyped(KeyEvent e) {}
    /*
     * This method starts the game 
     */
    public void play()
    {
    	audioPlayer.startMenuMusic();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {public void run() {}});
    }
}