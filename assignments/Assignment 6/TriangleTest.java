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
	
	@Test
	public void test_InstanceVariablePrivacy()
	{
	Triangle triangle = new Triangle( new Line(new Point(0,0), new Point(2,0)),
						new Line(new Point(2,0), new Point(0,2)),
						new Line(new Point(0,2), new Point(0,0)));
	Triangle original = triangle;
	triangle.Line1 = new Line(new Point(0,0), new Point(0,0));
	triangle.Line2 = new Line(new Point(0,0), new Point(0,0));
	triangle.Line3 = new Line(new Point(0,0), new Point(0,0));
	assertEquals("Was able to directly change Line1",  Original.getLine1, triangle.getLine1);
	assertEquals("Was able to directly change Line2",  Original.getLine2, triangle.getLine2);
	assertEquals("Was able to directly change Line3",  Original.getLine3, triangle.getLine3);
	
	}
	
	//GetLine1
	@Test
	public void test_getLine1_triangle()
	{
		Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
                new Line(new Point(2,0), new Point(0,2)),
                new Line(new Point(0,2), new Point(0,0)));
		
		assertEquals("Line 1 length should be 2.0",2.0, triangle.getLine1().length(), 0.00001);

	}
	
	@Test
	public void test_getLine1_triangle_privacyLeak_StartPointXCoord()
	{
		Line l1 = new Line(new Point(0,0), new Point(2,0));
		Triangle triangle = new Triangle(l1,
                new Line(new Point(2,0), new Point(0,2)),
                new Line(new Point(0,2), new Point(0,0)));
		int original = triangle.getLine1().getStart().getXCoord();
		Point p1 = new Point(1,1);
		triangle.getLine1().setStart(p1);
		
		assertEquals("Line 1 start point x-coordinate should be 0",original,triangle.getLine1().getStart().getXCoord());
	}
	
	@Test
	public void test_getLine1_triangle_privacyLeak_StartPointYCoord()
	{
		Line l1 = new Line(new Point(0,0), new Point(2,0));
		Triangle triangle = new Triangle(l1,
                new Line(new Point(2,0), new Point(0,2)),
                new Line(new Point(0,2), new Point(0,0)));
		int original = triangle.getLine1().getStart().getYCoord();
		Point p1 = new Point(1,1);
		triangle.getLine1().setStart(p1);
		
		assertEquals("Line 1 start point y-coordinate should be 0",original,triangle.getLine1().getStart().getYCoord());
	}
	
	@Test
	public void test_getLine1_triangle_privacyLeak_EndPointXCoord()
	{
		Line l1 = new Line(new Point(0,0), new Point(2,0));
		Triangle triangle = new Triangle(l1,
                new Line(new Point(2,0), new Point(0,2)),
                new Line(new Point(0,2), new Point(0,0)));
		int original = triangle.getLine1().getEnd().getXCoord();
		Point p1 = new Point(1,1);
		triangle.getLine1().setEnd(p1);
		
		assertEquals("Line 1 end point x-coordinate should be 2",original,triangle.getLine1().getEnd().getXCoord());
	}
	
	@Test
	public void test_getLine1_triangle_privacyLeak_EndPointYCoord()
	{
		Line l1 = new Line(new Point(0,0), new Point(2,0));
		Triangle triangle = new Triangle(l1,
                new Line(new Point(2,0), new Point(0,2)),
                new Line(new Point(0,2), new Point(0,0)));
		int original = triangle.getLine1().getEnd().getYCoord();
		Point p1 = new Point(1,1);
		triangle.getLine1().setEnd(p1);
		
		assertEquals("Line 1 end point y-coordinate should be 0",original,triangle.getLine1().getEnd().getYCoord());
	}
	
	//GetLine2
	@Test
	public void test_getLine2_triangle()
	{
		Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
                new Line(new Point(0,0), new Point(2,0)),
                new Line(new Point(0,2), new Point(0,0)));
		
		assertEquals("Line 2 length should be 2.0",2.0, triangle.getLine2().length(), 0.00001);
	}
	
	@Test
	public void test_getLine2_triangle_privacyLeak_StartPointXCoord()
	{
		Line l2 = new Line(new Point(0,0), new Point(2,0));
		Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
                l2,
                new Line(new Point(0,0), new Point(2,0)));
		int original = triangle.getLine2().getStart().getXCoord();
		Point p2 = new Point(1,1);
		triangle.getLine2().setStart(p2);
		
		assertEquals("Line 2 start point x-coordinate should be 0",original,triangle.getLine2().getStart().getXCoord());
	}
	
	@Test
	public void test_getLine2_triangle_privacyLeak_StartPointYCoord()
	{
		Line l2 = new Line(new Point(0,0), new Point(2,0));
		Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
                l2,
                new Line(new Point(0,0), new Point(2,0)));
		int original = triangle.getLine2().getStart().getYCoord();
		Point p2 = new Point(1,1);
		triangle.getLine2().setStart(p2);
		
		assertEquals("Line 2 start point y-coordinate should be 0",original,triangle.getLine2().getStart().getYCoord());
	}
	
	@Test
	public void test_getLine2_triangle_privacyLeak_EndPointXCoord()
	{
		Line l2 = new Line(new Point(0,0), new Point(2,0));
		Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
                l2,
                new Line(new Point(0,0), new Point(2,0)));
		int original = triangle.getLine2().getEnd().getXCoord();
		Point p2 = new Point(1,1);
		triangle.getLine2().setEnd(p2);
		
		assertEquals("Line 2 end point x-coordinate should be 2",original,triangle.getLine2().getEnd().getXCoord());
	}
	
	@Test
	public void test_getLine2_triangle_privacyLeak_EndPointYCoord()
	{
		Line l2 = new Line(new Point(0,0), new Point(2,0));
		Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
                l2,
                new Line(new Point(0,0), new Point(2,0)));
		int original = triangle.getLine2().getEnd().getYCoord();
		Point p2 = new Point(1,1);
		triangle.getLine2().setEnd(p2);
		
		assertEquals("Line 2 end point y-coordinate should be 0",original,triangle.getLine2().getEnd().getYCoord());
	}
	
	//GetLine3
	@Test
	public void test_getLine3_triangle()
	{
		Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
                new Line(new Point(2,0), new Point(0,2)),
                new Line(new Point(0,0), new Point(2,0)));
		
		assertEquals("Line 3 length should be 2.0",2.0, triangle.getLine3().length(), 0.00001);
	}
	
	@Test
	public void test_getLine3_triangle_privacyLeak_StartPointXCoord() {
		Line l3 = new Line(new Point(0,0), new Point(2,0));
		Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
				new Line(new Point(2,0), new Point(0,2)),
                l3);
		int original = triangle.getLine3().getStart().getXCoord();
		Point p3 = new Point(1,1);
		triangle.getLine3().setStart(p3);
		
		assertEquals("Line 3 start point x-coordinate should be 0",original,triangle.getLine3().getStart().getXCoord());
	}
	
	@Test
	public void test_getLine3_triangle_privacyLeak_StartPointYCoord() {
		Line l3 = new Line(new Point(0,0), new Point(2,0));
		Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
				new Line(new Point(2,0), new Point(0,2)),
                l3);
		int original = triangle.getLine3().getStart().getYCoord();
		Point p3 = new Point(1,1);
		triangle.getLine3().setStart(p3);
		
		assertEquals("Line 3 start point y-coordinate should be 0",original,triangle.getLine3().getStart().getYCoord());
	}
	
	@Test
	public void test_getLine3_triangle_privacyLeak_EndPointXCoord() {
		Line l3 = new Line(new Point(0,0), new Point(2,0));
		Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
				new Line(new Point(2,0), new Point(0,2)),
                l3);
		int original = triangle.getLine3().getEnd().getXCoord();
		Point p3 = new Point(1,1);
		triangle.getLine3().setEnd(p3);
		
		assertEquals("Line 3 end point x-coordinate should be 2",original,triangle.getLine3().getEnd().getXCoord());
	}
	
	@Test
	public void test_getLine3_triangle_privacyLeak_EndPointYCoord() {
		Line l3 = new Line(new Point(0,0), new Point(2,0));
		Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
				new Line(new Point(2,0), new Point(0,2)),
                l3);
		int original = triangle.getLine3().getEnd().getYCoord();
		Point p3 = new Point(1,1);
		triangle.getLine3().setEnd(p3);
		
		assertEquals("Line 3 end point y-coordinate should be 0",original,triangle.getLine3().getEnd().getYCoord());
	}
	
	@Test
	public void test_PrivacyLeakConstructor_Line1()
	{
		Line l1 = new Line(new Point(0,0), new Point(2,0));

	    Triangle triangle = new Triangle(l1,
							            new Line(new Point(2,0), new Point(0,2)),
							            new Line(new Point(0,2), new Point(0,0)));
	    l1.setStart(new Point(3,3));
	    double circumference = triangle.getCircumference();

	    assertEquals("Line from (0,0) to (2,0) passed in as arguement to parameter Line1 in constructor. The start point of Line1 was changed to (3,3) but this should not effect Triangle object. Circumference of Triangle with vertices at (0,0), (2,0) and (0,2) should be 6.82842", 6.82842, circumference, 0.00001);
	}
	
	@Test
	public void test_PrivacyLeakConstructor_Line2()
	{
	    Line l2 = new Line(new Point(2,0), new Point(0,2));

	    Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
							            l2,
							            new Line(new Point(0,2), new Point(0,0)));
	    l2.setStart(new Point(3,3));
	    double circumference = triangle.getCircumference();

	    assertEquals("Line from (0,2) to (0,2) passed in as arguement to parameter Line2 in constructor. The start point of Line2 was changed to (3,3) but this should not effect Triangle object. Circumference of Triangle with vertices at (0,0), (2,0) and (0,2) should be 6.82842", 6.82842, circumference, 0.00001);
	}
	
	@Test
	public void test_PrivacyLeakConstructor_Line3()
	{
	    Line l3 = new Line(new Point(0,2), new Point(0,0));

	    Triangle triangle = new Triangle(new Line(new Point(0,0), new Point(2,0)),
	    									new Line(new Point(2,0), new Point(0,2)),
							            l3);
	    l3.setStart(new Point(3,3));
	    double circumference = triangle.getCircumference();

	    assertEquals("Line from (0,2) to (0,0) passed in as arguement to parameter Line3 in constructor. The start point of Line3 was changed to (3,3) but this should not effect Triangle object. Circumference of Triangle with vertices at (0,0), (2,0) and (0,2) should be 6.82842", 6.82842, circumference, 0.00001);
	}
	
	@Test
	public void test_constructor_AllThreeLineSame()
	{
	    Line l1 = new Line(new Point(1,0), new Point(0,0));
	    Line l2 = new Line(new Point(1,0), new Point(0,0));
	    Line l3 = new Line(new Point(1,0), new Point(0,0));
	    Triangle triangle = new Triangle(l1,l2,l3);
	    boolean allNull = triangle.getLine1() == null && triangle.getLine2() == null && triangle.getLine3() == null;

	    assertTrue("Three identical lines passed in as argument to constructor. Since these lines do not make a triangle, expected null with all getLine methods, but got at least one return value that was not null", allNull);
	}
	
	@Test
	public void test_constructor_NotTriangle()
	{
	    Line l1 = new Line(new Point(2,0), new Point(0,0));
	    Line l2 = new Line(new Point(0,0), new Point(0,2));
	    Line l3 = new Line(new Point(2,0), new Point(1,1));
	    Triangle triangle = new Triangle(l1,l2,l3);
	    boolean allNull = triangle.getLine1() == null && triangle.getLine2() == null && triangle.getLine3() == null;

	    assertTrue("Three lines passed in to constructor do not make a Triangle, so all three lines should return null", allNull);
	}
	
}
