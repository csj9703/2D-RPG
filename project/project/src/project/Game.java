package project;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * This class manages player input
 */
public class Game implements KeyListener
{	
	private Player player = new Player();
	private Battle battle = new Battle();
	private Map game = new Map();

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
	boolean inBattleScene = false;
	boolean inventoryOpen = false;
	boolean inStartScene = true;
	boolean inGameScene = false;
	boolean inEndScene = false;
	boolean inVictoryScene = false;
	boolean textBoxDisplayed = false;
	boolean justDefeatedEnemy = false;
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
        	if ((inGameScene) && (!(inStartScene)))
        	{
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
        // Use item button
        else if(e.getKeyCode()== KeyEvent.VK_U) 
        {
        	if (inventoryOpen)
        		player.useItem();
        }
        // Start button
        else if(e.getKeyCode()== KeyEvent.VK_ENTER) 
        {
        	if (inStartScene)
        	{
        		startingScene.setVisible(false);
            	inStartScene = false;
            	gameInterface.setVisible(true);
            	inGameScene = true;
            	textBox.setVisible(true);
            	textBoxDisplayed = true;
        	}
        }
        // Attack button
        else if(e.getKeyCode()== KeyEvent.VK_A) 
        {
        	if (inBattleScene)
        	{
        		battle.playerAttack(player, game.getEnemy());
        		// after player attacks:
        		if (battle.enemyIsAlive(game.getEnemy()))
        		{
        			battlePanel.showBattleResults();
        			battle.enemyAttack(player, game.getEnemy());
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
        		}
        	}
        }
        // switches panel when an enemy is found
        if (game.foundEnemy())
        {
        	battleInterface.setVisible(true);
        	inBattleScene = true;
        	gameInterface.setVisible(false);
        	inGameScene = false;
        }
        // displays a pop up message when you find an item
        if ((game.foundItem()) && (!(justDefeatedEnemy)))
        {
        	textPanel.update();
        	player.pickUp("Potion");
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
        	gameInterface.setVisible(false);
        	inGameScene = false;
        	victoryScene.setVisible(true);
        	inVictoryScene = true;
        }
        // updates the user interface after each key press
        battlePanel.update(player, game.getEnemy(), battle);
        inventoryPanel.update(player);
        gamePanel.update(game);
        game.checkStageCompletion();        
    }
    // DO NOT USE THESE METHODS
    public void keyPressed(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    /*
     * This method starts the game 
     */
    public void play()
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {public void run() {}});
    }
}