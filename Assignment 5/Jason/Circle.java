import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * This class draws a Circle.
 */
public class Circle extends Shape{

	/**
	 * Constructor that takes in a point and a size.
	 * @param topLeft A point in the window(x and y coordinates).
	 * @param size The size of the shape in pixels.
	 */
	public Circle(Point topLeft, int size)
	{
		super(topLeft,size);
	}

	/**
	 * This method draws the circle
	 */
	public void draw(Graphics g){
		g.drawOval(getTopLeftPoint().getXCoord(), getTopLeftPoint().getYCoord(),
				getSize() * 2,
				getSize() * 2);
	}

}
