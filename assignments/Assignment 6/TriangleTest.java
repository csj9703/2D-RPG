import static org.junit.Assert.*;

import org.junit.Test;

public class TriangleTest 
{
	@Test
	public void test_getArea_small_triangle() 
	{
		Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
						                 new Line(new Point(2,0), new Point(0,2)),
						                 new Line(new Point(0,2), new Point(0,0)));
		assertEquals("Area should be 2.0", 2.0, triangle.getArea(), 0.00001);
	}
	
	@Test
	public void test_getArea_large_triangle() 
	{
		Triangle triangle = new Triangle(new Line(new Point(1,1), new Point(7651,58)),
						                 new Line(new Point(7651,58), new Point(3158,64081)),
						                 new Line(new Point(3158,64081), new Point(1,1)));
		assertEquals("Area should be 245016025.49999", 245016025.49999, triangle.getArea(), 0.00001);
	}
	
	@Test
	public void test_getCircumferance_small_triangle() 
	{
		Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
						                 new Line(new Point(2,0), new Point(0,2)),
						                 new Line(new Point(0,2), new Point(0,0)));
		assertEquals("Circumferance should be 6.82842", 6.82842, triangle.getCircumference(), 0.00001);
	}
	
	@Test
	public void test_getCircumferance_large_triangle() 
	{
		Triangle triangle = new Triangle(new Line(new Point(1,1), new Point(7651,58)),
						                 new Line(new Point(7651,58), new Point(3158,64081)),
						                 new Line(new Point(3158,64081), new Point(1,1)));
		assertEquals("Circumferance should be 135988.39348", 135988.39348, triangle.getCircumference(), 0.00001);
	}
	
	//Jason
	@Test
	public void test_getLine1_triangle()
	{
		Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
                new Line(new Point(2,0), new Point(0,2)),
                new Line(new Point(0,2), new Point(0,0)));
		
		assertEquals("Line 1 length should be 2.0",2.0, triangle.getLine1().length(), 0.00001);
	}
	
	@Test
	public void test_getLine1_triangle_privacyLeak()
	{
		Line l1 = new Line(new Point(0,0), new Point(2,0));
		
		Triangle triangle = new Triangle(l1,
                new Line(new Point(2,0), new Point(0,2)),
                new Line(new Point(0,2), new Point(0,0)));
		int original = triangle.getLine1().getStart().getXCoord();
		Point p1 = new Point(1,0);
		l1.setStart(p1);
		
		assertEquals("Line 1 starting point should be 1",original,triangle.getLine1().getStart().getXCoord());
	}
	
	@Test
	public void test_getLine2_triangle()
	{
		Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
                new Line(new Point(0,0), new Point(2,0)),
                new Line(new Point(0,2), new Point(0,0)));
		
		assertEquals("Line 2 length should be 2.0",2.0, triangle.getLine2().length(), 0.00001);
	}
	
	@Test
	public void test_getLine3_triangle()
	{
		Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
                new Line(new Point(2,0), new Point(0,2)),
                new Line(new Point(0,0), new Point(2,0)));
		
		assertEquals("Line 3 length should be 2.0",2.0, triangle.getLine3().length(), 0.00001);
	}
	
	
}
