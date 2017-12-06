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
/*
 * This class manages player input
 */
public class Game implements KeyListener
{	
	private Player player = new Spawner().spawnPlayer();
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
	// flags used to keep track of which scene is being displayed
	private boolean inBattleScene = false;
	private boolean inventoryOpen = false;
	private boolean inStartScene = true;
	private boolean inGameScene = false;
	private boolean justDefeatedEnemy = false;
	/**
	 * This constructor will create the GUI that contains a shut down 
	 * hook that will save the game on exit
	 */
	public Game()
	{
		new Gui(this, gameInterface, battleInterface, inventoryInterface, startingScene, endingScene, victoryScene, textBox);
		Runtime.getRuntime().addShutdownHook(onExit());
	}
	/**
	 * This method creates and returns a thread that is executed
	 * when the program is closed allowing the player to save
	 * his game progress to a text file on exit
	 */
	private Thread onExit()
	{
		return new Thread() {public void run() {new FileWriter(new Player(player),new Map(game)).save();}};
	}
	/**
	 * This method is used to display the game, it will hide
	 * the starting menu and show the in game display
	 */
	private void startGame()
	{
		if (inStartScene)
    	{
    		startingScene.setVisible(false);
        	inStartScene = false;
        	gameInterface.setVisible(true);
        	inGameScene = true;
        	textBox.setVisible(true);
    	}
	}
	/**
	 * This method is used to open or close the inventory menu
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
	/**
	 * This method initiates a turn of combat
	 * The original reference is used for battle between
	 * the player and enemy because you cannot defeat a enemy 
	 * if a new copy of it is made each attack, i.e. health
	 * will not decrease
	 */
	private void attack()
	{
		if (inBattleScene)
    	{
			audioPlayer.playAttackSFX();
    		player.attack(game.getEnemy());
    		// after player attacks:
    		if (game.getEnemy().isAlive())
    		{
    			battlePanel.showBattleResults();
    			game.getEnemy().attack(player);
    		}
    		else
    		{
    			battleInterface.setVisible(false);
    			inBattleScene = false;
    			gameInterface.setVisible(true);
    			inGameScene = true;
    			game.foundEnemy(false);
    			battlePanel.hideBattleResults();
    			textPanel.displayBattleResults(new Enemy(game.getEnemy()));
    			justDefeatedEnemy = true;
    			player.obtainExp(new Enemy(game.getEnemy()));
    			player.checkExp();
    			audioPlayer.stopBattleMusic();
    			audioPlayer.startGameMusic();
    		}
    	}
	}
	/**
	 * This method updates the gui when an enemy is found
	 */
	private void checkForBattle()
	{
		if (game.foundEnemy())
		{
			battleInterface.setVisible(true);
			inBattleScene = true;
			gameInterface.setVisible(false);
			inGameScene = false;
		}
	}
	/**
	 * This method updates the gui when an item is found
	 */
	private void checkForItem()
	{
		if ((game.foundItem()) && (!(justDefeatedEnemy)))
		{
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
	}
	/**
	 * This method checks to see if player has been defeated
	 */
	private void checkPlayerHealth()
	{
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
        }
	}
	/**
	 * This method checks to see if winning condition is met
	 */
	private void checkWinCondition()
	{
		if (game.gameWon())
        {
        	audioPlayer.stopGameMusic();
        	audioPlayer.startVictoryMusic();
        	gameInterface.setVisible(false);
        	inGameScene = false;
        	victoryScene.setVisible(true);
        }
	}
	/**
	 * This method updates the user interface after each key press
	 */
	private void updateGUI()
	{
		checkForBattle();
		checkForItem();
		checkPlayerHealth();
		checkWinCondition();
        battlePanel.update(new Player(player), new Enemy(game.getEnemy()));
        inventoryPanel.update(new Player(player));
        gamePanel.update(new Map(game));
        game.checkStageCompletion();
	}
	/**
	 * This method loads the saved game data 
	 */
	private void loadGame()
	{
		player.loadPlayerData();
		game.loadMapData();
	}
	/**
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
        // Load game button
        else if(e.getKeyCode()== KeyEvent.VK_L) 
        {
        	if (inStartScene)
        		loadGame();
        }
        // Updates the GUI after each input command
        updateGUI();
    }
	/**
     * This method is not used but is required by the key listener 
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    public void keyPressed(KeyEvent e) {}
	/**
     * This method is not used but is required by the key listener 
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    public void keyTyped(KeyEvent e) {}
	/**
     * This method starts the game 
     */
    public void play()
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {public void run() {}});
    }
}