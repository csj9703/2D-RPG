package project;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * This class contains the graphical user interface for the game
 */
public class Gui 
{
	private ImageIcon wall = new ImageIcon("wall.png");
	private ImageIcon road = new ImageIcon("grass.png");
	private ImageIcon player = new ImageIcon("player.png");
	private ImageIcon enemy = new ImageIcon("enemy.png");
	private ImageIcon item = new ImageIcon("item.png");
	private JLabel[][] labels;
	private final int ROW = 20;
	private final int COL = 20;
	
	public Gui(Map game) 
	{ 
		final int WIDTH = 700;
		final int HEIGHT = 700;
		// game window
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH, HEIGHT);
		window.setLayout(null);
		// panel displaying the maze
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(ROW,COL));
		
		// creates 20 x 20 labels and adds to panel grid
		labels = new JLabel[ROW][COL];
		for (int r = 0; r < ROW; r++)
		{
		     for (int c = 0; c < COL; c++)
		     {
		    	 labels[r][c] = new JLabel();
		    	 panel.add(labels[r][c]);
		     }
		}
		update(game);
	
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		JPanel gamePanel = new JPanel();
		gamePanel.setBounds(0, 0, 700, 700);
		gamePanel.add(panel);

		window.add(gamePanel);
		window.setVisible(true);
	}
	/*
	 * This method updates the maze with the correct images
	 * @param game The map
	 */
	public void update(Map game)
	{
		String[][] maze = game.getMaze();
		for (int i = 0; i < ROW; i++)
		{
		     for (int j = 0; j < COL; j++)
		     {
		    	 if (maze[i][j] == "#") 
		    	 {
		    		 labels[i][j].setIcon(wall); 
		    	 }
		    	 else if (maze[i][j] == " ") 
		    	 {
		    		 labels[i][j].setIcon(road);
		    	 }
		    	 else if (maze[i][j] == "X") 
		    	 {
		    		 labels[i][j].setIcon(player);
		    	 }
		    	 else if (maze[i][j] == "E")
		    	 {
		    		 labels[i][j].setIcon(enemy);
		    	 }
		    	 else if (maze[i][j] == "?") 
		    	 {
		    		 labels[i][j].setIcon(item);
		    	 }
		     } 
		}
	}
}