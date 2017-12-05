package gui;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Map;
/*
 * This class is a panel that displays the maze, player, items, and enemies
 */
public class GamePanel 
{
	private ImageIcon wallDark = new ImageIcon("src/graphics/WallDark.png");
	private ImageIcon wall = new ImageIcon("src/graphics/wall.png");
	private ImageIcon road = new ImageIcon("src/graphics/grass.png");
	private ImageIcon player = new ImageIcon("src/graphics/player.png");
	private ImageIcon item = new ImageIcon("src/graphics/item.png");
	private ImageIcon zombie = new ImageIcon("src/graphics/zombie.png");
	private ImageIcon skeletonMinion = new ImageIcon("src/graphics/skeleton_minion.png");
	private ImageIcon skeletonKing = new ImageIcon("src/graphics/skeleton_king.png");
	private ImageIcon blackKnight = new ImageIcon("src/graphics/black_knight.png");
	private ImageIcon reaper = new ImageIcon("src/graphics/reaper.png");	
	private JLabel[][] labels;
	private final int ROW = 20;
	private final int COL = 20;
	/**
	 * This method creates and returns a JPanel
	 * @param game The map
	 */
	public JPanel createPanel(Map game) 
	{ 
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
		gamePanel.setBounds(0, 0, 650, 650);
		gamePanel.add(panel);

		return gamePanel;
	}
	/**
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
		    	 if (maze[i][j] == "w") 
		    	 {
		    		 labels[i][j].setIcon(wall); 
		    	 }
		    	 else if(maze[i][j] == "v") 
		    	 {
		    		 labels[i][j].setIcon(wallDark);
		    	 }
		    	 else if (maze[i][j] == "r") 
		    	 {
		    		 labels[i][j].setIcon(road);
		    	 }
		    	 else if (maze[i][j] == "n") 
		    	 {
		    		 labels[i][j].setIcon(road);
		    	 }
		    	 else if (maze[i][j] == "m") 
		    	 {
		    		 labels[i][j].setIcon(road);
		    	 }
		    	 else if (maze[i][j] == "x") 
		    	 {
		    		 labels[i][j].setIcon(player);
		    	 }
		    	 else if ((maze[i][j]).matches("[1-6]")) 
		    	 {
		    		 labels[i][j].setIcon(item);
		    	 }	 
		    	 else if ((maze[i][j]) == "a") 
		    	 {
		    		 labels[i][j].setIcon(zombie);
		    	 }	 
		    	 else if ((maze[i][j]) == "b") 
		    	 {
		    		 labels[i][j].setIcon(skeletonMinion);
		    	 }	 
		    	 else if ((maze[i][j]) == "c") 
		    	 {
		    		 labels[i][j].setIcon(skeletonKing);
		    	 }	 
		    	 else if ((maze[i][j]) == "d") 
		    	 {
		    		 labels[i][j].setIcon(blackKnight);
		    	 }	 
		    	 else if ((maze[i][j]) == "e") 
		    	 {
		    		 labels[i][j].setIcon(reaper);
		    	 }	 
		     } 
		}
	}
}