import java.util.ArrayList;
/**
 * Class representing a point on the screen.  The top left point on the screen
 * is considered (0,0).  Moving to the right increases the x-coordinate,
 * moving down, increases the y-coordinate.
 */
public class Point {
    private int xcoord = 0;
    private int ycoord = 0;
    
    public Point(int x, int y){
    	setXCoord(x);
    	setYCoord(y);
    }
	
    public int getXCoord() {
        return xcoord;
    }
    
    public int getYCoord() {
        return ycoord;
    }
    
    /**
     * To ensure the point falls on the screen, the xcoordinate must be non-negative.
     * @param xValue the value for the xcoordinate of this point.
     */
    public void setXCoord(int xValue) {
    	if (xValue >= 0) {
            xcoord = xValue;
    	}
    }
    
    /**
     * To ensure the point falls on the screen, the y-coordinate must be non-negative.
     * @param yValue the value for the ycoordinate of this point.
     */
    public void setYCoord(int yValue) {
    	if (yValue >= 0) {
            ycoord = yValue;
    	}
    }
       
    /**
     * Move the point up by the specified amount.
     * @param amount the number to add to the ycoord of this point.
     */
    public void moveUp(int amount) {
    	//To go up on the screen, we need to get closer to zero: we must subtract
        setYCoord(ycoord - amount);
    }
    
    /**
     * Move the point down by the specified amount.
     * @param amount the number to subtract from the ycoord of this point.
     */
    public void moveDown(int amount) {
    	// to go down we need to go further away from 0
        setYCoord(ycoord + amount);
    }
    
    /**
     * Move the point right (or east) the specified amount.
     * @param amount the number to add to the xcoord of this point.
     */
    public void moveRight(int amount) {
        setXCoord(xcoord + amount);
    }
    
    /**
     * Move the point left (or west) by the specified amount.
     * @param amount the number to subtract from the xcoord of this point.
     */
    public void moveLeft(int amount) {
        setXCoord(xcoord - amount);
    }

    /**
     * Computes and returns the euclidean distance between this point and the point provided
     * as an argument.
     * @param other the other end point to compute the distance to.
     * @return the euclidean distance between this point and the one provided as an argument.
     */
    public double distance(Point other) {
        int xdiff = xcoord - other.xcoord;
        int ydiff = ycoord - other.ycoord;
        int xsquare = xdiff * xdiff;
        int ysquare = ydiff * ydiff;
        double distance = Math.sqrt(xsquare + ysquare);
        return distance;
    }
    
    /**
     * Checks if this point and the one provided as an argument represent
     * the same coordinate (ie have the same x- and y-coordinate).
     * @param other the point to compare self with.
     * @return true if the other point is the same coordinate as this point.
     */
    public boolean equals(Point other) {
        return xcoord == other.xcoord && ycoord == other.ycoord;
    }
    
    /**
     * Creates a string representation of this point.  The string format 
     * is (<x-coordinate>,<y-coordinate>).
     * @return string representation of this point.
     */
    public String toString() {
        return "(" + xcoord + "," + ycoord + ")";
    }
}