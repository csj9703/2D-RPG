public class Triangle 
{
	private Line line1, line2, line3;
	
	public Triangle(Line line1, Line line2, Line line3)
	{
		this.line1 = new Line(line1.getStart(), line1.getEnd());
		this.line2 = new Line(line2.getStart(), line2.getEnd());
		this.line3 = new Line(line3.getStart(), line3.getEnd());
	}
	
	public Line getLine1()
	{
		return new Line(line1.getStart(), line1.getEnd());
	}
	
	public Line getLine2() 
	{
		return new Line(line2.getStart(), line2.getEnd());
	}
	
	public Line getLine3() 
	{
		return new Line(line3.getStart(), line3.getEnd());
	}
	
	public double getCircumference() 
	{
		return line1.length() + line2.length() + line3.length();
	}
	/*
	 * area = root of (p(p-a)(p-b)(p-c)) where p is half the perimeter
	 */
	public double getArea()
	{
		double p = (line1.length() + line2.length() + line3.length())/2;
		
		double area = Math.pow(p*((p-line1.length())*(p-line2.length())*(p-line3.length())), 0.5);
		
		return area;
	}
}