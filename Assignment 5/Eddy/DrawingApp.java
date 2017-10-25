import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;
/** 
 * This class is for drawing shapes on the screen. When the user presses c a circle
 * will be drawn, and when the user presses s, a square will be drawn. In addition
 * the arrow keys will move all the shapes in the desired direction. Simultaneously,
 * all shapes will be moving down every second. 
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.0
 * @since October 25, 2017
 */
public class DrawingApp extends JFrame implements KeyListener 
{
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 1000;
	public static final int DEFAULT_CIRCLE_SIZE = 100;
	public static final int DEFAULT_SQUARE_SIZE = 60;
	public static final int UP=1, DOWN=2, LEFT=3, RIGHT=4;

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	   
    /** 
     * This constructor creates a window and adds a key listener
     */
    public DrawingApp() 
    {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().addKeyListener(this);
        getContentPane().setFocusable(true); 
        requestFocusInWindow();
        
        // creates a timer that goes off every 200ms after a initial delay of 1000ms
        Timer timer = new Timer(200, new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                timerAction();
            }
        });
        timer.setInitialDelay(1000);
        timer.start();
    }
	/**
	 * This method will redraw all shapes 10 pixels below its previous location
	 */
    public void timerAction()
    {
		for (Shape s : shapes) 
		{
			s.moveDown(10);
		}
		repaint();
    }
 
    /*
     * This method draws all the shapes that should be in the window
     */
	@Override
    public void paint(Graphics canvas) 
	{
        super.paint(canvas);
        for (Shape s : shapes) 
        {
        	s.draw(canvas);
        }
    }
    
	/*
	 * This method moves all shapes drawn in window 
	 * @param direction The direction to be moved
	 */
	public void move(int direction)
	{
		final int DISTANCE = 5;
		for (Shape s : shapes) 
		{
			switch(direction)
			{
				case 1:
					s.moveUp(DISTANCE);
					break;
				case 2:
					s.moveDown(DISTANCE);
					break;
				case 3:
					s.moveLeft(DISTANCE);
					break;
				case 4:
					s.moveRight(DISTANCE);
					break;
			}
			repaint();
		}
	}
	/*
	 * This method executes each time a selected key is pressed
	 */
	@Override
	public void keyPressed(KeyEvent e) 
	{
		Random rng = new Random();
		int xCoord, yCoord;
		switch (e.getKeyCode()) 
		{
		// creates a circle at a random location within the window
		case 'C':
			xCoord = rng.nextInt(WINDOW_WIDTH-DEFAULT_CIRCLE_SIZE+1);
			yCoord = rng.nextInt(WINDOW_HEIGHT-DEFAULT_CIRCLE_SIZE+1);
			Shape aCircle = new Circle(new Point(xCoord,yCoord), DEFAULT_CIRCLE_SIZE);		
			shapes.add(aCircle);
			break;
		// creates a square at a random location within the window
		case 'S':
			xCoord = rng.nextInt(WINDOW_WIDTH-DEFAULT_SQUARE_SIZE+1);
			yCoord = rng.nextInt(WINDOW_HEIGHT-DEFAULT_SQUARE_SIZE+1);
			Shape aSquare = new Square(new Point(xCoord,yCoord), DEFAULT_SQUARE_SIZE);		
			shapes.add(aSquare);
			break;
		// the arrow keys move the shapes in the window
		case KeyEvent.VK_UP:
			move(UP);
			break;
		case KeyEvent.VK_DOWN:
			move(DOWN);
			break;
		case KeyEvent.VK_LEFT:
			move(LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			move(RIGHT);
			break;
		}
	}
	// required method for KeyListener but unused in this application
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	/*
	 * This method instances itself and runs the application
	 */
    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
				DrawingApp faceWindow = new DrawingApp();
				faceWindow.setVisible(true);
			}
		});
    }
}