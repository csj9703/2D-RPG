public class MyCircle 
{
	private int xCoord, yCoord, radius;
	
	/**
	 * this method checks in which quadrant the center of the circle (which is at (X,Y)) is 
	 * and it returns as a string (Quadrant1, Quadrant2, Quadrant3, Quadrant4, Origin)	
	 */
	public String checkQuadrant()
	{
		String location;
		
		if (xCoord > 0 && yCoord > 0)
		{
			location = "Quadrant1";
		}
		else if (xCoord < 0 && yCoord > 0)
		{
			location = "Quadrant2";
		}
		else if (xCoord < 0 && yCoord < 0)
		{
			location = "Quadrant3";
		}
		else if (xCoord > 0 && yCoord < 0)
		{
			location = "Quadrant4";
		}
		else
		{
			location = "Origin";
		}
		return location;
	}
	/**
	 * This method computes the largest possible radius (assuming pi=3)
	 * for a given circle circumference size
	 * @param circumference The circle's circumference
	 */
	public int biggestRadius(int circumference)
	{
		final int PI = 3;
		return circumference > 0 ? circumference/2/PI : 0;
	}
	
	public int getRadius()
	{
		return radius;
	}
	
	public void setRadius(int newRadius)
	{
		radius = newRadius < 0 ? 0 : newRadius;
	}
	
	public int getX()
	{
		return xCoord;
	}
	
	public void setX(int newX)
	{
		xCoord = newX;
	}
	
	public int getY()
	{
		return yCoord;
	}
	
	public void setY(int newY)
	{
		yCoord = newY;
	}
}
