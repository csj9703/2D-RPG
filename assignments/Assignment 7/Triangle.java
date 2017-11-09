import java.util.ArrayList;
/**
 * This class defines a triangle
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.0
 * @since November 8, 2017
 */
public class Triangle extends Shape
{
	/**
	 * This constructor accepts three line objects as arguments 
	 * @param line1 The first line
	 * @param line2 The second line
	 * @param line3 The third line
	 */
	public Triangle(Line line1, Line line2, Line line3)
	{
		// adds lines to a ArrayList
		super.addLine(line1);
		super.addLine(line2);
		super.addLine(line3);
	}
	/*
	 * This method calculates and returns the area 
	 * of the triangle as a double
	 */
	@Override
	public double getArea() 
	{	
		// formula: area = root of (p(p-a)(p-b)(p-c)) where p is half the perimeter		 
		ArrayList<Line> lines = getLines();	
		double p = (lines.get(0).length() + lines.get(1).length() + lines.get(2).length())/2;	
		return Math.pow(p*((p-lines.get(0).length())*(p-lines.get(1).length())*(p-lines.get(2).length())), 0.5);	
	}
}