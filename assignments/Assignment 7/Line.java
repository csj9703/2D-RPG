/*
 * This class defines a line
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.0
 * @since November 8, 2017
 */
public class Line 
{
	private Point start;
	private Point end;
	/*
	 * Constructor that accepts two instances of the Point object
	 * @param start A Point
	 * @param end A Point
	 */
	public Line(Point start, Point end)
	{
		this.start = new Point(start.getXCoord(), start.getYCoord());
		this.end = new Point(end.getXCoord(), end.getYCoord());
	}
	/*
	 * Getter for start point, returns start point
	 */
	public Point getStart()
	{
		return new Point(start.getXCoord(), start.getYCoord());
	}
	/*
	 * Setter for start point
	 * @param start A Point
	 */
	public void setStart(Point start)
	{
		this.start = new Point(start.getXCoord(), start.getYCoord());
	}
	/*
	 * Getter for end point, returns end point
	 */
	public Point getEnd()
	{
		return new Point(end.getXCoord(), end.getYCoord());
	}
	/*
	 * Setter for end point
	 * @param end A Point
	 */
	public void setEnd(Point end)
	{
		this.end = new Point(end.getXCoord(), end.getYCoord());
	}
	/*
	 * This method returns the Euclidean distance between two Points
	 */
	public double length()
	{
		return start.distance(end);
	}
	/*
	 * This method returns a string which contains 
	 * all the points in the line 
	 */
	@Override
	public String toString()
	{
		return "[" + getStart().toString() + "," + getEnd().toString() + "]";
	}
}