import java.util.ArrayList;
/*
 * The Shape class is a abstract class that holds 
 * the lines, classes representing a shape should 
 * inherit from this class
 * @author Team 6 - CPSC 233 - Tutorial T02
 * @version 1.0
 * @since November 8, 2017
 */
public abstract class Shape 
{
	private ArrayList<Line> lines = new ArrayList<Line>();
	/*
	 * This method takes a Line object as argument 
	 * and adds it to the ArrayList 
	 * @param line The Line object
	 */
	protected void addLine(Line line)
	// There is no potential privacy leak in this method because
	// this is a void method that does not return anything
	{
		if (lines.size() == 0)
		{
			lines.add(line);
		}
		else
		{
			if ((line.getStart().getXCoord() == lines.get(lines.size() - 1).getEnd().getXCoord()) &&					
				(line.getStart().getYCoord() == lines.get(lines.size() - 1).getEnd().getYCoord()));
			{
				lines.add(line);
			}
		}
	}
	/*
	 * This abstract method does nothing and must
	 * be overridden in a subclass
	 */
	public abstract double getArea();
	// There is no potential privacy leak in this method because
	// this method is abstract and does nothing
	/*
	 * This is the getter method for the lines instance 
	 * variable with protected access, returns lines
	 */
	protected ArrayList<Line> getLines()
	// There is a potential for privacy leak in this method because
	// it returns a ArrayList, which contain references
	// The privacy leak has been removed by copying and returning
	// a new ArrayList instead of the original ArrayList reference
	{
		return new ArrayList<Line>(lines);
	}
	/*
	 * This method has public access and returns an 
	 * ArrayList with all the lines in the list
	 */
	public ArrayList<Line> getShape()
	// There is a potential for privacy leak in this method because
	// it returns a ArrayList, which contain references
	// The privacy leak has been removed by copying and returning
	// a new ArrayList instead of the original ArrayList reference
	{
		return new ArrayList<Line>(lines);
	}
	/*
	 * This method adds the length of all lines in the 
	 * ArrayList and returns the result as a double
	 */
	protected double getCircumference()
	// There is no potential privacy leak in this method because 
	// this method only returns a local variable that is a double
	{
		double totalCircumference = 0;	
		for (Line line : lines)
		{
			totalCircumference += line.length();
		}
		return totalCircumference;
	}
	/*
	 * This method returns a string which contains 
	 * all the lines in the shape 
	 */
	@Override
	public String toString()
	// There is no potential privacy leak in this method because 
	// this method returns a string, and a Java String is immutable 
	{
		String string = "";
		for (int x = 0; x < lines.size(); x++)
		{
			string += lines.get(x).toString() + ((x != lines.size()-1) ? "," : "");
		}		
		return string;
	}
}