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
	public static final int DEFAULT_CIRCLE_SIZE = 100;
	//My code
	public static final int DEFAULT_SQUARE_SIZE = 60;
	//
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

		// The following three windows are needed to listen to keyboard events.
		// We need the focus in our content pane in our window to ensure we are informed of keyboard
		// events.
        getContentPane().addKeyListener(this);
        getContentPane().setFocusable(true); 
        requestFocusInWindow();
        
        // This creates a timer.  Whenever the timer goes off (every 200 ms)
        // we call this frame's method to repaint itself.  (Which will
        // indirectly call paint which is defined below.)
        Timer timer = new Timer(200,
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    timerAction();
                }
            });
        // The timer will go off for the first time 1000ms after the timer is started.
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
		// Draws what should be displayed in this window.  this will be called each
		// time the window needs to be refreshed.  This includes when the window
		// is displayed, maximized, moved, etc.)

        // We need to do this call to make sure the window is wiped clean before we
        // start drawing.
        super.paint(canvas);

        for (Shape s : shapes) {
        	s.draw(canvas);
        }
    }
    
	@Override
	public void keyTyped(KeyEvent event) {
		// Required for KeyListener, but we are not interested in this event so we'll
		// do nothing.
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
			Circle newCircle = new Circle(new Point(randNum,randNum),DEFAULT_CIRCLE_SIZE);
			shapes.add(newCircle);
			break;
		case 'S':
			Square newSquare = new Square(new Point(randNum,randNum),DEFAULT_SQUARE_SIZE);
			shapes.add(newSquare);
			break;
		case KeyEvent.VK_LEFT:
			for (Shape s : shapes) {
				s.moveLeft(moveAmount);
			}
			break;
		case KeyEvent.VK_RIGHT:
			for (Shape s : shapes) {
				s.moveRight(moveAmount);
			}
			break;
		case KeyEvent.VK_UP:
			for (Shape s : shapes) {
				s.moveUp(moveAmount);
			}
			break;
		case KeyEvent.VK_DOWN:
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