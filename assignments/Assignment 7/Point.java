/*
 * This class defines a point
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.0
 * @since November 8, 2017
 */
public class Point
{
	private int xcoord, ycoord;
	/*
	 * Constructor that accepts two integers,
	 * sets value to 0 if negative
	 */
	public Point(int x, int y)
	{	
	    xcoord = x >= 0 ? x : 0;
	    ycoord = y >= 0 ? y : 0;
	}
	/*
	 * Copy constructor
	 */
	public Point(Point point)
	{
	    xcoord = point.xcoord;
	    ycoord = point.ycoord;
	}
	/*
	 * Getter for xCoord, returns xCoord
	 */
	public int getXCoord()
	{
	    return xcoord;
	}
	/*
	 * This method sets xCoord if parameter value is not negative
	 * @param x An integer 
	 */
	public void setXCoord(int x)
	{
	    xcoord = x >= 0 ? x : xcoord;
	}
	/*
	 * Getter for yCoord, returns yCoord
	 */
	public int getYCoord()
	{
	    return ycoord;
	}
	/*
	 * This method sets yCoord if parameter value is not negative
	 * @param y An integer 
	 */
	public void setYCoord(int y)
	{
	    ycoord = y >= 0 ? y : ycoord;
	}
	/*
	 * This method decreases yCoord
	 * @param distance An integer
	 */
	public void moveUp(int distance)
	{
	    ycoord -= distance;
	}
	/*
	 * This method increases yCoord
	 * @param distance An integer
	 */
	public void moveDown(int distance)
	{
	    ycoord += distance;
	}
	/*
	 * This method decreases xCoord
	 * @param distance An integer
	 */
	public void moveLeft(int distance)
	{
	    xcoord -= distance;
	}
	/*
	 * This method increases xCoord
	 * @param distance An integer
	 */
	public void moveRight(int distance)
	{
	    xcoord += distance;
	}
	/*
	 * This method returns the Euclidean distance between two Points
	 */
	public double distance(Point point)
	{
		return Math.pow(Math.pow(xcoord - point.getXCoord(), 2) + Math.pow(ycoord - point.getYCoord(), 2), 0.5);
	}
	/*
	 * This method returns true when two Points are equal, false otherwise
	 */
	public boolean equals(Point point)
	{
	    return xcoord == point.getXCoord() && ycoord == point.getYCoord() ? true : false;
	}
	/*
	 * This method returns a string which contains 
	 * all the coordinates in the point 
	 */
	@Override
	public String toString()
	{
		return "(" + xcoord + "," + ycoord + ")";
	}
}