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
	// game gui 
	private GamePanel gamePanel = new GamePanel();
	private JPanel gameInterface = gamePanel.createPanel(game);
	// battle gui
	private BattlePanel battlePanel = new BattlePanel();
	private JPanel battleInterface = battlePanel.createPanel(player, game.getEnemy());
	// inventory gui
	private InventoryPanel inventoryPanel = new InventoryPanel();
	private JPanel inventoryInterface = inventoryPanel.createPanel(player);
	// starting gui
	private StartScenePanel startScenePanel = new StartScenePanel();
	private JPanel startingScene = startScenePanel.createPanel();
	// ending gui
	private EndScenePanel endScenePanel = new EndScenePanel();
	private JPanel endingScene = endScenePanel.createPanel();
	// victory gui
	private VictoryScenePanel victoryScenePanel = new VictoryScenePanel();
	private JPanel victoryScene = victoryScenePanel.createPanel();	
	
	private Gui gui = new Gui(this, gameInterface, battleInterface, inventoryInterface, startingScene, endingScene, victoryScene);
	
	// flags used to keep track of which gui is being displayed
	boolean inBattle = false;
	boolean inventoryOpen = false;
	/*
	 * This method manages the player input
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
    public void keyReleased(KeyEvent e) 
    {
    	// Movement buttons
        if(e.getKeyCode()== KeyEvent.VK_RIGHT)
        {
        	if ((!(inventoryOpen)) && (!(inBattle)))
        		game.move("d");
        }
        else if(e.getKeyCode()== KeyEvent.VK_LEFT) 
        {
        	if ((!(inventoryOpen)) && (!(inBattle)))
        		game.move("a");
        }
        else if(e.getKeyCode()== KeyEvent.VK_DOWN) 
        {
        	if ((!(inventoryOpen)) && (!(inBattle)))
        		game.move("s");
        }
        else if(e.getKeyCode()== KeyEvent.VK_UP) 
        {
        	if ((!(inventoryOpen)) && (!(inBattle)))
        		game.move("w");
        }
        // Inventory button
        else if(e.getKeyCode()== KeyEvent.VK_I) 
        {
        	if ((!(inventoryOpen)) && (!(inBattle)))
        	{
        		gameInterface.setVisible(false);
        		inventoryInterface.setVisible(true);
        		inventoryOpen = true;
        	}
        	else
        	{
        		gameInterface.setVisible(true);
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
        	startingScene.setVisible(false);
        	gameInterface.setVisible(true);
        }
        // Attack button
        else if(e.getKeyCode()== KeyEvent.VK_A) 
        {
        	if (inBattle)
        	{
        		battle.playerAttack(player, game.getEnemy());
        		// after player attacks:
        		if (battle.enemyIsAlive(game.getEnemy()))
        		{
        			battle.enemyAttack(player, game.getEnemy());
        		}
        		else
        		{
        			battleInterface.setVisible(false);
        			gameInterface.setVisible(true);
        			game.foundEnemy(false);
        			inBattle = false;
        		}
        	}
        }
        // switches panel when an enemy is found
        if (game.foundEnemy())
        {
        	battleInterface.setVisible(true);
        	gameInterface.setVisible(false);
        	inBattle = true;
        }
        // displays a pop up message when you find an item
        if (game.foundItem())
        {
        	player.pickUp("Potion");
        	game.foundItem(false);
        	JOptionPane.showMessageDialog(null, "You found a Potion!");
        }
        // ends the game when player dies
        if (!(player.isAlive()))
        {
        	gameInterface.setVisible(false);
        	battleInterface.setVisible(false);
        	inventoryInterface.setVisible(false);
        	endingScene.setVisible(true);
        }
        // switches to victory screen when game is complete
        if (game.gameWon())
        {
        	gameInterface.setVisible(false);
        	victoryScene.setVisible(true);
        }
        // updates the user interface after each key press
        battlePanel.update(player, game.getEnemy());
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