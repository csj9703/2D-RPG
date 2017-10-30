import java.awt.Graphics;
/*
 * This is a abstract class to contain shapes
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.0
 * @since October 25, 2017
 */
public abstract class Shape 
{
	private Point topLeft;
	private int size;
	/**
	 * This constructor accepts a Point object and a integer size
	 * @param topLeft A instance of Point
	 * @param size The size 
	 */
	public Shape(Point topLeft, int size)
	{
		this.topLeft = topLeft;
		this.size = size;
	}
	/**
	 * This method moves the shape up 
	 * @param amount The distance in pixels
	 */
	public void moveUp(int amount) 
	{
		topLeft.moveUp(amount);
	}
	/**
	 * This method moves the shape down 
	 * @param amount The distance in pixels
	 */
	public void moveDown(int amount) 
	{
		topLeft.moveDown(amount);
	}
	/**
	 * This method moves the shape left 
	 * @param amount The distance in pixels
	 */
	public void moveLeft(int amount) 
	{
		topLeft.moveLeft(amount);
	}
	/**
	 * This method moves the shape right 
	 * @param amount The distance in pixels
	 */
	public void moveRight(int amount) 
	{
		topLeft.moveRight(amount);
	}
	/*
	 * This is a abstract method that does nothings
	 * @param g A graphics object
	 */
	public abstract void draw(Graphics g);
	/*
	 * This is the getter method for the topLeft point, returns topLeft
	 */
	public Point getTopLeft()
	{
		return new Point(topLeft.getXCoord(),topLeft.getYCoord());
	}
	/*
	 * This is the getter method for size, returns size
	 */
	public int getSize()
	{
		return new Integer(size);
	}
	/*
	 * This is the setter method for size
	 * @param newsize The size to be set to
	 */
	public void setSize(int newSize)
	{
		size = newSize;
	}
}