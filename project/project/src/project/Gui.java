package project;

import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * This class is the graphical user interface for the game
 */
public class Gui extends JFrame 
{
    /*
     * This constructor initializes the frame
     */
    public Gui(KeyListener listener, JPanel gameInterface, JPanel battleInterface, JPanel inventoryInterface, 
    		JPanel startingScene, JPanel endingScene, JPanel victoryScene)
    {
    	JFrame window = new JFrame();
        window.setTitle("MAZE RPG");
        window.addKeyListener(listener);
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
}