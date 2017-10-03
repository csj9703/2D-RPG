import static org.junit.Assert.*;

import org.junit.Test;

public class MyCircleTest {

	// Testing setter and getters
	
		@Test
		public void test_setter_and_getter_X_positiveX(){
			MyCircle c = new MyCircle();
			c.setX(5);
			assertEquals("x should have value 5.", 5, c.getX());
			assertEquals("y should be default of 0.", 0, c.getY());
			assertEquals("Radius should be default of 0.", 0, c.getRadius());
		}
		
		@Test
		public void test_setter_and_getter_Y_positiveY() {
			MyCircle c = new MyCircle();
			c.setY(11);
			assertEquals("x should have default value 0.", 0, c.getX());
			assertEquals("y should be 11.", 11, c.getY());
			assertEquals("Radius should be default of 0.", 0, c.getRadius());
		}

		@Test
		public void test_setter_and_getter_radius_positiveRadius() {
			MyCircle c = new MyCircle();
			c.setRadius(7);
			assertEquals("x should have default value 0.", 0, c.getX());
			assertEquals("y should have default value 0.", 0, c.getY());
			assertEquals("Radius should be 7.", 7, c.getRadius());
		}

		@Test
		public void test_setter_and_getter_X_negativeX(){
			MyCircle c = new MyCircle();
			c.setX(-11);
			assertEquals("x should have value -11.", -11, c.getX());
			assertEquals("y should be default of 0.", 0, c.getY());
			assertEquals("Radius should be default of 0.", 0, c.getRadius());
		}
		
		@Test
		public void test_setter_and_getter_Y_negativeY() {
			MyCircle c = new MyCircle();
			c.setY(-14);
			assertEquals("x should have default value 0.", 0, c.getX());
			assertEquals("y should be -14.", -14, c.getY());
			assertEquals("Radius should be default of 0.", 0, c.getRadius());
		}

		@Test
		public void test_setter_and_getter_radius_negativeRadius() {
			MyCircle c = new MyCircle();
			c.setRadius(4);
			c.setRadius(-4);
			assertEquals("x should have default value 0.", 0, c.getX());
			assertEquals("y should have default value 0.", 0, c.getY());
			assertEquals("Tried to set to invalid -4.  Should be set to 0 instead.", 0, c.getRadius());
		}

		// Testing Region
		
		@Test
		public void test_checkQuadrant_quadrant1() {
			MyCircle c = new MyCircle();
			c.setX(5);
			c.setY(10);
			c.setRadius(7);
			assertEquals("Checking Quadrant1", "Quadrant1", c.checkQuadrant());
		}

		@Test
		public void test_checkQuadrant_quadrant2() {
			MyCircle c = new MyCircle();
			c.setX(-5);
			c.setY(10);
			c.setRadius(7);
			assertEquals("Checking Quadrant2", "Quadrant2", c.checkQuadrant());
		}

		@Test
		public void test_checkQuadrant_quadrant3() {
			MyCircle c = new MyCircle();
			c.setX(-11);
			c.setY(-10);
			c.setRadius(7);
			assertEquals("Checking Quadrant3", "Quadrant3", c.checkQuadrant());
		}

		@Test
		public void test_checkQuadrant_quadrant4() {
			MyCircle c = new MyCircle();
			c.setX(10);
			c.setY(-1);
			c.setRadius(7);
			assertEquals("Checking Quadrant4", "Quadrant4", c.checkQuadrant());
		}
		
		@Test
		public void test_checkQuadrant_origin() {
			MyCircle c = new MyCircle();
			c.setX(0);
			c.setY(0);
			c.setRadius(7);
			assertEquals("Checking the Origin", "Origin", c.checkQuadrant());
		}

		// testing area		
		@Test
		public void test_biggestRadius_negativeArea() {
			MyCircle c = new MyCircle();
			c.setX(0);
			c.setY(0);
			c.setRadius(7);
			assertEquals("Should be zero since -10 not valid area.", 0, c.biggestRadius(-10));
		}
		
		@Test
		public void test_biggestRadius_positiveArea() {
			MyCircle c = new MyCircle();
			assertEquals("Biggest radius for area 10 is 1", 1, c.biggestRadius(10));
		}

		@Test
		public void test_biggestRadius_AreaSizeBorderlineCase() {
			MyCircle c = new MyCircle();
			assertEquals("Biggest radius for area 12 is 2", 2, c.biggestRadius(12));
		}

		@Test
		public void test_biggestRadius_AreaSizeOneAboveBorderlineCase() {
			MyCircle c = new MyCircle();
			assertEquals("Biggest radius for area 13 is 2", 2, c.biggestRadius(13));
		}
		
		@Test
		public void test_biggestRadius_ZeroSizeArea() {
			MyCircle c = new MyCircle();
			assertEquals("Biggest radius for area 0 is 0", 0, c.biggestRadius(0));
		}
		
		
		
}
