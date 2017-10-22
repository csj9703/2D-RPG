package project;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * This is the main manager class for the game.
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 2.0
 * @since October 22, 2017
 */
public class Main extends JFrame implements KeyListener
{
	static Player player = new Player();
	static Battle battle = new Battle();
	static Map game = new Map();
	// game gui 
	static GamePanel gamePanel = new GamePanel();
	static JPanel gameInterface = gamePanel.createPanel(game);
	// battle gui
	static BattlePanel battlePanel = new BattlePanel();
	static JPanel battleInterface = battlePanel.createPanel(player, game.getEnemy());
	// inventory gui
	static InventoryPanel inventoryPanel = new InventoryPanel();
	static JPanel inventoryInterface = inventoryPanel.createPanel(player);
	// starting gui
	static StartScenePanel startScenePanel = new StartScenePanel();
	static JPanel startingScene = startScenePanel.createPanel();
	// ending gui
	static EndScenePanel endScenePanel = new EndScenePanel();
	static JPanel endingScene = endScenePanel.createPanel();
	// victory gui
	static VictoryScenePanel victoryScenePanel = new VictoryScenePanel();
	static JPanel victoryScene = victoryScenePanel.createPanel();
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
     * This constructor adds the key listener 
     */
    public Main()
    {
        addKeyListener(this);
    }
    /*
     * This method starts the game and initializes the game window
     */
    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                Main window = new Main();
                window.setTitle("MAZE RPG");
                window.setResizable(true);
                window.setSize(700, 700);
                window.setLayout(null);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.getContentPane().add(startingScene);
                window.getContentPane().add(gameInterface);
                window.getContentPane().add(battleInterface);
                window.getContentPane().add(inventoryInterface);
                window.getContentPane().add(endingScene);
                window.getContentPane().add(victoryScene);
                
                gameInterface.setVisible(false);
                battleInterface.setVisible(false);
                inventoryInterface.setVisible(false);
                endingScene.setVisible(false);
                victoryScene.setVisible(false);
                               
                window.setVisible(true);
            }
        });
    }
}