public class MyCircle 
{
	private int xCoord, yCoord, radius;

	
	public int getX()
	{
		return xCoord;
	}
	
	public int getY()
	{
		return yCoord;
	}
	
	public int getRadius()
	{
		return radius;
	}
	
	public void setX(int newX)
	{
		xCoord = newX;
	}
	
	public void setY(int newY)
	{
		yCoord = newY;
	}
	
	public void setRadius(int newRadius)
	{
		radius = newRadius;
	}
	
	public String checkQuadrant(int xCoord, int yCoord)
	{
		String location = "";
		
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
	
	public int biggestRadius(int circumference)
	{
		final int PI = 3;
		return circumference / 2 / PI;
	}
	
	
	
	
	
	
	
}
