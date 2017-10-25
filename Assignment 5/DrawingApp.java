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
 * Application for drawing circles on the screen.  When the user click, a circle
 * will be created on the spot of default size.  When dragging the mouse, the circle
 * will have the size indicated by the drag area.
 * @author Nathaly Verwaal
 *
 */
public class DrawingApp extends JFrame implements KeyListener {
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 1000;
	//The Default sizes of the circle and square.
	public static final int DEFAULT_CIRCLE_SIZE = 100;
	public static final int DEFAULT_SQUARE_SIZE = 60;
	//Creates an arraylist to store the shapes created later.
	private ArrayList<Shape> shapes = new ArrayList<Shape>();   
    /** 
     * Creates the window that users can use to draw circles.
     */
    public DrawingApp() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // put one circle in the list to get it started.
		Circle aCircle = new Circle (new Point(0,0),DEFAULT_CIRCLE_SIZE);
		shapes.add(aCircle);
		
        getContentPane().addKeyListener(this);
        getContentPane().setFocusable(true); 
        requestFocusInWindow();
        
        Timer timer = new Timer(200,
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    timerAction();
                }
            });
        timer.setInitialDelay(1000);
        timer.start();
    }
    
	/**
	 * This method will move all circles in our list down and ask the frame to
	 * be re-drawn.
	 */
    public void timerAction(){
		for (Shape s : shapes) {
			s.moveDown(10);
		}
		repaint();
    }
    
	@Override
    public void paint(Graphics canvas) {
        super.paint(canvas);

        for (Shape s : shapes) {
        	s.draw(canvas);
        }
    }
    
	@Override
	public void keyTyped(KeyEvent event) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Random random = new Random();
		int randNum = random.nextInt(1000);
		int size = 50;
		//
		int moveAmount = 5;
		switch (e.getKeyCode()) {
		case 'C':
			//This draws a cirle at a random location within the window.
			Circle newCircle = new Circle(new Point(randNum,randNum),DEFAULT_CIRCLE_SIZE);
			shapes.add(newCircle);
			break;
		case 'S':
			//This draws a square at a random location within the window.
			Square newSquare = new Square(new Point(randNum,randNum),DEFAULT_SQUARE_SIZE);
			shapes.add(newSquare);
			break;
		case KeyEvent.VK_LEFT:
			//This moves all the shapes in the array left by 5 pixels.
			for (Shape s : shapes) {
				s.moveLeft(moveAmount);
			}
			break;
		case KeyEvent.VK_RIGHT:
			//This moves all the shapes in the array right by 5 pixels.
			for (Shape s : shapes) {
				s.moveRight(moveAmount);
			}
			break;
		case KeyEvent.VK_UP:
			//This moves all the shapes in the array up by 5 pixels.
			for (Shape s : shapes) {
				s.moveUp(moveAmount);
			}
			break;
		case KeyEvent.VK_DOWN:
			//This moves all the shapes in the array down by 5 pixels.
			for (Shape s : shapes) {
				s.moveDown(moveAmount);
			}
			break;
		}
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Required for KeyListener, but we are not interested in this event so we'll
		// do nothing.		
	}
	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
				DrawingApp faceWindow = new DrawingApp();
				faceWindow.setVisible(true);
			}
		});
    }

}