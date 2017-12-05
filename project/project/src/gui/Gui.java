package gui;

import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * This class is the graphical user interface for the game
 */
public class Gui extends JFrame 
{
	/**
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
        
        checkFiles();
    }
    /**
     * This method ensures all graphics are in the the correct
     * directory and that none are corrupt or missing
     */
    private void checkFiles()
    {
		// checks for start scene panel files
		fileExists("src/graphics/titleBG.gif");
		fileExists("src/graphics/Title.png");
		// checks for end scene panel files
		fileExists("src/graphics/gameOver.png");
		fileExists("src/graphics/YouDied.png");
		// checks for victory scene panel files
		fileExists("src/graphics/victory.gif");
		fileExists("src/graphics/congratulations.png");
		// checks for battle panel files
    	fileExists("src/graphics/reaper.gif");
    	fileExists("src/graphics/blackKnight.gif");
    	fileExists("src/graphics/skeletonKing.gif");
    	fileExists("src/graphics/skeleton.gif");
    	fileExists("src/graphics/zombie.gif");
    	// checks for inventory panel files
		fileExists("src/graphics/rusty_dagger.png");
		fileExists("src/graphics/iron_longsword.png");
		fileExists("src/graphics/excalibur.png");
		fileExists("src/graphics/small_potion.png");
		fileExists("src/graphics/medium_potion.png");
		fileExists("src/graphics/large_potion.png");
		fileExists("src/graphics/inventory_header.png");
    	// checks for game panel files
		fileExists("src/graphics/WallDark.png");
		fileExists("src/graphics/wall.png");
		fileExists("src/graphics/grass.png");
		fileExists("src/graphics/player.png");
		fileExists("src/graphics/item.png");
		fileExists("src/graphics/zombie.png");
		fileExists("src/graphics/skeleton_minion.png");
		fileExists("src/graphics/skeleton_king.png");
		fileExists("src/graphics/black_knight.png");
		fileExists("src/graphics/reaper.png");	
    }
    /**
	 * This method will display an error message if any 
	 * image files are corrupt or missing
	 * @param filePath The image path
	 */
	private void fileExists(String filePath) 
	{
		File f = new File(filePath);
		if (!(f.exists()) || (!(f.canRead())))
		{
			Object[] options = {"OK"};
			JOptionPane.showOptionDialog(null, "Unable to load all texture files. Exit and reinstall Game", "IMAGE LOADING ERROR",
			JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			null, options, options[0]);
		}
	}
    
}