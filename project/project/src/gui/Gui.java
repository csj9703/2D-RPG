package gui;

import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * This class is the graphical user interface for the game
 */
public class Gui extends JFrame 
{
    /*
     * This constructor accepts as arguments the other panels and 
     * initializes the frame
     */
    public Gui(KeyListener listener, JPanel gameInterface, JPanel battleInterface, JPanel inventoryInterface, 
    		JPanel startingScene, JPanel endingScene, JPanel victoryScene, JPanel textBox)
    {
    	JFrame window = new JFrame();
        window.setTitle("MAZE RPG");
        window.addKeyListener(listener);
        window.setResizable(true);
        window.setSize(665, 750);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(startingScene);
        window.getContentPane().add(gameInterface);
        window.getContentPane().add(battleInterface);
        window.getContentPane().add(inventoryInterface);
        window.getContentPane().add(endingScene);
        window.getContentPane().add(victoryScene);
        window.getContentPane().add(textBox);
        
        textBox.setLocation(5,650);
        
        gameInterface.setVisible(false);
        battleInterface.setVisible(false);
        inventoryInterface.setVisible(false);
        endingScene.setVisible(false);
        victoryScene.setVisible(false);
        textBox.setVisible(false);
                       
        window.setVisible(true);
    }
}