import java.awt.Graphics;
/**
 * This class draws a Square.
 */
public class Square extends Shape{
	
	/**
	 * Constructor that takes in a point and a size.
	 * @param topLeft A point in the window(x and y coordinates).
	 * @param size The size of the shape in pixels.
	 */
	public Square(Point topLeft, int size) 
	{
		super(topLeft, size);
	}

	/**
	 * This method draws the square
	 */
	public void draw(Graphics g) {
		g.drawRect(getTopLeftPoint().getXCoord(), getTopLeftPoint().getYCoord(), 
				getSize(), getSize());
	}
	
	
	
}
