import java.awt.Graphics;
/*
 * This class draws a circle
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.0
 * @since October 25, 2017
 */
public class Circle extends Shape
{
	/**
	 * This constructor accepts a Point object and a integer size
	 * @param topLeft A instance of Point
	 * @param size The size 
	 */
	public Circle(Point topLeft, int size) 
	{
		super(topLeft, size);
	}
	/*
	 * This method draws a oval
	 * @see Shape#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g)
	{
		g.drawOval(getTopLeft().getXCoord(), getTopLeft().getYCoord(), getSize(), getSize());
	}
}